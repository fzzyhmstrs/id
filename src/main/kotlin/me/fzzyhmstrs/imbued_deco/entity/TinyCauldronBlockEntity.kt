package me.fzzyhmstrs.imbued_deco.entity

import me.fzzyhmstrs.imbued_deco.registry.RegisterEntity
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.inventory.Inventories
import net.minecraft.inventory.Inventory
import net.minecraft.item.ItemStack
import net.minecraft.item.PotionItem
import net.minecraft.nbt.NbtCompound
import net.minecraft.nbt.NbtElement
import net.minecraft.potion.PotionUtil
import net.minecraft.text.Text
import net.minecraft.util.ItemScatterer
import net.minecraft.util.Nameable
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class TinyCauldronBlockEntity(pos: BlockPos, state: BlockState) : BlockEntity(RegisterEntity.TINY_CAULDRON_BLOCK_ENTITY,pos, state), Inventory, Nameable {

    private var inventory = ItemStack.EMPTY
    private var color = -1
    private var customName: Text? = null

    override fun readNbt(nbt: NbtCompound) {

        inventory = ItemStack.fromNbt(nbt)
        if (inventory.item is PotionItem){
            color = PotionUtil.getColor(inventory)
        }
        if (nbt.contains("CustomName", NbtElement.STRING_TYPE.toInt())) {
            customName = Text.Serializer.fromJson(nbt.getString("CustomName"))
        }
    }

    override fun writeNbt(nbt: NbtCompound) {
        inventory.writeNbt(nbt)
        if (customName != null) {
            nbt.putString("CustomName", Text.Serializer.toJson(customName))
        }
    }

    override fun clear() {
        inventory = ItemStack.EMPTY
        color = -1
    }

    override fun size(): Int {
        return 1
    }

    override fun isEmpty(): Boolean {
        return inventory.isEmpty
    }

    override fun getStack(slot: Int): ItemStack {
        return if(slot == 0) inventory else ItemStack.EMPTY
    }

    override fun removeStack(slot: Int, amount: Int): ItemStack {
        return Inventories.splitStack(listOf(inventory), slot, amount).also { if(it.isEmpty) color = -1 }
    }

    override fun removeStack(slot: Int): ItemStack {
        return this.removeStack(slot, 1)
    }

    override fun setStack(slot: Int, stack: ItemStack) {
        inventory = stack
        if (inventory.item is PotionItem){
            color = PotionUtil.getColor(inventory)
        } else if (inventory.isEmpty) color = -1
    }

    override fun canPlayerUse(player: PlayerEntity?): Boolean {
        return false
    }

    fun onStateReplaced(world: World, pos: BlockPos) {
        if (inventory.isEmpty) return
        ItemScatterer.spawn(world, pos.x.toDouble(), pos.y.toDouble(), pos.z.toDouble(), inventory)
    }

    fun getColor(): Int{
        return color
    }

    fun setCustomName(text: Text){
        this.customName = text
    }

    override fun getName(): Text {
        TODO("Not yet implemented")
    }
}