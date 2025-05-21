package net.abnormal.anabnormalcircumstance;

import net.fabricmc.api.ModInitializer;
import net.abnormal.anabnormalcircumstance.item.ModItems;
import net.abnormal.anabnormalcircumstance.event.ModAttackEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AnAbnormalCircumstance implements ModInitializer {
	public static final String MOD_ID = "anabnormalcircumstance";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModAttackEvent.register();
	}
}