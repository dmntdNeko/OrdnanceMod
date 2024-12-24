package com.example.ordnancemod.blocks;

import com.example.ordnancemod.OrdnanceMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

public class BlockCompactScrap extends Block {

    public BlockCompactScrap(Material material) {
        super(material);
    }

    @Override
    public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion explosion) {
        world.setBlock(x, y, z, OrdnanceMod.blockLoosenedScrap);
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
        return 20.0F;
    }

    @Override
    public float getExplosionResistance(Entity entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ) {
        return 5.0F;
    }

    @Override
    public int getHarvestLevel(int metadata) {
        return 3;
    }

    @Override
    public String getHarvestTool(int metadata) {
        return "pickaxe";
    }

    @Override
    public boolean canDropFromExplosion(Explosion explosion) {
        return false;
    }
}
