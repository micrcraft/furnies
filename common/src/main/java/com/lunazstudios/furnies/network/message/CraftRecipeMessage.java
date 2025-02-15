package com.lunazstudios.furnies.network.message;

import com.lunazstudios.furnies.menu.FurniCrafterMenu;
import com.lunazstudios.furnies.network.FNetwork;
import dev.architectury.networking.NetworkManager;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;

public record CraftRecipeMessage(int containerId, int recipeIndex) implements CustomPacketPayload {
    public static final StreamCodec<RegistryFriendlyByteBuf, CraftRecipeMessage> CODEC =
            StreamCodec.of(
                    (buf, msg) -> {
                        buf.writeInt(msg.containerId);
                        buf.writeInt(msg.recipeIndex);
                    },
                    buf -> new CraftRecipeMessage(buf.readInt(), buf.readInt())
            );

    public static void handle(CraftRecipeMessage message, NetworkManager.PacketContext context) {
        context.queue(() -> {
            if (context.getPlayer() instanceof ServerPlayer serverPlayer &&
                    serverPlayer.containerMenu instanceof FurniCrafterMenu menu &&
                    menu.containerId == message.containerId) {
                menu.craftSelectedRecipe(message.recipeIndex);
            }
        });
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return FNetwork.CRAFT_RECIPE_TYPE;
    }
}
