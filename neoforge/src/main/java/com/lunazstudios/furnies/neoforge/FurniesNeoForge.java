package com.lunazstudios.furnies.neoforge;

import com.lunazstudios.furnies.Furnies;
import com.lunazstudios.furnies.client.screen.FurniCrafterScreen;
import com.lunazstudios.furnies.registry.FMenus;
import com.lunazstudios.furnies.registry.neoforge.FRegistryImpl;
import com.lunazstudios.furnies.registry.neoforge.FTabsImpl;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@Mod(Furnies.MOD_ID)
public final class FurniesNeoForge {
    public FurniesNeoForge(IEventBus bus) {
        Furnies.init();

        FRegistryImpl.BLOCKS.register(bus);
        FRegistryImpl.ITEMS.register(bus);
        FRegistryImpl.ENTITY_TYPES.register(bus);
        FRegistryImpl.BLOCK_ENTITY_TYPES.register(bus);
        FRegistryImpl.MENUS.register(bus);
        FRegistryImpl.RECIPE_TYPES.register(bus);
        FRegistryImpl.RECIPE_SERIALIZERS.register(bus);
        FRegistryImpl.SOUND_EVENTS.register(bus);
        FTabsImpl.register(bus);
    }

    @EventBusSubscriber(modid = Furnies.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event) {
            event.register(FMenus.FURNI_CRAFTER_MENU.get(), FurniCrafterScreen::new);
        }
    }
}
