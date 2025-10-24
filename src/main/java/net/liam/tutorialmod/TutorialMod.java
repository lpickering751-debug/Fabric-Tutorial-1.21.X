package net.liam.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.liam.tutorialmod.block.ModBlocks;
import net.liam.tutorialmod.component.ModDataComponentTypes;
import net.liam.tutorialmod.item.ModItemGroups;
import net.liam.tutorialmod.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer{
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
	public void onInitialize() {
        ModItemGroups.registerItemGroups();

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModDataComponentTypes.registerDataComponentTypes();
	}
}