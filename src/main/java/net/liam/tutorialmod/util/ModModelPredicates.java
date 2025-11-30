package net.liam.tutorialmod.util;

import net.liam.tutorialmod.TutorialMod;
import net.liam.tutorialmod.component.ModDataComponentTypes;
import net.liam.tutorialmod.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class ModModelPredicates {
    public static void registerModelPredicates() {
        ModelPredicateProviderRegistry.register(ModItems.IRON_MAGNET, Identifier.of(TutorialMod.MOD_ID, "active"),
                (stack, world, entity, seed) ->
                        stack.get(ModDataComponentTypes.ACTIVE) != null && Boolean.TRUE.equals(stack.get(ModDataComponentTypes.ACTIVE)) ? 1f : 0f);
    }
}
