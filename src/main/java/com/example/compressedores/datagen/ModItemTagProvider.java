package com.example.compressedores.datagen;

import com.example.compressedores.CompressedOres;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagProvider extends ItemTagsProvider {

  public ModItemTagProvider(DataGenerator pGenerator, BlockTagsProvider pBlockTagGenerator, String modId,
      ExistingFileHelper existingFileHelper) {
    super(pGenerator, pBlockTagGenerator, modId, existingFileHelper);
  }

  @Override
  protected void addTags() {
    // 添加物品标签
    tag(net.minecraftforge.common.Tags.Items.STONES)
        .add(CompressedOres.COMPRESSED_STONE_1.get().asItem())
        .add(CompressedOres.COMPRESSED_STONE_2.get().asItem())
        .add(CompressedOres.COMPRESSED_STONE_3.get().asItem())
        .add(CompressedOres.COMPRESSED_STONE_4.get().asItem())
        .add(CompressedOres.COMPRESSED_STONE_5.get().asItem())
        .add(CompressedOres.COMPRESSED_STONE_6.get().asItem())
        .add(CompressedOres.COMPRESSED_STONE_7.get().asItem())
        .add(CompressedOres.COMPRESSED_STONE_8.get().asItem())
        .add(CompressedOres.COMPRESSED_STONE_9.get().asItem());
  }
}