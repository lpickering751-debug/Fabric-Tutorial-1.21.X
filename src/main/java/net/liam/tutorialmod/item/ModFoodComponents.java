package net.liam.tutorialmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent PROTEIN_BAR = new FoodComponent.Builder()
            .nutrition(7)
            .saturationModifier(1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 6000), 1.0f)
            .alwaysEdible()
            .build();

}