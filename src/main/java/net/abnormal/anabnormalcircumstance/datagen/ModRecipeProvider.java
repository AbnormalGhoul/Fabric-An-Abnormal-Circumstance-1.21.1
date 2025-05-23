package net.abnormal.anabnormalcircumstance.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.abnormal.anabnormalcircumstance.AnAbnormalCircumstance;
//import net.abnormal.anabnormalcircumstance.block.ModBlocks;
import net.abnormal.anabnormalcircumstance.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        // Silver Coins
        offerReversibleCompactingRecipes(
                exporter,
                RecipeCategory.MISC,
                ModItems.COPPER_COIN,
                RecipeCategory.DECORATIONS,
                ModItems.SILVER_COIN,
                "copper_coin_to_silver_coin",  // compacting ID
                "silver_coin",                 // compacting group
                "silver_coin_to_copper_coins", // reverse ID
                "copper_coin"                  // reverse group
        );

        // Gold Coins
        offerReversibleCompactingRecipes(
                exporter,
                RecipeCategory.MISC,
                ModItems.SILVER_COIN,
                RecipeCategory.DECORATIONS,
                ModItems.GOLD_COIN,
                "silver_coin_to_gold_coin",    // compacting ID
                "gold_coin",                   // compacting group
                "gold_coin_to_silver_coins",   // reverse ID
                "silver_coin"                  // reverse group
        );

        //Platinum Coin
        offerReversibleCompactingRecipes(
                exporter,
                RecipeCategory.MISC,
                ModItems.GOLD_COIN,
                RecipeCategory.DECORATIONS,
                ModItems.PLATINUM_COIN,
                "gold_coin_to_platinum_coin",  // compacting ID
                "platinum_coin",               // compacting group
                "platinum_coin_to_gold_coins", // reverse ID
                "gold_coin"                    // reverse group
        );
    }
}