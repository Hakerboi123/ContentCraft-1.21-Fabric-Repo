package ie.juiceboxstudios.contentcraft;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static ie.juiceboxstudios.contentcraft.block.ModBlocks.registerModBlocks;
import static ie.juiceboxstudios.contentcraft.item.ModItemGroups.registerItemGroups;
import static ie.juiceboxstudios.contentcraft.item.ModItems.registerModItems;

public class ContentCraft implements ModInitializer {
	public static final String MOD_ID = "contentcraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		registerModItems();
		registerModBlocks();
		registerItemGroups();
	}
}