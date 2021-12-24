package personal.ibonny.matteroverdrive116.block;

import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockDisplayReader;

import javax.annotation.Nullable;

public class DecorativeColoredBlock extends DecorativeBlock implements IBlockColor {
    public DecorativeColoredBlock(Properties properties) {
        super(properties);
    }

    @Override
    public int getColor(@Nullable BlockState state, @Nullable IBlockDisplayReader blockDisplayReader, @Nullable BlockPos blockPos, int tintIndex) {
        return 15;
    }
}
