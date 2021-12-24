package personal.ibonny.matteroverdrive116.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
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
import java.util.function.ToIntFunction;


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

    public static RegistryObject<Block> DECORATIVE_COILS = registerBlock(
        "decorative.coils",
        () -> new DecorativeBlock(
            Block.Properties.create(Material.ROCK).sound(SoundType.STONE)
        )
    );

    public static RegistryObject<Block> DECORATIVE_CLEAN = registerBlock(
        "decorative.clean",
        () -> new DecorativeBlock(
            Block.Properties.create(Material.ROCK).sound(SoundType.STONE)
        )
    );

    public static RegistryObject<Block> DECORATIVE_VENT_DARK = registerBlock(
        "decorative.vent.dark",
        () -> new DecorativeBlock(
            Block.Properties.create(Material.ROCK).sound(SoundType.STONE)
        )
    );

    public static RegistryObject<Block> DECORATIVE_VENT = registerBlock(
        "decorative.vent",
        () -> new DecorativeBlock(
            Block.Properties.create(Material.ROCK).sound(SoundType.STONE)
        )
    );

    public static RegistryObject<Block> DECORATIVE_HOLO_MATRIX = registerBlock(
        "decorative.holo.matrix",
        () -> new DecorativeBlock(
            Block.Properties.create(Material.ROCK).sound(SoundType.STONE)
        )
    );

    public static RegistryObject<Block> DECORATIVE_TRITANIUM_PLATE = registerBlock(
        "decorative.tritanium_plate",
        () -> new DecorativeBlock(
            Block.Properties.create(Material.ROCK).sound(SoundType.STONE)
        )
    );

    public static RegistryObject<Block> DECORATIVE_TRITANIUM_PLATE_STRIPED = registerBlock(
        "decorative.tritanium_plate_striped",
        () -> new DecorativeBlock(
            Block.Properties.create(Material.ROCK).sound(SoundType.STONE)
        )
    );

    public static RegistryObject<Block> DECORATIVE_CARBON_FIBER_PLATE = registerBlock(
        "decorative.carbon_fiber_plate",
        () -> new DecorativeBlock(
            Block.Properties.create(Material.ROCK).sound(SoundType.STONE)
        )
    );

    public static RegistryObject<Block> DECORATIVE_MATTER_TUBE = registerBlock(
        "decorative.matter_tube",
        () -> new DecorativeBlock(
            Block.Properties.create(Material.ROCK).sound(SoundType.STONE)
        )
    );

    public static RegistryObject<Block> DECORATIVE_BEAMS = registerBlock(
        "decorative.beams",
        () -> new DecorativeBlock(
            Block.Properties.create(Material.ROCK).sound(SoundType.STONE)
        )
    );

    public static RegistryObject<Block> DECORATIVE_FLOOR_TILES = registerBlock(
        "decorative.floor_tiles",
        () -> new DecorativeBlock(
            Block.Properties.create(Material.ROCK).sound(SoundType.STONE)
        )
    );

    public static RegistryObject<Block> DECORATIVE_FLOOR_TILES_GREEN = registerBlock(
        "decorative.floor_tiles_green",
        () -> new DecorativeBlock(
            Block.Properties.create(Material.ROCK).sound(SoundType.STONE)
        )
    );

    public static RegistryObject<Block> DECORATIVE_FLOOR_TILES_WHITE = registerBlock(
        "decorative.floor_tiles_white",
        () -> new DecorativeBlock(
            Block.Properties.create(Material.ROCK).sound(SoundType.STONE)
        )
    );

    public static RegistryObject<Block> DECORATIVE_FLOOR_NOISE = registerBlock(
        "decorative.floor_noise",
        () -> new DecorativeBlock(
            Block.Properties.create(Material.ROCK).sound(SoundType.STONE)
        )
    );

    public static RegistryObject<Block> DECORATIVE_WHITE_PLATE = registerBlock(
        "decorative.white_plate",
        () -> new DecorativeBlock(
            Block.Properties.create(Material.ROCK).sound(SoundType.STONE)
        )
    );

    public static RegistryObject<Block> DECORATIVE_SEPARATOR = registerBlock(
        "decorative.separator",
        () -> new DecorativeBlock(
            Block.Properties.create(Material.ROCK).sound(SoundType.STONE)
        )
    );

    public static ToIntFunction<BlockState> lightLevel = BlockState -> 15;

    public static RegistryObject<Block> DECORATIVE_TRITANIUM_LAMP = registerBlock(
        "decorative.tritanium_lamp",
        () -> new DecorativeBlock(
            Block.Properties.create(Material.ROCK).sound(SoundType.STONE).setLightLevel(lightLevel)
        )
    );

    public static RegistryObject<Block> DECORATIVE_TRITANIUM_PLATE_COLORED = registerBlock(
        "decorative.tritanium_plate_colored",
        () -> new DecorativeColoredBlock(
            Block.Properties.create(Material.ROCK).sound(SoundType.STONE)
        )
    );

    public static RegistryObject<Block> DECORATIVE_ENGINE_EXHAUST_PLASMA = registerBlock(
        "decorative.engine_exhaust_plasma",
        () -> new DecorativeBlock(
            Block.Properties.create(Material.ROCK).sound(SoundType.STONE).setLightLevel(lightLevel)
        )
    );

    public static RegistryObject<Block> MICROWAVE = registerBlock(
        "microwave",
        () -> new MicrowaveBlock(
            Block.Properties.create(Material.IRON).sound(SoundType.STONE)
        )
    );

    public static RegistryObject<Block> STAR_MAP = registerBlock(
        "star_map",
        () -> new StarMapBlock(
            Block.Properties.create(Material.ROCK).sound(SoundType.STONE)
        )
    );

    public static RegistryObject<Block> TRITANIUN_CRATE = registerBlock(
        "tritanium_crate",
        () -> new TritaniumCrateBlock(
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
