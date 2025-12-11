// 文件路径: src/main/java/com/example/compressedores/CompressedOres.java
package com.compressedrawstone.compressedores;

import com.compressedrawstone.compressedores.datagen.DataGenerators;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(CompressedOres.MODID)
public class CompressedOres {

  public static final String MODID = "compressed_stones";

  // 注册表
  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

  // 基础属性：普通石头
  private static final float BASE_EXPLOSION_RESISTANCE = 6.0F;
  private static final float MAX_EXPLOSION_RESISTANCE = 1200.0F; // 黑曜石级别

  // 注册9个压缩等级
  public static final RegistryObject<Block> COMPRESSED_STONE_1 = registerCompressedBlock("compressed_stone_1", 1);
  public static final RegistryObject<Block> COMPRESSED_STONE_2 = registerCompressedBlock("compressed_stone_2", 2);
  public static final RegistryObject<Block> COMPRESSED_STONE_3 = registerCompressedBlock("compressed_stone_3", 3);
  public static final RegistryObject<Block> COMPRESSED_STONE_4 = registerCompressedBlock("compressed_stone_4", 4);
  public static final RegistryObject<Block> COMPRESSED_STONE_5 = registerCompressedBlock("compressed_stone_5", 5);
  public static final RegistryObject<Block> COMPRESSED_STONE_6 = registerCompressedBlock("compressed_stone_6", 6);
  public static final RegistryObject<Block> COMPRESSED_STONE_7 = registerCompressedBlock("compressed_stone_7", 7);
  public static final RegistryObject<Block> COMPRESSED_STONE_8 = registerCompressedBlock("compressed_stone_8", 8);
  public static final RegistryObject<Block> COMPRESSED_STONE_9 = registerCompressedBlock("compressed_stone_9", 9);

  public CompressedOres() {
    IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    BLOCKS.register(modEventBus);
    ITEMS.register(modEventBus);
    // 监测数据生成事件
    modEventBus.addListener(DataGenerators::gatherData);
  }

  /**
   * 根据压缩等级计算爆炸抗性
   */
  private static float getExplosionResistance(int level) {
    if (level <= 1)
      return BASE_EXPLOSION_RESISTANCE;
    if (level >= 9)
      return MAX_EXPLOSION_RESISTANCE;
    // 线性插值：从 level 1 到 level 9
    return BASE_EXPLOSION_RESISTANCE + (MAX_EXPLOSION_RESISTANCE - BASE_EXPLOSION_RESISTANCE) * (level - 1) / 8.0F;
  }

  /**
   * 注册一个压缩方块及其对应的物品
   */
  private static RegistryObject<Block> registerCompressedBlock(String name, int level) {
    float explosionResistance = getExplosionResistance(level);

    // 复制石头的基础属性，但覆盖爆炸抗性和硬度（可选）
    BlockBehaviour.Properties properties = BlockBehaviour.Properties.copy(Blocks.STONE)
        .explosionResistance(explosionResistance)
        .strength(1.5F + (level - 1) * 0.5F); // 硬度也随等级提升

    RegistryObject<Block> block = BLOCKS.register(name, () -> new Block(properties));

    // 注册对应的物品
    ITEMS.register(name,
        () -> new BlockItem(block.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    return block;
  }
}