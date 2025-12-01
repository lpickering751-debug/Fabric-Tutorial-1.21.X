package net.liam.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.liam.tutorialmod.block.ModBlocks;
import net.liam.tutorialmod.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    private RecipeExporter exporter;

    @Override
    public void generate(RecipeExporter exporter) {
        this.exporter = exporter;

        List<ItemConvertible> STEEL_INGOT_SMELTABLES = List.of(ModItems.RAW_STEEL, ModBlocks.STEEL_ORE, ModBlocks.DEEPSLATE_STEEL_ORE);

        smelt(STEEL_INGOT_SMELTABLES, ModItems.STEEL_INGOT, 0.7f);
        blast(STEEL_INGOT_SMELTABLES, ModItems.STEEL_INGOT, 0.7f);

        smelt(List.of(Blocks.RAW_COPPER_BLOCK), Blocks.COPPER_BLOCK.asItem(), 1.0f);
        smelt(List.of(Blocks.RAW_IRON_BLOCK), Blocks.IRON_BLOCK.asItem(), 1.0f);
        smelt(List.of(Blocks.RAW_GOLD_BLOCK), Blocks.GOLD_BLOCK.asItem(), 1.0f);
        smelt(List.of(ModBlocks.RAW_STEEL_BLOCK), ModBlocks.STEEL_BLOCK.asItem(), 1.0f);

        blast(List.of(Blocks.RAW_COPPER_BLOCK), Blocks.COPPER_BLOCK.asItem(), 1.0f);
        blast(List.of(Blocks.RAW_IRON_BLOCK), Blocks.IRON_BLOCK.asItem(), 1.0f);
        blast(List.of(Blocks.RAW_GOLD_BLOCK), Blocks.GOLD_BLOCK.asItem(), 1.0f);
        blast(List.of(ModBlocks.RAW_STEEL_BLOCK), ModBlocks.STEEL_BLOCK.asItem(), 1.0f);


        offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.STEEL_INGOT,
                RecipeCategory.DECORATIONS, ModBlocks.STEEL_BLOCK, "steel_ingot_from_steel_block", "steel_ingot");

        offerReversibleCompactingRecipesWithCompactingRecipeGroup(exporter, RecipeCategory.MISC, ModItems.STEEL_NUGGET,
                RecipeCategory.MISC, ModItems.STEEL_INGOT, "steel_ingot_from_nuggets", "steel_ingot");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_STEEL,
                RecipeCategory.DECORATIONS, ModBlocks.RAW_STEEL_BLOCK);



        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ELYTRA_LAUNCHER)
                .pattern("SSS")
                .pattern("RMR")
                .pattern("SSS")
                .input('S', ModItems.STEEL_INGOT)
                .input('R', Items.REDSTONE)
                .input('M', ModItems.IRON_MAGNET)
                .criterion(hasItem(ModItems.STEEL_INGOT), conditionsFromItem(ModItems.STEEL_INGOT))
                .offerTo(exporter);


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.IRON_MAGNET)
                .pattern("LSN")
                .pattern(" IS")
                .pattern("RSN")
                .input('L', Items.LAPIS_LAZULI)
                .input('R', Items.REDSTONE)
                .input('S', ModItems.STEEL_INGOT)
                .input('N',ModItems.STEEL_NUGGET)
                .input('I',Items.IRON_INGOT)
                .criterion(hasItem(ModItems.STEEL_INGOT), conditionsFromItem(ModItems.STEEL_INGOT))
                .offerTo(exporter);


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PROTEIN_BAR, 5)
                .pattern("WCS")
                .pattern("PHA")
                .pattern("ECH")
                .input('W', Items.HONEY_BOTTLE)
                .input('C', Items.COCOA_BEANS)
                .input('S', Items.SUGAR)
                .input('P', Items.PUMPKIN_SEEDS)
                .input('H', Items.HONEY_BOTTLE)
                .input('A', Items.APPLE)
                .input('E', Items.EGG)
                .criterion(hasItem(Items.HONEY_BOTTLE), conditionsFromItem(Items.HONEY_BOTTLE))
                .offerTo(exporter);

    }


    private void smelt(List<ItemConvertible> input, Item output, float xp) {
        FabricRecipeProvider.offerSmelting(exporter,
                input,
                RecipeCategory.MISC,
                output,
                xp, 200,
                getRecipeName(output));
    }


    private void blast(List<ItemConvertible> input, Item output, float xp) {
        FabricRecipeProvider.offerBlasting(exporter,
                input,
                RecipeCategory.MISC,
                output,
                xp, 100,
                getRecipeName(output));
    }
}