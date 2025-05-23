package net.abnormal.anabnormalcircumstance.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
//import net.abnormal.anabnormalcircumstance.block.ModBlocks;
import net.abnormal.anabnormalcircumstance.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_BLOCK);
//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_PINK_GARNET_BLOCK);
//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_ORE);
//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
//
//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.COPPER_COIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILVER_COIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLD_COIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLATINUM_COIN, Models.GENERATED);

        itemModelGenerator.register(ModItems.KATAR, Models.GENERATED);

        itemModelGenerator.register(ModItems.RED_SOLIN_BLADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.YELLOW_SOLIN_BLADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.DWARVEN_AXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.WILL_BREAKER, Models.GENERATED);

    }
}
