package me.fzzyhmstrs.imbued_deco.block

import me.fzzyhmstrs.imbued_deco.entity.ImbuedHopperBlockEntity
import me.fzzyhmstrs.imbued_deco.entity.PlaceablePotionBlockEntity
import net.minecraft.block.Block
import net.minecraft.block.BlockRenderType
import net.minecraft.block.BlockState
import net.minecraft.block.BlockWithEntity
import net.minecraft.block.entity.BlockEntity
import net.minecraft.state.StateManager
import net.minecraft.state.property.IntProperty
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class PlaceablePotionBlock(settings: Settings) : BlockWithEntity(settings) {

    companion object{
        val POTIONS: IntProperty = IntProperty.of("potions", 1, 4)
    }

    init {
        this.defaultState = this.defaultState.with(POTIONS,1)
    }

    @Deprecated("Deprecated in Java", ReplaceWith("BlockRenderType.MODEL", "net.minecraft.block.BlockRenderType"))
    override fun getRenderType(state: BlockState?): BlockRenderType {
        return BlockRenderType.MODEL
    }

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        builder.add(POTIONS)
    }

    override fun createBlockEntity(pos: BlockPos, state: BlockState): BlockEntity {
        return ImbuedHopperBlockEntity(pos, state)
    }

    @Deprecated("Deprecated in Java")
    override fun onStateReplaced(
        state: BlockState,
        world: World,
        pos: BlockPos,
        newState: BlockState,
        moved: Boolean
    ) {
        if (state.isOf(newState.block))
            return
        val blockEntity = world.getBlockEntity(pos)
        if (blockEntity is PlaceablePotionBlockEntity){
            blockEntity.onStateReplaced(world, pos)
            blockEntity.clear()
            world.updateComparators(pos, this)
        }
        super.onStateReplaced(state, world, pos, newState, moved)
    }
}