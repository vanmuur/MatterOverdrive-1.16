package personal.ibonny.matteroverdrive116.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import personal.ibonny.matteroverdrive116.tile.ModTileEntities;

import javax.annotation.Nullable;


public class MatterRecyclerBlock extends Block {
    public static final BooleanProperty RUNNING = BooleanProperty.create("running");

    public MatterRecyclerBlock(final Properties properties) {
        super(properties);

        this.setDefaultState(this.getDefaultState().with(RUNNING, false));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);

        builder.add(RUNNING);
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote()) {
            if (handIn == Hand.MAIN_HAND) {
                if (state.get(RUNNING)) {
                    worldIn.setBlockState(pos, state.with(RUNNING, false));

                    System.out.println("Right-clicked block. State running is now: " + worldIn.getBlockState(pos));
                } else {
                    worldIn.setBlockState(pos, state.with(RUNNING, true));

                    System.out.println("Right-clicked block. State running is now: " + worldIn.getBlockState(pos));
                }
            }

            return ActionResultType.SUCCESS;
        }

        return ActionResultType.PASS;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntities.MATTER_RECYCLER_TILE.get().create();
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }
}
