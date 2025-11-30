package net.liam.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.liam.tutorialmod.TutorialMod;
import net.liam.tutorialmod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup STEEL_INGREDIENTS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "steel_ingredients"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.STEEL_INGOT))
                    .displayName(Text.translatable("itemgroup.tutorialmod.steel_ingredients"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.STEEL_INGOT);
                        entries.add(ModItems.RAW_STEEL);
                        entries.add(ModItems.STEEL_NUGGET);
                        entries.add(ModItems.STEEL_POWDER);

                    }).build());

    public static final ItemGroup STEEL_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "steel_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.STEEL_BLOCK))
                    .displayName(Text.translatable("itemgroup.tutorialmod.steel_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.STEEL_BLOCK);
                        entries.add(ModBlocks.RAW_STEEL_BLOCK);
                        entries.add(ModBlocks.STEEL_ORE);
                        entries.add(ModBlocks.DEEPSLATE_STEEL_ORE);

                    }).build());

    public static final ItemGroup MISC_MOD_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "misc"),
            FabricItemGroup.builder().icon(() -> new ItemStack(Items.NAME_TAG))
                    .displayName(Text.translatable("itemgroup.tutorialmod.misc"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.IRON_MAGNET);
                        entries.add(ModBlocks.ELYTRA_LAUNCHER);
                        entries.add(ModItems.PROTEIN_BAR);
                        entries.add(ModItems.ASH);
                    }).build());

    public static void registerItemGroups() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);

    }
}
