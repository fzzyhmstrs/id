package me.fzzyhmstrs.imbued_deco.mixins;

import me.fzzyhmstrs.imbued_deco.block.PlaceablePotionBlock;
import me.fzzyhmstrs.imbued_deco.entity.PlaceablePotionBlockEntity;
import me.fzzyhmstrs.imbued_deco.registry.RegisterBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.PotionItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PotionItem.class)
public class PotionItemMixin {

    @Inject(method = "useOnBlock", at = @At("TAIL"))
    private void imbued_deco_placeablePotionOnUse(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir){
        if (context.getSide() != Direction.UP){
            World world = context.getWorld();
            BlockPos blockPos = context.getBlockPos();
            BlockState blockState = world.getBlockState(blockPos);
            if (blockState.isOf(RegisterBlock.INSTANCE.getPLACEABLE_POTION())){
                if (blockState.get(PlaceablePotionBlock.Companion.getPOTIONS()) == 4) return;
                BlockEntity blockEntity = world.getBlockEntity(blockPos);
                if (!(blockEntity instanceof PlaceablePotionBlockEntity)) return;
                BlockState newBlockState = blockState.cycle(PlaceablePotionBlock.Companion.getPOTIONS());
                int slot = newBlockState.get(PlaceablePotionBlock.Companion.getPOTIONS()) - 1;
                ItemStack stack = context.getStack().split(1);
                ((PlaceablePotionBlockEntity)blockEntity).setStack(slot,stack);
                world.setBlockState(blockPos,newBlockState);
                world.playSound(null, blockPos, SoundEvents.BLOCK_BREWING_STAND_BREW, SoundCategory.BLOCKS, 0.75f, 1.0f);
                cir.setReturnValue(ActionResult.success(world.isClient));
            }
        }
    }


}
