package net.abnormal.anabnormalcircumstance.effect;

import net.abnormal.anabnormalcircumstance.AnAbnormalCircumstance;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> STUNNING = registerStatusEffect("stunning",
            new StunningEffect());

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(AnAbnormalCircumstance.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        AnAbnormalCircumstance.LOGGER.info("Registering Mod Effects for " + AnAbnormalCircumstance.MOD_ID);
    }
}