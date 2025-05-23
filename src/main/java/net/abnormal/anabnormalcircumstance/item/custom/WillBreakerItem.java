package net.abnormal.anabnormalcircumstance.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.item.tooltip.TooltipType;
import java.util.List;

public class WillBreakerItem extends SwordItem {
    public WillBreakerItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity) {
            // Get the actual damage dealt (including all modifiers)
            float damageDealt = (float) attacker.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
            float healthToSteal = damageDealt * 0.1f;

            // Heal the attacker
            attacker.heal(healthToSteal);
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.anabnormalcircumstance.will_breaker.tooltip"));
        tooltip.add(Text.translatable("tooltip.anabnormalcircumstance.will_breaker.lifesteal"));
        super.appendTooltip(stack, context, tooltip, type);
    }
}