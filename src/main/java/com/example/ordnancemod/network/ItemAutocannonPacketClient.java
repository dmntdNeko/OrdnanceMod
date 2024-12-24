package com.example.ordnancemod.network;

import com.example.ordnancemod.OrdnanceMod;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;

import static com.example.ordnancemod.OrdnanceMod.LOGGER;

public class ItemAutocannonPacketClient implements IMessage {
    boolean LClickDown;
    ItemStack stack;

    public ItemAutocannonPacketClient() {}

    public ItemAutocannonPacketClient(boolean LClickDown, ItemStack stack) {
        this.LClickDown = LClickDown;
        this.stack = stack;
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeBoolean(this.LClickDown);
        ByteBufUtils.writeItemStack(buf, stack);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.LClickDown = buf.readBoolean();
        this.stack = ByteBufUtils.readItemStack(buf);
    }

    public ItemStack getItemStack(){
        return stack;
    }
    public boolean getLClickDown() {return LClickDown;}

    public static class Handler implements IMessageHandler<ItemAutocannonPacketClient,IMessage> {

        @Override
        public IMessage onMessage(ItemAutocannonPacketClient message, MessageContext ctx) {
            LOGGER.info("Packet received by server, data is as follows: " + message.getItemStack());
            EntityPlayerMP serverPlayer = ctx.getServerHandler().playerEntity;
            //EntityPlayerMP player = (EntityPlayerMP) Minecraft.getMinecraft().thePlayer;
            ItemStack stack = message.getItemStack();
            if (stack.getTagCompound() != null) {
                //boolean someState = stack.stackTagCompound.getBoolean("isDown");
                boolean someState = message.getLClickDown();
                OrdnanceMod.NETWORK.sendTo(new ItemAutocannonPacketServer(someState), serverPlayer);
            }

            return null;
        }
    }
}
