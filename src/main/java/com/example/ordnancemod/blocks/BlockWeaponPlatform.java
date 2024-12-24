package com.example.ordnancemod.blocks;


import com.example.ordnancemod.entities.EntityTurretMount;
import com.example.ordnancemod.tileentities.TileWeaponPlatform;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.List;

public class BlockWeaponPlatform extends Block {

    public TileWeaponPlatform weaponPlatform;

    public BlockWeaponPlatform(Material material) {
        super(material);
        setLightOpacity(0);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            TileEntity tile = world.getTileEntity(x, y, z);
            if (tile instanceof TileWeaponPlatform) {
                TileWeaponPlatform WeaponPlatform = (TileWeaponPlatform) tile;
                return mountSystem(world, x, y, z, player);
            }
        }
        return false;
    }

    public boolean mountSystem(World world, int x, int y, int z, EntityPlayer player) {
        if (world.isRemote) {
            return true;
        } else {
            List<Entity> list = world.getEntitiesWithinAABB(Entity.class, AxisAlignedBB.getBoundingBox(x,y,z,x+1,y+1,z+1));
            Iterator line = list.iterator();

            Entity entity;
            do {
                if (!line.hasNext()) {
                    EntityTurretMount mount = new EntityTurretMount(world);
                    mount.setPosition((float) x + 0.5, (float) y, (float) z + 0.5);
                    player.mountEntity(mount);
                    world.spawnEntityInWorld(mount);
                    player.mountEntity(mount);
                    return true;
                }
                entity = (Entity) line.next();
            } while (!(entity instanceof EntityTurretMount));
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
            if (tileEntity instanceof TileWeaponPlatform) {
                this.weaponPlatform = (TileWeaponPlatform) tileEntity;
                //this.weaponPlatform.setRotation(player.rotationYaw,0.0F);
                float playerYaw = player.rotationYaw;
                if (playerYaw <= 45 && playerYaw >= -45) {
                    this.weaponPlatform.setRotation(0.0F, 0.0F);
                } else if (playerYaw > 45 && playerYaw <= 135) {
                    this.weaponPlatform.setRotation(90.0F, 0.0F);
                } else if (playerYaw < -45 && playerYaw >= -135) {
                    this.weaponPlatform.setRotation(-90.0F, 0.0F);
                }else if (playerYaw > 135 || playerYaw < -135) {
                    this.weaponPlatform.setRotation(180.0F, 0.0F);
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
        return new TileWeaponPlatform();
    }


}
