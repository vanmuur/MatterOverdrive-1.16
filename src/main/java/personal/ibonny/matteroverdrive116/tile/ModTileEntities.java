package personal.ibonny.matteroverdrive116.tile;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import personal.ibonny.matteroverdrive116.MatterOverdrive116;
import personal.ibonny.matteroverdrive116.block.ModBlocks;

public class ModTileEntities {
    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES =
        DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MatterOverdrive116.MOD_ID);

    public static RegistryObject<TileEntityType<MatterRecyclerTileEntity>> MATTER_RECYCLER_TILE =
        TILE_ENTITIES.register("matter_recycler_tile", () -> TileEntityType.Builder.create(
            MatterRecyclerTileEntity::new, ModBlocks.MATTER_RECYCLER.get()).build(null));

    public static void register(IEventBus eventBus) {
        TILE_ENTITIES.register(eventBus);
    }
}
