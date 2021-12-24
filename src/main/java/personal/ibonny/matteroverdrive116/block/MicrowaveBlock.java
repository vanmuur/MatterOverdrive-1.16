package personal.ibonny.matteroverdrive116.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import personal.ibonny.matteroverdrive116.container.MicrowaveContainer;
import personal.ibonny.matteroverdrive116.tile.MicrowaveTileEntity;
import personal.ibonny.matteroverdrive116.tile.ModTileEntities;

import javax.annotation.Nullable;


public class MicrowaveBlock extends HorizontalBlock {
    private static final VoxelShape SHAPE_N = Block.makeCuboidShape(1, 0, 5, 15, 10, 16);
    private static final VoxelShape SHAPE_E = Block.makeCuboidShape(0, 0, 1, 11, 10, 15);
    private static final VoxelShape SHAPE_W = Block.makeCuboidShape(5, 0, 1, 16, 10, 15);
    private static final VoxelShape SHAPE_S = Block.makeCuboidShape(1, 0, 0, 15, 10, 11);

    public MicrowaveBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch(state.get(HORIZONTAL_FACING)) {
            case NORTH: return SHAPE_N;
            case SOUTH: return SHAPE_S;
            case EAST: return SHAPE_E;
            case WEST: return SHAPE_W;
        }

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

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntities.MICROWAVE_TILE.get().create();
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote()) {
            if (handIn == Hand.MAIN_HAND) {
                TileEntity tileEntity = worldIn.getTileEntity(pos);

                if(tileEntity instanceof MicrowaveTileEntity) {
                    INamedContainerProvider containerProvider = createContainerProvider(worldIn, pos);

                    NetworkHooks.openGui(((ServerPlayerEntity)player), containerProvider, tileEntity.getPos());
                } else {
                    throw new IllegalStateException("Our Container provider is missing!");
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
                return new TranslationTextComponent("screen.matteroverdrive116.microwave");
            }

            @Nullable
            @Override
            public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
                return new MicrowaveContainer(i, worldIn, pos, playerInventory, playerEntity);
            }
        };
    }

}
