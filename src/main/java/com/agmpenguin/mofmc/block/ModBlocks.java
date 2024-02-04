package com.agmpenguin.mofmc.block;

import com.agmpenguin.mofmc.item.ModItems;
import com.agmpenguin.mofmc.mofmc;
import net.minecraft.client.resources.model.Material;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, mofmc.MOD_ID);
    // RUBY ORE
    public static final RegistryObject<Block> RUBY_ORE = registerOre("ruby_ore", 6f, 3, 7);
    public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = registerOre("deepslate_ruby_ore", 6f, 3, 7);
    public static final RegistryObject<Block> NETHER_RUBY_ORE = registerOre("nether_ruby_ore", 6f, 3, 7);
    public static final RegistryObject<Block> END_RUBY_ORE = registerOre("end_ruby_ore", 6f, 3, 7);
    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block", 6f);
    public static final RegistryObject<Block> RAW_RUBY_BLOCK = registerBlock("raw_ruby_block", 6f);
    public static final RegistryObject<Block> RUBY_STAIRS = registerStairBlock("ruby_stairs", RUBY_BLOCK, 6f);
    public static final RegistryObject<Block> RUBY_SLAB = registerSlabBlock("ruby_slab", RUBY_BLOCK, 6f);
    public static final RegistryObject<Block> RUBY_PRESSURE_PLATE = registerPressurePlateBlock("ruby_pressure_plate", "everything", BlockSetType.STONE, 0.5f);
    // PYRITE ORE
    public static final RegistryObject<Block>
            PYRITE_ORE = registerOre("pyrite_ore", 6f, 3, 7),
            DEEPSLATE_PYRITE_ORE = registerOre("deepslate_pyrite_ore", 6f, 3, 7),
            NETHER_PYRITE_ORE = registerOre("nether_pyrite_ore", 6f, 3, 7),
            END_PYRITE_ORE = registerOre("end_pyrite_ore", 6f, 3, 7),
            PYRITE_BLOCK = registerBlock("pyrite_block", 6f),
            RAW_PYRITE_BLOCK = registerBlock("raw_pyrite_block", 6f),
            PYRITE_STAIRS = registerStairBlock("pyrite_stairs", PYRITE_BLOCK, 6f),
            PYRITE_SLAB = registerSlabBlock("pyrite_slab", PYRITE_BLOCK, 6f),
            PYRITE_PRESSURE_PLATE = registerPressurePlateBlock("pyrite_pressure_plate", "everything", BlockSetType.STONE, 6f);
    // TITANIUM ORE
    public static final RegistryObject<Block> TITANIUM_ORE = registerOre("titanium_ore", 6f, 3, 7);
    public static final RegistryObject<Block> DEEPSLATE_TITANIUM_ORE = registerOre("deepslate_titanium_ore", 6f, 3, 7);
    public static final RegistryObject<Block> NETHER_TITANIUM_ORE = registerOre("nether_titanium_ore", 6f, 3, 7);
    public static final RegistryObject<Block> END_TITANIUM_ORE = registerOre("end_titanium_ore", 6f, 3, 7);
    public static final RegistryObject<Block> TITANIUM_BLOCK = registerBlock("titanium_block", 6f);
    public static final RegistryObject<Block> TITANIUM_STAIRS = registerStairBlock("titanium_stairs", TITANIUM_BLOCK, 6f);
    public static final RegistryObject<Block> TITANIUM_SLAB = registerSlabBlock("titanium_slab", TITANIUM_BLOCK, 6f);
    public static final RegistryObject<Block> TITANIUM_PRESSURE_PLATE = registerPressurePlateBlock("titanium_pressure_plate", "everything", BlockSetType.STONE, 6f);


    private static RegistryObject<Block> registerBlock(String name, float strength) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, () -> new Block(BlockBehaviour.Properties
                .copy(Blocks.STONE)
                .strength(strength)
                .requiresCorrectToolForDrops()));

        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static RegistryObject<Block> registerOre(String name, float strength, int minExp, int maxExp) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, () -> new DropExperienceBlock(BlockBehaviour.Properties
                .copy(Blocks.STONE)
                .strength(strength)
                .requiresCorrectToolForDrops(),
                UniformInt.of(minExp, maxExp)));

        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static RegistryObject<Block> registerStairBlock(String name, RegistryObject<Block> block, float strength) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, () -> new StairBlock(block.get().defaultBlockState(), BlockBehaviour.Properties
                .copy(block.get())
                .strength(strength)
                .requiresCorrectToolForDrops()));

        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static RegistryObject<Block> registerSlabBlock(String name, RegistryObject<Block> block, float strength) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, () -> new SlabBlock(BlockBehaviour.Properties
                .copy(block.get())
                .strength(strength)
                .requiresCorrectToolForDrops()));

        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static RegistryObject<Block> registerPressurePlateBlock(String name, String sensitivity, BlockSetType blockSetType, float strength, MapColor... mapColor) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, () -> new PressurePlateBlock(
                PressurePlateBlock.Sensitivity.valueOf(sensitivity.toUpperCase()),
                BlockBehaviour.Properties.of()
                        .strength(strength)
                        .requiresCorrectToolForDrops(),
                blockSetType));

        registerBlockItem(name, toReturn);
        return toReturn;
    }








    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
