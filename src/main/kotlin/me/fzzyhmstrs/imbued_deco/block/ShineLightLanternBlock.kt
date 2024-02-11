package me.fzzyhmstrs.imbued_deco.block

import net.minecraft.block.BlockState
import net.minecraft.block.LanternBlock
import net.minecraft.particle.ParticleEffect
import net.minecraft.particle.ParticleTypes
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.random.Random
import net.minecraft.world.World

class ShineLightLanternBlock(settings: Settings, private val particleEffect: ParticleEffect = ParticleTypes.END_ROD) : LanternBlock(settings) {

    override fun randomDisplayTick(state: BlockState, world: World, pos: BlockPos, random: Random) {
        val d = pos.x.toDouble() + 0.6 - (random.nextFloat() * 0.2f).toDouble()
        val e = pos.y.toDouble() + 0.3 - (random.nextFloat() * 0.2f).toDouble()
        val f = pos.z.toDouble() + 0.6 - (random.nextFloat() * 0.2f).toDouble()
        if (random.nextInt(2) == 0) {
            world.addParticle(
                particleEffect,
                d,
                e ,
                f,
                random.nextGaussian() * 0.005,
                random.nextGaussian() * 0.005,
                random.nextGaussian() * 0.005
            )
        }
    }

}