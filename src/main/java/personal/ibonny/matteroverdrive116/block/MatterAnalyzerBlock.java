package personal.ibonny.matteroverdrive116.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

import javax.annotation.Nullable;


public class MatterAnalyzerBlock extends HorizontalBlock {
    public static final BooleanProperty RUNNING = BooleanProperty.create("running");

    public MatterAnalyzerBlock(final Properties properties) {
        super(properties);

        this.setDefaultState(this.getDefaultState().with(RUNNING, false));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);

        builder.add(RUNNING);
        builder.add(HORIZONTAL_FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote()) {
            if (handIn == Hand.MAIN_HAND) {
                if (state.get(RUNNING)) {
                    worldIn.setBlockState(pos, state.with(RUNNING, false));
               } else {
                    worldIn.setBlockState(pos, state.with(RUNNING, true));
                }
            }

            return ActionResultType.SUCCESS;
        }

        return ActionResultType.PASS;
    }
}
