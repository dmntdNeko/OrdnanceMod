package com.example.ordnancemod.tileentities;

import com.example.ordnancemod.OrdnanceMod;
import com.example.ordnancemod.network.TileGrinderPacket;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.ITickable;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

import java.util.ArrayList;
import java.util.List;

public class TileGrinder extends TileEntity implements IInventory, ITickable {

    private final InventoryBasic inventory = new InventoryBasic("tileGrinder",false,1);
    private int ticksElapsed;
    private boolean isActive;
    public float spinAngle;

    public Minecraft mc = Minecraft.getMinecraft();
    public EntityPlayer player = mc.thePlayer;

    public TileGrinder(){}

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        this.isActive = tag.getBoolean("isActive");
        this.spinAngle = tag.getFloat("spinAngle");
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        tag.setBoolean("isActive", this.isActive);
        tag.setFloat("spinAngle",this.spinAngle);
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();

        tag.setBoolean("isActive",this.isActive);
        tag.setFloat("spinAngle",this.spinAngle);
        return new S35PacketUpdateTileEntity(this.xCoord,this.yCoord,this.zCoord,1,tag);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
        NBTTagCompound tag = packet.func_148857_g();

        this.isActive = tag.getBoolean("isActive");
        this.spinAngle = tag.getFloat("spinAngle");
    }

    @Override
    public void tick() {
        if (!worldObj.isRemote) {
            TileGrinderPacket packet = new TileGrinderPacket(this);
            OrdnanceMod.NETWORK.sendToAllAround(packet, new NetworkRegistry.TargetPoint(worldObj.provider.dimensionId,this.xCoord,this.yCoord,this.zCoord,64));
            int processingTime = 20;
            if (this.ticksElapsed >= processingTime && !(inventory.getStackInSlot(0) == null)) {
                List<ItemStack> loot = getLoot();
                dropLoot(loot);
                inventory.decrStackSize(0, 1);
                this.ticksElapsed = 0;
                this.isActive = true;
                System.out.println("Processed");
                markDirty();
            } else if (!(inventory.getStackInSlot(0) == null)) {
                this.isActive = true;
                this.ticksElapsed++;
                markDirty();
            } else if (inventory.getStackInSlot(0)==null){
                this.isActive = false;
                markDirty();
            }
            markDirty();
        }
    }

    public void updateEntity() {
        if (!worldObj.isRemote) {
            TileGrinderPacket packet = new TileGrinderPacket(this);
            OrdnanceMod.NETWORK.sendToAllAround(packet, new NetworkRegistry.TargetPoint(worldObj.provider.dimensionId,this.xCoord,this.yCoord,this.zCoord,64));
            int processingTime = 20;
            if (this.ticksElapsed >= processingTime && !(inventory.getStackInSlot(0) == null)) {
                List<ItemStack> loot = getLoot();
                dropLoot(loot);
                inventory.decrStackSize(0, 1);
                this.ticksElapsed = 0;
                this.isActive = true;
            } else if (!(inventory.getStackInSlot(0) == null)) {
                this.isActive = true;
                this.ticksElapsed++;
                this.addSpinAngle(8.0F);
            } else if (inventory.getStackInSlot(0)==null){
                this.isActive = false;
            }
            this.worldObj.markBlockForUpdate(this.xCoord,this.yCoord,this.zCoord);
            markDirty();
        }
    }

    public boolean addItem(ItemStack itemStack) {
        if (itemStack.getItem() == Item.getItemFromBlock(Blocks.sand)) {
            ItemStack existingStack = inventory.getStackInSlot(0);
            if (existingStack==null) {
                inventory.setInventorySlotContents(0,itemStack.copy());
                return true;
            } else if (existingStack.stackSize < existingStack.getMaxStackSize()) {
                int space = existingStack.getMaxStackSize() - existingStack.stackSize;
                int amountToAdd = Math.min(space,itemStack.stackSize);
                existingStack.stackSize+=amountToAdd;
                return true;
            }
        }
        return false; // Couldn't add item
    }

    private List<ItemStack> getLoot() {
        // Replace this with your own loot table logic
        List<ItemStack> loot = new ArrayList<ItemStack>();
        int randomInt = worldObj.rand.nextInt(10); // 0-9
        if (randomInt == 0) {
            loot.add(new ItemStack(Items.gold_ingot, 1));
        } else {
            loot.add(new ItemStack(Items.gold_nugget, 1));
        }
        return loot;
    }

    private void dropLoot(List<ItemStack> loot) {
        for (ItemStack item : loot) {
            if (item!=null) {
                float f = 0.7F;
                double d0 = (double)(worldObj.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
                double d1 = (double)(worldObj.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
                double d2 = (double)(worldObj.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
                EntityItem entityitem = new EntityItem(worldObj, (double)xCoord + d0, (double)yCoord + d1, (double)zCoord + d2, item);
                entityitem.delayBeforeCanPickup = 10;
                worldObj.spawnEntityInWorld(entityitem);
            }
        }
    }

    @Override
    public int getSizeInventory() {
        return inventory.getSizeInventory();
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return inventory.getStackInSlot(slot);
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {
        markDirty();
        return inventory.decrStackSize(1,1);
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        return inventory.getStackInSlotOnClosing(slot);
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        inventory.setInventorySlotContents(slot,stack);
        markDirty();
    }

    @Override
    public String getInventoryName() {
        return inventory.getInventoryName();
    }

    @Override
    public boolean hasCustomInventoryName() {
        return inventory.hasCustomInventoryName();
    }

    @Override
    public int getInventoryStackLimit() {
        return inventory.getInventoryStackLimit();
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return inventory.isUseableByPlayer(player);
    }

    @Override
    public void openInventory() {
        inventory.openInventory();
    }

    @Override
    public void closeInventory() {
        inventory.closeInventory();
    }

    @Override
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
        return false;
    }

    public float getSpinAngle() {
        return this.spinAngle;
    }

    public void addSpinAngle(float addSpin){
        float spin = this.spinAngle + addSpin;
        if (spin>=360.0F) {
            this.spinAngle = 0.0F + Math.abs(spin - 360.0F - addSpin);
        } else {
            this.spinAngle = spin;
        }
        this.worldObj.markBlockForUpdate(this.xCoord,this.yCoord,this.zCoord);
        markDirty();
    }

    public int getTicksElapsed(){
        return this.ticksElapsed;
    }

    public boolean getActive() {
        return this.isActive;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


}
