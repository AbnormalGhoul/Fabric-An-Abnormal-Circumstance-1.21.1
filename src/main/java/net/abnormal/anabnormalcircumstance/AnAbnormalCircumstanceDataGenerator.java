package net.abnormal.anabnormalcircumstance;

import net.abnormal.anabnormalcircumstance.datagen.ModItemTagProvider;
import net.abnormal.anabnormalcircumstance.datagen.ModBlockTagProvider;
import net.abnormal.anabnormalcircumstance.datagen.ModModelProvider;
import net.abnormal.anabnormalcircumstance.datagen.ModRecipeProvider;
import net.abnormal.anabnormalcircumstance.datagen.ModLootTableProvider;
import net.abnormal.anabnormalcircumstance.enchantment.ModEnchantments;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class AnAbnormalCircumstanceDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {

		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);

	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.ENCHANTMENT, ModEnchantments::bootstrap);
	}

}
