package net.abnormal.anabnormalcircumstance.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

public class StunningEffect extends StatusEffect {
    private static final Identifier SPEED_MODIFIER_ID =
            Identifier.of("anabnormalcircumstance", "stunning_speed");
    private static final Identifier JUMP_MODIFIER_ID =
            Identifier.of("anabnormalcircumstance", "stunning_jump");

    public StunningEffect() {
        super(StatusEffectCategory.HARMFUL, 0x5A5A5A);
        this.addAttributeModifier(
                EntityAttributes.GENERIC_MOVEMENT_SPEED,
                SPEED_MODIFIER_ID,
                -1.0, // I've tried -2000 or anything like that but it doesnt do anything
                EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
        );
        this.addAttributeModifier(
                EntityAttributes.GENERIC_JUMP_STRENGTH,
                JUMP_MODIFIER_ID,
                -1.0,
                EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
        );
    }
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        // Only allows downward movement (gravity)
        double verticalVelocity = Math.min(entity.getVelocity().y, 0);

        // Completely stops all movement
        entity.setVelocity(0, verticalVelocity, 0);
        entity.velocityDirty = true;

        if (entity instanceof PlayerEntity player) {
            // If on ground, ensure no movement (At least it should)
            if (player.isOnGround()) {
                player.setVelocity(0, 0, 0);
            }
            // Force position update
            player.updatePosition(player.getX(), player.getY(), player.getZ());
        }

        return true;
    }
}