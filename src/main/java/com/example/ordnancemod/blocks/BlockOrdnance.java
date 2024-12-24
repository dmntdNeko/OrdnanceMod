package com.example.ordnancemod.blocks;

import com.example.ordnancemod.tileentities.TileOrdnance;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockOrdnance extends Block {

    public TileOrdnance tileOrdnance;

    public BlockOrdnance(Material material) {
        super(material);
        setLightOpacity(0);
        setLightLevel(10f);// 0 is east, 90 is south, 180 is west, 270 is north
        // south = 0; west = 90; north = 180; east = -90
        // block logic = very confusing. east = 45, 180 facing direction

    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            TileEntity tile = world.getTileEntity(x, y, z);
            if (tile instanceof TileOrdnance) {
                TileOrdnance lightArtillery = (TileOrdnance) tile;
                if (!player.isSneaking()) {
                    if (side == 2 || side == 3 || side == 4 || side == 5) {
                        lightArtillery.incrementYaw();
                    } else if (side == 0 || side == 1) {
                        lightArtillery.incrementPitch();
                    }
                } else {
                        if (side == 2 || side == 3 || side == 4 || side == 5) {
                            lightArtillery.decrementYaw();
                        } else if (side == 0 || side == 1) {
                            lightArtillery.decrementPitch();
                        }
                    }
                }
            }
            return false;
        }

    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int meta, float hitX, float hitY, float hitZ, int side) {
        return super.onBlockPlaced(world, x, y, z, meta, hitX, hitY, hitZ, side);
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase placer, ItemStack stack) {
        super.onBlockPlacedBy(world, x, y, z, placer, stack);
        if (placer instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) placer;
            TileEntity tileEntity = world.getTileEntity(x,y,z);
            if (tileEntity instanceof TileOrdnance) {
                this.tileOrdnance = (TileOrdnance) tileEntity;
                //this.weaponPlatform.setRotation(player.rotationYaw,0.0F);
                float playerYaw = (player.rotationYaw + 360) % 360;
                if (playerYaw >= 45 && playerYaw < 135) {
                    this.tileOrdnance.setRotation(90.0F, 0.0F);
                } else if (playerYaw >= 135 && playerYaw < 225) {
                    this.tileOrdnance.setRotation(180.0F, 0.0F);
                } else if (playerYaw >= 225 && playerYaw < 315) {
                    this.tileOrdnance.setRotation(270.0F, 0.0F);
                } else {
                    this.tileOrdnance.setRotation(0.0F, 0.0F);
                }
            }
        }
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side) {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean hasTileEntity(int metadata) {
        return true;
    }
    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        return new TileOrdnance();
    }
    
}
