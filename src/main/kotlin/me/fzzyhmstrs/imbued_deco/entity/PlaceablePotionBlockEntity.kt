package me.fzzyhmstrs.imbued_deco.entity

import me.fzzyhmstrs.imbued_deco.registry.RegisterEntity
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.inventory.Inventories
import net.minecraft.inventory.Inventory
import net.minecraft.item.ItemStack
import net.minecraft.item.PotionItem
import net.minecraft.nbt.NbtCompound
import net.minecraft.network.listener.ClientPlayPacketListener
import net.minecraft.network.packet.Packet
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket
import net.minecraft.potion.PotionUtil
import net.minecraft.util.ItemScatterer
import net.minecraft.util.collection.DefaultedList
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import java.util.concurrent.atomic.AtomicIntegerArray

class PlaceablePotionBlockEntity(pos: BlockPos, state: BlockState) : BlockEntity(RegisterEntity.PLACEABLE_POTION_BLOCK_ENTITY,pos, state), Inventory {

    private var inventory = DefaultedList.ofSize(4, ItemStack.EMPTY)
    private var colors = AtomicIntegerArray(intArrayOf(-1, -1, -1, -1))

    override fun readNbt(nbt: NbtCompound) {
        inventory.clear()
        Inventories.readNbt(nbt, inventory)
        //sync this to client
        inventory.forEachIndexed { index, itemStack ->
            if (itemStack.item is PotionItem){
                colors[index] = PotionUtil.getColor(itemStack)
            }
        }
    }

    override fun writeNbt(nbt: NbtCompound) {
        Inventories.writeNbt(nbt, inventory, true)
    }

    //need to sync to client on initialization somehow.
    override fun toUpdatePacket(): Packet<ClientPlayPacketListener> {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    override fun toInitialChunkDataNbt(): NbtCompound{
        return createNbt()
    }

    private fun updateListeners() {
        this.markDirty()
        world?.updateListeners(getPos(), cachedState, cachedState, Block.NOTIFY_ALL)
    }

    override fun clear() {
        inventory.clear()
    }

    override fun size(): Int {
        return 4
    }

    override fun isEmpty(): Boolean {
        return inventory.stream().allMatch { it.isEmpty }
    }

    override fun getStack(slot: Int): ItemStack {
        return inventory[slot]
    }

    fun getStacks(): DefaultedList<ItemStack>{
        return inventory
    }

    override fun removeStack(slot: Int, amount: Int): ItemStack? {
        return Inventories.splitStack(inventory, slot, amount)
    }

    override fun removeStack(slot: Int): ItemStack? {
        return this.removeStack(slot, 1)
    }

    override fun setStack(slot: Int, stack: ItemStack) {
        this.inventory[slot] = stack
        if (stack.count > this.maxCountPerStack) {
            stack.count = this.maxCountPerStack
        }
        if (stack.item is PotionItem){
            colors[slot] = PotionUtil.getColor(stack)
        }
    }

    override fun canPlayerUse(player: PlayerEntity?): Boolean {
        return false
    }

    fun onStateReplaced(world: World, pos: BlockPos) {
        for (stack in inventory){
            if (stack.isEmpty) continue
            ItemScatterer.spawn(world, pos.x.toDouble(), pos.y.toDouble(), pos.z.toDouble(), stack)
        }
    }

    fun getColor(tintIndex: Int): Int{
        return colors[tintIndex]
    }
}
