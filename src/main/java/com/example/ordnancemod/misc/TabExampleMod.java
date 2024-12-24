package com.example.ordnancemod.misc;

import com.example.ordnancemod.OrdnanceMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabExampleMod extends CreativeTabs {


    public TabExampleMod(String label) {
        super(label);
    }

    public TabExampleMod(int index, String label) {
        super(index, label);
    }

    @Override
    public Item getTabIconItem() {
        return Item.getItemFromBlock(OrdnanceMod.blockCompactScrap);
    }
}
