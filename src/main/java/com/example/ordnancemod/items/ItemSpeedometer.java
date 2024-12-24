package com.example.ordnancemod.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.math.BigDecimal;

public class ItemSpeedometer extends Item {

    int ticksHeld;
    int instancesHeld;
    double y;
    double x;
    double z;
    double yPrev;
    double xPrev;
    double zPrev;

    double hyp;
    int tickrate = 1;
    public ItemSpeedometer(){}

    public void onUpdate(ItemStack item, World world, Entity player, int ticks, boolean inHand){
        super.onUpdate(item,world,player,ticks,inHand);

        ++ticksHeld;
        //yPrev = Double.parseDouble(new BigDecimal(Double.toString(player.posY)).setScale(2,BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString());
        //y = Double.parseDouble(new BigDecimal(Double.toString(player.posY)).setScale(2,BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString());

        if (ticksHeld%40==0) {
            if (!world.isRemote && inHand && player instanceof EntityPlayer) {
                EntityPlayer player1 = (EntityPlayer) player;
                if (!player1.capabilities.isCreativeMode){
                    instancesHeld++;
                    y = Double.parseDouble(new BigDecimal(Double.toString(player.posY)).setScale(2, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString());
                    x = Double.parseDouble(new BigDecimal(Double.toString(player.posX)).setScale(2, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString());
                    z = Double.parseDouble(new BigDecimal(Double.toString(player.posZ)).setScale(2, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString());

                    double deltax = getXDelta(x);
                    double deltaz = getZDelta(z);
                    hyp = Double.parseDouble(new BigDecimal(Double.toString(MathHelper.sqrt_double((deltax * deltax) + (deltaz * deltaz)))).setScale(2, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString());

                    //player1.addChatComponentMessage(new ChatComponentText("[" + instancesHeld + "] (V): " + getYDelta(y) + ".  (H): " + hyp));
                    //((EntityPlayer) player).addChatComponentMessage(new ChatComponentText("["+instancesHeld+"] (V): "+getYDelta(y)+".  (H): " +getHorizontalVelocity((EntityPlayer) player)));
                    setYPrev(y);
                    setXPrev(x);
                    setZPrev(z);
                }
            }
        } else if (ticksHeld<=0) {
            
        }
        if (inHand==false){ticksHeld=-2;instancesHeld=-1;}

    }

    public void setYPrev(double yIn) {
        this.yPrev = yIn;
    }

    public void setXPrev(double xIn) {
        this.xPrev = xIn;
    }

    public void setZPrev(double zIn) {
        this.zPrev = zIn;
    }

    public double getYPrev() {
        return this.yPrev;
    }

    public double getXPrev() {
        return this.xPrev;
    }

    public double getZPrev() {
        return this.zPrev;
    }

    public double getYDelta(double yIn) {
        return Double.parseDouble(new BigDecimal(Double.toString(yIn-getYPrev())).setScale(2,BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString());
    }

    public double getXDelta(double xIn) {
        return Double.parseDouble(new BigDecimal(Double.toString(xIn-getXPrev())).setScale(2,BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString());
    }

    public double getZDelta(double zIn) {
        return Double.parseDouble(new BigDecimal(Double.toString(zIn-getZPrev())).setScale(2,BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString());
    }

    public double getHorizontalVelocity(EntityPlayer player) {
        x = Double.parseDouble(new BigDecimal(Double.toString(player.posX)).setScale(2,BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString());
        z = Double.parseDouble(new BigDecimal(Double.toString(player.posZ)).setScale(2,BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString());
        double deltax = getXDelta(x);
        double deltaz = getZDelta(z);
        hyp = Double.parseDouble(new BigDecimal(Double.toString(MathHelper.sqrt_double((deltax*deltax)+(deltaz*deltaz)))).setScale(2,BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString());
        return hyp;
    }

    public double getHyp(double xIn, double zIn) {
        hyp = Double.parseDouble(new BigDecimal(Double.toString(MathHelper.sqrt_double((xIn*xIn)+(zIn*zIn)))).setScale(2,BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString());
        return hyp;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
        if (!world.isRemote) {
            if (this.tickrate<=40) {
                if (this.tickrate==1) {
                    this.tickrate += 9;
                } else if (this.tickrate>=10){
                    this.tickrate += 10;
                }
            } else {
                this.tickrate = 1;
            }
        }
        return super.onItemRightClick(item, world, player);
    }

    public int getTickrate(){
        return this.tickrate;
    }
}
