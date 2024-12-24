package com.example.ordnancemod.gui;

import com.example.ordnancemod.containers.ContainerMinecartHeavy;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {
    public static final int GUI_ID_minecartHeavy = 1;
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == GUI_ID_minecartHeavy) {
            //return null;
            return new ContainerMinecartHeavy();
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == GUI_ID_minecartHeavy) {
            return new GuiMinecartHeavy();
        }
        return null;
    }
}
