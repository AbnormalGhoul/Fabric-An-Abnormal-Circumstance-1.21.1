package net.abnormal.anabnormalcircumstance.event;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;

import java.util.ArrayList;
import java.util.List;

public class SoulboundEventHandler {
    public static void register() {
        ServerPlayerEvents.ALLOW_DEATH.register((player, damageSource, damageAmount) -> {
            // Store soulbound items before death
            List<ItemStack> soulboundItems = new ArrayList<>();
            for (ItemStack stack : player.getInventory().main) {
                if (hasSoulbound(stack)) {
                    soulboundItems.add(stack.copy());
                    stack.setCount(0); // Remove from inventory to prevent drop
                }
            }
            // Store soulboundItems somewhere to restore after respawn
            // For example, attach to player using a capability or a custom player component
            return true; // Allow death
        });

        ServerPlayerEvents.AFTER_RESPAWN.register((oldPlayer, newPlayer, alive) -> {
            // Retrieve and restore soulbound items to newPlayer's inventory
        });
    }

    private static boolean hasSoulbound(ItemStack stack) {
        return stack.hasEnchantments() && stack.getEnchantments().toString().contains("anabnormalcircumstance:soulbound");
    }
}
