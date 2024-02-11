package me.fzzyhmstrs.imbued_deco.mixins;

import net.minecraft.block.entity.HopperBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(HopperBlockEntity.class)
public interface HopperBlockEntityAccessor {
    @Accessor
    long getLastTickTime();

    @Accessor
    void setLastTickTime(long lastTickTime);

    @Invoker
    void callSetTransferCooldown(int transferCooldown);

    @Invoker
    boolean callIsDisabled();
}
