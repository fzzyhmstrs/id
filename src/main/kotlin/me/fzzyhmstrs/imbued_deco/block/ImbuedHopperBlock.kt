package me.fzzyhmstrs.imbued_deco.block

import me.fzzyhmstrs.imbued_deco.entity.ImbuedHopperBlockEntity
import me.fzzyhmstrs.imbued_deco.registry.RegisterEntity
import net.minecraft.block.BlockState
import net.minecraft.block.HopperBlock
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityTicker
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.block.entity.HopperBlockEntity
import net.minecraft.entity.Entity
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class ImbuedHopperBlock(settings: Settings) : HopperBlock(settings) {

    override fun <T : BlockEntity?> getTicker(
        world: World,
        state: BlockState?,
        type: BlockEntityType<T>?
    ): BlockEntityTicker<T>? {
        return if (world.isClient) null else checkType(
            type, RegisterEntity.IMBUED_HOPPER_BLOCK_ENTITY
        ) { w: World, pos: BlockPos, s: BlockState, blockEntity: ImbuedHopperBlockEntity ->
            ImbuedHopperBlockEntity.serverTick(w, pos, s, blockEntity)
        }
    }

    override fun createBlockEntity(pos: BlockPos?, state: BlockState?): BlockEntity? {
        return HopperBlockEntity(pos, state)
    }

    @Deprecated("Deprecated in Java")
    override fun onEntityCollision(state: BlockState, world: World, pos: BlockPos, entity: Entity) {
        val blockEntity = world.getBlockEntity(pos)
        if (blockEntity is ImbuedHopperBlockEntity) {
            ImbuedHopperBlockEntity.onEntityCollided(world, pos, state, entity, blockEntity)
        }
    }

}