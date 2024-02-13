package me.fzzyhmstrs.imbued_deco.block

import net.minecraft.block.Block
import net.minecraft.block.BlockRenderType
import net.minecraft.block.BlockState
import net.minecraft.block.ShapeContext
import net.minecraft.entity.Entity
import net.minecraft.particle.ParticleEffect
import net.minecraft.particle.ParticleTypes
import net.minecraft.state.property.Properties
import net.minecraft.util.math.BlockPos
import net.minecraft.util.shape.VoxelShape
import net.minecraft.world.BlockView
import net.minecraft.world.World

class CrystallizedLightBridgeBlock(settings: Settings, private val particleEffect: ParticleEffect = ParticleTypes.END_ROD) : Block(settings) {

    companion object{
        private val voxelShape = createCuboidShape(0.0, 14.0, 0.0, 16.0, 16.0, 16.0)
        private val axis = Properties.HORIZONTAL_AXIS
        private val enabled = Properties.ENABLED
    }

    @Deprecated("Deprecated in Java")
    override fun getRenderType(state: BlockState): BlockRenderType {
        return if(state.get(enabled)){
            BlockRenderType.MODEL
        } else {
            BlockRenderType.INVISIBLE
        }
    }

    override fun onSteppedOn(world: World, pos: BlockPos, state: BlockState, entity: Entity) {
        if (!state.get(enabled)) return
        world.addParticle(
            particleEffect,
            entity.x,
            entity.y ,
            entity.z,
            world.random.nextGaussian() * 0.005,
            world.random.nextGaussian() * 0.005,
            world.random.nextGaussian() * 0.005
        )
    }

    override fun getCollisionShape(
        state: BlockState?,
        world: BlockView?,
        pos: BlockPos?,
        context: ShapeContext?
    ): VoxelShape {
        return super.getCollisionShape(state, world, pos, context)
    }




}