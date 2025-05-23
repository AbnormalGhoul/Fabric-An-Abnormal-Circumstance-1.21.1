    package net.abnormal.anabnormalcircumstance.item;

    import net.abnormal.anabnormalcircumstance.AnAbnormalCircumstance;
    import net.abnormal.anabnormalcircumstance.item.custom.DwarvenAxeItem;
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

        // Items
        public static final Item KATAR = registerItem("katar", new Item(new Item.Settings().maxCount(1)));
        public static final Item COPPER_COIN = registerItem("copper_coin", new Item(new Item.Settings()));
        public static final Item SILVER_COIN = registerItem("silver_coin", new Item(new Item.Settings()));
        public static final Item GOLD_COIN = registerItem("gold_coin", new Item(new Item.Settings()));
        public static final Item PLATINUM_COIN = registerItem("platinum_coin", new Item(new Item.Settings()));

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
        }
    }