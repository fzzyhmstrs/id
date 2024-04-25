package me.fzzyhmstrs.imbued_deco.mixins;

import me.fzzyhmstrs.imbued_deco.block.PlaceablePotionBlock;
import me.fzzyhmstrs.imbued_deco.entity.PlaceablePotionBlockEntity;
import me.fzzyhmstrs.imbued_deco.registry.RegisterBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
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

    @Inject(method = "useOnBlock", at = @At("TAIL"), cancellable = true)
    private void imbued_deco_placeablePotionOnUse(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir){
        if ((Object)this instanceof SplashPotionItem || (Object)this instanceof LingeringPotionItem) return;
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
        } else {
            PlayerEntity playerEntity = context.getPlayer();
            if (playerEntity == null) return;
            if (Direction.getEntityFacingOrder(playerEntity)[0] != Direction.DOWN) return;
            Direction side = context.getSide();
            BlockState blockState2 = world.getBlockState(blockPos.offset(side));
            BlockPos downPos = blockPos.offset(side).down();
            if (blockState2.isReplaceable() &&  Block.isFaceFullSquare(world.getBlockState(downPos).getSidesShape(world, downPos), Direction.UP)){
                world.setBlockState(blockPos.offset(side),RegisterBlock.INSTANCE.getPLACEABLE_POTION().getDefaultState());
                BlockEntity blockEntity = world.getBlockEntity(blockPos.offset(side));
                if (blockEntity instanceof PlaceablePotionBlockEntity){
                    ItemStack stack = context.getStack().split(1);
                    ((PlaceablePotionBlockEntity)blockEntity).setStack(0,stack);
                    world.playSound(null, blockPos, SoundEvents.BLOCK_BREWING_STAND_BREW, SoundCategory.BLOCKS, 0.75f, 1.0f);
                    cir.setReturnValue(ActionResult.success(world.isClient));
                }
            }
        }

    }


}