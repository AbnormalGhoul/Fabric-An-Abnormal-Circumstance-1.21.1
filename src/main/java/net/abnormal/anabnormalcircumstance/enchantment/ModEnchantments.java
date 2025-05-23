package net.abnormal.anabnormalcircumstance.enchantment;

import net.abnormal.anabnormalcircumstance.AnAbnormalCircumstance;
import net.abnormal.anabnormalcircumstance.enchantment.custom.SoulboundEnchantmentEffect;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.item.Item;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModEnchantments {

    public static final RegistryKey<Enchantment> SOULBOUND =
            RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(AnAbnormalCircumstance.MOD_ID, "soulbound"));

    public static void bootstrap(Registerable<Enchantment> registerable) {
        var enchantments = registerable.getRegistryLookup(RegistryKeys.ENCHANTMENT);
        var items = registerable.getRegistryLookup(RegistryKeys.ITEM);

        // Define the custom tools tag
        TagKey<Item> toolsTag = TagKey.of(RegistryKeys.ITEM, Identifier.of(AnAbnormalCircumstance.MOD_ID, "tools"));
        RegistryEntryList<Item> toolsList = items.getOrThrow(toolsTag);

        // Register the Soulbound enchantment
        register(registerable, SOULBOUND, Enchantment.builder(
                        Enchantment.definition(toolsList, toolsList, 1, 1,
                                Enchantment.leveledCost(5, 7),
                                Enchantment.leveledCost(25, 9),
                                1)));
    }

    private static void register(Registerable<Enchantment> registry, RegistryKey<Enchantment> key, Enchantment.Builder builder) {
        registry.register(key, builder.build(key.getValue()));
    }
}