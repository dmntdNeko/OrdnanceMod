package com.example.ordnancemod.entities;


import com.example.ordnancemod.OrdnanceMod;
import com.example.ordnancemod.misc.CustomExplosion;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeChunkManager;

import java.util.Random;

public class EntityOrdnanceProjectile extends EntityProjectile {
    private ForgeChunkManager.Ticket chunkTicket;

    private int ticksExisted;
    private Random explosionRNG = new Random();
    private boolean doSmoke;

    public EntityOrdnanceProjectile(World world) {
        super(world);
    }

    public EntityOrdnanceProjectile(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    public EntityOrdnanceProjectile(World world, double x, double y, double z, boolean doSmoke) {
        this(world, x, y, z);
        this.doSmoke = doSmoke;
        System.out.println(this.doSmoke);
    }

    public EntityOrdnanceProjectile(World world, EntityLivingBase shooter, EntityLivingBase hitEntity, float velocity, float inaccuracy) {
        super(world, shooter, hitEntity, velocity, inaccuracy);
    }

    public EntityOrdnanceProjectile(World world, EntityLivingBase shooter, float projectileSpeed, float inaccuracy) {
        super(world, shooter, projectileSpeed, inaccuracy);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        this.ticksExisted++;

        //if (this.ticksExisted % 2 == 0) {
        if (this.worldObj.isRemote) {
            //ExampleMod.proxy.spawnParticle("explode", this.worldObj, this.posX,this.posY,this.posZ,-this.motionX/10,-this.motionY/10,-this.motionZ/10);
            int smokeTick = (int) Math.floor((Math.random() * 21) + 20);
            //if (this.ticksExisted <= 40){
            if (this.ticksExisted <= smokeTick) {
                float scale = 8F - (float) (this.ticksExisted * 0.2);
                double maxAge = (scale * 4F) + 1;
                for (int i = 0; i < 10; i++) {
                    //this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY - 0.3D, this.posZ, this.rand.nextGaussian() * 0.05D, this.rand.nextGaussian() * 0.05D, this.rand.nextGaussian() * 0.05D);
                    OrdnanceMod.proxy.spawnParticle("explodelong", this.worldObj, this.posX, this.posY, this.posZ, -this.motionX, -this.motionY, -this.motionZ, scale, maxAge);
                    OrdnanceMod.proxy.spawnParticle("explodelong", this.worldObj, this.posX, this.posY, this.posZ, -this.motionX / 2.5, -this.motionY / 2.5, -this.motionZ / 2.5, scale, maxAge);
                    OrdnanceMod.proxy.spawnParticle("flamebig", this.worldObj, this.posX, this.posY, this.posZ, -this.motionX, -this.motionY, -this.motionZ, scale / 2, maxAge);
                }
            }
            OrdnanceMod.proxy.spawnParticle("explodeshort", this.worldObj, this.posX, this.posY, this.posZ, 0, 0, 0);
        }
        //}

        if (this.getTicksInGround() == 2) {
            this.onImpact();
            this.setDead();
        }
    }

    public void onImpact() {
        CustomExplosion leafRemover = new CustomExplosion(worldObj, this, this.posX, this.posY, this.posZ, 3, false);
        this.worldObj.spawnParticle("explode", this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0);
        this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "examplemod:artillery_hit_smoke", 12.5f, 0.8f);
        this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "examplemod:artillery_hit_smoke", 5.0f, 1.0f);
        this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "examplemod:artillery_hit_smoke", 2.5f, 1.2f);
        this.smokeExplosion();
        leafRemover.newCustomExplosion(true);
        this.didFirstImpact = true;
    }

    @Override
    public void doImpactEffect() {
        this.onImpact();
    }

    public void smokeExplosion() {
        if (this.worldObj.isRemote) {
            double radius = 8;
            /*for (int i = 0; i < 200; ++i) {
                double partX = this.posX + Math.random() * (double) radius / 2.0 - (double) (radius / 4.0F);
                double partY = this.posY + Math.random() * (double) radius / 2.0 - (double) (radius / 4.0F);
                double partZ = this.posZ + Math.random() * (double) radius / 2.0 - (double) (radius / 4.0F);
                ExampleMod.proxy.spawnParticle("explode", this.worldObj, partX, partY, partZ, (Math.random() - 0.5) / 2.0, (Math.random() + 1) * 0.05, (Math.random() - 0.5) / 2.0);
            }*/
            for (int i = 0; i < 50; ++i) {
                //max age default = 3D;
                //radius /= 5;
                radius = 5;
                double partX = this.posX + Math.random() * (double) radius / 2.0 - (double) (radius / 4.0F);
                double partY = this.posY + Math.random() * (double) radius / 2.0 - (double) (radius / 4.0F);
                double partZ = this.posZ + Math.random() * (double) radius / 2.0 - (double) (radius / 4.0F);
                //ExampleMod.proxy.spawnParticle("explodelong", this.worldObj, partX, partY, partZ, (Math.random() - 0.5) / 2.0, (Math.random() + 1) * 0.025, (Math.random() - 0.5) / 2.0);
                OrdnanceMod.proxy.spawnParticle("explodelong", this.worldObj, partX, partY, partZ, (Math.random() - 0.5), (Math.random() + 1) * 0.25, (Math.random() - 0.5), 5, 30D);
                OrdnanceMod.proxy.spawnParticle("flamebig", this.worldObj, partX, partY, partZ, 0, 0, 0, 10, 3D);
            }
            for (int i = 0; i < 30; ++i) {
                //max age default = 5D;
                //radius /= 10;
                radius = 10;
                double partX = this.posX + Math.random() * (double) radius / 2.0 - (double) (radius / 4.0F);
                double partY = this.posY + Math.random() * (double) radius / 2.0 - (double) (radius / 4.0F);
                double partZ = this.posZ + Math.random() * (double) radius / 2.0 - (double) (radius / 4.0F);
                //ExampleMod.proxy.spawnParticle("explodelong", this.worldObj, partX, partY, partZ, (Math.random() - 0.5) / 2.0, (Math.random() + 1) * 0.050, (Math.random() - 0.5) / 2.0);
                OrdnanceMod.proxy.spawnParticle("explodelong", this.worldObj, partX, partY, partZ, (Math.random() - 0.5) / 2, (Math.random() + 1) * 0.5, (Math.random() - 0.5) / 2, 5, 20D);
                OrdnanceMod.proxy.spawnParticle("flamebig", this.worldObj, partX, partY, partZ, (Math.random() - 0.5) / 2, (Math.random() + 1) * 0.125, (Math.random() - 0.5) / 2, 3, 5D);
                //ExampleMod.proxy.spawnParticle("flaksmokelarge", this.worldObj, partX, partY, partZ, (Math.random() - 0.5), (Math.random() + 1) *0.25, (Math.random() - 0.5));
            }
        }
    }

    @Override
    public void spawnBullet() {

    }

    @Override
    public String getHitSound() {
        return "examplemod:HMGImpact";
    }
}



