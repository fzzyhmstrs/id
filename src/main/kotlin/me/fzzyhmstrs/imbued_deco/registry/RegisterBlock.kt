package me.fzzyhmstrs.imbued_deco.registry

import me.fzzyhmstrs.amethyst_imbuement.AI
import me.fzzyhmstrs.amethyst_imbuement.item.AiItemSettings
import me.fzzyhmstrs.amethyst_imbuement.registry.RegisterBlock
import me.fzzyhmstrs.fzzy_core.coding_util.FzzyPort
import net.minecraft.block.Block
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import java.util.ArrayList

object RegisterBlock {

    internal val regBlockItem: ArrayList<Item> = ArrayList(65)

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


    @Suppress("unused")
    private fun always(): Boolean {
        return true
    }
    private fun never(): Boolean {
        return false
    }


}