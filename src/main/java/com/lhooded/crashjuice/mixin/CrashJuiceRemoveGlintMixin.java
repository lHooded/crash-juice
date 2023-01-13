package com.lhooded.crashjuice.mixin;

import com.lhooded.crashjuice.CrashJuicePostInitialisationConstants;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PotionItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PotionItem.class)
public class CrashJuiceRemoveGlintMixin {
    @Inject(at = @At("HEAD"), method = "hasGlint", cancellable = true)
    private void crashJuiceRemoveGlint(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (stack.getItem() instanceof PotionItem) {
            if (ItemStack.areNbtEqual(stack, CrashJuicePostInitialisationConstants.CRASH_POTION_ITEM_STACK)) {
                cir.setReturnValue(false);
            }
        }
    }
}
