    package net.abnormal.anabnormalcircumstance.item;

    import net.abnormal.anabnormalcircumstance.AnAbnormalCircumstance;
    import net.abnormal.anabnormalcircumstance.item.custom.DwarvenAxeItem;
    import net.abnormal.anabnormalcircumstance.item.custom.SpearItem;
    import net.abnormal.anabnormalcircumstance.item.custom.WillBreakerItem;
    import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
    import net.minecraft.item.*;
    import net.minecraft.item.tooltip.TooltipType;
    import net.minecraft.registry.Registries;
    import net.minecraft.registry.Registry;
    import net.minecraft.text.Text;
    import net.minecraft.util.Identifier;
    import java.util.List;

    import static net.minecraft.item.SwordItem.createAttributeModifiers;

    public class ModItems {
        // Combat
        public static final Item KATAR = registerItem("katar", new Item(new Item.Settings().maxCount(1)));

            // Spears
        public static final Item WOODEN_SPEAR = registerItem("wooden_spear",
                new SpearItem(ModToolMaterials.WOOD, 4.0f, -2.6f, 1.0f, new Item.Settings()));

        public static final Item STONE_SPEAR = registerItem("stone_spear",
                new SpearItem(ModToolMaterials.STONE, 4.0f, -2.6f, 1.0f, new Item.Settings()));

        public static final Item GOLDEN_SPEAR = registerItem("golden_spear",
                new SpearItem(ModToolMaterials.GOLD, 4.0f, -2.6f, 1.0f, new Item.Settings()));

        public static final Item IRON_SPEAR = registerItem("iron_spear",
                new SpearItem(ModToolMaterials.IRON, 4.0f, -2.6f, 1.0f, new Item.Settings()));

        public static final Item DIAMOND_SPEAR = registerItem("diamond_spear",
                new SpearItem(ModToolMaterials.DIAMOND, 4.0f, -2.6f, 1.0f, new Item.Settings()));

        public static final Item NETHERITE_SPEAR = registerItem("netherite_spear",
                new SpearItem(ModToolMaterials.NETHERITE, 4.0f, -2.6f, 2.0f, new Item.Settings()));

            // Rapiers
        public static final Item WOODEN_RAPIER = registerItem("wooden_rapier",
                    new SwordItem(ModToolMaterials.WOOD, new Item.Settings()
                            .attributeModifiers(createAttributeModifiers(ModToolMaterials.WOOD, 3, -2.2f))));

        public static final Item STONE_RAPIER = registerItem("stone_rapier",
                new SwordItem(ModToolMaterials.STONE, new Item.Settings()
                        .attributeModifiers(createAttributeModifiers(ModToolMaterials.STONE, 3, -2.2f))));

        public static final Item GOLDEN_RAPIER = registerItem("golden_rapier",
                new SwordItem(ModToolMaterials.GOLD, new Item.Settings()
                        .attributeModifiers(createAttributeModifiers(ModToolMaterials.GOLD, 3, -2.2f))));

        public static final Item IRON_RAPIER = registerItem("iron_rapier",
                new SwordItem(ModToolMaterials.IRON, new Item.Settings()
                        .attributeModifiers(createAttributeModifiers(ModToolMaterials.IRON, 3, -2.2f))));

        public static final Item DIAMOND_RAPIER = registerItem("diamond_rapier",
                new SwordItem(ModToolMaterials.DIAMOND, new Item.Settings()
                        .attributeModifiers(createAttributeModifiers(ModToolMaterials.DIAMOND, 3, -2.2f))));

        public static final Item NETHERITE_RAPIER = registerItem("netherite_rapier",
                new SwordItem(ModToolMaterials.NETHERITE, new Item.Settings()
                        .attributeModifiers(createAttributeModifiers(ModToolMaterials.NETHERITE, 3, -2.2f))));


        // Nation Weapons
        public static final Item YELLOW_SOLIN_BLADE = registerItem("yellow_solin_blade", new Item(new Item.Settings().maxCount(1)) {
            @Override
            public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                tooltip.add(Text.translatable("tooltip.anabnormalcircumstance.yellow_solin_blade.tooltip"));
                super.appendTooltip(stack, context, tooltip, type);}});

        public static final Item RED_SOLIN_BLADE = registerItem("red_solin_blade",
                new SwordItem(ModToolMaterials.SOULSTONE, new Item.Settings()
                        .attributeModifiers(createAttributeModifiers(ModToolMaterials.SOULSTONE, 9, -2.4f))){
                    @Override
                    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                        tooltip.add(Text.translatable("tooltip.anabnormalcircumstance.red_solin_blade.tooltip"));
                        super.appendTooltip(stack, context, tooltip, type);}});

    public static final Item DWARVEN_AXE = registerItem("dwarven_axe",
            new DwarvenAxeItem(ModToolMaterials.SOULSTONE,new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.SOULSTONE, 13, -3.0f))));

    public static final Item WILL_BREAKER = registerItem("will_breaker",
            new WillBreakerItem(ModToolMaterials.SOULSTONE, new Item.Settings().attributeModifiers(createAttributeModifiers(ModToolMaterials.SOULSTONE, 9, -2.4f))));


        // Helper Functions

        private static Item registerItem(String name, Item item) {
            return Registry.register(Registries.ITEM, Identifier.of(AnAbnormalCircumstance.MOD_ID, name), item);
        }

        public static void registerModItems() {
            AnAbnormalCircumstance.LOGGER.info("Registering Mod Items for " + AnAbnormalCircumstance.MOD_ID);

            ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
                entries.add(WOODEN_SPEAR);
                entries.add(STONE_SPEAR);
                entries.add(GOLDEN_SPEAR);
                entries.add(IRON_SPEAR);
                entries.add(DIAMOND_SPEAR);
                entries.add(NETHERITE_SPEAR);

                entries.add(WOODEN_RAPIER);
                entries.add(STONE_RAPIER);
                entries.add(GOLDEN_RAPIER);
                entries.add(IRON_RAPIER);
                entries.add(DIAMOND_RAPIER);
                entries.add(NETHERITE_RAPIER);

                entries.add(KATAR);

                entries.add(YELLOW_SOLIN_BLADE);
                entries.add(RED_SOLIN_BLADE);
                entries.add(DWARVEN_AXE);
                entries.add(WILL_BREAKER);
            });
        }
    }