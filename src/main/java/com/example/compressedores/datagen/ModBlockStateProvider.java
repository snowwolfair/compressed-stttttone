package com.example.compressedores.datagen;

import com.example.compressedores.CompressedOres;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {

  public ModBlockStateProvider(DataGenerator gen, String modid, ExistingFileHelper exFileHelper) {
    super(gen, modid, exFileHelper);
  }

  @Override
  protected void registerStatesAndModels() {
    // 为所有压缩石生成方块状态和模型
    simpleBlockWithItem(CompressedOres.COMPRESSED_STONE_1.get(),
        models().cubeAll("compressed_stone_1", modLoc("block/compressed_stone_1")));
    simpleBlockWithItem(CompressedOres.COMPRESSED_STONE_2.get(),
        models().cubeAll("compressed_stone_2", modLoc("block/compressed_stone_2")));
    simpleBlockWithItem(CompressedOres.COMPRESSED_STONE_3.get(),
        models().cubeAll("compressed_stone_3", modLoc("block/compressed_stone_3")));
    simpleBlockWithItem(CompressedOres.COMPRESSED_STONE_4.get(),
        models().cubeAll("compressed_stone_4", modLoc("block/compressed_stone_4")));
    simpleBlockWithItem(CompressedOres.COMPRESSED_STONE_5.get(),
        models().cubeAll("compressed_stone_5", modLoc("block/compressed_stone_5")));
    simpleBlockWithItem(CompressedOres.COMPRESSED_STONE_6.get(),
        models().cubeAll("compressed_stone_6", modLoc("block/compressed_stone_6")));
    simpleBlockWithItem(CompressedOres.COMPRESSED_STONE_7.get(),
        models().cubeAll("compressed_stone_7", modLoc("block/compressed_stone_7")));
    simpleBlockWithItem(CompressedOres.COMPRESSED_STONE_8.get(),
        models().cubeAll("compressed_stone_8", modLoc("block/compressed_stone_8")));
    simpleBlockWithItem(CompressedOres.COMPRESSED_STONE_9.get(),
        models().cubeAll("compressed_stone_9", modLoc("block/compressed_stone_9")));
  }
}