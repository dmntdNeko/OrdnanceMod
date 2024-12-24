package com.example.ordnancemod.entities;


import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityModel extends Entity {
    
    public EntityModel(World world) {
        super(world);
        this.setSize(1.0F,1.0F);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.ticksExisted >= 600){
            this.setDead();
        }
    }

    @Override
    protected void entityInit() {}

    @Override
    protected void readEntityFromNBT(NBTTagCompound p_70037_1_) {}

    @Override
    protected void writeEntityToNBT(NBTTagCompound p_70014_1_) {}
}
