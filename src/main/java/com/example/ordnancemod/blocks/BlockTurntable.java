package com.example.ordnancemod.blocks;

import com.example.ordnancemod.tileentities.TileTurntable;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTurntable extends Block {

    public BlockTurntable(Material material) {
        super(material);
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
        return new TileTurntable();
    }

}
