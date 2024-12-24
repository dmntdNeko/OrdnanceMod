package com.example.ordnancemod.tileentities;

import com.example.ordnancemod.OrdnanceMod;
import com.example.ordnancemod.entities.EntityOrdnanceProjectile;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeChunkManager;

public class TileOrdnance extends TileEntity {

    public float angle = 0.0F;
    private boolean positivePitch;
    private float rate = 0.5F;

    public float yaw;
    public float pitch;
    public float baseYaw;


    private float targetYaw;
    private float targetPitch;
    public float maxPitch;
    private float minPitch;
    private boolean isRotatingY;
    private boolean isRotatingP;
    private float currentRotationRateY;
    private float maxRotationRateY;
    private float maxRotationRateP;
    private boolean isClockwise;
    private boolean isElevating;
    private float rotationRateP;
    public float rock;

    //Fire mission stats
    private int shotTimer;
    private int shotDelay;
    private int shotsRemaining;
    private boolean ongoingFireMission;

    public int initialDelay;
    public int delay;
    public int shots;

    private ForgeChunkManager.Ticket chunkTicket;

    public TileOrdnance() {
        //this.yaw = 0;
        //this.pitch = 0F;
        this.currentRotationRateY = 0;
        this.maxRotationRateY = 0.5F;
        this.maxRotationRateP = 0.5F;
        this.maxPitch = 45.0F;
        this.minPitch = -25.0F;
        this.rock = 0.0F;
        this.initialDelay = 240;
        this.delay = 100;
        this.shots = 6;
    }


    @Override
    public void validate() {
        if (!this.worldObj.isRemote) {
            //request chunkloading ticket
            chunkTicket = ForgeChunkManager.requestTicket(OrdnanceMod.INSTANCE, this.worldObj, ForgeChunkManager.Type.NORMAL);
            if (chunkTicket != null) {
                //Forge chunk to stay loaded
                ChunkCoordIntPair chunk = new ChunkCoordIntPair(this.xCoord >> 4, this.zCoord >> 4);
                ForgeChunkManager.forceChunk(chunkTicket, chunk);

                /*
                // The chunk in which the chunk loader is located
                int chunkX = this.xCoord >> 4;
                int chunkZ = this.zCoord >> 4;

                // Define the radius of chunks to load around the chunk loader
                int radius = 1; // This would load chunks in a 5x5 area (radius 2 around the chunkloader)

                // Force all chunks within the radius to stay loaded
                for (int x = -radius; x <= radius; x++) {
                    for (int z = -radius; z <= radius; z++) {
                        ChunkCoordIntPair chunk = new ChunkCoordIntPair(chunkX + x, chunkZ + z);
                        ForgeChunkManager.forceChunk(chunkTicket, chunk);
                    }
                }

                 */
            }
        }
    }

    @Override
    public void invalidate() {
        super.invalidate();
        //release chunk when tile entity is destroyed
        if (chunkTicket != null) {
            ForgeChunkManager.releaseTicket(chunkTicket);
        }
    }

    public void incrementYaw() {
        //this.targetYaw+=22.5;
        this.targetYaw += 5.0F;
        //this.targetYaw = this.fixAngle(this.targetYaw);
        markDirty();
    }

    public void decrementYaw() {
        //this.targetYaw-=22.5;
        this.targetYaw -= 5.0F;
        //this.targetYaw = this.fixAngle(this.targetYaw);
        markDirty();
    }

    public void incrementPitch() {
        this.targetPitch -= 5.0;
        this.targetPitch = this.fixElevation(this.targetPitch);
        markDirty();
    }

    public void decrementPitch() {
        this.targetPitch += 5.0;
        this.targetPitch = this.fixElevation(this.targetPitch);
        markDirty();
    }

    public float fixAngle(float input) {
        if (input > 180) {
            input -= 360;
        } else if (input < -180) {
            input += 360;
        }
        markDirty();
        return input;
    }

    public float fixElevation(float input) {
        if (input > this.maxPitch) {
            input = maxPitch;
        } else if (input < this.minPitch) {
            input = minPitch;
        }
        markDirty();
        return input;
    }

    @Override
    public void updateEntity() {
        if (!this.worldObj.isRemote) {
            super.updateEntity();
            float diffP = this.targetPitch - this.pitch;
            //float diffP = Math.abs(this.targetPitch - this.pitch);
            this.isRotatingP = this.pitch != this.targetPitch && Math.abs(diffP) > maxRotationRateP;
            if (this.isRotatingP) {
                this.isElevating = diffP >= 0;

                if (this.isElevating) {
                    this.setPitch(maxRotationRateP);
                } else {
                    this.setPitch(-maxRotationRateP);
                }
                //this.pitch = fixElevation(this.pitch);
            }

            float diffY = -(this.targetYaw - this.yaw);
            this.isRotatingY = this.yaw != this.targetYaw && Math.abs(diffY) > maxRotationRateY;
            //this.isRotatingY = !(diff <= this.maxRotationRateY);
            if (this.isRotatingY) {
                this.isClockwise = diffY >= 0;

                if (this.isClockwise) {
                    this.setYaw(-maxRotationRateY);
                } else {
                    this.setYaw(maxRotationRateY);
                }
                //this.yaw = fixAngle(this.yaw);
            }

            if (this.ongoingFireMission) {
                if (shotsRemaining > 0) {
                    this.shotTimer--;
                    if (this.shotTimer <= 0) {
                        this.shoot(this.worldObj);
                        this.shotsRemaining--;
                        this.shotTimer = this.shotDelay;
                    }
                } else {
                    System.out.println("Rounds Complete");
                    this.ongoingFireMission = false;
                }
            }

            if (this.rock > 0) {
                this.rock -= 0.5F;
            }
            //block.setYaw(this.yaw);
            this.markDirty();
        }
    }

    public void shoot(World world) {
        if (!world.isRemote) {
            float speed = 5F; //2.5 default
            //Default entity spawns
            //entityOrdnanceProjectile flare = new entityOrdnanceProjectile(world, this.xCoord + 0.5 + (3.5 * (Math.cos(Math.toRadians(this.yaw - 90)))), this.yCoord + 1 + (3.5 * (Math.sin(Math.toRadians(this.pitch)))), this.zCoord + 0.5 + (3.5 * Math.sin(Math.toRadians(-(this.yaw - 90)))));
            //flare.setThrowableHeading(Math.cos(Math.toRadians(this.yaw - 90)) * Math.cos(Math.toRadians(this.pitch)), Math.sin(Math.toRadians(this.pitch)), Math.sin(Math.toRadians(-(this.yaw - 90))) * (Math.cos(Math.toRadians(this.pitch))), speed, 5.0f);

            EntityOrdnanceProjectile flare = new EntityOrdnanceProjectile(world, this.xCoord + 0.5 + (3.5 * (-Math.sin(Math.toRadians(this.yaw)))), this.yCoord + 1 + (3.5 * (Math.sin(Math.toRadians(this.pitch)))), this.zCoord + 0.5 + (3.5 * Math.cos(Math.toRadians((this.yaw)))),false);
            flare.setThrowableHeading(-Math.sin(Math.toRadians(this.yaw)) * Math.cos(Math.toRadians(this.pitch)), Math.sin(Math.toRadians(this.pitch)), Math.cos(Math.toRadians(this.yaw)) * (Math.cos(Math.toRadians(this.pitch))), speed, 5.0f);
            flare.canBePickedUp = 1;
            world.spawnEntityInWorld(flare);
            float pitch = (float) (1 + (Math.random() * (0.1 + 0.1) - 0.1));
            world.playSoundEffect(this.xCoord, this.yCoord, this.zCoord, "examplemod:artillery_fire_far", 12.5f, pitch-0.25F);
            world.playSoundEffect(this.xCoord, this.yCoord, this.zCoord, "examplemod:artillery_fire_mid", 5.0f, pitch);
            world.playSoundEffect(this.xCoord, this.yCoord, this.zCoord, "examplemod:artillery_fire_near", 2.5f, pitch+0.25F);
            this.rock = 10;
        }
    }

    public void doFireMission() {
        if (!this.ongoingFireMission) {
            this.shotTimer = this.initialDelay + (int) Math.floor(initialDelay * (Math.random() * 0.5F));
            this.shotDelay = this.delay;
            this.shotsRemaining = this.shots;
            this.ongoingFireMission = true;
            System.out.println("Timer: " + this.shotTimer + "; Delay: " + this.shotDelay + "; Shots: " + this.shotsRemaining);
        }
    }

    public float getTargetYaw() {
        return targetYaw;
    }

    public void setTargetYaw(float input) {

    }

    public void setYaw(float input) {
        this.yaw += input;
        this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
        markDirty();
    }

    public void setPitch(float input) {
        this.pitch += input;
        this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
        markDirty();
    }

    public float getYaw() {
        return this.yaw;
    }

    public float getPitch() {
        return this.pitch;
    }

    public float getBaseYaw() {return this.baseYaw;}

    public void setTargetPitch() {

    }

    public boolean getIsClockwiseY() {
        return this.isClockwise;
    }

    public void setRotation(float yaw, float pitch) {
        this.baseYaw = this.yaw = this.targetYaw = yaw;
        this.pitch = this.targetPitch = pitch;
    }

    @Override
    public double getMaxRenderDistanceSquared() {
        return 13684.0D;
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);

        this.yaw = tag.getFloat("yaw");
        this.targetYaw = tag.getFloat("targetYaw");
        this.pitch = tag.getFloat("pitch");
        this.targetPitch = tag.getFloat("targetPitch");
        this.baseYaw = tag.getFloat("baseYaw");
        this.rock = tag.getFloat("rock");

        if (tag.getBoolean("ChunkLoaded") && !worldObj.isRemote) {
            chunkTicket = ForgeChunkManager.requestTicket(OrdnanceMod.INSTANCE, worldObj, ForgeChunkManager.Type.NORMAL);
            if (chunkTicket != null) {
                ChunkCoordIntPair chunk = new ChunkCoordIntPair(this.xCoord >> 4, this.zCoord >> 4);
                ForgeChunkManager.forceChunk(chunkTicket, chunk);
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);

        tag.setFloat("yaw", this.yaw);
        tag.setFloat("targetYaw", this.targetYaw);
        tag.setFloat("pitch", this.pitch);
        tag.setFloat("targetPitch", this.targetPitch);
        tag.setFloat("baseYaw", this.baseYaw);
        tag.setFloat("rock", this.rock);

        if (chunkTicket != null) {
            tag.setBoolean("Chunkloaded", true);
        }
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();

        tag.setFloat("yaw", this.yaw);
        tag.setFloat("targetYaw", this.targetYaw);
        tag.setFloat("pitch", this.pitch);
        tag.setFloat("targetPitch", this.targetPitch);
        tag.setFloat("baseYaw", this.baseYaw);
        tag.setFloat("rock", this.rock);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, tag);
    }

    @Override
    public void onDataPacket(NetworkManager manager, S35PacketUpdateTileEntity packet) {
        NBTTagCompound nbt = packet.func_148857_g();

        this.yaw = nbt.getFloat("yaw");
        this.targetYaw = nbt.getFloat("targetYaw");
        this.pitch = nbt.getFloat("pitch");
        this.targetPitch = nbt.getFloat("targetPitch");
        this.baseYaw = nbt.getFloat("baseYaw");
        this.rock = nbt.getFloat("rock");
    }
}
