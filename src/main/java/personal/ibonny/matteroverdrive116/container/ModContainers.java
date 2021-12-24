package personal.ibonny.matteroverdrive116.container;

import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import personal.ibonny.matteroverdrive116.MatterOverdrive116;

public class ModContainers {
    public static DeferredRegister<ContainerType<?>> CONTAINERS
            = DeferredRegister.create(ForgeRegistries.CONTAINERS, MatterOverdrive116.MOD_ID);

    public static final RegistryObject<ContainerType<MatterRecyclerContainer>> MATTER_RECYCLER_CONTAINER =
            CONTAINERS.register("matter_recycler_container",
                () -> IForgeContainerType.create(((windowId, inv, data) -> {
                    BlockPos pos = data.readBlockPos();
                    World world = inv.player.getEntityWorld();
                    return new MatterRecyclerContainer(windowId, world, pos, inv, inv.player);
                }))
            );

    public static final RegistryObject<ContainerType<MicrowaveContainer>> MICROWAVE_CONTAINER =
        CONTAINERS.register("microwave_container",
            () -> IForgeContainerType.create(((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                World world = inv.player.getEntityWorld();
                return new MicrowaveContainer(windowId, world, pos, inv, inv.player);
            }))
        );

    public static void register(IEventBus eventBus) {
        CONTAINERS.register(eventBus);
    }
}
