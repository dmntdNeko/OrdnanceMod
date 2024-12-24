package com.example.ordnancemod.util;

import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {
    public void registerEventHandlers() {
        MinecraftForge.EVENT_BUS.register(new CommonEventHandler());
    }

    public void registerItemRenderers(Item smallArm, IItemRenderer renderer){}

    public void registerRenderers(){

    }

    public void registerEntities(){

    }

    public void spawnParticle(String name, World world, double posX, double posY, double posZ, double motionX, double motionY, double motionZ){
        this.spawnParticle(name,world,posX,posY,posZ,motionX,motionY,motionZ);
    }

    public void spawnParticle(String name, World world, double posX, double posY, double posZ, double motionX, double motionY, double motionZ, float scale, double maxAge){
        this.spawnParticle(name,world,posX,posY,posZ,motionX,motionY,motionZ,scale,maxAge);
    }

    public void spawnParticle(String name, World world, double posX, double posY, double posZ, double motionX, double motionY, double motionZ, float yaw, float pitch) {
        this.spawnParticle(name,world,posX,posY,posZ,motionX,motionY,motionZ,yaw,pitch);
    }

}
