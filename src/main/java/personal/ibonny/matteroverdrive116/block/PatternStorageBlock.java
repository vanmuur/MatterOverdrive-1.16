package personal.ibonny.matteroverdrive116.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;
import java.util.stream.Stream;


public class PatternStorageBlock extends HorizontalBlock {
    protected PatternStorageBlock(Properties properties) {
        super(properties);
    }

    private static final VoxelShape SHAPE_N = Stream.of(
        Block.makeCuboidShape(3, 0, 3, 13, 13, 16),
        Block.makeCuboidShape(0, 13, 3, 16, 16, 16),
        VoxelShapes.combineAndSimplify(Block.makeCuboidShape(13, 0, 3, 16, 13, 4), VoxelShapes.combineAndSimplify(Block.makeCuboidShape(13, 3, 4, 16, 13, 5), VoxelShapes.combineAndSimplify(Block.makeCuboidShape(13, 7, 5, 16, 13, 6), VoxelShapes.combineAndSimplify(Block.makeCuboidShape(13, 10, 6, 16, 13, 7), VoxelShapes.combineAndSimplify(Block.makeCuboidShape(13, 11, 7, 16, 13, 8), VoxelShapes.combineAndSimplify(Block.makeCuboidShape(13, 12, 8, 16, 13, 9), VoxelShapes.combineAndSimplify(Block.makeCuboidShape(13, 12, 9, 16, 13, 10), Block.makeCuboidShape(13, 12, 10, 16, 13, 11), IBooleanFunction.OR), IBooleanFunction.OR), IBooleanFunction.OR), IBooleanFunction.OR), IBooleanFunction.OR), IBooleanFunction.OR), IBooleanFunction.OR),
        VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 0, 3, 3, 13, 4), VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 3, 4, 3, 13, 5), VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 7, 5, 3, 13, 6), VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 10, 6, 3, 13, 7), VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 11, 7, 3, 13, 8), VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 12, 8, 3, 13, 9), VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 12, 9, 3, 13, 10), Block.makeCuboidShape(0, 12, 10, 3, 13, 11), IBooleanFunction.OR), IBooleanFunction.OR), IBooleanFunction.OR), IBooleanFunction.OR), IBooleanFunction.OR), IBooleanFunction.OR), IBooleanFunction.OR)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
//        switch (state.get(HORIZONTAL_FACING)) {
//            case NORTH:
//                return SHAPE_N;
//            case SOUTH:
//                return SHAPE_S;
//            case WEST:
//                return SHAPE_W;
//            case EAST:
//                return SHAPE_E;
//            default:
//                return SHAPE_N;
//        }

        return SHAPE_N;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);

        builder.add(HORIZONTAL_FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
    }
}
