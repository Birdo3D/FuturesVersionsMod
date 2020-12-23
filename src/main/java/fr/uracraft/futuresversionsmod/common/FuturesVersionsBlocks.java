package fr.uracraft.futuresversionsmod.common;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.uracraft.futuresversionsmod.blocks.*;
import net.minecraft.block.Block;

public class FuturesVersionsBlocks {

    public static Block grass_path;
    public static Block andesite;
    public static Block diorite;
    public static Block granite;
    public static Block polished_andesite;
    public static Block polished_diorite;
    public static Block polished_granite;

    public static void blocks(FMLPreInitializationEvent event){
        grass_path= new GrassPath();
        andesite= new Andesite();
        diorite= new Diorite();
        granite= new Granite();
        polished_andesite= new PolishedAndesite();
        polished_diorite= new PolishedDiorite();
        polished_granite= new PolishedGranite();

        GameRegistry.registerBlock(grass_path,"grass_path");
        GameRegistry.registerBlock(andesite,"andesite");
        GameRegistry.registerBlock(diorite,"diorite");
        GameRegistry.registerBlock(granite,"granite");
        GameRegistry.registerBlock(polished_andesite,"polished_andesite");
        GameRegistry.registerBlock(polished_diorite,"polished_diorite");
        GameRegistry.registerBlock(polished_granite,"polished_granite");
    }
}
