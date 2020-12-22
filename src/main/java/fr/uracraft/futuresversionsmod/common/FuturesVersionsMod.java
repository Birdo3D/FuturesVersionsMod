package fr.uracraft.futuresversionsmod.common;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import fr.uracraft.futuresversionsmod.events.FuturesVersionsClientEvents;
import fr.uracraft.futuresversionsmod.events.FuturesVersionsEvents;
import fr.uracraft.futuresversionsmod.packets.AutoJumpPacket;
import fr.uracraft.futuresversionsmod.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = "futuresversionsmod", name = "FuturesVersionsMod", version = "1.0.0")

public class FuturesVersionsMod {
    @Instance("futuresversionsmod")
    public static FuturesVersionsMod instance;
    public static final String MODID = "futuresversionsmod";

    @SidedProxy(clientSide = "fr.uracraft.futuresversionsmod.proxy.ClientProxy", serverSide = "fr.uracraft.futuresversionsmod.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static CreativeTabs futuresversionsmodcreativetab = new FuturesVersionsModCreativeTab("futuresversionsmodcreativetab");
    public static SimpleNetworkWrapper fvmpackethandler;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.registerRender();
        if(event.getSide().isClient()){
            NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
        }
        FuturesVersionsBlocks.blocks(event);
        FuturesVersionsItems.items(event);
        fvmpackethandler = NetworkRegistry.INSTANCE.newSimpleChannel("AutoJump");
        fvmpackethandler.registerMessage(AutoJumpPacket.Handler.class, AutoJumpPacket.class, 0, Side.SERVER);
        fvmpackethandler.registerMessage(AutoJumpPacket.Handler.class, AutoJumpPacket.class, 1, Side.CLIENT);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new FuturesVersionsEvents());
        FMLCommonHandler.instance().bus().register(new FuturesVersionsEvents());
        if(event.getSide().isClient())
        {
            MinecraftForge.EVENT_BUS.register(new FuturesVersionsClientEvents());
            FMLCommonHandler.instance().bus().register(new FuturesVersionsClientEvents());
        }
        FuturesVersionsRecipes.recipes(event);
        NetworkRegistry.INSTANCE.registerGuiHandler("futuresversionsmod", new GuiHandler());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}