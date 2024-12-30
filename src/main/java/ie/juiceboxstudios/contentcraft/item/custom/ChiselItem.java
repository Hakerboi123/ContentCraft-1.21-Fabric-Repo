package ie.juiceboxstudios.contentcraft.item.custom;

import ie.juiceboxstudios.contentcraft.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;

public class ChiselItem extends Item {
    private static final Map<Block, Block> CHISEL_MAP = new HashMap<>();
    static {
        //Woods
        CHISEL_MAP.put(Blocks.OAK_LOG, Blocks.OAK_PLANKS);
        CHISEL_MAP.put(Blocks.OAK_PLANKS, Blocks.OAK_LOG);
        CHISEL_MAP.put(Blocks.SPRUCE_LOG, Blocks.SPRUCE_PLANKS);
        CHISEL_MAP.put(Blocks.SPRUCE_PLANKS, Blocks.SPRUCE_LOG);
        CHISEL_MAP.put(Blocks.BIRCH_LOG, Blocks.BIRCH_PLANKS);
        CHISEL_MAP.put(Blocks.BIRCH_PLANKS, Blocks.BIRCH_LOG);
        CHISEL_MAP.put(Blocks.JUNGLE_LOG, Blocks.JUNGLE_PLANKS);
        CHISEL_MAP.put(Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_LOG);
        CHISEL_MAP.put(Blocks.ACACIA_LOG, Blocks.ACACIA_PLANKS);
        CHISEL_MAP.put(Blocks.ACACIA_PLANKS, Blocks.ACACIA_LOG);
        CHISEL_MAP.put(Blocks.DARK_OAK_LOG, Blocks.DARK_OAK_PLANKS);
        CHISEL_MAP.put(Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_LOG);
        CHISEL_MAP.put(Blocks.CRIMSON_STEM, Blocks.CRIMSON_PLANKS);
        CHISEL_MAP.put(Blocks.CRIMSON_PLANKS, Blocks.CRIMSON_STEM);
        CHISEL_MAP.put(Blocks.WARPED_STEM, Blocks.WARPED_PLANKS);
        CHISEL_MAP.put(Blocks.WARPED_PLANKS, Blocks.WARPED_STEM);
        //Stones
        CHISEL_MAP.put(Blocks.COBBLESTONE, Blocks.STONE);
        CHISEL_MAP.put(Blocks.STONE, Blocks.COBBLESTONE);
        CHISEL_MAP.put(Blocks.DEEPSLATE, Blocks.COBBLED_DEEPSLATE);
        CHISEL_MAP.put(Blocks.COBBLED_DEEPSLATE, Blocks.DEEPSLATE);
        //Ores
        CHISEL_MAP.put(Blocks.LAPIS_ORE, Blocks.DEEPSLATE_LAPIS_ORE);
        CHISEL_MAP.put(Blocks.DEEPSLATE_LAPIS_ORE, Blocks.LAPIS_ORE);
        CHISEL_MAP.put(Blocks.EMERALD_ORE, Blocks.DEEPSLATE_EMERALD_ORE);
        CHISEL_MAP.put(Blocks.DEEPSLATE_EMERALD_ORE, Blocks.EMERALD_ORE);
        CHISEL_MAP.put(Blocks.DIAMOND_ORE, Blocks.DEEPSLATE_DIAMOND_ORE);
        CHISEL_MAP.put(Blocks.DEEPSLATE_DIAMOND_ORE, Blocks.DIAMOND_ORE);
        CHISEL_MAP.put(Blocks.IRON_ORE, Blocks.DEEPSLATE_IRON_ORE);
        CHISEL_MAP.put(Blocks.DEEPSLATE_IRON_ORE, Blocks.IRON_ORE);
        CHISEL_MAP.put(Blocks.GOLD_ORE, Blocks.DEEPSLATE_GOLD_ORE);
        CHISEL_MAP.put(Blocks.DEEPSLATE_GOLD_ORE, Blocks.GOLD_ORE);
        CHISEL_MAP.put(Blocks.REDSTONE_ORE, Blocks.DEEPSLATE_REDSTONE_ORE);
        CHISEL_MAP.put(Blocks.DEEPSLATE_REDSTONE_ORE, Blocks.REDSTONE_ORE);
        //Misc
        CHISEL_MAP.put(Blocks.LAVA, Blocks.WATER);
        CHISEL_MAP.put(Blocks.WATER, Blocks.LAVA);
        CHISEL_MAP.put(Blocks.GRASS_BLOCK, Blocks.DIRT);
        CHISEL_MAP.put(Blocks.DIRT, Blocks.GRASS_BLOCK);
        CHISEL_MAP.put(Blocks.SAND, Blocks.GRAVEL);
        CHISEL_MAP.put(Blocks.GRAVEL, Blocks.SAND);
        //Mod Integration
        //ContentCraft
        CHISEL_MAP.put(ModBlocks.XAENON_BLOCK, ModBlocks.RAW_XAENON_BLOCK);
        CHISEL_MAP.put(ModBlocks.RAW_XAENON_BLOCK, ModBlocks.XAENON_BLOCK);
    }

    public ChiselItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(CHISEL_MAP.containsKey(clickedBlock)) {
            if(!world.isClient()) {
                world.setBlockState(context.getBlockPos(), CHISEL_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.ITEM_BRUSH_BRUSHING_SAND_COMPLETE, SoundCategory.BLOCKS);
            }
        }

        return ActionResult.SUCCESS;
    }
}
