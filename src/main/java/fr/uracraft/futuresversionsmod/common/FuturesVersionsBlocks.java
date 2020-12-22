package fr.uracraft.futuresversionsmod.common;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.uracraft.futuresversionsmod.blocks.GrassPath;
import net.minecraft.block.Block;

public class FuturesVersionsBlocks {

    public static Block grass_path;

    public static void blocks(FMLPreInitializationEvent event){
        grass_path= new GrassPath();

        GameRegistry.registerBlock(grass_path,"grass_path");
    }
}
