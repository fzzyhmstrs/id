@file:Suppress("unused")

package me.fzzyhmstrs.imbued_deco.registry

import me.fzzyhmstrs.amethyst_imbuement.AI
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.text.Text

// don't know if this is better as a class or object. as an object it allows me to call it without needing to initialize an instance of it.
object RegisterItemGroup {

    fun registerItemGroup(): ItemGroup {
        return Registry.register(Registries.ITEM_GROUP,AI.identity("id_group"), FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.imbued_deco.id_group"))
            .icon { ItemStack(RegisterBlock.HARD_LIGHT_STAIRS.asItem()) }
            .entries { _, entries ->
                entries.addAll(RegisterBlock.regBlockItem.stream()
                    .map { block -> ItemStack(block) }
                    .toList())
            }.build())
    }

    fun registerAll() {
    }
}