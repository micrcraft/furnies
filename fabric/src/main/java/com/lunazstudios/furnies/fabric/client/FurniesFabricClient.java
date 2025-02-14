package com.lunazstudios.furnies.fabric.client;

import com.lunazstudios.furnies.client.FurniesClient;
import com.lunazstudios.furnies.registry.FBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

public final class FurniesFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        FurniesClient.init();

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.translucent(),
                FBlocks.LIGHT_TOILET.get(), FBlocks.DARK_TOILET.get()
        );

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(),
                FBlocks.OAK_CHAIR.get(), FBlocks.SPRUCE_CHAIR.get(), FBlocks.BIRCH_CHAIR.get(), FBlocks.DARK_OAK_CHAIR.get(),
                FBlocks.JUNGLE_CHAIR.get(), FBlocks.ACACIA_CHAIR.get(), FBlocks.MANGROVE_CHAIR.get(), FBlocks.BAMBOO_CHAIR.get(),
                FBlocks.CHERRY_CHAIR.get(), FBlocks.CRIMSON_CHAIR.get(), FBlocks.WARPED_CHAIR.get(),

                FBlocks.LIGHT_FREEZER.get(), FBlocks.LIGHT_FRIDGE.get(), FBlocks.DARK_FREEZER.get(), FBlocks.DARK_FRIDGE.get()
        );
    }
}
