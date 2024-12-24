package com.example.ordnancemod.world;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class OrdnanceWorldGen implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        //generateOre(ExampleMod.blockCompactScrap,world,random,chunkX,chunkZ,8,64, 1, 64, 128, Blocks.air);
    }

    public void generateOre(Block block, World world, Random rand, int chunkX, int chunkZ, int minVeinSize, int maxVeinSize, float chance, int minY, int maxY, Block replace) {
        int veinSize = minVeinSize + rand.nextInt(maxVeinSize - minVeinSize);
        int heightRange = maxY - minY;
        WorldGenMinable gen = new WorldGenMinable(block, 24, replace);
        float roll = rand.nextFloat() * 100.0F;
        if (roll <= chance) {
            int xRand = chunkX * 16 + rand.nextInt(16);
            int yRand = rand.nextInt(heightRange) + minY;
            int zRand = chunkZ * 16 + rand.nextInt(16);
            gen.generate(world,rand,xRand,yRand,zRand);
        }
    }
}
