package net.liam.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.liam.tutorialmod.block.ModBlocks;
import net.liam.tutorialmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {

        addDrop(ModBlocks.ELYTRA_LAUNCHER);

        addDrop(ModBlocks.STEEL_ORE, ModItems.RAW_STEEL);
        addDrop(ModBlocks.STEEL_ORE, multipleOreDrops(ModBlocks.STEEL_ORE, ModItems.STEEL_NUGGET, 1, 5));

        addDrop(ModBlocks.DEEPSLATE_STEEL_ORE, ModItems.RAW_STEEL);
        addDrop(ModBlocks.DEEPSLATE_STEEL_ORE, multipleOreDrops(ModBlocks.STEEL_ORE, ModItems.STEEL_NUGGET, 1, 5));

        addDrop(ModBlocks.STEEL_BLOCK, materialDrops(ModBlocks.STEEL_BLOCK.asItem(), ModItems.STEEL_INGOT, 3, 6));
        addDrop(ModBlocks.RAW_STEEL_BLOCK, materialDrops(ModBlocks.RAW_STEEL_BLOCK.asItem(), ModItems.RAW_STEEL, 5, 7));
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop,((LeafEntry.Builder<?>)
                        ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                        .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }

    public LootTable.Builder materialDrops(Item BlockItem, Item material, float min, float max) {
        return LootTable.builder()
                .pool(LootPool.builder()
                        .with(ItemEntry.builder(material)
                                .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create()
                                        .items(Items.STONE_PICKAXE)))
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min, max))))

                        .with(ItemEntry.builder(BlockItem)
                                .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create()
                                        .items(Items.IRON_PICKAXE, Items.DIAMOND_PICKAXE, Items.NETHERITE_PICKAXE)))));
    }
}
