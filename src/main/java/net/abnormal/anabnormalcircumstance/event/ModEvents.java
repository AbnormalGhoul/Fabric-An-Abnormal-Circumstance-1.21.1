package net.abnormal.anabnormalcircumstance.event;

import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.TypedActionResult;
import net.abnormal.anabnormalcircumstance.item.ModItems;

public class ModEvents {
    public static void registerEvents() {
        ServerEntityCombatEvents.AFTER_KILLED_OTHER_ENTITY.register((world, entity, killedEntity) -> {
            if (entity instanceof PlayerEntity player) {
                ItemStack offhandStack = player.getOffHandStack();
                if (offhandStack.isOf(ModItems.KATAR)) {
                    // Apply extra effects here if needed
                }
            }
        });
    }
}
