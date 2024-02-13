package me.fzzyhmstrs.imbued_deco.registry

import me.fzzyhmstrs.imbued_deco.entity.PlaceablePotionBlockEntity
import me.fzzyhmstrs.imbued_deco.entity.TinyCauldronBlockEntity
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry
import net.minecraft.client.render.RenderLayer

object RegisterRenderer {

    fun registerAll() {
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.HARD_LIGHT_STAIRS, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_STAIRS_WHITE, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_STAIRS_LIGHT_GRAY, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_STAIRS_GRAY, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_STAIRS_BLACK, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_STAIRS_BROWN, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_STAIRS_RED, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_STAIRS_ORANGE, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_STAIRS_YELLOW, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_STAIRS_LIME, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_STAIRS_GREEN, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_STAIRS_CYAN, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_STAIRS_LIGHT_BLUE, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_STAIRS_BLUE, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_STAIRS_PURPLE, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_STAIRS_MAGENTA, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_STAIRS_PINK, RenderLayer.getTranslucent())

        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.HARD_LIGHT_SLAB, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_SLAB_WHITE, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_SLAB_LIGHT_GRAY, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_SLAB_GRAY, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_SLAB_BLACK, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_SLAB_BROWN, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_SLAB_RED, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_SLAB_ORANGE, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_SLAB_YELLOW, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_SLAB_LIME, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_SLAB_GREEN, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_SLAB_CYAN, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_SLAB_LIGHT_BLUE, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_SLAB_BLUE, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_SLAB_PURPLE, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_SLAB_MAGENTA, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_SLAB_PINK, RenderLayer.getTranslucent())

        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.HARD_LIGHT_PANE, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_PANE_WHITE, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_PANE_LIGHT_GRAY, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_PANE_GRAY, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_PANE_BLACK, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_PANE_BROWN, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_PANE_RED, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_PANE_ORANGE, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_PANE_YELLOW, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_PANE_LIME, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_PANE_GREEN, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_PANE_CYAN, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_PANE_LIGHT_BLUE, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_PANE_BLUE, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_PANE_PURPLE, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_PANE_MAGENTA, RenderLayer.getTranslucent())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.CRYSTALLIZED_LIGHT_PANE_PINK, RenderLayer.getTranslucent())

        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.SHINE_LIGHT_LANTERN, RenderLayer.getCutout())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.SHINE_LIGHT_RAINBOW_LANTERN, RenderLayer.getCutout())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.SHINE_LIGHT_LIGHT_GRAY_LANTERN, RenderLayer.getCutout())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.SHINE_LIGHT_GRAY_LANTERN, RenderLayer.getCutout())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.SHINE_LIGHT_BLACK_LANTERN, RenderLayer.getCutout())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.SHINE_LIGHT_BROWN_LANTERN, RenderLayer.getCutout())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.SHINE_LIGHT_RED_LANTERN, RenderLayer.getCutout())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.SHINE_LIGHT_ORANGE_LANTERN, RenderLayer.getCutout())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.SHINE_LIGHT_YELLOW_LANTERN, RenderLayer.getCutout())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.SHINE_LIGHT_LIME_LANTERN, RenderLayer.getCutout())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.SHINE_LIGHT_GREEN_LANTERN, RenderLayer.getCutout())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.SHINE_LIGHT_CYAN_LANTERN, RenderLayer.getCutout())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.SHINE_LIGHT_LIGHT_BLUE_LANTERN, RenderLayer.getCutout())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.SHINE_LIGHT_BLUE_LANTERN, RenderLayer.getCutout())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.SHINE_LIGHT_PURPLE_LANTERN, RenderLayer.getCutout())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.SHINE_LIGHT_MAGENTA_LANTERN, RenderLayer.getCutout())
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.SHINE_LIGHT_PINK_LANTERN, RenderLayer.getCutout())

        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.STEEL_BARS, RenderLayer.getCutout())

        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.IMBUED_HOPPER, RenderLayer.getCutoutMipped())

        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlock.PLACEABLE_POTION, RenderLayer.getTranslucent())

        ColorProviderRegistry.BLOCK.register({_, renderView, pos, tintIndex ->
            if (renderView == null || pos == null) return@register -1
            (renderView.getBlockEntity(pos) as? PlaceablePotionBlockEntity)?.getColor(tintIndex) ?: -1
        }, RegisterBlock.PLACEABLE_POTION)

        ColorProviderRegistry.BLOCK.register({_, renderView, pos, tintindex ->
            if (renderView == null || pos == null || tintindex != 1) return@register -1
            (renderView.getBlockEntity(pos) as? TinyCauldronBlockEntity)?.getColor() ?: -1
        }, RegisterBlock.TINY_CAULDRON)
    }
}