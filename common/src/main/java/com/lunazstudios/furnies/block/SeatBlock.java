package com.lunazstudios.furnies.block;

import com.lunazstudios.furnies.entity.SeatEntity;
import com.lunazstudios.furnies.registry.FBlockTags;
import com.lunazstudios.furnies.registry.FEntityTypeTags;
import com.lunazstudios.furnies.registry.FRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;
import java.util.Optional;

/**
 * Original Author: StarfishStudios
 * Project: Another Furniture
 */

public class SeatBlock extends Block {
    public SeatBlock(Properties properties) {
        super(properties);
    }

    public float seatHeight(BlockState state) {
        return 0.35F;
    }

    public boolean isSittable(BlockState state) {
        return true;
    }

    public BlockPos primaryDismountLocation(Level level, BlockState state, BlockPos pos) {
        return pos;
    }

    public float setRiderRotation(BlockState state, Entity entity) {
        return entity.getYRot();
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (FRegistry.isFakePlayer(player)) return InteractionResult.PASS;
        if (!level.mayInteract(player, pos)) return InteractionResult.PASS;
        if (!isSittable(state) || player.isPassenger() || player.isCrouching()) return InteractionResult.PASS;

        if (isSeatBlocked(level, pos)) return InteractionResult.PASS;
        if (isSeatOccupied(level, pos)) {
            List<SeatEntity> seats = level.getEntitiesOfClass(SeatEntity.class, new AABB(pos));
            if (ejectSeatedExceptPlayer(level, seats.get(0))) return InteractionResult.SUCCESS;
            return InteractionResult.PASS;
        }


        if (level.isClientSide) return InteractionResult.SUCCESS;
        sitDown(level, pos, getLeashed(player).orElse(player));
        return InteractionResult.SUCCESS;
    }

    public static boolean isSeatBlocked(Level level, BlockPos pos) {
        return !(level.getBlockState(pos.above()).getCollisionShape(level, pos).isEmpty() ||
                level.getBlockState(pos.above()).is(FBlockTags.ABOVE_BYPASSES_SEAT_CHECK));
    }

    public static boolean isSeatOccupied(Level level, BlockPos pos) {
        return !level.getEntitiesOfClass(SeatEntity.class, new AABB(pos)).isEmpty();
    }

    public static Optional<Entity> getLeashed(Player player) {
        List<Entity> entities = player.level().getEntities((Entity) null, player.getBoundingBox().inflate(10), e -> true);
        for (Entity e : entities)
            if (e instanceof Mob mob && mob.getLeashHolder() == player && canBePickedUp(e)) return Optional.of(mob);
        return Optional.empty();
    }

    public static boolean ejectSeatedExceptPlayer(Level level, SeatEntity seatEntity) {
        List<Entity> passengers = seatEntity.getPassengers();
        if (!passengers.isEmpty() && passengers.get(0) instanceof Player) return false;
        if (!level.isClientSide) seatEntity.ejectPassengers();
        return true;
    }

    public static boolean canBePickedUp(Entity passenger) {
        if (passenger instanceof Player) return false;
        if (passenger instanceof TamableAnimal ta && !ta.isTame()) return false;
        return passenger instanceof LivingEntity && passenger.getType().is(FEntityTypeTags.CAN_SIT_IN_SEATS);
    }

    public static void sitDown(Level level, BlockPos pos, Entity entity) {
        if (level.isClientSide) return;

        SeatEntity seat = new SeatEntity(level, pos);
        level.addFreshEntity(seat);
        entity.startRiding(seat);

        level.updateNeighbourForOutputSignal(pos, level.getBlockState(pos).getBlock());

        if (entity instanceof TamableAnimal ta) ta.setInSittingPose(true);
    }

    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
        return false;
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    public int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
        return isSeatOccupied(level, pos) ? 15 : 0;
    }
}
