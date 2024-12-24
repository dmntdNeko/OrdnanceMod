package com.example.ordnancemod.entities;

import com.example.ordnancemod.OrdnanceMod;
import com.example.ordnancemod.network.EntityMountableWeaponPacket;
import com.example.ordnancemod.skinLibrary.SkinLibrary;
import com.example.ordnancemod.smallArms.SmallArm;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityMountableWeapon extends Entity {
    public ModelBase model;
    public ResourceLocation texture;
    private int skinID;
    private SmallArm smallArm;
    public SkinLibrary library;
    public String libraryName;

    public EntityMountableWeapon(World world) {
        super(world);
        this.setSize(1F,1F);
    }

    public EntityMountableWeapon(World world, double x, double y, double z, SmallArm sa) {
        this(world);
        this.setPosition(x,y+0.5,z);
        this.smallArm = sa;
        System.out.println("SmallArm: " + sa);
        this.libraryName = sa.getLibraryName();
        System.out.println("Library Name: " + this.libraryName);
        //this.setSkinLibrary(this.smallArm.getLibrary());
        System.out.println("~~~~~~~~~~");
        System.out.println("Default skin ID: " + this.skinID);
        System.out.println("~~~~~~~~~~");
        this.skinID = this.smallArm.getSkinID();
        System.out.println("Updated Skin ID: " + this.skinID);
        System.out.println("~~~~~~~~~~");
    }

    @Override
    protected void entityInit() {

    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        //if (!this.worldObj.isRemote && this.ticksExisted >= 2 && this.ticksExisted <= 20) {
        if (!this.worldObj.isRemote && this.ticksExisted >= 2) {
            this.syncLibraryName();
        }

        if (this.ticksExisted >= 200) {
            this.setDead();
        }

    }

    public void syncLibraryName() {
        if (!this.worldObj.isRemote) {
            OrdnanceMod.NETWORK.sendToAllAround(
                    new EntityMountableWeaponPacket(this.getEntityId(),this.libraryName),
                    new NetworkRegistry.TargetPoint(this.dimension,this.posX,this.posY,this.posZ,64)
            );
        }
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound tag) {
        this.skinID = tag.getInteger("skinID");
        this.libraryName = tag.getString("libraryName");
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tag) {
        tag.setInteger("skinID",this.skinID);
        tag.setString("libraryName",this.libraryName);
    }

    public int getSkinID() {return this.skinID;}
    public void setSkinID(int a) {this.skinID = a;}

    public SmallArm getSmallArm() {return this.smallArm;}
    public void setSmallArm(SmallArm sa) {this.smallArm = sa;}

    public SkinLibrary getSkinLibrary() {return this.library;}
    public void setSkinLibrary(SkinLibrary a) {this.library = a;}


}
