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

    private var inventory = DefaultedList.ofSize(1, ItemStack.EMPTY)
    @Volatile
    private var color = -1
    private var customName: Text? = null

    override fun readNbt(nbt: NbtCompound) {

        inventory = ItemStack.fromNbt(nbt)
        //sync this to client
        inventory.clear()
        Inventories.readNbt(nbt, inventory)
        //sync this to client
        if (inventory[0].item is PotionItem){
            color = PotionUtil.getColor(inventory[0])
        }
        }
        if (nbt.contains("CustomName", NbtElement.STRING_TYPE.toInt())) {
            customName = Text.Serializer.fromJson(nbt.getString("CustomName"))
        }
    }

    override fun writeNbt(nbt: NbtCompound) {
         Inventories.writeNbt(nbt, inventory, true)
        if (customName != null) {
            nbt.putString("CustomName", Text.Serializer.toJson(customName))
        }
    }

    //need to sync to client on initialization somehow.
    override fun toUpdatePacket(): Packet<ClientPlayPacketListener>{
        return BlockEntityUpdateS2CPacket.create(this);
    }

    override fun toInitialChunkDataNbt(): NbtCompound{
        return createNbt()
    }

    override fun clear() {
        inventory.clear()
        color = -1
    }

    override fun size(): Int {
        return 1
    }

    override fun isEmpty(): Boolean {
        return inventory[0].isEmpty
    }

    override fun getStack(slot: Int): ItemStack {
        return if(slot == 0) inventory[0] else ItemStack.EMPTY
    }

    override fun removeStack(slot: Int, amount: Int): ItemStack {
        return Inventories.splitStack(inventory, slot, amount).also { if(it.isEmpty) color = -1 }
    }

    override fun removeStack(slot: Int): ItemStack {
        return this.removeStack(slot, 1)
    }

    override fun setStack(slot: Int, stack: ItemStack) {
        inventory[0] = stack
        if (inventory[0].item is PotionItem){
            color = PotionUtil.getColor(inventory)
        } else if (isEmpty()) color = -1
    }

    override fun canPlayerUse(player: PlayerEntity?): Boolean {
        return false
    }

    fun getColor(): Int{
        return color
    }

    fun setCustomName(text: Text){
        this.customName = text
    }

    override fun getName(): Text {
        return customName ?: super.getDisplayName()
    }
}
