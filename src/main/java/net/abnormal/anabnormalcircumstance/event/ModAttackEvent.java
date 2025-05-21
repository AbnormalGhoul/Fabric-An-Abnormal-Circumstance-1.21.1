package net.abnormal.anabnormalcircumstance.event;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.abnormal.anabnormalcircumstance.item.ModItems;

public class ModAttackEvent {
    // Katar modifiers
    private static final Identifier KATAR_ID = Identifier.of("anabnormalcircumstance", "katar");
    private static final EntityAttributeModifier KATAR_MODIFIER =
            new EntityAttributeModifier(
                    KATAR_ID,
                    3.0,
                    EntityAttributeModifier.Operation.ADD_VALUE
            );

    // Yellow Solin Blade modifiers
    private static final Identifier SOLIN_BLADE_ID = Identifier.of("anabnormalcircumstance", "solin_blade");
    private static final EntityAttributeModifier SOLIN_BLADE_MODIFIER =
            new EntityAttributeModifier(
                    SOLIN_BLADE_ID,
                    6.0,
                    EntityAttributeModifier.Operation.ADD_VALUE
            );

    public static void register() {
        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (!world.isClient() && hand == Hand.MAIN_HAND) {
                ItemStack offhandStack = player.getOffHandStack();

                // Check for Katar
                if (offhandStack.isOf(ModItems.KATAR)) {
                    handleDamageBonus(player, world, KATAR_ID, KATAR_MODIFIER);
                }
                // Check for Yellow Solin Blade
                else if (offhandStack.isOf(ModItems.YELLOW_SOLIN_BLADE)) {
                    handleDamageBonus(player, world, SOLIN_BLADE_ID, SOLIN_BLADE_MODIFIER);
                }
            }
            return ActionResult.PASS;
        });
    }

    private static void handleDamageBonus(PlayerEntity player, World world, Identifier id, EntityAttributeModifier modifier) {
        var instance = player.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        if (instance != null) {
            // Remove any existing modifier first to prevent stacking
            instance.removeModifier(id);
            instance.addPersistentModifier(modifier);

            // Remove after attack is processed
            world.getServer().execute(() -> {
                instance.removeModifier(id);
            });
        }
    }
}