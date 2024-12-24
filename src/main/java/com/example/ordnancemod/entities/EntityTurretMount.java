package com.example.ordnancemod.entities;

import com.example.ordnancemod.tileentities.TileWeaponPlatform;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

public class EntityTurretMount extends Entity {

    private Block block;
    private TileWeaponPlatform boundSystem;

    public EntityTurretMount(World world) {
        super(world);
        this.setSize(0.0F, 0.0F);
        this.checkSystem(world);
    }

    @Override
    protected void entityInit() {
    }

    @Override
    public double getMountedYOffset() {
        return 0.4375F;
    }

    @Override
    public void onEntityUpdate() {
        super.onEntityUpdate();
        if (!this.worldObj.isRemote && this.riddenByEntity == null) {
            this.setDead();
        } else if (this.riddenByEntity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) this.riddenByEntity;
            if (boundSystem != null) {
                boundSystem.setRotation(player.rotationYaw, 0.0F);
                if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
                    if (21 >= boundSystem.getShotTick() && boundSystem.getShotTick() > 13) {
                        boundSystem.setShotTick(21);
                    }
                }

            }
        }
    }

    public void checkSystem(World world) {
        this.block = world.getBlock(this.serverPosX,this.serverPosY,this.serverPosZ);
        if (this.block.hasTileEntity(world.getBlockMetadata(this.serverPosX,this.serverPosY,this.serverPosZ))) {
            if (world.getTileEntity(this.serverPosX,this.serverPosY,this.serverPosZ) instanceof TileWeaponPlatform) {
                this.boundSystem = (TileWeaponPlatform) world.getTileEntity(this.serverPosX,this.serverPosY,this.serverPosZ);
            }
        }
    }

    @Override
    public boolean isEntityInvulnerable() {
        return true;
    }

    @Override
    public boolean isInvisible() {
        return true;
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound p_70037_1_) {
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound p_70014_1_) {
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }

    @Override
    public boolean canBePushed() {
        return false;
    }

    @Override
    protected void fall(float p_70069_1_) {
    }

    @Override
    public void setPositionAndRotation2(double x, double y, double z, float yaw, float pitch, int something) {
        this.setPosition(x, y, z);
        this.setRotation(yaw, pitch);
    }
}
