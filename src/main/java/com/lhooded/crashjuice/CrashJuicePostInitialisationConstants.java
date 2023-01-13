package com.lhooded.crashjuice;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtil;
public class CrashJuicePostInitialisationConstants {
    public static final ItemStack CRASH_POTION_ITEM_STACK = PotionUtil.setPotion(new ItemStack(Items.POTION), CrashJuice.CRASH_POTION);
}
