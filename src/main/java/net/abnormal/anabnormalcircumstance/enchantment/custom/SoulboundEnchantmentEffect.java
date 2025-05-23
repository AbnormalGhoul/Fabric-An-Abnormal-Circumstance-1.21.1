package net.abnormal.anabnormalcircumstance.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public record SoulboundEnchantmentEffect() implements EnchantmentEntityEffect {
    public static MapCodec<SoulboundEnchantmentEffect> CODEC = MapCodec.unit(SoulboundEnchantmentEffect::new);

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
        if (user instanceof ItemEntity itemEntity) {
            ItemStack stack = itemEntity.getStack();
            if (stack.hasEnchantments() && stack.getEnchantments().toString().contains("anabnormalcircumstance:soulbound")) {
                itemEntity.setToDefaultPickupDelay();
                itemEntity.setOwner(user.getUuid());
            }
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
