package me.fzzyhmstrs.imbued_deco.registry

import me.fzzyhmstrs.amethyst_imbuement.AI
import me.fzzyhmstrs.fzzy_core.coding_util.FzzyPort
import me.fzzyhmstrs.fzzy_core.entity_util.EntityBuilder
import me.fzzyhmstrs.imbued_deco.entity.ImbuedHopperBlockEntity
import me.fzzyhmstrs.imbued_deco.entity.PlaceablePotionBlockEntity
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityType

object RegisterEntity: EntityBuilder() {

    fun <T: BlockEntity> BlockEntityType<T>.register(name: String): BlockEntityType<T> {
        return FzzyPort.BLOCK_ENTITY_TYPE.register(AI.identity(name), this)
    }

    val IMBUED_HOPPER_BLOCK_ENTITY = buildBlockEntity({ p, s -> ImbuedHopperBlockEntity(p, s) }, RegisterBlock.IMBUED_HOPPER).register("imbued_hopper_entity")
    val PLACEABLE_POTION_BLOCK_ENTITY = buildBlockEntity({ p, s -> PlaceablePotionBlockEntity(p, s) }, RegisterBlock.PLACEABLE_POTION).register("placeable_potion_entity")


    fun registerAll(){}

}