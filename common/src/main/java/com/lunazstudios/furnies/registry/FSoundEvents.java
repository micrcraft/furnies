package com.lunazstudios.furnies.registry;

import com.lunazstudios.furnies.Furnies;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public class FSoundEvents {
    public static final Supplier<SoundEvent> FRIDGE_OPEN = register("block.fridge.open");
    public static final Supplier<SoundEvent> FRIDGE_CLOSE = register("block.fridge.close");

    public static final Supplier<SoundEvent> STOVE_OPEN = register("block.stove.open");
    public static final Supplier<SoundEvent> STOVE_CLOSE = register("block.stove.close");

    public static Supplier<SoundEvent> register(String name) {
        return FRegistry.registerSoundEvent(name, () -> SoundEvent.createVariableRangeEvent(Furnies.id(name)));
    }

    public static void init() {}
}
