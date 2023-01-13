package com.lhooded.crashjuice;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.InstantStatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class CrashStatusEffect extends InstantStatusEffect {
    public CrashStatusEffect() {
        super(StatusEffectCategory.HARMFUL, 0x000000);
    }

    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof ServerPlayerEntity serverPlayer) {
            serverPlayer.networkHandler.connection.disconnect(Text.of(""));
            return;
        }
        if (entity.hasCustomName()) {
            return;
        }
        if (entity instanceof TameableEntity && ((TameableEntity) entity).isTamed()) {
            return;
        }
        entity.remove(Entity.RemovalReason.DISCARDED);
    }
}
