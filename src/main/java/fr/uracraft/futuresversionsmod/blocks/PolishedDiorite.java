package fr.uracraft.futuresversionsmod.blocks;

import fr.uracraft.futuresversionsmod.common.FuturesVersionsMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class PolishedDiorite extends Block {

    public PolishedDiorite() {
        super(Material.rock);
        this.setHardness(1.5F);
        this.setResistance(30F);
        this.setLightOpacity(255);
        this.setHarvestLevel("pickaxe", 0);
        this.useNeighborBrightness = true;
        this.setStepSound(soundTypeStone);
        this.setBlockTextureName("polished_diorite");
        this.setBlockName("polished_diorite");
        this.setCreativeTab(FuturesVersionsMod.futuresversionsmodcreativetab);
    }
}
