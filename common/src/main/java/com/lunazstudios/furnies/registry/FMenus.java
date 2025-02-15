package com.lunazstudios.furnies.registry;

import com.lunazstudios.furnies.menu.FurniCrafterMenu;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;

import java.util.function.Supplier;

public class FMenus {

    public static final Supplier<MenuType<FurniCrafterMenu>> FURNI_CRAFTER_MENU =
            FRegistry.registerMenuType("furni_crafter", () ->
                    new MenuType<>(FurniCrafterMenu::new, FeatureFlags.DEFAULT_FLAGS)
            );

    public static void register() {}
}
