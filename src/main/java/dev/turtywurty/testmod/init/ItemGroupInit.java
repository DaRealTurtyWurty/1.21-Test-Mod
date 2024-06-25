package dev.turtywurty.testmod.init;

import dev.turtywurty.testmod.TestMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

import java.util.Optional;

public class ItemGroupInit {
    private static final Text TEST_TITLE = Text.translatable("itemGroup." + TestMod.MOD_ID + ".test_group");

    public static final ItemGroup TEST_GROUP = register("test_group", FabricItemGroup.builder()
            .displayName(TEST_TITLE)
            .entries((displayContext, entries) -> Registries.ITEM.getIds()
                    .stream()
                    .filter(key -> key.getNamespace().equals(TestMod.MOD_ID))
                    .map(Registries.ITEM::getOrEmpty)
                    .map(Optional::orElseThrow)
                    .forEach(entries::add))
            .icon(ItemInit.TEST_ITEM::getDefaultStack)
            .build());

    public static <T extends ItemGroup> T register(String name, T creativeTab) {
        return Registry.register(Registries.ITEM_GROUP, TestMod.id(name), creativeTab);
    }

    public static void load() {
    }
}
