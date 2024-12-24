package com.example.ordnancemod.network;

import com.example.ordnancemod.entities.EntityMountableWeapon;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;

public class EntityMountableWeaponPacket implements IMessage {
    private int entityID;
    private String libraryName;

    public EntityMountableWeaponPacket(){}

    public EntityMountableWeaponPacket(int entityID, String libraryName) {
        this.entityID = entityID;
        this.libraryName = libraryName;
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(entityID);
        byte[] stringBytes = libraryName.getBytes();
        buf.writeInt(stringBytes.length);
        buf.writeBytes(stringBytes);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.entityID = buf.readInt();
        int length = buf.readInt();
        byte[] stringBytes = new byte[length];
        buf.readBytes(stringBytes);
        this.libraryName = new String(stringBytes);
    }

    public static class Handler implements IMessageHandler<EntityMountableWeaponPacket, IMessage> {

        @Override
        public IMessage onMessage(EntityMountableWeaponPacket message, MessageContext ctx) {
            if (ctx.side.isClient()) {
                Entity entity = Minecraft.getMinecraft().theWorld.getEntityByID(message.entityID);
                if (entity instanceof EntityMountableWeapon) {
                    ((EntityMountableWeapon)entity).libraryName = message.libraryName;
                }
            }
            return null;
        }
    }
}
