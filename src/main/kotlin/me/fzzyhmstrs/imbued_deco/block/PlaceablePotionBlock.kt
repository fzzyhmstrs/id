package me.fzzyhmstrs.imbued_deco.block

import me.fzzyhmstrs.imbued_deco.entity.PlaceablePotionBlockEntity
import net.minecraft.block.*
import net.minecraft.block.entity.BlockEntity
import net.minecraft.state.StateManager
import net.minecraft.state.property.IntProperty
import net.minecraft.util.math.BlockPos
import net.minecraft.util.shape.VoxelShape
import net.minecraft.world.BlockView
import net.minecraft.world.World

class PlaceablePotionBlock(settings: Settings) : BlockWithEntity(settings) {

    companion object{
        private val shapes = arrayOf(
            createCuboidShape(5.0,0.0,5.0,11.0,10.0,11.0),
            createCuboidShape(3.0,0.0,4.0,14.0,13.0,12.0),
            createCuboidShape(3.0,0.0,2.0,14.0,13.0,15.0),
            createCuboidShape(1.0,0.0,2.0,14.0,13.0,15.0)

        )
        val POTIONS: IntProperty = IntProperty.of("potions", 1, 4)
    }

    init {
        this.defaultState = this.defaultState.with(POTIONS,1)
    }

    @Deprecated("Deprecated in Java")
    override fun getOutlineShape(
        state: BlockState,
        world: BlockView,
        pos: BlockPos,
        context: ShapeContext
    ): VoxelShape {
        return shapes[state.get(POTIONS) - 1]
    }

    @Deprecated("Deprecated in Java", ReplaceWith("BlockRenderType.MODEL", "net.minecraft.block.BlockRenderType"))
    override fun getRenderType(state: BlockState?): BlockRenderType {
        return BlockRenderType.MODEL
    }

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        builder.add(POTIONS)
    }

    override fun createBlockEntity(pos: BlockPos, state: BlockState): BlockEntity {
        return PlaceablePotionBlockEntity(pos, state)
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