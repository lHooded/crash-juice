package com.lhooded.crashjuice.mixin;

import com.lhooded.crashjuice.CrashJuice;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BrewingRecipeRegistry.class)
public class CrashJuiceRecipeMixin {

    @Shadow
    private static void registerPotionRecipe(Potion input, Item item, Potion output) {
        throw new RuntimeException();
    }

    @Inject(at = @At("TAIL"), method = "registerDefaults()V")
    private static void RegisterDefaults(CallbackInfo ci) {
        registerPotionRecipe(Potions.AWKWARD, Items.NETHER_STAR, CrashJuice.CRASH_POTION);
    }
}
