package dev.turtywurty.testmod.init;

import dev.turtywurty.testmod.TestMod;
import dev.turtywurty.testmod.list.FoodList;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ItemInit {
    public static final Item TEST_ITEM = register("test_item", new Item(new Item.Settings()));
    public static final Item TEST_FOOD = register("test_food",
            new Item(new Item.Settings().food(FoodList.TEST_FOOD_SETTINGS)));

    public static <T extends Item> T register(String name, T item) {
        return Registry.register(Registries.ITEM, TestMod.id(name), item);
    }

    public static void init() {
        // This method is used to load the class and therefore the static fields.
    }
}
