package net.abnormal.anabnormalcircumstance.enchantment;

import com.mojang.serialization.MapCodec;
import net.abnormal.anabnormalcircumstance.AnAbnormalCircumstance;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantmentEffects {

//    public static final MapCodec<? extends EnchantmentEntityEffect> SOULBOUND =
//            registerEntityEffect("soulbound", SoulboundEnchantmentEffect.CODEC);

    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect
            (String name, MapCodec<? extends EnchantmentEntityEffect> codec) {

        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(AnAbnormalCircumstance.MOD_ID, name), codec);
    }

    public static void registerEnchantmentEffects() {
        AnAbnormalCircumstance.LOGGER.info("Registering Mod Enchantment Effects for " + AnAbnormalCircumstance.MOD_ID);
    }
}
