package com.example.compressedores.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagProvider extends BlockTagsProvider {

  public ModBlockTagProvider(DataGenerator pGenerator, ExistingFileHelper existingFileHelper) {
    super(pGenerator, existingFileHelper, "compressedores");
  }

  @Override
  protected void addTags() {
    // 添加方块标签
    tag(net.minecraftforge.common.Tags.Blocks.STONES)
        .add(com.example.compressedores.CompressedOres.COMPRESSED_STONE_1.get())
        .add(com.example.compressedores.CompressedOres.COMPRESSED_STONE_2.get())
        .add(com.example.compressedores.CompressedOres.COMPRESSED_STONE_3.get())
        .add(com.example.compressedores.CompressedOres.COMPRESSED_STONE_4.get())
        .add(com.example.compressedores.CompressedOres.COMPRESSED_STONE_5.get())
        .add(com.example.compressedores.CompressedOres.COMPRESSED_STONE_6.get())
        .add(com.example.compressedores.CompressedOres.COMPRESSED_STONE_7.get())
        .add(com.example.compressedores.CompressedOres.COMPRESSED_STONE_8.get())
        .add(com.example.compressedores.CompressedOres.COMPRESSED_STONE_9.get());
  }
}