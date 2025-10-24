package net.liam.tutorialmod;

import net.fabricmc.api.ClientModInitializer;
import net.liam.tutorialmod.util.ModModelPredicates;

public class TutorialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        ModModelPredicates.registerModelPredicates();
    }
}