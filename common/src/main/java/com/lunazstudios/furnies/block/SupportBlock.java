package com.lunazstudios.furnies.block;

import com.lunazstudios.furnies.block.properties.FBlockStateProperties;
import com.lunazstudios.furnies.util.block.ShapeUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SupportBlock extends FurnitureHorizontalBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty CONNECTED_RIGHT = FBlockStateProperties.CONNECTED_RIGHT;
    public static final BooleanProperty CONNECTED_LEFT = FBlockStateProperties.CONNECTED_LEFT;

    protected static final VoxelShape TOP = Block.box(0, 12, 0, 16, 16, 16);

    protected static final VoxelShape BOTTOM_SHAPE_NORTH = Shapes.or(
            Block.box(6, 3, 9, 10, 16, 12),
            Block.box(6, 4, 12, 10, 13, 13),
            Block.box(4, 3, 13, 12, 11, 16));
    protected static final VoxelShape BOTTOM_SHAPE_EAST = ShapeUtil.rotateShape(BOTTOM_SHAPE_NORTH, Direction.EAST);
    protected static final VoxelShape BOTTOM_SHAPE_SOUTH = ShapeUtil.rotateShape(BOTTOM_SHAPE_NORTH, Direction.SOUTH);
    protected static final VoxelShape BOTTOM_SHAPE_WEST = ShapeUtil.rotateShape(BOTTOM_SHAPE_NORTH, Direction.WEST);

    protected static final VoxelShape[] BOTTOM_SHAPES = new VoxelShape[] {
            BOTTOM_SHAPE_SOUTH, BOTTOM_SHAPE_WEST, BOTTOM_SHAPE_NORTH, BOTTOM_SHAPE_EAST
    };

    public SupportBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, false)
                .setValue(CONNECTED_RIGHT, false)
                .setValue(CONNECTED_LEFT, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction facing = state.getValue(FACING);
        // Always include the top.
        VoxelShape shape = TOP;
        // Add the bottom shape unless both sides are connected.
        boolean right = state.getValue(CONNECTED_RIGHT);
        boolean left = state.getValue(CONNECTED_LEFT);
        if (!(right && left)) {
            int index = getBottomShapeIndex(facing);
            shape = Shapes.or(shape, BOTTOM_SHAPES[index]);
        }
        return shape;
    }

    private int getBottomShapeIndex(Direction facing) {
        switch (facing) {
            case SOUTH:
                return 0;
            case WEST:
                return 1;
            case NORTH:
                return 2;
            case EAST:
                return 3;
            default:
                return 0;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        boolean waterlogged = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
        BlockState state = this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection().getOpposite())
                .setValue(WATERLOGGED, waterlogged);
        return updateConnections(state, context.getLevel(), context.getClickedPos());
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState,
                                  LevelAccessor level, BlockPos currentPos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        return updateConnections(state, level, currentPos);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED)
                ? Fluids.WATER.getSource(false)
                : super.getFluidState(state);
    }

    protected BlockState updateConnections(BlockState state, LevelAccessor level, BlockPos pos) {
        Direction facing = state.getValue(FACING);
        Direction rightDir = facing.getClockWise();
        Direction leftDir = facing.getCounterClockWise();

        boolean connectedRight = isValidConnection(level.getBlockState(pos.relative(rightDir)));
        boolean connectedLeft = isValidConnection(level.getBlockState(pos.relative(leftDir)));

        return state.setValue(CONNECTED_RIGHT, connectedRight)
                .setValue(CONNECTED_LEFT, connectedLeft);
    }

    protected boolean isValidConnection(BlockState neighborState) {
        return neighborState.getBlock() instanceof SupportBlock;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, CONNECTED_RIGHT, CONNECTED_LEFT);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)))
                .setValue(CONNECTED_RIGHT, false)
                .setValue(CONNECTED_LEFT, false);
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }
}
