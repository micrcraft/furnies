package com.lunazstudios.furnies.network;

import com.lunazstudios.furnies.network.message.CraftRecipeMessage;
import com.lunazstudios.furnies.network.message.SyncCraftableRecipesMessage;
import dev.architectury.networking.NetworkManager;
import dev.architectury.platform.Platform;
import net.fabricmc.api.EnvType;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public class FNetwork {
    public static final CustomPacketPayload.Type<CraftRecipeMessage> CRAFT_RECIPE_TYPE =
            new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath("funnies", "craft_recipe"));
    public static final CustomPacketPayload.Type<SyncCraftableRecipesMessage> CRAFTABLE_RECIPES_SYNC_TYPE =
            new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath("furnies", "craftable_recipes_sync"));

    public static void registerPackets() {
        NetworkManager.registerReceiver(
                NetworkManager.Side.C2S,
                CRAFT_RECIPE_TYPE,
                CraftRecipeMessage.CODEC,
                CraftRecipeMessage::handle
        );

        if (Platform.getEnv() == EnvType.CLIENT) {
            NetworkManager.registerReceiver(
                    NetworkManager.Side.S2C,
                    CRAFTABLE_RECIPES_SYNC_TYPE,
                    SyncCraftableRecipesMessage.CODEC,
                    SyncCraftableRecipesMessage::handle
            );
        } else {
            NetworkManager.registerS2CPayloadType(
                    CRAFTABLE_RECIPES_SYNC_TYPE,
                    SyncCraftableRecipesMessage.CODEC
            );
        }
    }
}
