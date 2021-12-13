package personal.ibonny.matteroverdrive116.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import personal.ibonny.matteroverdrive116.block.ModBlocks;

public class ModItemGroup {
    public static final ItemGroup MO_GROUP = new ItemGroup("MOModTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.MATTER_ANALYZER.get());
        }
    };
}