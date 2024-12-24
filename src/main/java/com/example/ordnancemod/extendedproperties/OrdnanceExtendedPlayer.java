package com.example.ordnancemod.extendedproperties;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityEvent;

public class OrdnanceExtendedPlayer implements IExtendedEntityProperties {
    public static final String prop_name = "OrdnanceExtendedProperties";
    public int currentAmmo;
    public int maxAmmo;

    public OrdnanceExtendedPlayer(){}

    public static void register(){
        MinecraftForge.EVENT_BUS.register(new Handler());
    }

    @SubscribeEvent
    public void entityConstruct(EntityEvent.EntityConstructing event) {
        if (event.entity instanceof EntityPlayer) {
            if (event.entity.getExtendedProperties(prop_name) == null) {
                event.entity.registerExtendedProperties(prop_name, new OrdnanceExtendedPlayer());
            }
        }
    }

    public static OrdnanceExtendedPlayer get(Entity entity){
        return (OrdnanceExtendedPlayer) entity.getExtendedProperties(prop_name);
    }

    @Override
    public void saveNBTData(NBTTagCompound nbtTagCompound) {

    }

    @Override
    public void loadNBTData(NBTTagCompound nbtTagCompound) {

    }

    @Override
    public void init(Entity entity, World world) {

    }

    public static class Handler {

    }
}
