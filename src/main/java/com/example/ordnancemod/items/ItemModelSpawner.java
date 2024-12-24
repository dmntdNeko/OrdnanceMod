package com.example.ordnancemod.items;

import com.example.ordnancemod.entities.EntityModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemModelSpawner extends Item {

    public ItemModelSpawner(){
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        EntityModel model = new EntityModel(world);
        model.setPosition(x+0.5,y+1,z+0.5);
        world.spawnEntityInWorld(model);
        return super.onItemUse(stack, player, world, x, y, z, side, hitX, hitY, hitZ);
    }
}
