package com.compressedrawstone.compressedores.datagen;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import javax.annotation.Nonnull;

import com.compressedrawstone.compressedores.CompressedOres;
import com.mojang.datafixers.util.Pair;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class ModBlockLootTable {
  public static class LootProvider extends LootTableProvider {
    public LootProvider(DataGenerator generator) {
      super(generator);
    }

    @Nonnull
    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
      // 此处指明 Data Generator 需生成的战利品表类别，此处仅需生成方块的战利品表
      return List.of(Pair.of(CustomBlockLoot::new, LootContextParamSets.BLOCK));
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, @Nonnull ValidationContext context) {
      // 模组自定义的战利品表 DataProvider 必须覆盖此方法，以绕过对原版战利品表的检查
      map.forEach((key, value) -> LootTables.validate(context, key, value));
    }
  }

  public static class CustomBlockLoot extends BlockLoot {
    @Override
    protected void addTables() {
      // 此处添加 xiaozhong:sulfur_block 处的战利品表，意为掉落自身对应物品一个
      this.dropSelf(CompressedOres.COMPRESSED_STONE_1.get());
      this.dropSelf(CompressedOres.COMPRESSED_STONE_2.get());
      this.dropSelf(CompressedOres.COMPRESSED_STONE_3.get());
      this.dropSelf(CompressedOres.COMPRESSED_STONE_4.get());
      this.dropSelf(CompressedOres.COMPRESSED_STONE_5.get());
      this.dropSelf(CompressedOres.COMPRESSED_STONE_6.get());
      this.dropSelf(CompressedOres.COMPRESSED_STONE_7.get());
      this.dropSelf(CompressedOres.COMPRESSED_STONE_8.get());
      this.dropSelf(CompressedOres.COMPRESSED_STONE_9.get());
      /*
       * // 如欲在非精准采集的情况下掉落九个 xiaozhong:sulfur_dust，请使用以下代码：
       * this.add(SULFUR_BLOCK.get(), block ->
       * createSingleItemTableWithSilkTouch(block, SULFUR_DUST_ITEM.get(),
       * ConstantValue.exactly(9f)));
       */
    }

    @Nonnull
    @Override
    protected Iterable<Block> getKnownBlocks() {
      // 模组自定义的方块战利品表必须覆盖此方法，以绕过对原版方块战利品表的检查（此处返回该模组的所有方块）
      return CompressedOres.BLOCKS.getEntries().stream().map(Supplier::get)::iterator;
    }
  }
}
