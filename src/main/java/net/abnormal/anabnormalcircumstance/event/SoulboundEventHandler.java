package net.abnormal.anabnormalcircumstance.event;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;

import java.util.*;

public class SoulboundEventHandler {
    private static final Map<UUID, List<ItemStack>> soulboundCache = new HashMap<>();

    public static void register() {
        ServerPlayerEvents.ALLOW_DEATH.register((player, source, damage) -> {
            List<ItemStack> soulboundItems = new ArrayList<>();

            for (int i = 0; i < player.getInventory().size(); i++) {
                ItemStack stack = player.getInventory().getStack(i);
                if (isSoulbound(stack)) {
                    soulboundItems.add(stack.copy()); // Save a copy
                    player.getInventory().setStack(i, ItemStack.EMPTY); // Remove from drops
                }
            }

            soulboundCache.put(player.getUuid(), soulboundItems);
            return true;
        });

        ServerPlayerEvents.AFTER_RESPAWN.register((oldPlayer, newPlayer, alive) -> {
            List<ItemStack> savedItems = soulboundCache.remove(newPlayer.getUuid());
            if (savedItems != null) {
                for (ItemStack stack : savedItems) {
                    newPlayer.getInventory().insertStack(stack); // Add to new inventory
                }
            }
        });
    }

    private static boolean isSoulbound(ItemStack stack) {
        return stack.hasEnchantments() &&
                stack.getEnchantments().toString().contains("anabnormalcircumstance:soulbound");
    }
}
