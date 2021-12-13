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


public class StarMapBlock extends HorizontalBlock {
    protected StarMapBlock(Properties properties) {
        super(properties);
    }

    private static final VoxelShape SHAPE_N = Stream.of(
        Block.makeCuboidShape(0, 0, 0, 16, 4, 16),
        Block.makeCuboidShape(2, 4, 2, 14, 7, 14),
        Block.makeCuboidShape(0, 7, 0, 16, 9, 16),
        Block.makeCuboidShape(1, 4, 12, 2, 7, 13),
        Block.makeCuboidShape(1, 4, 10, 2, 7, 11),
        Block.makeCuboidShape(1, 4, 8, 2, 7, 9),
        Block.makeCuboidShape(3, 4, 1, 4, 7, 2),
        Block.makeCuboidShape(5, 4, 1, 6, 7, 2),
        Block.makeCuboidShape(7, 4, 1, 8, 7, 2),
        Block.makeCuboidShape(14, 4, 3, 15, 7, 4),
        Block.makeCuboidShape(14, 4, 5, 15, 7, 6),
        Block.makeCuboidShape(14, 4, 7, 15, 7, 8),
        Block.makeCuboidShape(12, 4, 14, 13, 7, 15),
        Block.makeCuboidShape(10, 4, 14, 11, 7, 15),
        Block.makeCuboidShape(8, 4, 14, 9, 7, 15)
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
