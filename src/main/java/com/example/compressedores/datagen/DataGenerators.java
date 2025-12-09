package com.example.compressedores.datagen;

import com.example.compressedores.CompressedOres;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
  @SubscribeEvent
  public static void gatherData(GatherDataEvent event) {
    DataGenerator generator = event.getGenerator();

    // 添加数据生成器
    generator.addProvider(event.includeServer(), new ModRecipes(generator));
    generator.addProvider(event.includeClient(), new ModBlockStateProvider(generator,
        CompressedOres.MODID, event.getExistingFileHelper()));
    generator.addProvider(event.includeServer(), new ModItemTagProvider(generator,
        new ModBlockTagProvider(generator, event.getExistingFileHelper()),
        CompressedOres.MODID, event.getExistingFileHelper()));
  }
}