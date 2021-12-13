package personal.ibonny.matteroverdrive116.item;

import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import personal.ibonny.matteroverdrive116.MatterOverdrive116;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS
        = DeferredRegister.create(ForgeRegistries.ITEMS, MatterOverdrive116.MOD_ID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
