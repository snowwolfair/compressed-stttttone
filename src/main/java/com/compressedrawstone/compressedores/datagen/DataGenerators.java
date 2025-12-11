package com.compressedrawstone.compressedores.datagen;

import com.compressedrawstone.compressedores.CompressedOres;
import com.compressedrawstone.compressedores.ModRecipes;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
  @SubscribeEvent
  public static void gatherData(GatherDataEvent event) {
    DataGenerator generator = event.getGenerator();
    var helper = event.getExistingFileHelper();

    // 添加数据生成器
    // 方块模型物品生成
    if (event.includeServer()) {
      generator.addProvider(new ModRecipes(generator));
    }
    generator.addProvider(new ModBlockStateProvider(generator, CompressedOres.MODID, helper));
    // generator.addProvider(event.includeServer(), new
    // ModItemTagProvider(generator, new ModBlockTagProvider(generator,
    // event.getExistingFileHelper()),CompressedOres.MODID,
    // event.getExistingFileHelper()));

    generator.addProvider(new LootTableProvider(generator));
  }
}