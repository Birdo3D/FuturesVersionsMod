package fr.uracraft.futuresversionsmod.common;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class FuturesVersionsModCreativeTab extends CreativeTabs {

    public FuturesVersionsModCreativeTab(String label) {
        super(label);
    }

    @Override
    public Item getTabIconItem() {
        return Item.getItemFromBlock(FuturesVersionsBlocks.grass_path);
    }

    @SideOnly(Side.CLIENT)
    public int func_151243_f() {
        return 0;
    }
}

