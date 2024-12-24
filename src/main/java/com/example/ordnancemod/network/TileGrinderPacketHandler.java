package com.example.ordnancemod.network;

import com.example.ordnancemod.tileentities.TileGrinder;
import com.example.ordnancemod.util.ClientProxy;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileGrinderPacketHandler implements IMessageHandler<TileGrinderPacket, IMessage> {
    @Override
    public IMessage onMessage(TileGrinderPacket packet, MessageContext ctx) {
        int x = packet.getX();
        int y = packet.getY();
        int z = packet.getZ();
        ItemStack inventory = packet.getInventory();

        World world = ClientProxy.getClientWorld();
        TileEntity tileEntity = world.getTileEntity(x,y,z);

        if (tileEntity instanceof TileGrinder) {
            ((TileGrinder)tileEntity).getStackInSlot(0);
        }

        return null;
    }
}
