package fr.uracraft.futuresversionsmod.common;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int id, EntityPlayer entityPlayer, World world, int x, int y, int z) {

        TileEntity tile = world.getTileEntity(x, y, z);

        /*if(tile instanceof TileEntityShulkerBox) {
            return new ContainerShulkerBox((TileEntityShulkerBox) tile, entityPlayer.inventory);
        }*/
        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer entityPlayer, World world, int x, int y, int z) {

        TileEntity tile = world.getTileEntity(x, y, z);

        /*if(tile instanceof TileEntityShulkerBox) {
            return new GuiShulkerBox((TileEntityShulkerBox) tile, entityPlayer.inventory);
        }*/
        return null;
    }
}