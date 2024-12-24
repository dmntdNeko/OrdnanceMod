package com.example.ordnancemod.smallArms;

import com.example.ordnancemod.skinLibrary.LahtiSkins;

public class ItemLahti extends SmallArm{
    public ItemLahti() {
        super(new FiringMode[] { FiringMode.SAFE, FiringMode.SEMI});
        this.minDmg = 100;
        this.maxDmg = 150;
        this.knockback = 0;
        this.maxAmmo = 10;
        this.projectileSpeed = 25.0F;
        this.shotSound = "ordnancemod:autocannon";
        this.shotPitch = 1.0F;
        this.RTMax = 150;
        this.tickShotDelay = 100;
        this.inaccuracy = 3.0F;
        this.recoilMultiplier = 0.8F;
        this.setDefaults();

        this.setSkinID(0);
        isPlaceable = true;

        setUnlocalizedName("ItemLahti");
        setTextureName("ordnancemod:ItemLMG");
        setLibrary(new LahtiSkins());
        this.setLibraryName("lahti");
    }
}
