package net.abnormal.anabnormalcircumstance.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.item.tooltip.TooltipType;
import java.util.List;

public class DwarvenAxeItem extends AxeItem {
    public DwarvenAxeItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // Check for existing Wither effect
        StatusEffectInstance existingWither = target.getStatusEffect(StatusEffects.WITHER);
        int newDuration = 100; // Base 5 seconds (100 ticks)

        if (existingWither != null) {
            // If already has Wither, add to the remaining duration
            newDuration += existingWither.getDuration();
        }

        // Apply Wither II with calculated duration
        target.addStatusEffect(new StatusEffectInstance(
                StatusEffects.WITHER,
                newDuration,
                1,  // Wither II
                false, // No ambient particles
                true,  // Show icon
                true   // Show particles
        ));

        return super.postHit(stack, target, attacker);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.anabnormalcircumstance.dwarven_axe.tooltip"));
        tooltip.add(Text.translatable("tooltip.anabnormalcircumstance.dwarven_axe.wither"));
        super.appendTooltip(stack, context, tooltip, type);
    }
}