package net.liam.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.liam.tutorialmod.block.ModBlocks;
import net.liam.tutorialmod.item.ModItems;
import net.liam.tutorialmod.util.ModTags;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.MAGNETIC_ITEMS)
                .add(
                        ModItems.STEEL_INGOT,
                        ModItems.STEEL_NUGGET,
                        ModItems.RAW_STEEL,
                        ModItems.STEEL_POWDER,
                        ModItems.IRON_MAGNET,
                        ModBlocks.STEEL_BLOCK.asItem(),
                        ModBlocks.RAW_STEEL_BLOCK.asItem(),
                        ModBlocks.ELYTRA_LAUNCHER.asItem(),
                        Items.IRON_NUGGET,
                        Items.IRON_INGOT,
                        Items.IRON_SWORD,
                        Items.IRON_SHOVEL,
                        Items.IRON_PICKAXE,
                        Items.IRON_AXE,
                        Items.IRON_HOE,
                        Items.IRON_HELMET,
                        Items.IRON_CHESTPLATE,
                        Items.IRON_LEGGINGS,
                        Items.IRON_BOOTS,
                        Items.IRON_DOOR,
                        Items.IRON_TRAPDOOR,
                        Items.IRON_BARS,
                        Items.HEAVY_WEIGHTED_PRESSURE_PLATE,
                        Items.CHAINMAIL_HELMET,
                        Items.CHAINMAIL_CHESTPLATE,
                        Items.CHAINMAIL_LEGGINGS,
                        Items.CHAINMAIL_BOOTS,
                        Items.RAIL,
                        Items.POWERED_RAIL,
                        Items.DETECTOR_RAIL,
                        Items.ACTIVATOR_RAIL,
                        Items.MINECART,
                        Items.CHEST_MINECART,
                        Items.FURNACE_MINECART,
                        Items.TNT_MINECART,
                        Items.HOPPER_MINECART,
                        Items.IRON_HORSE_ARMOR,
                        Items.FLINT_AND_STEEL,
                        Items.SHEARS,
                        Items.ANVIL,
                        Items.CHIPPED_ANVIL,
                        Items.DAMAGED_ANVIL,
                        Items.IRON_BLOCK,
                        Items.CAULDRON,
                        Items.FLOWER_POT,
                        Items.BUCKET,
                        Items.WATER_BUCKET,
                        Items.LAVA_BUCKET,
                        Items.POWDER_SNOW_BUCKET,
                        Items.MILK_BUCKET,
                        Items.COMPASS,
                        Items.CLOCK,
                        Items.CROSSBOW,
                        Items.TRIPWIRE_HOOK,
                        Items.SHIELD,
                        Items.HEAVY_CORE,
                        Items.SALMON_BUCKET,
                        Items.COD_BUCKET,
                        Items.TROPICAL_FISH_BUCKET,
                        Items.TADPOLE_BUCKET,
                        Items.PUFFERFISH_BUCKET,
                        Items.AXOLOTL_BUCKET,
                        Items.RECOVERY_COMPASS,
                        Items.RAW_IRON,
                        Items.RAW_IRON_BLOCK
                );
    }
}
