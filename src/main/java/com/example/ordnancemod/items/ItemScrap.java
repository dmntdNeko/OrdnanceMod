package com.example.ordnancemod.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class ItemScrap extends Item {

    private IIcon[] icons;

    public ItemScrap(){
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setMaxStackSize(64);
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List subItems) {
        for (int i = 0; i < icons.length; i++) {
            subItems.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        int metadata = stack.getItemDamage();
        switch (metadata) {
            case 0: return "itemScrap.iron";
            case 1: return "itemScrap.gold";
            case 2: return "itemScrap.copper";
            default: return "itemScrap";
        }
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        icons = new IIcon[3];

        icons[0] = iconRegister.registerIcon("ordnancemod:scrapIron");
        icons[1] = iconRegister.registerIcon("ordnancemod:scrapGold");
        icons[2] = iconRegister.registerIcon("ordnancemod:scrapCopper");
    }

    @Override
    public IIcon getIconFromDamage(int damage) {
        if (damage < 0 || damage >= icons.length) {
            damage = 0;
        }
        return icons[damage];
    }
}
