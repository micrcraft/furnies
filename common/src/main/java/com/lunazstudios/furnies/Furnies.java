package com.lunazstudios.furnies;

import com.lunazstudios.furnies.network.FNetwork;
import com.lunazstudios.furnies.registry.*;
import net.minecraft.resources.ResourceLocation;

public final class Furnies {
    public static final String MOD_ID = "furnies";

    public static void init() {
        FBlocks.register();
        FItems.init();
        FBlockTags.init();
        FEntityTypes.init();
        FEntityTypeTags.init();
        FBlockEntityTypes.init();
        FSoundEvents.init();
        FItemTags.init();
        FRecipes.register();
        FMenus.register();
        FNetwork.registerPackets();
    }

    public static ResourceLocation id(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }
}
