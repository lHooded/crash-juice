package com.lhooded.crashjuice.mixin;

import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.potion.Potion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ArrowEntity.class)
public interface CrashJuiceArrowEntityAccessor {
    @Accessor
    Potion getPotion();
}
