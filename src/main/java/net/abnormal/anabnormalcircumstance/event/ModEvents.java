package net.abnormal.anabnormalcircumstance.event;

import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.abnormal.anabnormalcircumstance.item.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class ModEvents {
    public static void registerEvents() {
        // Register attack and interaction events
        ModAttackEvent.register();

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