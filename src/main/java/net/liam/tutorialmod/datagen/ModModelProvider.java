package net.liam.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.liam.tutorialmod.block.ModBlocks;
import net.liam.tutorialmod.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STEEL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_STEEL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STEEL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_STEEL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ELYTRA_LAUNCHER);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.STEEL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEEL_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_STEEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEEL_POWDER, Models.GENERATED);
        itemModelGenerator.register(ModItems.ASH, Models.GENERATED);
        itemModelGenerator.register(ModItems.PROTEIN_BAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_MAGNET, Models.GENERATED);

    }
}
