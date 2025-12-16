package com.compressedrawstone.compressedores;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class OtherItem extends Item {
  public OtherItem(Properties properties) {
    super(properties);
  }

  @Override
  public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents,
      TooltipFlag pIsAdvanced) {
    pTooltipComponents.add(new TextComponent("yd之力")
        .withStyle(ChatFormatting.DARK_PURPLE)
        .withStyle(ChatFormatting.BOLD));
    pTooltipComponents.add(new TextComponent("某位创始人的遗物")
        .withStyle(ChatFormatting.GRAY)
        .append(new TextComponent("(可批发)"))
        .withStyle(ChatFormatting.RESET)
        .withStyle(ChatFormatting.GRAY)
        .withStyle(ChatFormatting.ITALIC)
        .withStyle(ChatFormatting.STRIKETHROUGH));
    super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
  }
}
