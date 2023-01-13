package com.lhooded.crashjuice.mixin;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.ProjectileDamageSource;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.potion.Potion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(targets = {"net/minecraft/entity/LivingEntity", "net/minecraft/entity.player/PlayerEntity", "net/minecraft/client/network/ClientPlayerEntity"})
public abstract class CrashJuiceRemoveArrowDamageMixin {
    @ModifyVariable(method = "applyDamage", at = @At(value = "LOAD", ordinal = 0), argsOnly = true)
    private float removeCrashJuiceDamage(float amount, DamageSource source) {
        if (source instanceof ProjectileDamageSource projectileDamageSource) {
            if (projectileDamageSource.getSource() instanceof ArrowEntity arrowEntity) {
                Potion potion = ((CrashJuiceArrowEntityAccessor) arrowEntity).getPotion();
                if (potion != null) {
                    if (potion.finishTranslationKey("").equals("crash")) {
                        return 0;
                    }
                }
            }
        }
        return amount;
    }
}