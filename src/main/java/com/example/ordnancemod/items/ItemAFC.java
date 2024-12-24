package com.example.ordnancemod.items;

import com.example.ordnancemod.blocks.BlockOrdnance;
import com.example.ordnancemod.blocks.BlockWeaponPlatform;
import com.example.ordnancemod.tileentities.TileOrdnance;
import com.example.ordnancemod.tileentities.TileWeaponPlatform;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import java.util.ArrayList;

public class ItemAFC extends Item {


    //private tileLightArtillery boundArtillery;
    private ArrayList<TileOrdnance> boundArtillery = new ArrayList<TileOrdnance>();
    public TileWeaponPlatform boundSystem;
    public boolean hasBoundSystem;

    private int linkX, linkY, linkZ;
    private int cooldown = 0;
    private int maxCooldown = 40;
    private int takeshiCounter = 0;

    public ItemAFC(){}

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        Block block = world.getBlock(x,y,z);
        if (!world.isRemote) {
            if (block instanceof BlockOrdnance) {
                //this.boundArtillery = (tileLightArtillery)world.getTileEntity(x,y,z);
                this.boundArtillery.add((TileOrdnance)world.getTileEntity(x,y,z));
                player.addChatComponentMessage(new ChatComponentText("Device linked to block @ "+x+", "+y+", "+z));
            } else if (block instanceof BlockWeaponPlatform) {
                this.boundSystem = (TileWeaponPlatform) world.getTileEntity(x,y,z);
                this.hasBoundSystem = true;
                player.addChatComponentMessage(new ChatComponentText("Device linked to block @ "+x+", "+y+", "+z));
            } else {
                player.addChatComponentMessage(new ChatComponentText("Invalid block"));
            }
        }
        return true;
    }

    public void sendFireMission(TileWeaponPlatform system, int shots, int delay){
        system.doFireMission(shots, delay);
    }

    public void sendFireMission(TileOrdnance system){
        system.doFireMission();
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (!world.isRemote){
            if (player.isSneaking()) {
                this.clearBindings(player);
                return stack;
            }

            if (this.boundArtillery != null) {
                //this.boundArtillery.shoot(world);
                for (TileOrdnance element : boundArtillery) {
                    //element.shoot(world);
                    // default light artillery - this.sendFireMission(element, 240, 100, 6);
                    this.sendFireMission(element);
                    //player.addChatComponentMessage(new ChatComponentText("Fire mission sent"));
                }
            }
            if (this.boundSystem!= null) {
                if (this.cooldown == 0) {
                    //this.sendFireMission(boundSystem,3,40);
                    //boundArtillery.shoot(world);
                    boundSystem.setShotTick(21);
                    //this.cooldown = this.maxCooldown;
                } else if (this.cooldown > 0) {
                    player.addChatComponentMessage(new ChatComponentText("Cooldown: "+this.cooldown/20+" seconds"));
                }
            } else {
                if (this.takeshiCounter==0) {
                    this.takeshiCounter = 732;
                }
            }
        }

        return super.onItemRightClick(stack, world, player);
    }

    public void clearBindings(EntityPlayer player){
        this.boundArtillery.clear();
        this.boundSystem = null;
        player.addChatComponentMessage(new ChatComponentText("Bound tiles cleared"));
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean inHand) {
        super.onUpdate(stack, world, entity, slot, inHand);
        if (!world.isRemote) {
            if (this.cooldown > 0) {
                this.cooldown--;
            }
            /*switch (this.takeshiCounter) {
                case 732:
                    world.playSoundAtEntity(entity,"examplemod:takeshi1",7.5F,1.0F);
                    break;
                case 612:
                    world.playSoundAtEntity(entity,"examplemod:takeshi2",7.5F,1.0F);
                    break;
                case 492:
                    world.playSoundAtEntity(entity,"examplemod:takeshi3",7.5F,1.0F);
                    break;
                case 372:
                    world.playSoundAtEntity(entity,"examplemod:takeshi4",7.5F,1.0F);
                    break;
                case 252:
                    world.playSoundAtEntity(entity,"examplemod:takeshi5",7.5F,1.0F);
                    break;
                case 130:
                    world.playSoundAtEntity(entity,"examplemod:takeshi6",7.5F,1.0F);
                    break;
                default:
                    break;
            }
            if (this.takeshiCounter > 0) {
                this.takeshiCounter--;
            }*/
        }
    }


}
