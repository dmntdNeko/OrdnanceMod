package com.example.ordnancemod.blocks;


import com.example.ordnancemod.OrdnanceMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

public class BlockLoosenedScrap extends BlockFalling {
    public BlockLoosenedScrap(Material material) {
        super(material);
        this.setStepSound(Block.soundTypeGravel);
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
        Random rand = new Random();

        int numScrap = rand.nextInt(4) + 2;
        for (int i = 0; i < numScrap; i++) {
            drops.add(new ItemStack(OrdnanceMod.itemScrap, 1, 0));
        }
        return drops;
    }

    @Override
    public float getBlockHardness(World world, int x, int y, int z) {
        return 0.6F;
    }

    @Override
    public int getHarvestLevel(int metadata) {
        return 2;
    }

    @Override
    public String getHarvestTool(int metadata) {
        return "shovel";
    }

}
