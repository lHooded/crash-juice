package com.lhooded.crashjuice;

import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
public class CrashJuice implements ModInitializer {
    public static final String MOD_ID = "crash-juice";
    public static final StatusEffect CRASH_EFFECT = new CrashStatusEffect();
    public static final Potion CRASH_POTION = new Potion("crash", new StatusEffectInstance(CRASH_EFFECT));
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final ItemStack CRASH_POTION_ITEM_STACK = PotionUtil.setPotion(new ItemStack(Items.POTION), CrashJuice.CRASH_POTION);


    @Override
    public void onInitialize() {
        Registry.register(Registry.STATUS_EFFECT, new Identifier(MOD_ID, "crash"), CRASH_EFFECT);
        Registry.register(Registry.POTION, new Identifier(MOD_ID, "crash"), CRASH_POTION);

        LOGGER.info("Initialised successfully.");
    }
}
