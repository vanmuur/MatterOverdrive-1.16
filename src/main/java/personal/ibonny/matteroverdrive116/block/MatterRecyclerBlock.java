package personal.ibonny.matteroverdrive116.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import personal.ibonny.matteroverdrive116.container.MatterRecyclerContainer;
import personal.ibonny.matteroverdrive116.tile.MatterRecyclerTileEntity;
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
                if (player.isSneaking()) {
                    if (state.get(RUNNING)) {
                        worldIn.setBlockState(pos, state.with(RUNNING, false));

                        System.out.println("Right-clicked block. State running is now: " + worldIn.getBlockState(pos));
                    } else {
                        worldIn.setBlockState(pos, state.with(RUNNING, true));

                        System.out.println("Right-clicked block. State running is now: " + worldIn.getBlockState(pos));
                    }
                } else {
                    TileEntity tileEntity = worldIn.getTileEntity(pos);

                    if(tileEntity instanceof MatterRecyclerTileEntity) {
                        INamedContainerProvider containerProvider = createContainerProvider(worldIn, pos);

                        NetworkHooks.openGui(((ServerPlayerEntity)player), containerProvider, tileEntity.getPos());
                    } else {
                        throw new IllegalStateException("Our Container provider is missing!");
                    }
                }
            }

            return ActionResultType.SUCCESS;
        }

        return ActionResultType.PASS;
    }

    private INamedContainerProvider createContainerProvider(World worldIn, BlockPos pos) {
        return new INamedContainerProvider() {
            @Override
            public ITextComponent getDisplayName() {
                return new TranslationTextComponent("screen.matteroverdrive116.matter_recycler");
            }

            @Nullable
            @Override
            public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
                return new MatterRecyclerContainer(i, worldIn, pos, playerInventory, playerEntity);
            }
        };
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
