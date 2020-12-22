package fr.uracraft.futuresversionsmod.common;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class FuturesVersionsRecipes {

    public static void recipes(FMLInitializationEvent event) {
        //GameRegistry.addShapelessRecipe(new ItemStack(Items.experience_bottle), new Object[]{ new ItemStack(Items.glass_bottle ), new ItemStack(xp_berry )});

        //Ender Crystal
        GameRegistry.addRecipe(new ItemStack(FuturesVersionsItems.ender_crystal), new Object[]{"GGG", "GEG", "GTG", 'G', Blocks.glass, 'E', Items.ender_eye, 'T', Items.ghast_tear});
    }
}
