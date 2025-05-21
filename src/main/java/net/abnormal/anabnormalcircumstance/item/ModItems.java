    package net.abnormal.anabnormalcircumstance.item;

    import net.abnormal.anabnormalcircumstance.AnAbnormalCircumstance;
    import net.abnormal.anabnormalcircumstance.item.custom.DwarvenAxeItem;
    import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
    import net.minecraft.item.*;
    import net.minecraft.item.tooltip.TooltipType;
    import net.minecraft.registry.Registries;
    import net.minecraft.registry.Registry;
    import net.minecraft.text.Text;
    import net.minecraft.util.Identifier;

    import java.util.List;

    public class ModItems {
        // Combat
        public static final Item KATAR = registerItem("katar", new Item(new Item.Settings().maxCount(1)));

        // Nation Weapons
        public static final Item YELLOW_SOLIN_BLADE = registerItem("yellow_solin_blade", new Item(new Item.Settings().maxCount(1)) {
            @Override
            public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                tooltip.add(Text.translatable("tooltip.anabnormalcircumstance.yellow_solin_blade.tooltip"));
                super.appendTooltip(stack, context, tooltip, type);
            }
        });

        public static final Item RED_SOLIN_BLADE = registerItem("red_solin_blade",
                new SwordItem(ModToolMaterials.SOULSTONE, new Item.Settings()
                        .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.SOULSTONE, 8, -2.4f))){
                    @Override
                    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                        tooltip.add(Text.translatable("tooltip.anabnormalcircumstance.red_solin_blade.tooltip"));
                        super.appendTooltip(stack, context, tooltip, type);
                    }
                });

    public static final Item DWARVEN_AXE = registerItem("dwarven_axe",
            new DwarvenAxeItem(ModToolMaterials.SOULSTONE,new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.SOULSTONE, 12, -3.0f))));



        // Registers
        private static Item registerItem(String name, Item item) {
            return Registry.register(Registries.ITEM, Identifier.of(AnAbnormalCircumstance.MOD_ID, name), item);
        }

        public static void registerModItems() {
            AnAbnormalCircumstance.LOGGER.info("Registering Mod Items for " + AnAbnormalCircumstance.MOD_ID);

            ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
                entries.add(YELLOW_SOLIN_BLADE);
                entries.add(RED_SOLIN_BLADE);
                entries.add(KATAR);
                entries.add(DWARVEN_AXE);
            });
        }
    }