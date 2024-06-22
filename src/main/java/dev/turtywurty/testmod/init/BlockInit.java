package dev.turtywurty.testmod.init;

import dev.turtywurty.testmod.TestMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class BlockInit {
    public static final Block TEST_BLOCK = registerWithItem("test_block", new Block(AbstractBlock.Settings.create()
            .strength(1.5F, 6.0F)
            .requiresTool() // This is necessary to make the block drop when broken with the right tool
    ));

    public static <T extends Block> T register(String name, T block) {
        return Registry.register(Registries.BLOCK, TestMod.id(name), block);
    }

    public static <T extends Block> T registerWithItem(String name, T block, Item.Settings settings) {
        T registered = register(name, block); // Register the block first (important for the item to work properly)
        ItemInit.register(name, new BlockItem(registered, settings));
        return registered;
    }

    public static <T extends Block> T registerWithItem(String name, T block) {
        return registerWithItem(name, block, new Item.Settings());
    }

    public static void init() {
        // Just to run the static block
    }
}
