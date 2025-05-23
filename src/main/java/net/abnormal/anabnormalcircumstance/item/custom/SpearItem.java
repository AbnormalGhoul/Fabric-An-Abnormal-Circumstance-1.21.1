package net.abnormal.anabnormalcircumstance.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.component.type.AttributeModifiersComponent;

import java.util.UUID;

public class SpearItem extends ToolItem {
    private static final Identifier ATTACK_RANGE_MODIFIER_ID = Identifier.of("anabnormalcircumstance", "spear_range_bonus");
    private static final Identifier ATTACK_DAMAGE_MODIFIER_ID = Identifier.of("anabnormalcircumstance", "attack_damage");
    private static final Identifier ATTACK_SPEED_MODIFIER_ID = Identifier.of("anabnormalcircumstance", "attack_speed");

    private final float attackDamage;
    private final float attackSpeed;
    private final float attackRangeBonus;
    private final AttributeModifiersComponent attributeModifiers;

    public SpearItem(ToolMaterial material, float baseDamage, float attackSpeed, float attackRangeBonus, Item.Settings settings) {
        super(material, settings);
        this.attackDamage = baseDamage + material.getAttackDamage();
        this.attackSpeed = attackSpeed;
        this.attackRangeBonus = attackRangeBonus;

        this.attributeModifiers = AttributeModifiersComponent.builder()
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                        new EntityAttributeModifier(
                                ATTACK_DAMAGE_MODIFIER_ID,
                                (double)this.attackDamage, // Cast to double
                                EntityAttributeModifier.Operation.ADD_VALUE
                        ),
                        AttributeModifierSlot.forEquipmentSlot(EquipmentSlot.MAINHAND))
                .add(EntityAttributes.GENERIC_ATTACK_SPEED,
                        new EntityAttributeModifier(
                                ATTACK_SPEED_MODIFIER_ID,
                                (double)this.attackSpeed, // Cast to double
                                EntityAttributeModifier.Operation.ADD_VALUE
                        ),
                        AttributeModifierSlot.forEquipmentSlot(EquipmentSlot.MAINHAND))
                .build();
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, EquipmentSlot.MAINHAND);
        return true;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (state.getHardness(world, pos) != 0.0F) {
            stack.damage(2, miner, EquipmentSlot.MAINHAND);
        }
        return true;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return TypedActionResult.pass(user.getStackInHand(hand));
    }

    @Override
    public AttributeModifiersComponent getAttributeModifiers() {
        return this.attributeModifiers;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);

        if (entity instanceof LivingEntity livingEntity) {
            var reachAttribute = livingEntity.getAttributeInstance(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE);
            if (reachAttribute != null) {
                var existingModifier = reachAttribute.getModifier(ATTACK_RANGE_MODIFIER_ID);

                // Always remove the modifier if it exists
                if (existingModifier != null) {
                    reachAttribute.removeModifier(existingModifier);
                }

                // Only re-add if currently selected
                if (selected) {
                    reachAttribute.addPersistentModifier(
                            new EntityAttributeModifier(
                                    ATTACK_RANGE_MODIFIER_ID,
                                    (double)this.attackRangeBonus, // Cast to double
                                    EntityAttributeModifier.Operation.ADD_VALUE
                            )
                    );
                }
            }
        }
    }
}