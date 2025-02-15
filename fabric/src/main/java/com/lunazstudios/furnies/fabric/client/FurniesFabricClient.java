package com.lunazstudios.furnies.fabric.client;

import com.lunazstudios.furnies.client.FurniesClient;
import com.lunazstudios.furnies.client.screen.FurniCrafterScreen;
import com.lunazstudios.furnies.registry.FBlocks;
import com.lunazstudios.furnies.registry.FMenus;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.RenderType;

public final class FurniesFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        FurniesClient.init();

        MenuScreens.register(FMenus.FURNI_CRAFTER_MENU.get(), FurniCrafterScreen::new);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.translucent(),
                FBlocks.LIGHT_TOILET.get(), FBlocks.DARK_TOILET.get()
        );

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(),
                FBlocks.OAK_CHAIR.get(), FBlocks.SPRUCE_CHAIR.get(), FBlocks.BIRCH_CHAIR.get(), FBlocks.DARK_OAK_CHAIR.get(),
                FBlocks.JUNGLE_CHAIR.get(), FBlocks.ACACIA_CHAIR.get(), FBlocks.MANGROVE_CHAIR.get(), FBlocks.BAMBOO_CHAIR.get(),
                FBlocks.CHERRY_CHAIR.get(), FBlocks.CRIMSON_CHAIR.get(), FBlocks.WARPED_CHAIR.get(),

                FBlocks.LIGHT_FREEZER.get(), FBlocks.LIGHT_FRIDGE.get(), FBlocks.DARK_FREEZER.get(), FBlocks.DARK_FRIDGE.get(),

                FBlocks.OAK_KITCHEN_SINK.get(), FBlocks.SPRUCE_KITCHEN_SINK.get(), FBlocks.BIRCH_KITCHEN_SINK.get(), FBlocks.DARK_OAK_KITCHEN_SINK.get(),
                FBlocks.JUNGLE_KITCHEN_SINK.get(), FBlocks.ACACIA_KITCHEN_SINK.get(), FBlocks.MANGROVE_KITCHEN_SINK.get(), FBlocks.BAMBOO_KITCHEN_SINK.get(),
                FBlocks.CHERRY_KITCHEN_SINK.get(), FBlocks.CRIMSON_KITCHEN_SINK.get(), FBlocks.WARPED_KITCHEN_SINK.get(),

                FBlocks.LIGHT_STOVE.get(), FBlocks.DARK_STOVE.get(),

                FBlocks.WHITE_LAMP.get(), FBlocks.ORANGE_LAMP.get(), FBlocks.MAGENTA_LAMP.get(), FBlocks.LIGHT_BLUE_LAMP.get(),
                FBlocks.YELLOW_LAMP.get(), FBlocks.LIME_LAMP.get(), FBlocks.PINK_LAMP.get(), FBlocks.GRAY_LAMP.get(),
                FBlocks.LIGHT_GRAY_LAMP.get(), FBlocks.CYAN_LAMP.get(), FBlocks.PURPLE_LAMP.get(), FBlocks.BLUE_LAMP.get(),
                FBlocks.BROWN_LAMP.get(), FBlocks.GREEN_LAMP.get(), FBlocks.RED_LAMP.get(), FBlocks.BLACK_LAMP.get()
        );
    }
}
