package net.liam.tutorialmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.liam.tutorialmod.TutorialMod;
import net.liam.tutorialmod.block.custom.ElytraLauncherBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block STEEL_BLOCK = registerBlock("steel_block",
            new Block(AbstractBlock.Settings.create().strength(5.0F, 6.0F)
                    .requiresTool().sounds(BlockSoundGroup.METAL)));

    public static final Block RAW_STEEL_BLOCK = registerBlock("raw_steel_block",
            new Block(AbstractBlock.Settings.create().strength(5.0F, 6.0F)
                    .requiresTool()));

    public static final Block STEEL_ORE = registerBlock("steel_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 5),
                    AbstractBlock.Settings.create().strength(3.0F, 3.0F)
                    .requiresTool()));

    public static final Block DEEPSLATE_STEEL_ORE = registerBlock("deepslate_steel_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(7, 9),
                    AbstractBlock.Settings.create().strength(4.5F, 3.0F)
                    .requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block ELYTRA_LAUNCHER = registerBlock("elytra_launcher",
            new ElytraLauncherBlock(AbstractBlock.Settings.create().strength(3.0f)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        TutorialMod.LOGGER.info("Registering Mod Blocks for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.addAfter(Items.NETHERITE_BLOCK, ModBlocks.STEEL_BLOCK);
                });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.addAfter(Items.END_CRYSTAL, ModBlocks.ELYTRA_LAUNCHER);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.addAfter(Items.DEEPSLATE_DIAMOND_ORE, ModBlocks.STEEL_ORE);
            entries.addAfter(ModBlocks.STEEL_ORE, ModBlocks.DEEPSLATE_STEEL_ORE);
            entries.addAfter(Items.RAW_GOLD_BLOCK, ModBlocks.RAW_STEEL_BLOCK);
                });
    }
}