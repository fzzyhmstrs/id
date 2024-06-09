package me.fzzyhmstrs.imbued_deco.block

import me.fzzyhmstrs.imbued_deco.entity.TinyCauldronBlockEntity
import net.minecraft.block.*
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.ItemUsage
import net.minecraft.item.Items
import net.minecraft.item.PotionItem
import net.minecraft.particle.ParticleTypes
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents
import net.minecraft.state.StateManager
import net.minecraft.state.property.BooleanProperty
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.random.Random
import net.minecraft.util.shape.VoxelShape
import net.minecraft.world.BlockView
import net.minecraft.world.World

class TinyCauldronBlock(settings: Settings) : BlockWithEntity(settings) {

    companion object{
        private val shape =
            createCuboidShape(4.0,0.0,4.0,12.0,8.0,12.0)
        val POTION: BooleanProperty = BooleanProperty.of("potion")
    }

    init {
        this.defaultState = this.defaultState.with(POTION,false)
    }

    @Deprecated("Deprecated in Java")
    override fun onUse(
        state: BlockState,
        world: World,
        pos: BlockPos,
        player: PlayerEntity,
        hand: Hand,
        hit: BlockHitResult
    ): ActionResult {
        val stack = player.getStackInHand(hand)
        if (stack.item is PotionItem && !state.get(POTION)){
            val blockEntity = world.getBlockEntity(pos) as? TinyCauldronBlockEntity ?: return ActionResult.PASS
            blockEntity.setStack(0,stack.copy())
            player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, ItemStack(Items.GLASS_BOTTLE)))
            world.setBlockState(pos,state.with(POTION,true))
            world.playSound(null, pos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 0.75f, 1.0f)
            return ActionResult.success(world.isClient)
        } else if (stack.isOf(Items.GLASS_BOTTLE) && state.get(POTION)){
            val blockEntity = world.getBlockEntity(pos) as? TinyCauldronBlockEntity
            val newStack = blockEntity?.getStack(0)?.copy() ?: return ActionResult.PASS
            blockEntity.clear()
            player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, newStack))
            world.setBlockState(pos,state.with(POTION,false))
            world.playSound(null, pos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 0.75f, 1.0f)
            return ActionResult.success(world.isClient)
        }
        return super.onUse(state, world, pos, player, hand, hit)
    }

    @Deprecated("Deprecated in Java")
    override fun getOutlineShape(
        state: BlockState,
        world: BlockView,
        pos: BlockPos,
        context: ShapeContext
    ): VoxelShape {
        return shape
    }

    @Deprecated("Deprecated in Java", ReplaceWith("BlockRenderType.MODEL", "net.minecraft.block.BlockRenderType"))
    override fun getRenderType(state: BlockState?): BlockRenderType {
        return BlockRenderType.MODEL
    }

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        builder.add(POTION)
    }

    override fun createBlockEntity(pos: BlockPos, state: BlockState): BlockEntity {
        return TinyCauldronBlockEntity(pos, state)
    }

    override fun onPlaced(
        world: World,
        pos: BlockPos,
        state: BlockState,
        placer: LivingEntity?,
        itemStack: ItemStack
    ) {
        val blockEntity = world.getBlockEntity(pos) as? TinyCauldronBlockEntity ?: return
        if (itemStack.hasCustomName()) {
            blockEntity.setCustomName(itemStack.name)
        }
    }

    /*@Deprecated("Deprecated in Java")
    override fun onStateReplaced(
        state: BlockState,
        world: World,
        pos: BlockPos,
        newState: BlockState,
        moved: Boolean
    ) {
        if (state.isOf(newState.block))
            return
        val blockEntity = world.getBlockEntity(pos)
        if (blockEntity is TinyCauldronBlockEntity){
            blockEntity.onStateReplaced(world, pos)
            blockEntity.clear()
            world.updateComparators(pos, this)
        }
        super.onStateReplaced(state, world, pos, newState, moved)
    }*/

    override fun randomDisplayTick(state: BlockState, world: World, pos: BlockPos, random: Random) {
        if (random.nextInt(3) == 0){
            val blockEntity = world.getBlockEntity(pos) as? TinyCauldronBlockEntity ?: return
            val color = blockEntity.getColor()
            if (color == -1) return
            val d: Double = (color shr 16 and 0xFF).toDouble() / 255.0
            val e: Double = (color shr 8 and 0xFF).toDouble() / 255.0
            val f: Double = (color shr 0 and 0xFF).toDouble() / 255.0
            world.addParticle(ParticleTypes.ENTITY_EFFECT, pos.x + 0.5, pos.y + 0.5, pos.z + 0.5, d,e,f)
        }
        super.randomDisplayTick(state, world, pos, random)
    }
}