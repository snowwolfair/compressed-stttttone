package com.compressedrawstone.compressedores;

import java.util.function.Consumer;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class ModRecipes extends RecipeProvider implements IConditionBuilder {

  public ModRecipes(DataGenerator generatorIn) {
    super(generatorIn);
  }

  @Override
  protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
    // 从石头开始制作第一阶压缩石
    ShapedRecipeBuilder.shaped(CompressedOres.COMPRESSED_STONE_1.get())
        .pattern("SSS")
        .pattern("SSS")
        .pattern("SSS")
        .define('S', Blocks.STONE)
        .unlockedBy("has_stone", has(Blocks.STONE))
        .save(consumer);

    // 压缩石头可以反向解压出9个石头
    ShapelessRecipeBuilder.shapeless(Blocks.STONE, 9)
        .requires(CompressedOres.COMPRESSED_STONE_1.get())
        .unlockedBy("has_" + getBlockName(CompressedOres.COMPRESSED_STONE_1.get()),
            has(CompressedOres.COMPRESSED_STONE_1.get()))
        .save(consumer);

    // 第2-9阶压缩石，每一阶由上一阶的9个组成
    createUpgradeRecipe(consumer, CompressedOres.COMPRESSED_STONE_1.get(), CompressedOres.COMPRESSED_STONE_2.get());
    createUpgradeRecipe(consumer, CompressedOres.COMPRESSED_STONE_2.get(), CompressedOres.COMPRESSED_STONE_3.get());
    createUpgradeRecipe(consumer, CompressedOres.COMPRESSED_STONE_3.get(), CompressedOres.COMPRESSED_STONE_4.get());
    createUpgradeRecipe(consumer, CompressedOres.COMPRESSED_STONE_4.get(), CompressedOres.COMPRESSED_STONE_5.get());
    createUpgradeRecipe(consumer, CompressedOres.COMPRESSED_STONE_5.get(), CompressedOres.COMPRESSED_STONE_6.get());
    createUpgradeRecipe(consumer, CompressedOres.COMPRESSED_STONE_6.get(), CompressedOres.COMPRESSED_STONE_7.get());
    createUpgradeRecipe(consumer, CompressedOres.COMPRESSED_STONE_7.get(), CompressedOres.COMPRESSED_STONE_8.get());
    createUpgradeRecipe(consumer, CompressedOres.COMPRESSED_STONE_8.get(), CompressedOres.COMPRESSED_STONE_9.get());

    createDowngradeRecipe(consumer, CompressedOres.COMPRESSED_STONE_9.get(), CompressedOres.COMPRESSED_STONE_8.get());
    createDowngradeRecipe(consumer, CompressedOres.COMPRESSED_STONE_8.get(), CompressedOres.COMPRESSED_STONE_7.get());
    createDowngradeRecipe(consumer, CompressedOres.COMPRESSED_STONE_7.get(), CompressedOres.COMPRESSED_STONE_6.get());
    createDowngradeRecipe(consumer, CompressedOres.COMPRESSED_STONE_6.get(), CompressedOres.COMPRESSED_STONE_5.get());
    createDowngradeRecipe(consumer, CompressedOres.COMPRESSED_STONE_5.get(), CompressedOres.COMPRESSED_STONE_4.get());
    createDowngradeRecipe(consumer, CompressedOres.COMPRESSED_STONE_4.get(), CompressedOres.COMPRESSED_STONE_3.get());
    createDowngradeRecipe(consumer, CompressedOres.COMPRESSED_STONE_3.get(), CompressedOres.COMPRESSED_STONE_2.get());
    createDowngradeRecipe(consumer, CompressedOres.COMPRESSED_STONE_2.get(), CompressedOres.COMPRESSED_STONE_1.get());

  }

  // 辅助方法：创建升级合成配方
  private void createUpgradeRecipe(Consumer<FinishedRecipe> consumer, net.minecraft.world.level.block.Block input,
      net.minecraft.world.level.block.Block output) {
    ShapedRecipeBuilder.shaped(output)
        .pattern("III")
        .pattern("III")
        .pattern("III")
        .define('I', input)
        .unlockedBy("has_" + getBlockName(input), has(input.asItem()))
        .save(consumer, new ResourceLocation(CompressedOres.MODID,
            "upgrade_" + getBlockName(output) + "_from_" + getBlockName(input)));
  }

  private void createDowngradeRecipe(Consumer<FinishedRecipe> consumer, net.minecraft.world.level.block.Block input,
      net.minecraft.world.level.block.Block output) {
    ShapelessRecipeBuilder.shapeless(output, 9)
        .requires(input)
        .unlockedBy("has_" + getBlockName(input), has(input.asItem()))
        .save(consumer, new ResourceLocation(CompressedOres.MODID,
            "downgrade_" + getBlockName(output) + "_from_" + getBlockName(input)));
  }

  // 获取方块名称的辅助方法
  private String getBlockName(net.minecraft.world.level.block.Block block) {
    return block.asItem().getRegistryName().getPath();
  }

}