package com.example.ordnancemod.items;

import com.example.ordnancemod.entities.EntityOrdnanceProjectile;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;

import java.util.List;
public class ItemTestGun extends Item {

    private int cooldown;
    private int fireDelay = -1;

   /* @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        EntityArrow bolt;
        player.playSound("random.bow",1.0f,(float)Math.random());
        float velocity = 5.0f;
        bolt = new EntityArrow(world, player,velocity);
        bolt.canBePickedUp = 0;
        bolt.setDamage(10.0D);
        bolt.setKnockbackStrength(10);
        world.spawnEntityInWorld(bolt);

        return super.onItemRightClick(stack, world, player);
    }

    */

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int useTime) {

        int j = this.getMaxItemUseDuration(stack) - useTime;
        ArrowLooseEvent event = new ArrowLooseEvent(player, stack, j);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled()) {
            return;
        }

        j = event.charge;

        float f = (float) j / 20.0f;

        player.worldObj.playSoundToNearExcept(player, "random.anvil", 1.0f, 0.01f);
        EntityArrow bolt = new EntityArrow(world, player, f * 3.0f);
        bolt.setDamage((double) f);

        world.spawnEntityInWorld(bolt);


        super.onPlayerStoppedUsing(stack, world, player, useTime);
    }

    @Override
    public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
        return stack;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 300000;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.bow;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) {
        super.addInformation(stack, player, list, bool);
        list.add(EnumChatFormatting.WHITE + "RnD Satellite Gun");
        list.add(EnumChatFormatting.YELLOW + "This is a work in progress");
    }

    @Override
    public void onUpdate(ItemStack item, World world, Entity player, int ticks, boolean inHand) {
        super.onUpdate(item, world, player, ticks, inHand);
        if (!world.isRemote) {
            if (this.cooldown > 0) {
                this.cooldown--;
            }
            if (this.fireDelay > 0) {
                this.fireDelay--;
            } else if (this.fireDelay == 0) {
                float velocity = 4.0f;
                EntityOrdnanceProjectile projectile = new EntityOrdnanceProjectile(world, (EntityPlayer)player, velocity,1.0F);
                //entityFlakProjectile projectile = new entityFlakProjectile(world, (EntityPlayer)player, velocity,1.0F);
                projectile.canBePickedUp = 0;
                projectile.setDamage(0.5D);
                projectile.setKnockbackStrength(0);
                world.spawnEntityInWorld(projectile);
                this.fireDelay = -1;
            }
        }

    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {

        if (!world.isRemote) {

            boolean flag = player.capabilities.isCreativeMode;

            if (this.cooldown == 0) {
                if (flag || player.inventory.hasItem(Item.getItemFromBlock(Blocks.tnt))) {

                    this.fireDelay = 5;
                    //player.worldObj.playSoundEffect(player.posX, player.posY, player.posZ, "examplemod:artillery_fire", 10.0f, 0.3f);
                    player.worldObj.playSoundEffect(player.posX, player.posY, player.posZ, "examplemod:artillery_fire", 10.0f, (float) (1+(Math.random()*(0.1+0.1)-0.1)));
                    //player.worldObj.playSoundEffect(player.posX, player.posY, player.posZ, "random.explode", 10.0f, 0.1f);
                    //player.worldObj.playSoundEffect(player.posX, player.posY, player.posZ, "random.break", 10.0f, 0.3f);
                    //player.worldObj.playSoundEffect(player.posX, player.posY, player.posZ, "random.break", 5.0f, 0.3f);
                    /*float velocity = 2.0f;
                    entityArtilleryFlare AFlare = new entityArtilleryFlare(world, player, velocity);
                    AFlare.canBePickedUp = 0;
                    AFlare.setDamage(0.5D);
                    AFlare.setKnockbackStrength(0);

                    if (!world.isRemote) {
                        world.spawnEntityInWorld(AFlare);
                    }

                     */

                    if (!flag) {
                        player.inventory.consumeInventoryItem(Item.getItemFromBlock(Blocks.tnt));
                    }

                } else if (!player.inventory.hasItem(Item.getItemFromBlock(Blocks.tnt))) {
                    player.worldObj.playSoundEffect(player.posX, player.posY, player.posZ, "random.click", 1.0f, 1.0f);
                }
                this.cooldown = 0;
            } else if (this.cooldown > 0) {
                player.worldObj.playSoundEffect(player.posX, player.posY, player.posZ, "random.click", 1.0f, 1.0f);
            }

        }

        return stack;

    }

}