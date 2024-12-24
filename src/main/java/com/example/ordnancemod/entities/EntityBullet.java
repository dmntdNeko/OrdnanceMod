package com.example.ordnancemod.entities;

import com.example.ordnancemod.OrdnanceMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityBullet extends EntityProjectile {

    private int spawnTick;
    private boolean didPoof;

    public EntityBullet(World world) {
        super(world);
    }

    public EntityBullet(World world, double x, double y, double z) {
        super(world);
        this.renderDistanceWeight = 10.0D;
        this.setSize(0.1F, 0.1F);
        this.setPosition(x, y, z);
        this.yOffset = 0.0F;
    }

    @Override
    public void onUpdate() {
        this.setGravity(0.0D);
        super.onUpdate();
        if (!this.worldObj.isRemote && !this.didPoof) {
            this.spawnTick++;
        }

        if (this.spawnTick == 1 && !this.isDead) {
            OrdnanceMod.proxy.spawnParticle("explodeshort", this.worldObj, this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0);
            //ExampleMod.proxy.spawnParticle("smoke", this.worldObj, this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0);
            this.didPoof = true;
            this.spawnTick = -1;
        }

    }

    public void onCollideWithPlayer(EntityPlayer player) {
        if (!this.worldObj.isRemote) {
            player.inventory.addItemStackToInventory(new ItemStack(OrdnanceMod.itemBullet, 1));
            this.playSound("random.pop", 0.2F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            player.onItemPickup(this, 1);
            this.setDead();
        }
    }
}
