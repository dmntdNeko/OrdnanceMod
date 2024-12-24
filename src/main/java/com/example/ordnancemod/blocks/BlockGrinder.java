package com.example.ordnancemod.blocks;

import com.example.ordnancemod.tileentities.TileGrinder;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGrinder extends BlockContainer {

    public BlockGrinder(Material material) {
        super(material);
        setLightOpacity(0);
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
    public boolean hasTileEntity(int metadata) {return true;}

    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        return new TileGrinder();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity instanceof TileGrinder) {
            TileGrinder grinder = (TileGrinder)tileEntity;
            ItemStack heldItem = player.getHeldItem();
            if (heldItem != null && heldItem.getItem() == Item.getItemFromBlock(Blocks.sand)) {
                if (grinder.addItem(heldItem)) {
                    if (!player.capabilities.isCreativeMode) {
                        heldItem.stackSize--;
                        if (heldItem.stackSize <= 0) {
                            player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                        }
                    }
                } return true;
            } else {
                System.out.println(grinder.getStackInSlot(0).getItem()+": "+grinder.getStackInSlot(0).stackSize);
            }
        }
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileGrinder();
    }
}
