package com.example.ordnancemod.tileentities;

import com.example.ordnancemod.entities.EntityOrdnanceProjectile;
import net.minecraft.world.World;

public class TileGriefingTable extends TileOrdnance {

    public TileGriefingTable(){
        super();
        this.initialDelay = 100;
        this.delay = 20;
        this.shots = 9;
        this.maxPitch = 90;
    }

    @Override
    public void shoot(World world) {
        if (!world.isRemote) {
            float speed = 5F;

            EntityOrdnanceProjectile flare = new EntityOrdnanceProjectile(world, this.xCoord + 0.5 + (3.5 * (-Math.sin(Math.toRadians(this.yaw)))), this.yCoord + 1 + (3.5 * (Math.sin(Math.toRadians(this.pitch)))), this.zCoord + 0.5 + (3.5 * Math.cos(Math.toRadians((this.yaw)))), true);
            flare.setThrowableHeading(-Math.sin(Math.toRadians(this.yaw)) * Math.cos(Math.toRadians(this.pitch)), Math.sin(Math.toRadians(this.pitch)), Math.cos(Math.toRadians(this.yaw)) * (Math.cos(Math.toRadians(this.pitch))), speed, 5.0f);
            flare.canBePickedUp = 1;
            world.spawnEntityInWorld(flare);
            float pitch = (float) (1 + (Math.random() * (0.1 + 0.1) - 0.1));
            world.playSoundEffect(this.xCoord, this.yCoord, this.zCoord, "examplemod:mlrs_fire", 15F, pitch); //default 9
            world.playSoundEffect(this.xCoord, this.yCoord, this.zCoord, "examplemod:mlrs_whizz", 20F, pitch); //default 12.5
            this.rock = 10;
        }
    }

}
