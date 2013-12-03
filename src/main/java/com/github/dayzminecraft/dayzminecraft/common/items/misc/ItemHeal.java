package com.github.dayzminecraft.dayzminecraft.common.items.misc;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;

import com.github.dayzminecraft.dayzminecraft.common.items.ItemMod;

public class ItemHeal extends ItemMod {
  private int healAmount;
  private Potion[] potionsToStop;

  public ItemHeal(int itemId, int amountToHeal, Potion... potionsToStop) {
    super(itemId);
    healAmount = amountToHeal;
    this.potionsToStop = potionsToStop;
  }

  public int getHealAmount() {
    return healAmount;
  }

  @Override
  public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
    itemStack.stackSize--;
    entityPlayer.heal(healAmount);
    entityPlayer.clearActivePotions();
    return itemStack;
  }
}
