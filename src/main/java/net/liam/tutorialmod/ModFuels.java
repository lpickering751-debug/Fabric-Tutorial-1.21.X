package net.liam.tutorialmod;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.liam.tutorialmod.item.ModItems;

public class ModFuels {

    public static void registerModFuels() {

        FuelRegistry.INSTANCE.add(ModItems.ASH, 2000);

    }


}
