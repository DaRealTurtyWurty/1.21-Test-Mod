package dev.turtywurty.testmod.init;

import dev.turtywurty.testmod.TestMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class BlockInit {
    public static final Block TEST_BLOCK = register("test_block", new Block(AbstractBlock.Settings.create()));

    public static <T extends Block> T register(String name, T block) {
        return Registry.register(Registries.BLOCK, TestMod.id(name), block);
    }

    public static void init() {
        // Just to run the static block
    }
}
