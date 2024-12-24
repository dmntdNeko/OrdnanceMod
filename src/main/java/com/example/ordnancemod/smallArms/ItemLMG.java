package com.example.ordnancemod.smallArms;

import com.example.ordnancemod.skinLibrary.LMGSkins;

public class ItemLMG extends SmallArm{

    public ItemLMG() {
        super(new FiringMode[] { FiringMode.SAFE, FiringMode.PRECISION, FiringMode.SUPPRESSION});
        this.minDmg = 8;
        this.maxDmg = 10;
        this.knockback = 2;
        this.maxAmmo = 50;
        //this.maxAmmo = 250;
        this.projectileSpeed = 15.0F;
        this.shotSound = "ordnancemod:fullPowerShot";
        this.shotPitch = 1.0F;
        this.RTMax = 100;
        this.tickShotDelay = 1;
        this.inaccuracy = 1.5F;
        this.LCRMultiplier = 2;
        this.inaccuracyMultiplier = 3.0F;
        this.recoilMultiplier = 0.125F;
        this.setDefaults();

        this.ADSMultiplier = 0.95F;
        this.setSkinID(0);
        isPlaceable = true;

        setUnlocalizedName("ItemLMG");
        setTextureName("ordnancemod:ItemLMG");
        setLibrary(new LMGSkins());
        this.setLibraryName("LMG");
    }
}
