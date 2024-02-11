package me.fzzyhmstrs.imbued_deco.entity

import me.fzzyhmstrs.imbued_deco.mixins.HopperBlockEntityAccessor
import me.fzzyhmstrs.imbued_deco.registry.RegisterEntity
import net.minecraft.block.BlockState
import net.minecraft.block.ChestBlock
import net.minecraft.block.HopperBlock
import net.minecraft.block.InventoryProvider
import net.minecraft.block.entity.ChestBlockEntity
import net.minecraft.block.entity.Hopper
import net.minecraft.block.entity.HopperBlockEntity
import net.minecraft.block.entity.LootableContainerBlockEntity
import net.minecraft.entity.Entity
import net.minecraft.entity.ItemEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.Inventories
import net.minecraft.inventory.Inventory
import net.minecraft.inventory.SidedInventory
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import net.minecraft.predicate.entity.EntityPredicates
import net.minecraft.screen.HopperScreenHandler
import net.minecraft.screen.ScreenHandler
import net.minecraft.text.Text
import net.minecraft.util.collection.DefaultedList
import net.minecraft.util.function.BooleanBiFunction
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Box
import net.minecraft.util.math.Direction
import net.minecraft.util.shape.VoxelShapes
import net.minecraft.world.World
import java.util.function.BooleanSupplier
import java.util.stream.Collectors
import java.util.stream.IntStream

class ImbuedHopperBlockEntity(pos: BlockPos, state: BlockState) : LootableContainerBlockEntity(RegisterEntity.IMBUED_HOPPER_BLOCK_ENTITY,pos, state), Hopper {

    private var inventory = DefaultedList.ofSize(5, ItemStack.EMPTY)
    private var transferCooldown = -1
    private var lastTickTime: Long = 0

    override fun readNbt(nbt: NbtCompound) {
        super.readNbt(nbt)
        inventory = DefaultedList.ofSize(size(), ItemStack.EMPTY)
        if (!deserializeLootTable(nbt)) {
            Inventories.readNbt(nbt, inventory)
        }
        transferCooldown = nbt.getInt("TransferCooldown")
    }

    override fun writeNbt(nbt: NbtCompound) {
        super.writeNbt(nbt)
        if (!serializeLootTable(nbt)) {
            Inventories.writeNbt(nbt, inventory)
        }
        nbt.putInt("TransferCooldown", transferCooldown)
    }

    override fun createScreenHandler(syncId: Int, playerInventory: PlayerInventory): ScreenHandler {
        return HopperScreenHandler(syncId, playerInventory, this)
    }

    override fun size(): Int {
        return inventory.size
    }

    override fun removeStack(slot: Int, amount: Int): ItemStack? {
        checkLootInteraction(null)
        return Inventories.splitStack(this.invStackList, slot, amount)
    }

    override fun setStack(slot: Int, stack: ItemStack) {
        checkLootInteraction(null)
        this.invStackList[slot] = stack
        if (stack.count > this.maxCountPerStack) {
            stack.count = this.maxCountPerStack
        }
    }

    override fun getInvStackList(): DefaultedList<ItemStack> {
        return inventory
    }

    override fun setInvStackList(list: DefaultedList<ItemStack>) {
        inventory = list
    }

    private fun setTransferCooldown(transferCooldown: Int) {
        this.transferCooldown = transferCooldown
    }

    private fun needsCooldown(): Boolean {
        return this.transferCooldown > 0
    }

    private fun isDisabled(): Boolean {
        return this.transferCooldown > 8
    }

    private fun isFull(): Boolean {
        for (itemStack in invStackList) {
            if (!itemStack.isEmpty && itemStack.count == itemStack.maxCount) continue
            return false
        }
        return true
    }

    override fun getContainerName(): Text {
        return Text.translatable("container.imbued_hopper")
    }

    override fun getHopperX(): Double {
        return pos.x.toDouble() + 0.5
    }

    override fun getHopperY(): Double {
        return pos.y.toDouble() + 0.5
    }

    override fun getHopperZ(): Double {
        return pos.z.toDouble() + 0.5
    }

    companion object {
        fun serverTick(world: World, pos: BlockPos, state: BlockState, blockEntity: ImbuedHopperBlockEntity) {
            --blockEntity.transferCooldown
            blockEntity.lastTickTime = world.time
            if (!blockEntity.needsCooldown()) {
                blockEntity.setTransferCooldown(0)
                insertAndExtract(world, pos, state, blockEntity, { extract(world, blockEntity, pos) }, false)
            }
        }

        private fun insertAndExtract(
            world: World,
            pos: BlockPos,
            state: BlockState,
            blockEntity: ImbuedHopperBlockEntity,
            booleanSupplier: BooleanSupplier,
            ignoreCooldown: Boolean = false
        ): Boolean {
            if (world.isClient) {
                return false
            }
            if ((!blockEntity.needsCooldown() || ignoreCooldown) && state.get(HopperBlock.ENABLED)) {
                var bl = false
                if (!blockEntity.isEmpty) {
                    bl = insert(world, pos, state, blockEntity)
                }
                if (!blockEntity.isFull()) {
                    bl = bl or booleanSupplier.asBoolean
                }
                if (bl) {
                    blockEntity.setTransferCooldown(2)
                    markDirty(world, pos, state)
                    return true
                }
            }
            return false
        }

        private fun insert(world: World, pos: BlockPos, state: BlockState, inventory: Inventory): Boolean {
            val inventory2 = getOutputInventory(world, pos, state) ?: return false
            val direction = state.get(HopperBlock.FACING).opposite
            if (isInventoryFull(inventory2, direction)) {
                return false
            }
            for (i in 0 until inventory.size()) {
                if (inventory.getStack(i).isEmpty) continue
                val itemStack = inventory.getStack(i).copy()
                val itemStack2 =
                    HopperBlockEntity.transfer(inventory, inventory2, inventory.removeStack(i), direction)
                if (itemStack2.isEmpty) {
                    inventory2.markDirty()
                    return true
                }
                inventory.setStack(i, itemStack)
            }
            return false
        }

        private fun getAvailableSlots(inventory: Inventory, side: Direction): IntStream {
            return if (inventory is SidedInventory) {
                IntStream.of(*inventory.getAvailableSlots(side))
            } else IntStream.range(0, inventory.size())
        }

        private fun isInventoryFull(inventory: Inventory, direction: Direction): Boolean {
            return getAvailableSlots(inventory, direction).allMatch { slot: Int ->
                val itemStack = inventory.getStack(slot)
                itemStack.count >= itemStack.maxCount
            }
        }

        private fun isInventoryEmpty(inv: Inventory, facing: Direction): Boolean {
            return getAvailableSlots(inv, facing).allMatch { slot: Int ->
                inv.getStack(
                    slot
                ).isEmpty
            }
        }

        fun extract(world: World, hopper: Hopper, pos: BlockPos): Boolean {
            val inventory = getInputInventory(world, pos)
            if (inventory != null) {
                val direction = Direction.DOWN
                return if (isInventoryEmpty(inventory, direction)) {
                    false
                } else getAvailableSlots(inventory, direction).anyMatch { slot: Int ->
                    extract(
                        hopper,
                        inventory,
                        slot,
                        direction
                    )
                }
            }
            if (pos.up().let { world.getBlockState(it).isFullCube(world, it) })
                return false
            for (itemEntity in getInputItemEntities(world, hopper)) {
                if (!extract(hopper, itemEntity)) continue
                return true
            }
            return false
        }

        private fun extract(hopper: Hopper, inventory: Inventory, slot: Int, side: Direction): Boolean {
            val itemStack = inventory.getStack(slot)
            if (!itemStack.isEmpty && canExtract(hopper, inventory, itemStack, slot, side)) {
                val itemStack2 = itemStack.copy()
                val itemStack3 = transfer(inventory, hopper, inventory.removeStack(slot, 1), null)
                if (itemStack3.isEmpty) {
                    inventory.markDirty()
                    return true
                }
                inventory.setStack(slot, itemStack2)
            }
            return false
        }

        fun extract(inventory: Inventory, itemEntity: ItemEntity): Boolean {
            var bl = false
            val itemStack = itemEntity.stack.copy()
            val itemStack2 = transfer(null, inventory, itemStack, null)
            if (itemStack2.isEmpty) {
                bl = true
                itemEntity.discard()
            } else {
                itemEntity.stack = itemStack2
            }
            return bl
        }

        /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
        fun transfer(from: Inventory?, to: Inventory, stack: ItemStack, side: Direction?): ItemStack {
            var itemStack = stack
            if (to is SidedInventory) {
                if (side != null) {
                    val invSlots = to.getAvailableSlots(side)
                    var i = 0
                    while (i < invSlots.size) {
                        if (itemStack.isEmpty) return stack
                        itemStack = transfer(from, to, stack, invSlots[i], side)
                        ++i
                    }
                    return itemStack
                }
            }
            val j = to.size()
            var i = 0
            while (i < j) {
                if (itemStack.isEmpty) return itemStack
                itemStack = transfer(from, to, stack, i, side)
                ++i
            }
            return stack
        }

        private fun canInsert(inventory: Inventory, stack: ItemStack, slot: Int, side: Direction?): Boolean {
            return if (!inventory.isValid(slot, stack)) {
                false
            } else
                inventory !is SidedInventory || inventory.canInsert(slot, stack, side)
        }

        private fun canExtract(
            hopperInventory: Inventory,
            fromInventory: Inventory,
            stack: ItemStack,
            slot: Int,
            facing: Direction
        ): Boolean {
            return if (!fromInventory.canTransferTo(hopperInventory, slot, stack)) {
                false
            } else
                fromInventory !is SidedInventory || fromInventory.canExtract(slot, stack, facing)
        }

        private fun transfer(
            from: Inventory?,
            to: Inventory,
            stack: ItemStack,
            slot: Int,
            side: Direction?
        ): ItemStack {
            val itemStack = to.getStack(slot)
            var itemStack2 = stack
            if (canInsert(to, stack, slot, side)) {
                var j: Int
                var bl = false
                val bl2 = to.isEmpty
                if (itemStack.isEmpty) {
                    to.setStack(slot, itemStack2.copy())
                    itemStack2 = ItemStack.EMPTY
                    bl = true
                } else if (canMergeItems(itemStack, itemStack2)) {
                    val i = itemStack2.maxCount - itemStack.count
                    j = itemStack2.count.coerceAtMost(i)
                    itemStack2.decrement(j)
                    itemStack.increment(j)
                    bl = j > 0
                }
                if (bl) {
                    if (bl2) {
                        if (to is ImbuedHopperBlockEntity && !to.isDisabled()) {
                            j = 0
                            if (from is HopperBlockEntity) {
                                if (to.lastTickTime >= (from as HopperBlockEntityAccessor).lastTickTime) {
                                    j = 1
                                }
                            }
                            to.setTransferCooldown(2 - j)
                        } else if (to is HopperBlockEntity && !(to as HopperBlockEntityAccessor).callIsDisabled()){
                            j = 0
                            if (from is HopperBlockEntity) {
                                if ((from as HopperBlockEntityAccessor).lastTickTime >= (from as HopperBlockEntityAccessor).lastTickTime) {
                                    j = 1
                                }
                            }
                            (from as HopperBlockEntityAccessor).callSetTransferCooldown(8 - j)
                        }
                    }
                    to.markDirty()
                }
            }
            return itemStack2
        }

        private fun getOutputInventory(world: World, pos: BlockPos, state: BlockState): Inventory? {
            val direction = state.get(HopperBlock.FACING)
            return getInventoryAt(world, pos.offset(direction))
        }

        private fun getInputInventory(world: World, pos: BlockPos): Inventory? {
            return getInventoryAt(world, pos.up())
        }

        fun getInputItemEntities(world: World, hopper: Hopper): List<ItemEntity> {
            return hopper.inputAreaShape.boundingBoxes.stream().flatMap { box: Box ->
                world.getEntitiesByClass(
                    ItemEntity::class.java,
                    box.offset(hopper.hopperX - 0.5, hopper.hopperY - 0.5, hopper.hopperZ - 0.5),
                    EntityPredicates.VALID_ENTITY
                ).stream()
            }.collect(Collectors.toList())
        }

        fun getInventoryAt(world: World, pos: BlockPos): Inventory? {
            val blockState = world.getBlockState(pos)
            val block = blockState.block
            if (block is InventoryProvider)
                return (block as InventoryProvider).getInventory(blockState, world, pos)
            val blockEntity = world.getBlockEntity(pos)
            if (blockEntity is ChestBlockEntity && block is ChestBlock)
                return ChestBlock.getInventory(block, blockState, world, pos, true)
            if (blockEntity is Inventory)
                return blockEntity
            if (blockState.isFullCube(world, pos))
                return null
            return world.getOtherEntities(null,
                Box(pos.x.toDouble(), pos.y.toDouble(), pos.z.toDouble(), pos.x + 1.0, pos.y + 1.0, pos.z + 1.0),
                EntityPredicates.VALID_INVENTORIES
            ).takeIf { it.isNotEmpty() }?.random() as Inventory?
        }

        private fun canMergeItems(first: ItemStack, second: ItemStack): Boolean {
            return first.count <= first.maxCount && ItemStack.canCombine(first, second)
        }

        fun onEntityCollided(
            world: World,
            pos: BlockPos,
            state: BlockState,
            entity: Entity,
            blockEntity: ImbuedHopperBlockEntity
        ) {
            if (entity is ItemEntity && VoxelShapes.matchesAnywhere(
                    VoxelShapes.cuboid(
                        entity.getBoundingBox().offset(-pos.x.toDouble(), -pos.y.toDouble(), -pos.z.toDouble())
                    ), blockEntity.inputAreaShape, BooleanBiFunction.AND
                )
            ) {
                insertAndExtract(world, pos, state, blockEntity, { HopperBlockEntity.extract(blockEntity, entity) },true)
            }
        }

    }

}