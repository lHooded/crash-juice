package com.lhooded.crashjuice;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

public class CrashStatusEffect extends StatusEffect {
    public CrashStatusEffect() {
        super(StatusEffectCategory.HARMFUL, 0x301934);
    }

    @Override
    public boolean isInstant() {
        return true;
    }

    @Override
    public void applyInstantEffect(@Nullable Entity source, @Nullable Entity attacker, LivingEntity target, int amplifier, double proximity) {
        if (target instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverplayer = (ServerPlayerEntity) target;
            serverplayer.networkHandler.connection.disconnect(Text.of("bye"));
        }
    }
}
