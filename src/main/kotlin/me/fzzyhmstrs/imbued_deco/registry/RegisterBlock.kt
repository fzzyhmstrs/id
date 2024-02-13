package me.fzzyhmstrs.imbued_deco.registry

import me.fzzyhmstrs.amethyst_imbuement.item.AiItemSettings
import me.fzzyhmstrs.amethyst_imbuement.particle.ColoredEndParticleEffect
import me.fzzyhmstrs.amethyst_imbuement.registry.RegisterBlock
import me.fzzyhmstrs.fzzy_core.coding_util.FzzyPort
import me.fzzyhmstrs.imbued_deco.ID
import me.fzzyhmstrs.imbued_deco.block.*
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.*
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.particle.ParticleEffect
import net.minecraft.particle.ParticleTypes
import net.minecraft.util.DyeColor
import java.util.ArrayList

object RegisterBlock {

    internal val regBlockItem: ArrayList<Item> = ArrayList(65)

    val ID_GROUP: ItemGroup by lazy{
        RegisterItemGroup.registerItemGroup()
    }

    fun registerAll(){
        val group = ID_GROUP
    }

    val HARD_LIGHT_STAIRS = registerBoth(stairsCopy(RegisterBlock.HARD_LIGHT_BLOCK),"hard_light_stairs")
    val CRYSTALLIZED_LIGHT_STAIRS_WHITE = registerBoth(stairsCopy(RegisterBlock.CRYSTALLIZED_LIGHT_WHITE),"crystallized_light_stairs_white")
    val CRYSTALLIZED_LIGHT_STAIRS_LIGHT_GRAY = registerBoth(stairsCopy(RegisterBlock.CRYSTALLIZED_LIGHT_LIGHT_GRAY),"crystallized_light_stairs_light_gray")
    val CRYSTALLIZED_LIGHT_STAIRS_GRAY = registerBoth(stairsCopy(RegisterBlock.CRYSTALLIZED_LIGHT_GRAY),"crystallized_light_stairs_gray")
    val CRYSTALLIZED_LIGHT_STAIRS_BLACK = registerBoth(stairsCopy(RegisterBlock.CRYSTALLIZED_LIGHT_BLACK),"crystallized_light_stairs_black")
    val CRYSTALLIZED_LIGHT_STAIRS_BROWN = registerBoth(stairsCopy(RegisterBlock.CRYSTALLIZED_LIGHT_BROWN),"crystallized_light_stairs_brown")
    val CRYSTALLIZED_LIGHT_STAIRS_RED = registerBoth(stairsCopy(RegisterBlock.CRYSTALLIZED_LIGHT_RED),"crystallized_light_stairs_red")
    val CRYSTALLIZED_LIGHT_STAIRS_ORANGE = registerBoth(stairsCopy(RegisterBlock.CRYSTALLIZED_LIGHT_ORANGE),"crystallized_light_stairs_orange")
    val CRYSTALLIZED_LIGHT_STAIRS_YELLOW = registerBoth(stairsCopy(RegisterBlock.CRYSTALLIZED_LIGHT_YELLOW),"crystallized_light_stairs_yellow")
    val CRYSTALLIZED_LIGHT_STAIRS_LIME = registerBoth(stairsCopy(RegisterBlock.CRYSTALLIZED_LIGHT_LIME),"crystallized_light_stairs_lime")
    val CRYSTALLIZED_LIGHT_STAIRS_GREEN = registerBoth(stairsCopy(RegisterBlock.CRYSTALLIZED_LIGHT_GREEN),"crystallized_light_stairs_green")
    val CRYSTALLIZED_LIGHT_STAIRS_CYAN = registerBoth(stairsCopy(RegisterBlock.CRYSTALLIZED_LIGHT_CYAN),"crystallized_light_stairs_cyan")
    val CRYSTALLIZED_LIGHT_STAIRS_LIGHT_BLUE = registerBoth(stairsCopy(RegisterBlock.CRYSTALLIZED_LIGHT_LIGHT_BLUE),"crystallized_light_stairs_light_blue")
    val CRYSTALLIZED_LIGHT_STAIRS_BLUE = registerBoth(stairsCopy(RegisterBlock.CRYSTALLIZED_LIGHT_BLUE),"crystallized_light_stairs_blue")
    val CRYSTALLIZED_LIGHT_STAIRS_PURPLE = registerBoth(stairsCopy(RegisterBlock.CRYSTALLIZED_LIGHT_PURPLE),"crystallized_light_stairs_purple")
    val CRYSTALLIZED_LIGHT_STAIRS_MAGENTA = registerBoth(stairsCopy(RegisterBlock.CRYSTALLIZED_LIGHT_MAGENTA),"crystallized_light_stairs_magenta")
    val CRYSTALLIZED_LIGHT_STAIRS_PINK = registerBoth(stairsCopy(RegisterBlock.CRYSTALLIZED_LIGHT_PINK),"crystallized_light_stairs_pink")

    val HARD_LIGHT_SLAB = registerBoth(slabCopy(RegisterBlock.HARD_LIGHT_BLOCK),"hard_light_slab")
    val CRYSTALLIZED_LIGHT_SLAB_WHITE = registerBoth(slabCopy(RegisterBlock.CRYSTALLIZED_LIGHT_WHITE),"crystallized_light_slab_white")
    val CRYSTALLIZED_LIGHT_SLAB_LIGHT_GRAY = registerBoth(slabCopy(RegisterBlock.CRYSTALLIZED_LIGHT_LIGHT_GRAY),"crystallized_light_slab_light_gray")
    val CRYSTALLIZED_LIGHT_SLAB_GRAY = registerBoth(slabCopy(RegisterBlock.CRYSTALLIZED_LIGHT_GRAY),"crystallized_light_slab_gray")
    val CRYSTALLIZED_LIGHT_SLAB_BLACK = registerBoth(slabCopy(RegisterBlock.CRYSTALLIZED_LIGHT_BLACK),"crystallized_light_slab_black")
    val CRYSTALLIZED_LIGHT_SLAB_BROWN = registerBoth(slabCopy(RegisterBlock.CRYSTALLIZED_LIGHT_BROWN),"crystallized_light_slab_brown")
    val CRYSTALLIZED_LIGHT_SLAB_RED = registerBoth(slabCopy(RegisterBlock.CRYSTALLIZED_LIGHT_RED),"crystallized_light_slab_red")
    val CRYSTALLIZED_LIGHT_SLAB_ORANGE = registerBoth(slabCopy(RegisterBlock.CRYSTALLIZED_LIGHT_ORANGE),"crystallized_light_slab_orange")
    val CRYSTALLIZED_LIGHT_SLAB_YELLOW = registerBoth(slabCopy(RegisterBlock.CRYSTALLIZED_LIGHT_YELLOW),"crystallized_light_slab_yellow")
    val CRYSTALLIZED_LIGHT_SLAB_LIME = registerBoth(slabCopy(RegisterBlock.CRYSTALLIZED_LIGHT_LIME),"crystallized_light_slab_lime")
    val CRYSTALLIZED_LIGHT_SLAB_GREEN = registerBoth(slabCopy(RegisterBlock.CRYSTALLIZED_LIGHT_GREEN),"crystallized_light_slab_green")
    val CRYSTALLIZED_LIGHT_SLAB_CYAN = registerBoth(slabCopy(RegisterBlock.CRYSTALLIZED_LIGHT_CYAN),"crystallized_light_slab_cyan")
    val CRYSTALLIZED_LIGHT_SLAB_LIGHT_BLUE = registerBoth(slabCopy(RegisterBlock.CRYSTALLIZED_LIGHT_LIGHT_BLUE),"crystallized_light_slab_light_blue")
    val CRYSTALLIZED_LIGHT_SLAB_BLUE = registerBoth(slabCopy(RegisterBlock.CRYSTALLIZED_LIGHT_BLUE),"crystallized_light_slab_blue")
    val CRYSTALLIZED_LIGHT_SLAB_PURPLE = registerBoth(slabCopy(RegisterBlock.CRYSTALLIZED_LIGHT_PURPLE),"crystallized_light_slab_purple")
    val CRYSTALLIZED_LIGHT_SLAB_MAGENTA = registerBoth(slabCopy(RegisterBlock.CRYSTALLIZED_LIGHT_MAGENTA),"crystallized_light_slab_magenta")
    val CRYSTALLIZED_LIGHT_SLAB_PINK = registerBoth(slabCopy(RegisterBlock.CRYSTALLIZED_LIGHT_PINK),"crystallized_light_slab_pink")

    val HARD_LIGHT_PANE = registerBoth(PaneBlock(FabricBlockSettings.copyOf(Blocks.GLASS_PANE).breakInstantly().luminance(10)), "hard_light_pane")
    val CRYSTALLIZED_LIGHT_PANE_WHITE = registerBoth(paneCopy(DyeColor.WHITE),"crystallized_light_pane_white")
    val CRYSTALLIZED_LIGHT_PANE_LIGHT_GRAY = registerBoth(paneCopy(DyeColor.LIGHT_GRAY),"crystallized_light_pane_light_gray")
    val CRYSTALLIZED_LIGHT_PANE_GRAY = registerBoth(paneCopy(DyeColor.GRAY),"crystallized_light_pane_gray")
    val CRYSTALLIZED_LIGHT_PANE_BLACK = registerBoth(paneCopy(DyeColor.BLACK),"crystallized_light_pane_black")
    val CRYSTALLIZED_LIGHT_PANE_BROWN = registerBoth(paneCopy(DyeColor.BROWN),"crystallized_light_pane_brown")
    val CRYSTALLIZED_LIGHT_PANE_RED = registerBoth(paneCopy(DyeColor.RED),"crystallized_light_pane_red")
    val CRYSTALLIZED_LIGHT_PANE_ORANGE = registerBoth(paneCopy(DyeColor.ORANGE),"crystallized_light_pane_orange")
    val CRYSTALLIZED_LIGHT_PANE_YELLOW = registerBoth(paneCopy(DyeColor.YELLOW),"crystallized_light_pane_yellow")
    val CRYSTALLIZED_LIGHT_PANE_LIME = registerBoth(paneCopy(DyeColor.LIME),"crystallized_light_pane_lime")
    val CRYSTALLIZED_LIGHT_PANE_GREEN = registerBoth(paneCopy(DyeColor.GREEN),"crystallized_light_pane_green")
    val CRYSTALLIZED_LIGHT_PANE_CYAN = registerBoth(paneCopy(DyeColor.CYAN),"crystallized_light_pane_cyan")
    val CRYSTALLIZED_LIGHT_PANE_LIGHT_BLUE = registerBoth(paneCopy(DyeColor.LIGHT_BLUE),"crystallized_light_pane_light_blue")
    val CRYSTALLIZED_LIGHT_PANE_BLUE = registerBoth(paneCopy(DyeColor.BLUE),"crystallized_light_pane_blue")
    val CRYSTALLIZED_LIGHT_PANE_PURPLE = registerBoth(paneCopy(DyeColor.PURPLE),"crystallized_light_pane_purple")
    val CRYSTALLIZED_LIGHT_PANE_MAGENTA = registerBoth(paneCopy(DyeColor.MAGENTA),"crystallized_light_pane_magenta")
    val CRYSTALLIZED_LIGHT_PANE_PINK = registerBoth(paneCopy(DyeColor.PINK),"crystallized_light_pane_pink")

    val SHINE_LIGHT_LANTERN = registerBoth(lantern(ParticleTypes.END_ROD), "shine_light_lantern")
    val SHINE_LIGHT_RAINBOW_LANTERN = registerBoth(ShineLightRainbowLanternBlock(FabricBlockSettings.copyOf(Blocks.LANTERN)),"shine_light_rainbow_lantern")
    val SHINE_LIGHT_LIGHT_GRAY_LANTERN = registerBoth(lantern(ColoredEndParticleEffect(DyeColor.LIGHT_GRAY)),"shine_light_light_gray_lantern")
    val SHINE_LIGHT_GRAY_LANTERN = registerBoth(lantern(ColoredEndParticleEffect(DyeColor.GRAY)),"shine_light_gray_lantern")
    val SHINE_LIGHT_BLACK_LANTERN = registerBoth(lantern(ColoredEndParticleEffect(DyeColor.BLACK)),"shine_light_black_lantern")
    val SHINE_LIGHT_BROWN_LANTERN = registerBoth(lantern(ColoredEndParticleEffect(DyeColor.BROWN)),"shine_light_brown_lantern")
    val SHINE_LIGHT_RED_LANTERN = registerBoth(lantern(ColoredEndParticleEffect(DyeColor.RED)),"shine_light_red_lantern")
    val SHINE_LIGHT_ORANGE_LANTERN = registerBoth(lantern(ColoredEndParticleEffect(DyeColor.ORANGE)),"shine_light_orange_lantern")
    val SHINE_LIGHT_YELLOW_LANTERN = registerBoth(lantern(ColoredEndParticleEffect(DyeColor.YELLOW)),"shine_light_yellow_lantern")
    val SHINE_LIGHT_LIME_LANTERN = registerBoth(lantern(ColoredEndParticleEffect(DyeColor.LIME)),"shine_light_lime_lantern")
    val SHINE_LIGHT_GREEN_LANTERN = registerBoth(lantern(ColoredEndParticleEffect(DyeColor.GREEN)),"shine_light_green_lantern")
    val SHINE_LIGHT_CYAN_LANTERN = registerBoth(lantern(ColoredEndParticleEffect(DyeColor.CYAN)),"shine_light_cyan_lantern")
    val SHINE_LIGHT_LIGHT_BLUE_LANTERN = registerBoth(lantern(ColoredEndParticleEffect(DyeColor.LIGHT_BLUE)),"shine_light_light_blue_lantern")
    val SHINE_LIGHT_BLUE_LANTERN = registerBoth(lantern(ColoredEndParticleEffect(DyeColor.BLUE)),"shine_light_blue_lantern")
    val SHINE_LIGHT_PURPLE_LANTERN = registerBoth(lantern(ColoredEndParticleEffect(DyeColor.PURPLE)),"shine_light_purple_lantern")
    val SHINE_LIGHT_MAGENTA_LANTERN = registerBoth(lantern(ColoredEndParticleEffect(DyeColor.MAGENTA)),"shine_light_magenta_lantern")
    val SHINE_LIGHT_PINK_LANTERN = registerBoth(lantern(ColoredEndParticleEffect(DyeColor.PINK)),"shine_light_pink_lantern")

    val STEEL_STAIRS = registerBoth(stairsCopy(RegisterBlock.STEEL_BLOCK),"steel_stairs")
    val STEEL_SLAB = registerBoth(slabCopy(RegisterBlock.STEEL_BLOCK),"steel_slab")
    val STEEL_BARS = registerBoth(PaneBlock(FabricBlockSettings.copyOf(RegisterBlock.STEEL_BLOCK)), "steel_bars")
    val CUT_STEEL_BLOCK = registerBoth(blockCopy(RegisterBlock.STEEL_BLOCK), "cut_steel_block")
    val CUT_STEEL_STAIRS = registerBoth(stairsCopy(RegisterBlock.STEEL_BLOCK),"cut_steel_stairs")
    val CUT_STEEL_SLAB = registerBoth(slabCopy(RegisterBlock.STEEL_BLOCK),"cut_steel_slab")

    val IMBUED_HOPPER = registerBoth(ImbuedHopperBlock(FabricBlockSettings.copyOf(RegisterBlock.STEEL_BLOCK).nonOpaque()),"imbued_hopper")

    val PLACEABLE_POTION = registerBlock(PlaceablePotionBlock(FabricBlockSettings.copyOf(Blocks.GLASS)),"placeable_potion")

    val TINY_CAULDRON = registerBoth(TinyCauldronBlock(FabricBlockSettings.copyOf(Blocks.CAULDRON)),"tiny_cauldron")

    /*
    * X Crystallized Light Stairs
    * X Crystallized Light Slabs
    * X Crystallized Light Panes < Stained Crystallized Light variants with mixes of 2 colors?
    * Crystallized Light Bridge < like CrossCode laser bridges
    * X Steel Stairs
    * X Steel Slabs
    * X Steel Bars
    * Steel Grating + stairs
    * Beryl Copper Bars
    * X Cut Steel Blocks
    * Gem Storage Blocks
    * Colored Warding Candles
    * Shine Light Lanterns - Copper and Iron
    * Force Door
    * Imbued Obsidian
    * Growler 'o' Enchanting < XP Bottle storage block
    *
    * */



    private fun<T: Block> registerBoth(block:T, path: String): T{
        val item = BlockItem(block, AiItemSettings())
        regBlockItem.add(item)
        FzzyPort.ITEM.register(ID.identity(path),item)
        return FzzyPort.BLOCK.register(ID.identity(path),block)
    }

    private fun<T: Block> registerBlock(block:T, path: String): T{
        return FzzyPort.BLOCK.register(ID.identity(path),block)
    }

    private fun<T: Item> registerItem(item:T, path: String): T{
        regBlockItem.add(item)
        return FzzyPort.ITEM.register(ID.identity(path),item)
    }

    private fun blockCopy(block: Block): Block{
        return Block(FabricBlockSettings.copyOf(block))
    }

    private fun stairsCopy(block: Block): StairsBlock{
        return StairsBlock(block.defaultState,FabricBlockSettings.copyOf(block))
    }

    private fun slabCopy(block: Block): SlabBlock {
        return SlabBlock(FabricBlockSettings.copyOf(block))
    }

    private fun paneCopy(color: DyeColor): StainedGlassPaneBlock {
        return StainedGlassPaneBlock(color,FabricBlockSettings.copyOf(Blocks.GLASS_PANE).breakInstantly().luminance(10))
    }

    private fun lantern(particleEffect: ParticleEffect): LanternBlock {
        return ShineLightLanternBlock(FabricBlockSettings.copyOf(Blocks.LANTERN),particleEffect)
    }

    @Suppress("unused")
    private fun always(): Boolean {
        return true
    }
    private fun never(): Boolean {
        return false
    }


}