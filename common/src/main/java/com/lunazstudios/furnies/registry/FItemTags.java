package com.lunazstudios.furnies.registry;

import com.lunazstudios.furnies.Furnies;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class FItemTags {

    public static final TagKey<Item> LAMPS = itemTag("lamps");

    private static TagKey<Item> itemTag(String name) {
        return TagKey.create(Registries.ITEM, Furnies.id(name));
    }

    public static void init() {}
}