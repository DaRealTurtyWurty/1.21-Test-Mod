package dev.turtywurty.testmod.list;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class FoodList {
    public static final FoodComponent TEST_FOOD_SETTINGS = new FoodComponent.Builder()
            .nutrition(4)
            .saturationModifier(0.3F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 20 * 30, 1), 0.3F)
            .build();
}
