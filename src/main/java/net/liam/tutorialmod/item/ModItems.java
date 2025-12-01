package net.liam.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.liam.tutorialmod.TutorialMod;
import net.liam.tutorialmod.item.custom.MagnetItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
    public static final Item STEEL_INGOT = registerItem("steel_ingot", new Item(new Item.Settings()));
    public static final Item RAW_STEEL = registerItem("raw_steel", new Item(new Item.Settings()));
    public static final Item STEEL_NUGGET = registerItem("steel_nugget", new Item(new Item.Settings()));
    public static final Item STEEL_POWDER = registerItem("steel_powder", new Item(new Item.Settings()));
    public static final Item ASH = registerItem("ash", new Item(new Item.Settings()));

    public static final Item IRON_MAGNET = registerItem("iron_magnet", new MagnetItem(new Item.Settings().maxDamage(128)));

    public static final Item PROTEIN_BAR = registerItem("protein_bar", new Item(new Item.Settings().food(ModFoodComponents.PROTEIN_BAR)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.tutorialmod.eat_me"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

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
            entries.addAfter(ModItems.STEEL_POWDER, ModItems.ASH);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.addAfter(Items.SPYGLASS, IRON_MAGNET);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.addAfter(Items.GOLDEN_CARROT,ModItems.PROTEIN_BAR);
        });
    }
}