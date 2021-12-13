package personal.ibonny.matteroverdrive116.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import personal.ibonny.matteroverdrive116.MatterOverdrive116;
import personal.ibonny.matteroverdrive116.item.ModItemGroup;
import personal.ibonny.matteroverdrive116.item.ModItems;

import java.util.function.Supplier;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, MatterOverdrive116.MOD_ID);

    public static RegistryObject<Block> MATTER_ANALYZER = registerBlock(
        "matter_analyzer",
        () -> new MatterAnalyzerBlock(
            Block.Properties.create(Material.ROCK).sound(SoundType.STONE)
        )
    );

    public static RegistryObject<Block> MATTER_RECYCLER = registerBlock(
        "matter_recycler",
        () -> new MatterRecyclerBlock(
            Block.Properties.create(Material.ROCK).sound(SoundType.STONE)
        )
    );

    public static RegistryObject<Block> DECOMPOSER = registerBlock(
        "decomposer",
        () -> new DecomposerBlock(
            Block.Properties.create(Material.ROCK).sound(SoundType.STONE)
        )
    );

    public static RegistryObject<Block> REPLICATOR = registerBlock(
        "replicator",
        () -> new ReplicatorBlock(
            Block.Properties.create(Material.ROCK).sound(SoundType.STONE)
        )
    );

    public static RegistryObject<Block> MATTER_PIPE = registerBlock(
        "matter_pipe",
        () -> new MatterPipeBlock(
            Block.Properties.create(Material.ROCK).sound(SoundType.STONE)
        )
    );

    public static RegistryObject<Block> PATTERN_STORAGE = registerBlock(
        "pattern_storage",
        () -> new PatternStorageBlock(
            Block.Properties.create(Material.ROCK).sound(SoundType.STONE)
        )
    );

    public static RegistryObject<Block> DECORATIVE_STRIPES = registerBlock(
        "decorative.stripes",
        () -> new DecorativeBlock(
            Block.Properties.create(Material.ROCK).sound(SoundType.STONE)
        )
    );

    public static RegistryObject<Block> STAR_MAP = registerBlock(
        "star_map",
        () -> new StarMapBlock(
            Block.Properties.create(Material.ROCK).sound(SoundType.STONE)
        )
    );

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(
            block.get(),
            new Item.Properties().group(ModItemGroup.MO_GROUP)
        ));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
