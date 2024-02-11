@file:Suppress("PropertyName")

package me.fzzyhmstrs.imbued_deco

import me.fzzyhmstrs.imbued_deco.registry.RegisterBlock
import me.fzzyhmstrs.imbued_deco.registry.RegisterEntity
import me.fzzyhmstrs.imbued_deco.registry.RegisterRenderer
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.fabricmc.api.ModInitializer
import net.minecraft.util.Identifier
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.random.Random


object ID: ModInitializer {
    const val MOD_ID = "imbued_deco"
    val LOGGER: Logger = LoggerFactory.getLogger("imbued_deco")
    override fun onInitialize() {
        RegisterBlock.registerAll()
        RegisterEntity.registerAll()
    }

    fun random(): Random {
        return Random(System.currentTimeMillis())
    }

    fun identity(path: String): Identifier{
        return Identifier(MOD_ID,path)
    }
}

@Environment(value = EnvType.CLIENT)
object IDClient: ClientModInitializer{

    override fun onInitializeClient() {
        RegisterRenderer.registerAll()
    }

    fun random(): Random{
        return Random(System.currentTimeMillis())
    }
}