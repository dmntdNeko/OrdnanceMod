package com.example.ordnancemod.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityTurretAutocannon extends Entity {

    public int health;
    public EntityTurretAutocannon(World world) {
        super(world);
        this.setSize(0.75F,2.0F);
    }

    public EntityTurretAutocannon(World world, int x, int y, int z) {
        this(world);
        this.setPosition(x,y,z);
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;
    }

    @Override
    public boolean canBePushed() {
         return true;
    }

    @Override
    protected void entityInit() {
        this.dataWatcher.addObject(19, 0.0F);
    }

    public boolean interactFirst(EntityPlayer player)
    {
        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && this.riddenByEntity != player)
        {
            return true;
        }
        else if (this.riddenByEntity != null && this.riddenByEntity != player)
        {
            return false;
        }
        else
        {
            if (!this.worldObj.isRemote)
            {
                player.mountEntity(this);
            }

            return true;
        }
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (!this.worldObj.isRemote && !this.isDead) {
            if (this.isEntityInvulnerable()) {
                return false;
            } else {
                this.setDamage(this.getDamage() + (amount * 10.0F));
                boolean flag = source.getEntity() instanceof EntityPlayer && ((EntityPlayer) source.getEntity()).capabilities.isCreativeMode;

                if (flag || this.getDamage() >= 40) {
                    this.setDead();
                }
            }
        } return true;
    }

    @Override
    public boolean isEntityInvulnerable() {
        return false;
    }

    public void setDamage(float damage)
    {
        this.dataWatcher.updateObject(19, Float.valueOf(damage));
    }
    public float getDamage() {return this.dataWatcher.getWatchableObjectFloat(19);}

    public double getMountedYOffset()
    {
        return (double)this.height - 0.3D;
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound p_70037_1_) {

    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound p_70014_1_) {

    }
}
