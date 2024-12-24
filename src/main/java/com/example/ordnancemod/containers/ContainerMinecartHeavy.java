package com.example.ordnancemod.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;


public class ContainerMinecartHeavy extends Container {
    public ContainerMinecartHeavy(){

    }
    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }
}
