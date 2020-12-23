package fr.uracraft.futuresversionsmod.common;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class FuturesVersionsWorldGenerator implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        generateOverworld(world, chunkX * 16, chunkZ * 16, random);
        //break;
    }


    private void addOre(Block block, Block blockSpawn, Random random, World world, int posX, int posZ, int minY, int maxY, int minV, int maxV, int spawnChance)
    {
        for(int i = 0; i < spawnChance; i++)
        {
            int chunkSize = 16;
            int Xpos = posX + random.nextInt(chunkSize);
            int Ypos = minY + random.nextInt(maxY - minY);
            int Zpos = posZ + random.nextInt(chunkSize);

            new WorldGenMinable(block, maxV, blockSpawn).generate(world, random, Xpos, Ypos, Zpos);
        }
    }

    private void generateOverworld(World world, int i, int j, Random random)
    {
        addOre(FuturesVersionsBlocks.andesite, Blocks.stone, random, world, i, j, 0, 79, 1, 33, 10);
        addOre(FuturesVersionsBlocks.diorite, Blocks.stone, random, world, i, j, 0, 79, 1, 33, 10);
        addOre(FuturesVersionsBlocks.granite, Blocks.stone, random, world, i, j, 0, 79, 1, 33, 10);
    }

}