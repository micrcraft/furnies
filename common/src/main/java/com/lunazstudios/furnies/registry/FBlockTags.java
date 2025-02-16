package com.lunazstudios.furnies.registry;

import com.lunazstudios.furnies.Furnies;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

/**
 * Original Author: StarfishStudios
 * Project: Another Furniture
 */
public class FBlockTags {
    public static final TagKey<Block> BAR_COUNTERS = blockTag("bar_counters");
    public static final TagKey<Block> CABINETS = blockTag("cabinets");
    public static final TagKey<Block> CHAIRS = blockTag("chairs");
    public static final TagKey<Block> DECORATIVE_STAIRS = blockTag("decorative_stairs");
    public static final TagKey<Block> DRAWERS = blockTag("drawers");
    public static final TagKey<Block> FRIDGES = blockTag("fridges");
    public static final TagKey<Block> KITCHEN_CABINETRY = blockTag("kitchen_cabinetry");
    public static final TagKey<Block> KITCHEN_CABINETS = blockTag("kitchen_cabinets");
    public static final TagKey<Block> KITCHEN_DRAWERS = blockTag("kitchen_drawers");
    public static final TagKey<Block> KITCHEN_SINKS = blockTag("kitchen_sinks");
    public static final TagKey<Block> LAMP_CONNECTORS = blockTag("lamp_connectors");
    public static final TagKey<Block> LAMPS = blockTag("lamps");
    public static final TagKey<Block> SOFAS = blockTag("sofas");
    public static final TagKey<Block> STONE_PATHS = blockTag("stone_paths");
    public static final TagKey<Block> STOOLS = blockTag("stools");
    public static final TagKey<Block> STOVES = blockTag("stoves");
    public static final TagKey<Block> SUPPORTS = blockTag("supports");
    public static final TagKey<Block> TABLES = blockTag("tables");
    public static final TagKey<Block> TOILETS = blockTag("toilets");
    public static final TagKey<Block> WOOD_PATHS = blockTag("wood_paths");
    public static final TagKey<Block> BENCHES = blockTag("benches");

    public static final TagKey<Block> ABOVE_BYPASSES_SEAT_CHECK = blockTag("above_bypasses_seat_check");
    public static final TagKey<Block> TABLES_CONNECTABLE = blockTag("table_connectable");

    private static TagKey<Block> blockTag(String name) {
        return TagKey.create(Registries.BLOCK, Furnies.id(name));
    }

    public static void init() {}
}
