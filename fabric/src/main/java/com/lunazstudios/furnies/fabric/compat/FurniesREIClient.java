package com.lunazstudios.furnies.fabric.compat;

import com.lunazstudios.furnies.recipe.FurniCraftingRecipe;
import com.lunazstudios.furnies.registry.FBlocks;
import com.lunazstudios.furnies.registry.FRecipes;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;

public class FurniesREIClient implements REIClientPlugin {

    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new FurniCrafterCategory());

        registry.addWorkstations(FurniCrafterCategory.FURNICRAFTER, EntryStacks.of(FBlocks.FURNI_CRAFTER.get()));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(FurniCraftingRecipe.class, FRecipes.FURNI_CRAFTING_RECIPE_TYPE,
                FurniCrafterDisplay::new);
    }
}
