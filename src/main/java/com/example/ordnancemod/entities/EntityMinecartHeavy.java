package com.example.ordnancemod.entities;

import com.example.ordnancemod.OrdnanceMod;
import com.example.ordnancemod.gui.GuiHandler;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.input.Keyboard;

public class EntityMinecartHeavy extends EntityMinecart implements IInventory {

    private boolean dropContentsWhenDead = true;
    private ItemStack[] inventory;
    private int playerInventorySubtraction;
    private int fireCounter;
    private float projectileVelocity = 17.5F; //HMG velocity
    //private float projectileVelocity = 25.0F; //autocannon velocity
    private float turretYaw;
    private float turretPitch;

    public EntityMinecartHeavy(World world) {
        super(world);
        this.setSize(1.5F,2.0F);
        this.yOffset = (this.height/2.0F) - 0.8125F;
        this.inventory = new ItemStack[16];
        for (int i = 0; i < this.getSizeInventory();i++) {
            this.inventory[i] = null;
        }
        MinecraftForge.EVENT_BUS.register(this);
    }
    public EntityMinecartHeavy(World world, double x, double y, double z) {
        this(world);
        this.setPosition(x, y, z);
        this.motionX = 0.0D;
        this.motionY = 0.0D;
        this.motionZ = 0.0D;
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;
    }

    @Override
    public double getMountedYOffset() {
        return 0.615D;
    }

    public boolean interactFirst(EntityPlayer player)
    {
        if(net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.event.entity.minecart.MinecartInteractEvent(this, player))) return true;
        if (player.isSneaking()) {
            if (!this.worldObj.isRemote) {
                player.addChatComponentMessage(new ChatComponentText("Sneak Right-clicked"));
                player.openGui(OrdnanceMod.INSTANCE, GuiHandler.GUI_ID_minecartHeavy,this.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
            }
            return true;
        } else {
            if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && this.riddenByEntity != player)
            {
                return true;
            }
            else if (this.riddenByEntity != null && this.riddenByEntity != player)
            {
                return false;
            }
            else
            {
                if (!this.worldObj.isRemote)
                {
                    player.mountEntity(this);
                }

                return true;
            }
        }
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        if (this.fireCounter > 0) {
            if (!this.worldObj.isRemote) {
                if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer) {
                    EntityPlayer player = (EntityPlayer) this.riddenByEntity;
                    this.turretYaw = player.rotationYaw;
                    this.turretPitch = player.rotationPitch;
                    if (this.fireCounter%2 == 0) {
                        //player.worldObj.playSoundEffect(player.posX, player.posY, player.posZ, "examplemod:autocannon", 1.0f, 1.0f);
                        player.worldObj.playSoundEffect(player.posX, player.posY, player.posZ, "examplemod:HMGShotNear", 1.0f, 0.9F);
                        //EntityArrow bullet = new EntityArrow(this.worldObj, this.posX - (2.5*Math.sin(Math.toRadians(this.turretYaw))), this.posY + 2, this.posZ + (2.5*Math.cos(Math.toRadians(this.turretYaw))));
                        //entityFlakProjectile bullet = new entityFlakProjectile(this.worldObj, this.posX - (2.5*Math.sin(Math.toRadians(this.turretYaw))), this.posY + 2 - (2.5*Math.sin(Math.toRadians(this.turretPitch))), this.posZ + (2.5*Math.cos(Math.toRadians(this.turretYaw))));
                        EntityProjectile bullet = new EntityProjectile(this.worldObj, this.posX - (2.5*Math.sin(Math.toRadians(this.turretYaw))), this.posY + 1 - (2.5*Math.sin(Math.toRadians(this.turretPitch))), this.posZ + (2.5*Math.cos(Math.toRadians(this.turretYaw))));
                        bullet.setThrowableHeading(-Math.sin(Math.toRadians(this.turretYaw)), Math.sin(-Math.toRadians(this.turretPitch)), Math.cos(Math.toRadians(this.turretYaw)), this.projectileVelocity, 1.0F);
                        bullet.canBePickedUp = 0;
                        bullet.setDamage(7.5D);
                        this.worldObj.spawnEntityInWorld(bullet);
                    }
                }
                this.fireCounter--;
            }
        }

        /*if (Keyboard.isKeyDown(Keyboard.KEY_SPACE) && this.fireCounter<=17){
            this.fireCounter = 21;
        }*/
        if (Keyboard.isKeyDown(Keyboard.KEY_SPACE) && this.fireCounter<=1){
            this.fireCounter = 5;
        }
        markDirty();
    }

    @Override
    public void setDead() {
        if (this.dropContentsWhenDead) {
            if (!this.worldObj.isRemote) {
                for (int i = 0; i < this.getSizeInventory();i++) {
                    ItemStack itemstack = this.getStackInSlot(i);

                    if (itemstack != null) {
                        float f = this.rand.nextFloat() * 0.8F * 0.1F;
                        float f1 = this.rand.nextFloat() * 0.8F * 0.1F;
                        float f2 = this.rand.nextFloat() * 0.8F * 0.1F;

                        while (itemstack.stackSize > 0) {
                            int j = this.rand.nextInt(21) + 10;

                            if (j > itemstack.stackSize) {
                                j = itemstack.stackSize;
                            }

                            itemstack.stackSize -= j;
                            EntityItem entityitem = new EntityItem(this.worldObj, this.posX + (double)f, this.posY + (double)f1, this.posZ + (double)f2, new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));

                            if (itemstack.hasTagCompound()) {
                                entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                            }

                            float f3 = 0.05F;

                            entityitem.motionX = this.rand.nextGaussian() * f3;
                            entityitem.motionY = this.rand.nextGaussian() * f3 + 0.2f;
                            entityitem.motionZ = this.rand.nextGaussian() * f;
                            this.worldObj.spawnEntityInWorld(entityitem);
                        }
                    }
                }
            }
        }
        super.setDead();
    }

    public float getTurretYaw(){
        return this.turretYaw;
    }

    protected void readEntityFromNBT(NBTTagCompound nbt) {
        super.readEntityFromNBT(nbt);
        
        this.turretYaw = nbt.getFloat("yaw");
    }

    protected void writeEntityToNBT(NBTTagCompound nbt) {
        super.writeEntityToNBT(nbt);
        
        nbt.setFloat("yaw",this.turretYaw);
    }



    @Override
    public int getMinecartType() {
        return 0;
    }

    @Override
    public int getSizeInventory() {
        return 16;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        if (this.inventory[slot] == null){
            return null;
        } else {
            return this.inventory[slot];
        }
    }

    @Override
    public ItemStack decrStackSize(int slot, int count) {
        if (this.inventory[slot] != null) {
            ItemStack itemstack;

            if (this.inventory[slot].stackSize <= count) {
                itemstack = this.inventory[slot];
                this.inventory[slot] = null;
                this.markDirty();
                return itemstack;
            } else {
                itemstack = this.inventory[slot].splitStack(count);
                if (this.inventory[slot].stackSize == 0) {
                    this.inventory[slot] = null;
                }
                return itemstack;
            }
        } else {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        if (this.inventory[slot] != null) {
            ItemStack itemstack = this.inventory[slot];
            this.inventory[slot] = null;
            return itemstack;
        } else {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        this.inventory[slot] = stack;
        if (stack != null && stack.stackSize > this.getInventoryStackLimit())
        {
            stack.stackSize = this.getInventoryStackLimit();
        }
        this.markDirty();
        System.out.println("Deposited item "+stack.getUnlocalizedName()+"in slot["+slot+"]");
    }

    @Override
    public String getInventoryName() {
        return "Heavy Minecart";
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public void markDirty() {

    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
        return true;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
        return false;
    }
}
