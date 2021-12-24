package personal.ibonny.matteroverdrive116.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;


public class DecorativeBlockConnected extends Block {
    public static final EnumProperty<ConnectedEnum> CONNECTED = EnumProperty.create(
        "connected", ConnectedEnum.class
    );

    public DecorativeBlockConnected(Properties properties) {
        super(properties);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);

        builder.add(CONNECTED);
    }

    private ConnectedEnum discoverNeighbours(IWorldReader world, BlockPos pos) {
        String connStateString = "";

        System.out.println("Block to the north is: " + world.getBlockState(pos.north()).getBlock());

        Block block = world.getBlockState(pos.north()).getBlock();

        if (block instanceof DecorativeBlockConnected) {
            ((DecorativeBlockConnected)block).updateState(world, pos.north());

            connStateString += "n";
        }

        if (world.getBlockState(pos.east()).getBlock() instanceof DecorativeBlockConnected) {
            connStateString += "e";
        }

        if (world.getBlockState(pos.west()).getBlock() instanceof DecorativeBlockConnected) {
            connStateString += "w";
        }

        if (world.getBlockState(pos.south()).getBlock() instanceof DecorativeBlockConnected) {
            connStateString += "s";
        }

        if (connStateString.equals("")) {
            connStateString = "none";
        }

        return ConnectedEnum.valueOfLabel(connStateString);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        ConnectedEnum sfp = discoverNeighbours(context.getWorld(), context.getPos());

        System.out.println("Connected Enum is: " + sfp);

        return this.getDefaultState().with(CONNECTED, sfp);
    }

    @Override
    public boolean removedByPlayer(BlockState state, World world, BlockPos pos, PlayerEntity player, boolean willHarvest, FluidState fluid) {
        System.out.println("Calling removed by player for block at pos: " + pos);

        return super.removedByPlayer(state, world, pos, player, willHarvest, fluid);
    }

    public void updateState(IWorldReader world, BlockPos pos) {
        System.out.println("Updating state at pos " + pos);

        ConnectedEnum sfp = discoverNeighbours(world, pos);

        this.setDefaultState(this.getDefaultState().with(CONNECTED, sfp));
    }
}
