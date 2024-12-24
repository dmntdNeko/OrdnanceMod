package com.example.ordnancemod.entities;


import com.example.ordnancemod.OrdnanceMod;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class EntityFlakProjectile extends EntityProjectile {

    private int ticksExisted;
    private int maxLife = 20;

    public EntityFlakProjectile(World world) {
        super(world);
        this.setGravity(0.0D);
    }

    public EntityFlakProjectile(World world, double x, double y, double z) {
        super(world, x, y, z);
        this.setGravity(0.0D);
    }

    public EntityFlakProjectile(World world, EntityLivingBase shooter, EntityLivingBase hitEntity, float velocity, float inaccuracy) {
        super(world, shooter, hitEntity, velocity, inaccuracy);
        this.setGravity(0.0D);
    }

    public EntityFlakProjectile(World world, EntityLivingBase shooter, float projectileSpeed, float inaccuracy) {
        super(world, shooter, projectileSpeed, inaccuracy);
        this.setGravity(0.0D);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        this.ticksExisted++;

        if (this.ticksExisted % 2 == 0) {
            if (this.worldObj.isRemote) {
                OrdnanceMod.proxy.spawnParticle("crit", this.worldObj, this.posX,this.posY,this.posZ,-this.motionX/20,-this.motionY/20,-this.motionZ/20);
            }
        }

        if (this.ticksExisted >= this.maxLife || this.getInGround()) {
            this.smokeExplosion();
        }

        if (this.ticksExisted > this.maxLife + 2 || this.getTicksInGround() > 2) {
            this.setDead();
        }
    }

    public void smokeExplosion(){
        if (this.worldObj.isRemote){
            //double radius = 8;
            double radius = 4;
            for (int i = 0; i < 25; ++i) {
                double tempRadius = radius/5;
                double partX = this.posX + Math.random() * (double) tempRadius / 2.0 - (double) (tempRadius / 4.0F);
                double partY = this.posY + Math.random() * (double) tempRadius / 2.0 - (double) (tempRadius / 4.0F);
                double partZ = this.posZ + Math.random() * (double) tempRadius / 2.0 - (double) (tempRadius / 4.0F);
                OrdnanceMod.proxy.spawnParticle("flaksmokesmall", this.worldObj, partX, partY, partZ, (Math.random() - 0.5) / 3.0, (Math.random() - 0.5) / 3.0, (Math.random() - 0.5) / 3.0);
                //ExampleMod.proxy.spawnParticle("flaksmokesmall", this.worldObj, partX, partY, partZ, (Math.random() - 0.5), (Math.random() - 0.5), (Math.random() - 0.5));
            }
            for (int i = 0; i < 15; ++i) {
                double tempRadius = radius/10;
                double partX = this.posX + Math.random() * (double) tempRadius / 2.0 - (double) (tempRadius / 4.0F);
                double partY = this.posY + Math.random() * (double) tempRadius / 2.0 - (double) (tempRadius / 4.0F);
                double partZ = this.posZ + Math.random() * (double) tempRadius / 2.0 - (double) (tempRadius / 4.0F);
                OrdnanceMod.proxy.spawnParticle("flaksmokesmall", this.worldObj, partX, partY, partZ, (Math.random() - 0.5) / 3.0, (Math.random() - 0.5) / 3.0, (Math.random() - 0.5) / 3.0);
                //ExampleMod.proxy.spawnParticle("flaksmokesmall", this.worldObj, partX, partY, partZ, (Math.random() - 0.5), (Math.random() - 0.5), (Math.random() - 0.5));
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



