package com.example.ordnancemod.network;

import com.example.ordnancemod.tileentities.TileGrinder;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;

public class TileGrinderPacket implements IMessage {
    private int x,y,z;
    private ItemStack inventory;

    public TileGrinderPacket(){}

    public TileGrinderPacket(TileGrinder tile) {
        this.x = tile.xCoord;
        this.y = tile.yCoord;
        this.z = tile.zCoord;
        this.inventory = tile.getStackInSlot(0);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        x = buf.readInt();
        y = buf.readInt();
        z = buf.readInt();
        inventory = ByteBufUtils.readItemStack(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        ByteBufUtils.writeItemStack(buf, inventory);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getZ(){
        return z;
    }

    public ItemStack getInventory() {
        return inventory;
    }
}
