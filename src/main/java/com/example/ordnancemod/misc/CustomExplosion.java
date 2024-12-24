package com.example.ordnancemod.misc;

import com.example.ordnancemod.OrdnanceMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.Random;

public class CustomExplosion extends Explosion {
    public World world;
    public boolean isSmoking;
    public boolean isFlaming;
    public double posX;
    public double posY;
    public double posZ;
    public double randX,randY,randZ;
    public double nX,nY,nZ;
    public Entity exploder;
    public boolean doBlockDamage;
    public boolean playSound;
    private Random explosionRNG = new Random();
    private Random rand = new Random();

    public CustomExplosion(World world, Entity exploder, double posX, double posY, double posZ, float size, boolean playSound) {
        super(world, exploder, posX, posY, posZ, size);
        this.world = world;
        this.exploder = exploder;
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
        this.explosionSize = size;
        this.playSound = playSound;
    }

    @Override
    public void doExplosionA() {
        super.doExplosionA();

        for (int i = 0; i < 20; i++) {
            if (!this.world.isRemote) {
                this.nX = this.posX + (this.explosionRNG.nextDouble() - 0.5) * this.explosionSize * 2.0;
                this.nY= this.posY + (this.explosionRNG.nextDouble() - 0.5) * this.explosionSize * 2.0;
                this.nZ = this.posZ + (this.explosionRNG.nextDouble() - 0.5) * this.explosionSize * 2.0;
                this.randX = (this.explosionRNG.nextDouble() - 0.5) * 2.0;
                this.randY = (this.explosionRNG.nextDouble() - 0.5) * 2.0;
                this.randZ = (this.explosionRNG.nextDouble() - 0.5) * 2.0;
                //System.out.println("should set particles");
            } else {
                this.world.spawnParticle("smoke", this.nX,this.nY,this.nZ, this.randX,this.randY,this.randZ);
                //System.out.println("should spawn particles");
            }
        }
    }

    @Override
    public void doExplosionB(boolean spawnParticles)
    {
        if (this.playSound) {
            this.world.playSoundEffect(posX,posY,posZ,"random.explode",4.0F,1.0F);
        }
        if (this.explosionSize >= 2.0F && this.isSmoking)
        {
            this.world.spawnParticle("hugeexplosion", this.explosionX, this.explosionY, this.explosionZ, 1.0D, 0.0D, 0.0D);
        }
        else
        {
            this.world.spawnParticle("largeexplode", this.explosionX, this.explosionY, this.explosionZ, 1.0D, 0.0D, 0.0D);
        }

        Iterator iterator;
        ChunkPosition chunkposition;
        int i;
        int j;
        int k;
        Block block;

        if (this.isSmoking)
        {
            iterator = this.affectedBlockPositions.iterator();

            while (iterator.hasNext())
            {
                chunkposition = (ChunkPosition)iterator.next();
                i = chunkposition.chunkPosX;
                j = chunkposition.chunkPosY;
                k = chunkposition.chunkPosZ;
                block = this.world.getBlock(i, j, k);

                if (spawnParticles)
                {
                    double d0 = (double) ((float) i + this.world.rand.nextFloat());
                    double d1 = (double) ((float) j + this.world.rand.nextFloat());
                    double d2 = (double) ((float) k + this.world.rand.nextFloat());
                    double d3 = d0 - this.explosionX;
                    double d4 = d1 - this.explosionY;
                    double d5 = d2 - this.explosionZ;
                    double d6 = (double) MathHelper.sqrt_double(d3 * d3 + d4 * d4 + d5 * d5);
                    d3 /= d6;
                    d4 /= d6;
                    d5 /= d6;
                    double d7 = 0.5D / (d6 / (double) this.explosionSize + 0.1D);
                    d7 *= (double) (this.world.rand.nextFloat() * this.world.rand.nextFloat() + 0.3F);
                    d3 *= d7;
                    d4 *= d7;
                    d5 *= d7;

                    if (this.world.isRemote) {
                        this.world.spawnParticle("explode", (d0 + this.explosionX * 1.0D) / 2.0D, (d1 + this.explosionY * 1.0D) / 2.0D, (d2 + this.explosionZ * 1.0D) / 2.0D, d3, d4, d5);
                        this.world.spawnParticle("smoke", d0, d1, d2, d3, d4, d5);
                        OrdnanceMod.proxy.spawnParticle("hugeexplosion", this.world, this.posX, this.posY, this.posZ, this.explosionRNG.nextFloat() + 1, 1.0, this.explosionRNG.nextFloat() + 1);
                        OrdnanceMod.proxy.spawnParticle("largeexplode", this.world, this.posX, this.posY, this.posZ, this.explosionRNG.nextFloat() + 1, 1.0, this.explosionRNG.nextFloat() + 1);
                    }
                }

                if (this.doBlockDamage) {
                    Material material = block.getMaterial();
                    if (material != Material.air) {
                        if (material == Material.leaves || material == Material.vine || material == Material.plants) {
                            if (block.canDropFromExplosion(this)) {
                                block.dropBlockAsItemWithChance(this.world, i, j, k, this.world.getBlockMetadata(i, j, k), 1.0F / this.explosionSize, 0);
                            }

                            block.onBlockExploded(this.world, i, j, k, this);
                        } else if (material == Material.grass) {
                            if (rand.nextFloat() <= 0.25F) {
                                world.setBlock(i,j,k,Blocks.dirt);
                            }
                        } else if (material == Material.glass) {
                            if (rand.nextFloat() <= 0.25F) {
                                block.onBlockExploded(world, i, j, k, this);
                            }
                        }
                    }
                }
            }
        }

        if (this.isFlaming)
        {
            iterator = this.affectedBlockPositions.iterator();

            while (iterator.hasNext())
            {
                chunkposition = (ChunkPosition)iterator.next();
                i = chunkposition.chunkPosX;
                j = chunkposition.chunkPosY;
                k = chunkposition.chunkPosZ;
                block = this.world.getBlock(i, j, k);
                Block block1 = this.world.getBlock(i, j - 1, k);

                if (block.getMaterial() == Material.air && block1.func_149730_j() && this.explosionRNG.nextInt(3) == 0)
                {
                    this.world.setBlock(i, j, k, Blocks.fire);
                }
            }
        }
    }

    public void newCustomExplosion(boolean doBlockDamage){
        CustomExplosion qEx = new CustomExplosion(world, exploder, posX, posY, posZ, explosionSize, playSound);
        qEx.isFlaming = false;
        qEx.isSmoking = true;
        qEx.doBlockDamage = doBlockDamage;
        qEx.doExplosionA();
        qEx.doExplosionB(true);
        qEx.playSound = playSound;
    }
}
