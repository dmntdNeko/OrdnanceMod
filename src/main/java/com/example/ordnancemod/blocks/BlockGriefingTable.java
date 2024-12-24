package com.example.ordnancemod.blocks;

import net.minecraft.block.material.Material;
import com.example.ordnancemod.tileentities.TileGriefingTable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockGriefingTable extends BlockOrdnance {
    public TileGriefingTable tileGriefingTable;
    
    public BlockGriefingTable(Material material) {
        super(material);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            TileEntity tile = world.getTileEntity(x, y, z);
            if (tile instanceof TileGriefingTable) {
                TileGriefingTable griefingTable = (TileGriefingTable) tile;
                if (!player.isSneaking()) {
                    if (side == 2 || side == 3 || side == 4 || side == 5) {
                        griefingTable.incrementYaw();
                    } else if (side == 0 || side == 1) {
                        griefingTable.incrementPitch();
                    }
                } else {
                    if (side == 2 || side == 3 || side == 4 || side == 5) {
                        griefingTable.decrementYaw();
                    } else if (side == 0 || side == 1) {
                        griefingTable.decrementPitch();
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
            if (tileEntity instanceof TileGriefingTable) {
                this.tileGriefingTable = (TileGriefingTable) tileEntity;
                //this.weaponPlatform.setRotation(player.rotationYaw,0.0F);
                float playerYaw = (player.rotationYaw + 360) % 360;
                if (playerYaw >= 45 && playerYaw < 135) {
                    this.tileGriefingTable.setRotation(90.0F, 0.0F);
                } else if (playerYaw >= 135 && playerYaw < 225) {
                    this.tileGriefingTable.setRotation(180.0F, 0.0F);
                } else if (playerYaw >= 225 && playerYaw < 315) {
                    this.tileGriefingTable.setRotation(270.0F, 0.0F);
                } else {
                    this.tileGriefingTable.setRotation(0.0F, 0.0F);
                }
            }
        }
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        return new TileGriefingTable();
    }
}
