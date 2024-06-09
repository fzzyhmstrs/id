package me.fzzyhmstrs.imbued_deco.block

import me.fzzyhmstrs.amethyst_imbuement.particle.ColoredEndParticleEffect
import net.minecraft.block.BlockState
import net.minecraft.block.LanternBlock
import net.minecraft.util.DyeColor
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.random.Random
import net.minecraft.world.World

class ShineLightRainbowLanternBlock(settings: Settings) : LanternBlock(settings) {

    companion object{
        private val particles = arrayOf(
            ColoredEndParticleEffect(DyeColor.RED),
            ColoredEndParticleEffect(DyeColor.ORANGE),
            ColoredEndParticleEffect(DyeColor.YELLOW),
            ColoredEndParticleEffect(DyeColor.LIME),
            ColoredEndParticleEffect(DyeColor.GREEN),
            ColoredEndParticleEffect(DyeColor.CYAN),
            ColoredEndParticleEffect(DyeColor.LIGHT_BLUE),
            ColoredEndParticleEffect(DyeColor.BLUE),
            ColoredEndParticleEffect(DyeColor.PURPLE),
            ColoredEndParticleEffect(DyeColor.MAGENTA),
            ColoredEndParticleEffect(DyeColor.PINK)
        )
    }

    override fun randomDisplayTick(state: BlockState, world: World, pos: BlockPos, random: Random) {
        val d = pos.x.toDouble() + 0.6 - (random.nextFloat() * 0.2f).toDouble()
        val e = pos.y.toDouble() + 0.3 - (random.nextFloat() * 0.2f).toDouble()
        val f = pos.z.toDouble() + 0.6 - (random.nextFloat() * 0.2f).toDouble()
        if (random.nextInt(2) == 0) {
            world.addParticle(
                particles[world.random.nextInt(11)],
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