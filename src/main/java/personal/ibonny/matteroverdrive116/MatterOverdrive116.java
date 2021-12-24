package personal.ibonny.matteroverdrive116;

import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import personal.ibonny.matteroverdrive116.block.ModBlocks;
import personal.ibonny.matteroverdrive116.container.ModContainers;
import personal.ibonny.matteroverdrive116.item.ModItems;
import personal.ibonny.matteroverdrive116.screen.MatterRecyclerScreen;
import personal.ibonny.matteroverdrive116.screen.MicrowaveScreen;
import personal.ibonny.matteroverdrive116.tile.ModTileEntities;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MatterOverdrive116.MOD_ID)
public class MatterOverdrive116 {
    public static final String MOD_ID="matteroverdrive116";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public MatterOverdrive116() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModTileEntities.register(eventBus);
        ModContainers.register(eventBus);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ScreenManager.registerFactory(ModContainers.MATTER_RECYCLER_CONTAINER.get(),
                MatterRecyclerScreen::new);
            ScreenManager.registerFactory(ModContainers.MICROWAVE_CONTAINER.get(), MicrowaveScreen::new);
        });
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
    }

    private void processIMC(final InterModProcessEvent event) {
    }
}
