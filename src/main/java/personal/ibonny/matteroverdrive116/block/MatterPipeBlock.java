package personal.ibonny.matteroverdrive116.block;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;

public class MatterPipeBlock extends BlockPipe implements IDismantleable {
    public MatterPipeBlock(Properties properties) {
        super(properties);
    }

    @Override
    public ArrayList<ItemStack> dismantleBlock(PlayerEntity player, World world, BlockPos pos, boolean returnDrops) {
        ArrayList<ItemStack> items = new ArrayList<>();
        BlockState state = world.getBlockState(pos);

        if (!returnDrops) {
            state.getBlock().harvestBlock(world, player, pos, state, world.getTileEntity(pos), ItemStack.EMPTY);
            state.getBlock().removedByPlayer(state, world, pos, player, true, null);
        } else {
            state.getBlock().removedByPlayer(state, world, pos, player, true, null);
//            state.getBlock().breakBlock(world, pos, state);
//            for (ItemStack itemStack : getDrops(world, pos, state, 0)) {
//                MOInventoryHelper.insertItemStackIntoInventory(player.inventory, itemStack, EnumFacing.DOWN);
//            }
        }

        return items;
    }

    @Override
    public boolean canDismantle(PlayerEntity player, World world, BlockPos pos) {
        return true;
    }

}
