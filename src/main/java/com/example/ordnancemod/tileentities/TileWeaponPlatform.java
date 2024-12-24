package com.example.ordnancemod.tileentities;

import com.example.ordnancemod.entities.EntityProjectile;
import com.example.ordnancemod.util.TrajectoryHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileWeaponPlatform extends TileEntity {

    private float rotationRate;

    private float yaw;
    private float pitch;
    private float targetYaw;
    private float targetPitch;

    private int currentAmmo;
    private int maxAmmo;
    private int shotTick;
    private int reloadTimer;

    private int shotsRemaining;
    private int shotDelay;

    private String soundNear;
    private String soundMid;
    private String soundFar;

    private TrajectoryHelper rofUtil = new TrajectoryHelper();

    public TileWeaponPlatform(){
        this.maxAmmo = 250;
        this.currentAmmo = 250;
        //this.soundNear = "examplemod:HMGShotNear";
        //this.soundMid = "examplemod:HMGShotMid";
        //this.soundFar = "examplemod:HMGShotFar";
        this.soundNear = this.soundFar = "examplemod:fullPowerShot";
    }

    @Override
    public void updateEntity() {
        if (!this.worldObj.isRemote) {
            super.updateEntity();
            if (this.currentAmmo > 0) {
                if (this.shotTick > 0){
                    if (!this.worldObj.isRemote){
                        if (shotTick %2==0 && 21 >= shotTick && shotTick > 13) {
                            this.shoot(this.worldObj);
                        }
                        this.shotTick--;
                    }
                }
            } else {
                if (this.shotTick != -1) {
                    this.reloadTimer = 200;
                }
                this.shotTick = -1;
                if (this.reloadTimer > 0) {
                    this.reloadTimer--;
                } else if (this.reloadTimer == 0) {
                    this.reloadTimer = -1;
                    this.currentAmmo = this.maxAmmo;
                    this.worldObj.playSoundEffect(this.xCoord,this.yCoord,this.zCoord,"random.click",1.0f,1.0f);
                }
            }
        }
    }

    public void doFireMission(int shots,int delay){
        this.shotsRemaining = shots;
        this.shotDelay = delay;
    }

    public void shoot(World world){
        if (!world.isRemote) {
            EntityProjectile bullet = new EntityProjectile(world,this.xCoord+2.0*(-Math.sin(Math.toRadians(this.yaw))),this.yCoord+1,this.zCoord+2.0*(Math.cos(Math.toRadians(this.yaw))));
            bullet.setDamage(10.0D);
            //bullet.setThrowableHeading(Math.cos(Math.toRadians(this.yaw-90)),Math.sin(Math.toRadians(this.pitch)),Math.sin(Math.toRadians(-(this.yaw-90))),1.0f,0.0f);
            bullet.setThrowableHeading(-Math.sin(Math.toRadians(this.yaw)),Math.sin(Math.toRadians(0)),Math.cos(Math.toRadians(this.yaw)),17.5f,1.0f);
            bullet.canBePickedUp = 1;
            world.spawnEntityInWorld(bullet);
            world.playSoundEffect(this.xCoord, this.yCoord, this.zCoord, this.soundNear, 2.5f, 0.75F);
            world.playSoundEffect(this.xCoord, this.yCoord, this.zCoord, this.soundFar, 12.5f, 0.75F);
            this.currentAmmo--;
            this.worldObj.markBlockForUpdate(this.xCoord,this.yCoord,this.zCoord);
            this.markDirty();
        }
    }

    @Override
    public double getMaxRenderDistanceSquared() {
        return 13684.0D;
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);

        this.yaw = tag.getFloat("yaw");
        this.pitch = tag.getFloat("pitch");
        this.currentAmmo = tag.getInteger("currentAmmo");
        this.maxAmmo = tag.getInteger("maxAmmo");

    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);

        tag.setFloat("yaw",this.yaw);
        tag.setFloat("pitch",this.targetPitch);
        tag.setInteger("currentAmmo",this.currentAmmo);
        tag.setInteger("maxAmmo",this.maxAmmo);
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();

        tag.setFloat("yaw",this.yaw);
        tag.setFloat("pitch",this.targetPitch);
        tag.setInteger("currentAmmo",this.currentAmmo);
        tag.setInteger("maxAmmo",this.maxAmmo);
        return new S35PacketUpdateTileEntity(this.xCoord,this.yCoord,this.zCoord,1,tag);
    }

    @Override
    public void onDataPacket(NetworkManager manager, S35PacketUpdateTileEntity packet) {
        NBTTagCompound tag = packet.func_148857_g();

        this.yaw = tag.getFloat("yaw");
        this.pitch = tag.getFloat("pitch");
        this.currentAmmo = tag.getInteger("currentAmmo");
        this.maxAmmo = tag.getInteger("maxAmmo");
    }

    public void setShotTick(int shotTick){
        this.shotTick = shotTick;
    }
    public int getShotTick(){
        return this.shotTick;
    }

    public int getCurrentAmmo() {return this.currentAmmo;}
    public int getMaxAmmo() {return this.maxAmmo;}

    public void setRotation(float yaw, float pitch) {
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public float getYaw() {return this.yaw; }
    public float getPitch() {return this.pitch; }

    public void incrementYaw(){}

    public void decrementYaw(){}

    public void incrementPitch(){}

    public void decrementPitch(){}

}
