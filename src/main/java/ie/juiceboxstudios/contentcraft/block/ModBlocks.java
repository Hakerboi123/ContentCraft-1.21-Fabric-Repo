package ie.juiceboxstudios.contentcraft.block;

import ie.juiceboxstudios.contentcraft.ContentCraft;
import ie.juiceboxstudios.contentcraft.block.custom.OrePolishingStationBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block XAENON_BLOCK = registerBlock("xaenon_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block RAW_XAENON_BLOCK = registerBlock("raw_xaenon_block",
            new Block(AbstractBlock.Settings.create().strength(4f).requiresTool()));

    public static final Block XAENON_ORE = registerBlock("xaenon_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 7),
                    AbstractBlock.Settings.create().strength(3f).requiresTool()));

    public static final Block ORE_POLISHING_STATION = registerBlock("ore_polishing_station",
            new OrePolishingStationBlock(FabricBlockSettings.copyOf(ModBlocks.RAW_XAENON_BLOCK).nonOpaque()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ContentCraft.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(ContentCraft.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        ContentCraft.LOGGER.info("Registering Mod Blocks for " + ContentCraft.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SEARCH).register(entries -> {
            entries.add(ModBlocks.XAENON_BLOCK);
            entries.add(ModBlocks.RAW_XAENON_BLOCK);
            entries.add(ModBlocks.XAENON_ORE);
        });
    }
}