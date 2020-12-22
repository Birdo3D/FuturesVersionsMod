package fr.uracraft.futuresversionsmod.common;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.uracraft.futuresversionsmod.items.EnderCrystal;
import net.minecraft.item.Item;

public class FuturesVersionsItems {

    public static Item ender_crystal;

    public static void items(FMLPreInitializationEvent event){
        ender_crystal= new EnderCrystal();

        GameRegistry.registerItem(ender_crystal,"ender_crystal");
    }
}
