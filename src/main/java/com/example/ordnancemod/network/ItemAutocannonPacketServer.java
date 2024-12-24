package com.example.ordnancemod.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemAutocannonPacketServer implements IMessage {

    private boolean state;

    public ItemAutocannonPacketServer(){}

    public ItemAutocannonPacketServer(boolean state){
        this.state = state;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.state = buf.readBoolean();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeBoolean(state);
    }

    public boolean getState() {
        return state;
    }

    public static class Handler implements IMessageHandler<ItemAutocannonPacketServer, IMessage> {
        @Override
        public IMessage onMessage(ItemAutocannonPacketServer itemAutocannonPacketServer, MessageContext ctx) {
            //System.out.println("Nessage received from " + ctx);
            //EntityPlayer player = ctx.getServerHandler().playerEntity;
            EntityPlayer player = Minecraft.getMinecraft().thePlayer;
            ItemStack stack = player.getHeldItem();

            if (stack != null) {
                NBTTagCompound tag = stack.getTagCompound();
                if (tag == null) tag = new NBTTagCompound();
                tag.setBoolean("isDown", itemAutocannonPacketServer.getState());
                stack.setTagCompound(tag);
            }
            return null;
        }
    }
}
