package net.liam.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.liam.tutorialmod.TutorialMod;
import net.liam.tutorialmod.item.custom.MagnetItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item STEEL_INGOT = registerItem("steel_ingot", new Item(new Item.Settings()));
    public static final Item RAW_STEEL = registerItem("raw_steel", new Item(new Item.Settings()));
    public static final Item STEEL_NUGGET = registerItem("steel_nugget", new Item(new Item.Settings()));
    public static final Item STEEL_POWDER = registerItem("steel_powder", new Item(new Item.Settings()));

    public static final Item MAGNET = registerItem("magnet", new MagnetItem(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.addAfter(Items.IRON_INGOT, STEEL_INGOT);
            entries.addAfter(Items.RAW_IRON, RAW_STEEL);
            entries.addAfter(Items.IRON_NUGGET, STEEL_NUGGET);
            entries.addAfter(Items.GUNPOWDER, STEEL_POWDER);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.addAfter(Items.NETHERITE_PICKAXE, MAGNET);
        });
    }
}