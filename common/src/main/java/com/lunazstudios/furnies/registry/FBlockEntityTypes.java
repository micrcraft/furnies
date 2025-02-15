package com.lunazstudios.furnies.registry;

import com.lunazstudios.furnies.block.entity.*;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class FBlockEntityTypes {

    public static final Supplier<BlockEntityType<CabinetBlockEntity>> CABINET = FRegistry.registerBlockEntityType("cabinet",
            () -> FRegistry.createBlockEntityType(CabinetBlockEntity::new,
                    FBlocks.OAK_CABINET.get(),
                    FBlocks.SPRUCE_CABINET.get(),
                    FBlocks.BIRCH_CABINET.get(),
                    FBlocks.JUNGLE_CABINET.get(),
                    FBlocks.ACACIA_CABINET.get(),
                    FBlocks.DARK_OAK_CABINET.get(),
                    FBlocks.MANGROVE_CABINET.get(),
                    FBlocks.BAMBOO_CABINET.get(),
                    FBlocks.CHERRY_CABINET.get(),
                    FBlocks.WARPED_CABINET.get(),
                    FBlocks.CRIMSON_CABINET.get()
            ));

    public static final Supplier<BlockEntityType<KitchenCabinetBlockEntity>> KITCHEN_CABINET = FRegistry.registerBlockEntityType("kitchen_cabinet",
            () -> FRegistry.createBlockEntityType(KitchenCabinetBlockEntity::new,
                    FBlocks.OAK_KITCHEN_CABINET.get(),
                    FBlocks.SPRUCE_KITCHEN_CABINET.get(),
                    FBlocks.BIRCH_KITCHEN_CABINET.get(),
                    FBlocks.JUNGLE_KITCHEN_CABINET.get(),
                    FBlocks.ACACIA_KITCHEN_CABINET.get(),
                    FBlocks.DARK_OAK_KITCHEN_CABINET.get(),
                    FBlocks.MANGROVE_KITCHEN_CABINET.get(),
                    FBlocks.BAMBOO_KITCHEN_CABINET.get(),
                    FBlocks.CHERRY_KITCHEN_CABINET.get(),
                    FBlocks.WARPED_KITCHEN_CABINET.get(),
                    FBlocks.CRIMSON_KITCHEN_CABINET.get()
            ));

    public static final Supplier<BlockEntityType<KitchenDrawerBlockEntity>> KITCHEN_DRAWER = FRegistry.registerBlockEntityType("kitchen_drawer",
            () -> FRegistry.createBlockEntityType(KitchenDrawerBlockEntity::new,
                    FBlocks.OAK_KITCHEN_DRAWER.get(),
                    FBlocks.SPRUCE_KITCHEN_DRAWER.get(),
                    FBlocks.BIRCH_KITCHEN_DRAWER.get(),
                    FBlocks.JUNGLE_KITCHEN_DRAWER.get(),
                    FBlocks.ACACIA_KITCHEN_DRAWER.get(),
                    FBlocks.DARK_OAK_KITCHEN_DRAWER.get(),
                    FBlocks.MANGROVE_KITCHEN_DRAWER.get(),
                    FBlocks.BAMBOO_KITCHEN_DRAWER.get(),
                    FBlocks.CHERRY_KITCHEN_DRAWER.get(),
                    FBlocks.WARPED_KITCHEN_DRAWER.get(),
                    FBlocks.CRIMSON_KITCHEN_DRAWER.get()
            ));

    public static final Supplier<BlockEntityType<FridgeBlockEntity>> FRIDGE = FRegistry.registerBlockEntityType("fridge",
            () -> FRegistry.createBlockEntityType(FridgeBlockEntity::new,
                    FBlocks.LIGHT_FRIDGE.get(),
                    FBlocks.DARK_FRIDGE.get()
            ));

    public static final Supplier<BlockEntityType<FreezerBlockEntity>> FREEZER = FRegistry.registerBlockEntityType("freezer",
            () -> FRegistry.createBlockEntityType(FreezerBlockEntity::new,
                    FBlocks.LIGHT_FREEZER.get(),
                    FBlocks.DARK_FREEZER.get()
            ));

    public static final Supplier<BlockEntityType<FurniCrafterBlockEntity>> FURNI_CRAFTER = FRegistry.registerBlockEntityType("furnicrafter",
            () -> FRegistry.createBlockEntityType(FurniCrafterBlockEntity::new,
                    FBlocks.FURNI_CRAFTER.get()
            ));

    public static void init() {}
}
