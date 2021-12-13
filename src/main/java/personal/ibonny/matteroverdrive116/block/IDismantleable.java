package personal.ibonny.matteroverdrive116.block;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;

public interface IDismantleable {
    ArrayList<ItemStack> dismantleBlock(PlayerEntity player, World world, BlockPos pos, boolean returnDrops);

    boolean canDismantle(PlayerEntity player, World world, BlockPos pos);
}
