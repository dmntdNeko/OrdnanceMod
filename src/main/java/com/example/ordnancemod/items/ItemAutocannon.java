package com.example.ordnancemod.items;

import com.example.ordnancemod.OrdnanceMod;
import com.example.ordnancemod.entities.EntityProjectile;
import com.example.ordnancemod.network.ItemAutocannonPacketClient;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import org.lwjgl.input.Mouse;

public class ItemAutocannon extends Item {

    int ticksInHand;
    float velocity = 20f;
    int shotsRemaining = 0;
    int tickShotDelay;
    float inaccuracy;
    boolean LClickDown;

    public ItemAutocannon() {
        this.tickShotDelay = 4;
        this.inaccuracy = 1.0F;
        this.LClickDown = false;
    }

    public void shoot(World world, EntityPlayer player) {
        EntityProjectile shot = new EntityProjectile(world,player,velocity,inaccuracy);
        shot.setDamage(10);
        shot.setKnockback(5);
        world.playSoundAtEntity(player, "examplemod:intermediateShot",2.5F,1.0F);
        world.spawnEntityInWorld(shot);
    }

    public void onUpdate(ItemStack item, World world, Entity player, int ticks, boolean inHand){
        super.onUpdate(item,world,player,ticks,inHand);
        EntityPlayer player1 = (EntityPlayer) player;
        long worldTick = world.getTotalWorldTime();
        boolean flag = player1.getHeldItem() == item && Minecraft.getMinecraft().currentScreen == null;

        if (world.isRemote && flag) {
            if (Mouse.isButtonDown(0)) {
                System.out.println("Button down message sent");
                OrdnanceMod.NETWORK.sendToServer(new ItemAutocannonPacketClient(true, item));
            } else {
                System.out.println("Button let go message sent");
                OrdnanceMod.NETWORK.sendToServer(new ItemAutocannonPacketClient(false, item));
            }
        }

        if (this.LClickDown) {
            if (worldTick % tickShotDelay == 0) {
                shoot(world,player1);
            }
        }
    }

    public void setLClickDown(ItemStack stack, boolean isDown) {
        if (stack.getTagCompound() == null) {
            stack.setTagCompound(new NBTTagCompound());
        }
        stack.stackTagCompound.setBoolean("LClickDown",LClickDown);
    }

    public boolean getLClickDown(ItemStack stack) {
        if (stack == null) {
            return false;
        } else {
            return stack.getTagCompound() == null ? false : stack.stackTagCompound.getBoolean("isDown");
        }
    }

}
