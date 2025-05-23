package net.abnormal.anabnormalcircumstance.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.abnormal.anabnormalcircumstance.AnAbnormalCircumstance;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup ABNORMAL_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(AnAbnormalCircumstance.MOD_ID, "abnormal_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.GOLD_COIN))
                    .displayName(Text.translatable("itemgroup.anabnormalcircumstance.abnormal_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.COPPER_COIN);
                        entries.add(ModItems.SILVER_COIN);
                        entries.add(ModItems.GOLD_COIN);
                        entries.add(ModItems.PLATINUM_COIN);
                        entries.add(ModItems.KATAR);
                        entries.add(ModItems.YELLOW_SOLIN_BLADE);
                        entries.add(ModItems.RED_SOLIN_BLADE);
                        entries.add(ModItems.DWARVEN_AXE);
                        entries.add(ModItems.WILL_BREAKER);

                    }).build());

    public static void registerItemGroups() {
        AnAbnormalCircumstance.LOGGER.info("Registering Item Groups for " + AnAbnormalCircumstance.MOD_ID);
    }}
