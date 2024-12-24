package com.example.ordnancemod.items;

import com.example.ordnancemod.tileentities.TileOrdnance;
import com.example.ordnancemod.entities.EntityMinecartHeavy;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRailBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemTileTester extends Item {

    public ItemTileTester(){}

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if (BlockRailBase.func_150051_a(world.getBlock(x,y,z))) {
            if (!world.isRemote) {
                EntityMinecartHeavy minecartHeavy = new EntityMinecartHeavy(world,x+0.5F,y,z+0.5F);
                world.spawnEntityInWorld(minecartHeavy);
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        MovingObjectPosition mop = getMovingObjectPositionFromPlayer(world,player,true);

        if (mop != null && mop.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
            int x = mop.blockX; int y = mop.blockY; int z = mop.blockZ;
            Block block = world.getBlock(x,y,z);
            String blockName = world.getBlock(x,y,z).getLocalizedName();
            if (!world.isRemote) {
                if (block.hasTileEntity(world.getBlockMetadata(x, y, z))) {
                    player.addChatComponentMessage(new ChatComponentText(blockName+": Tile @ "+x+", "+y+", "+z));
                    if (world.getTileEntity(x,y,z) instanceof TileOrdnance) {
                        TileOrdnance lightArtillery = (TileOrdnance) world.getTileEntity(x,y,z);
                        player.addChatComponentMessage(new ChatComponentText("Yaw: "+lightArtillery.getYaw()));;
                    }
                } else {
                    player.addChatComponentMessage(new ChatComponentText(blockName+": Block @ "+x+", "+y+", "+z));
                }
            }
        }

        /*int x = mop.blockX; int y = mop.blockY; int z = mop.blockZ;
        Block block = world.getBlock(x,y,z);
        entityMinecartHeavy minecartHeavy = new entityMinecartHeavy(world,x+0.5F,y+0.5F,z+0.5F);
        if (!world.isRemote) {
            world.spawnEntityInWorld(minecartHeavy);
        }*/
        return super.onItemRightClick(stack, world, player);
    }

}
