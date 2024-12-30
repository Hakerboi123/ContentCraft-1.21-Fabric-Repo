package ie.juiceboxstudios.contentcraft.item;

import ie.juiceboxstudios.contentcraft.ContentCraft;
import ie.juiceboxstudios.contentcraft.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup XAENON_EXPANSION = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ContentCraft.MOD_ID, "xaenon_expansion"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.XAENON_INGOT))
                    .displayName(Text.translatable("itemgroup.contentcraft.xaenon_expansion"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.CHISEL);
                        entries.add(ModItems.XAENON_INGOT);
                        entries.add(ModItems.RAW_XAENON);
                        entries.add(ModBlocks.XAENON_BLOCK);
                        entries.add(ModBlocks.RAW_XAENON_BLOCK);
                        entries.add(ModBlocks.XAENON_ORE);
                        entries.add(ModBlocks.ORE_POLISHING_STATION);
                    }).build());


    public static void registerItemGroups() {
        ContentCraft.LOGGER.info("Registering Item Groups for " + ContentCraft.MOD_ID);
    }
}