package me.fzzyhmstrs.imbued_deco.registry

import me.fzzyhmstrs.amethyst_imbuement.AI
import me.fzzyhmstrs.amethyst_imbuement.item.AiItemSettings
import me.fzzyhmstrs.fzzy_core.coding_util.FzzyBlockSettings
import me.fzzyhmstrs.amethyst_imbuement.registry.RegisterBlock as RegisterAi
import me.fzzyhmstrs.fzzy_core.coding_util.FzzyPort
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.*
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.util.DyeColor
import java.util.ArrayList

object RegisterBlock {

    internal val regBlockItem: ArrayList<Item> = ArrayList(65)

    fun registerAll(){}

    val HARD_LIGHT_STAIRS = registerBoth(stairsCopy(RegisterAi.HARD_LIGHT_BLOCK),"hard_light_stairs")
    val CRYSTALLIZED_LIGHT_STAIRS_WHITE = registerBoth(stairsCopy(RegisterAi.CRYSTALLIZED_LIGHT_WHITE),"crystallized_light_stairs_white")
    val CRYSTALLIZED_LIGHT_STAIRS_LIGHT_GRAY = registerBoth(stairsCopy(RegisterAi.CRYSTALLIZED_LIGHT_LIGHT_GRAY),"crystallized_light_stairs_light_gray")
    val CRYSTALLIZED_LIGHT_STAIRS_GRAY = registerBoth(stairsCopy(RegisterAi.CRYSTALLIZED_LIGHT_GRAY),"crystallized_light_stairs_gray")
    val CRYSTALLIZED_LIGHT_STAIRS_BLACK = registerBoth(stairsCopy(RegisterAi.CRYSTALLIZED_LIGHT_BLACK),"crystallized_light_stairs_black")
    val CRYSTALLIZED_LIGHT_STAIRS_BROWN = registerBoth(stairsCopy(RegisterAi.CRYSTALLIZED_LIGHT_BROWN),"crystallized_light_stairs_brown")
    val CRYSTALLIZED_LIGHT_STAIRS_RED = registerBoth(stairsCopy(RegisterAi.CRYSTALLIZED_LIGHT_RED),"crystallized_light_stairs_red")
    val CRYSTALLIZED_LIGHT_STAIRS_ORANGE = registerBoth(stairsCopy(RegisterAi.CRYSTALLIZED_LIGHT_ORANGE),"crystallized_light_stairs_orange")
    val CRYSTALLIZED_LIGHT_STAIRS_YELLOW = registerBoth(stairsCopy(RegisterAi.CRYSTALLIZED_LIGHT_YELLOW),"crystallized_light_stairs_yellow")
    val CRYSTALLIZED_LIGHT_STAIRS_LIME = registerBoth(stairsCopy(RegisterAi.CRYSTALLIZED_LIGHT_LIME),"crystallized_light_stairs_lime")
    val CRYSTALLIZED_LIGHT_STAIRS_GREEN = registerBoth(stairsCopy(RegisterAi.CRYSTALLIZED_LIGHT_GREEN),"crystallized_light_stairs_green")
    val CRYSTALLIZED_LIGHT_STAIRS_CYAN = registerBoth(stairsCopy(RegisterAi.CRYSTALLIZED_LIGHT_CYAN),"crystallized_light_stairs_cyan")
    val CRYSTALLIZED_LIGHT_STAIRS_LIGHT_BLUE = registerBoth(stairsCopy(RegisterAi.CRYSTALLIZED_LIGHT_LIGHT_BLUE),"crystallized_light_stairs_light_blue")
    val CRYSTALLIZED_LIGHT_STAIRS_BLUE = registerBoth(stairsCopy(RegisterAi.CRYSTALLIZED_LIGHT_BLUE),"crystallized_light_stairs_blue")
    val CRYSTALLIZED_LIGHT_STAIRS_PURPLE = registerBoth(stairsCopy(RegisterAi.CRYSTALLIZED_LIGHT_PURPLE),"crystallized_light_stairs_purple")
    val CRYSTALLIZED_LIGHT_STAIRS_MAGENTA = registerBoth(stairsCopy(RegisterAi.CRYSTALLIZED_LIGHT_MAGENTA),"crystallized_light_stairs_magenta")
    val CRYSTALLIZED_LIGHT_STAIRS_PINK = registerBoth(stairsCopy(RegisterAi.CRYSTALLIZED_LIGHT_PINK),"crystallized_light_stairs_pink")

    val HARD_LIGHT_SLAB = registerBoth(slabCopy(RegisterAi.HARD_LIGHT_BLOCK),"hard_light_slab")
    val CRYSTALLIZED_LIGHT_SLAB_WHITE = registerBoth(slabCopy(RegisterAi.CRYSTALLIZED_LIGHT_WHITE),"crystallized_light_slab_white")
    val CRYSTALLIZED_LIGHT_SLAB_LIGHT_GRAY = registerBoth(slabCopy(RegisterAi.CRYSTALLIZED_LIGHT_LIGHT_GRAY),"crystallized_light_slab_light_gray")
    val CRYSTALLIZED_LIGHT_SLAB_GRAY = registerBoth(slabCopy(RegisterAi.CRYSTALLIZED_LIGHT_GRAY),"crystallized_light_slab_gray")
    val CRYSTALLIZED_LIGHT_SLAB_BLACK = registerBoth(slabCopy(RegisterAi.CRYSTALLIZED_LIGHT_BLACK),"crystallized_light_slab_black")
    val CRYSTALLIZED_LIGHT_SLAB_BROWN = registerBoth(slabCopy(RegisterAi.CRYSTALLIZED_LIGHT_BROWN),"crystallized_light_slab_brown")
    val CRYSTALLIZED_LIGHT_SLAB_RED = registerBoth(slabCopy(RegisterAi.CRYSTALLIZED_LIGHT_RED),"crystallized_light_slab_red")
    val CRYSTALLIZED_LIGHT_SLAB_ORANGE = registerBoth(slabCopy(RegisterAi.CRYSTALLIZED_LIGHT_ORANGE),"crystallized_light_slab_orange")
    val CRYSTALLIZED_LIGHT_SLAB_YELLOW = registerBoth(slabCopy(RegisterAi.CRYSTALLIZED_LIGHT_YELLOW),"crystallized_light_slab_yellow")
    val CRYSTALLIZED_LIGHT_SLAB_LIME = registerBoth(slabCopy(RegisterAi.CRYSTALLIZED_LIGHT_LIME),"crystallized_light_slab_lime")
    val CRYSTALLIZED_LIGHT_SLAB_GREEN = registerBoth(slabCopy(RegisterAi.CRYSTALLIZED_LIGHT_GREEN),"crystallized_light_slab_green")
    val CRYSTALLIZED_LIGHT_SLAB_CYAN = registerBoth(slabCopy(RegisterAi.CRYSTALLIZED_LIGHT_CYAN),"crystallized_light_slab_cyan")
    val CRYSTALLIZED_LIGHT_SLAB_LIGHT_BLUE = registerBoth(slabCopy(RegisterAi.CRYSTALLIZED_LIGHT_LIGHT_BLUE),"crystallized_light_slab_light_blue")
    val CRYSTALLIZED_LIGHT_SLAB_BLUE = registerBoth(slabCopy(RegisterAi.CRYSTALLIZED_LIGHT_BLUE),"crystallized_light_slab_blue")
    val CRYSTALLIZED_LIGHT_SLAB_PURPLE = registerBoth(slabCopy(RegisterAi.CRYSTALLIZED_LIGHT_PURPLE),"crystallized_light_slab_purple")
    val CRYSTALLIZED_LIGHT_SLAB_MAGENTA = registerBoth(slabCopy(RegisterAi.CRYSTALLIZED_LIGHT_MAGENTA),"crystallized_light_slab_magenta")
    val CRYSTALLIZED_LIGHT_SLAB_PINK = registerBoth(slabCopy(RegisterAi.CRYSTALLIZED_LIGHT_PINK),"crystallized_light_slab_pink")

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







    /*
    * Crystallized Light Stairs
    * Crystallized Light Slabs
    * Crystallized Light Panes < Stained Crystallized Light variants with mixes of 2 colors?
    * Crystallized Light Bridge < like CrossCode laser bridges
    * Steel Stairs
    * Steel Slabs
    * Steel Bars
    * Steel Grating + stairs
    * Beryl Copper Bars
    * Cut Steel Blocks
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
        FzzyPort.ITEM.register(AI.identity(path),item)
        return FzzyPort.BLOCK.register(AI.identity(path),block)
    }

    private fun<T: Block> registerBlock(block:T, path: String): T{
        return FzzyPort.BLOCK.register(AI.identity(path),block)
    }

    private fun<T: Item> registerItem(item:T, path: String): T{
        regBlockItem.add(item)
        return FzzyPort.ITEM.register(AI.identity(path),item)
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

    @Suppress("unused")
    private fun always(): Boolean {
        return true
    }
    private fun never(): Boolean {
        return false
    }


}