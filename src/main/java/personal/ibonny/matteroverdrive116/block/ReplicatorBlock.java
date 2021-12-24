package personal.ibonny.matteroverdrive116.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;

import javax.annotation.Nullable;


public class ReplicatorBlock extends HorizontalBlock {
//    public static final BooleanProperty RUNNING = BooleanProperty.create("running");

    public ReplicatorBlock(final Properties properties) {
        super(properties);

//        this.setDefaultState(this.getDefaultState().with(RUNNING, false));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);

//        builder.add(RUNNING);
        builder.add(HORIZONTAL_FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
    }
}
