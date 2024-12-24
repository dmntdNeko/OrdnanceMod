package com.example.ordnancemod.smallArms;

public class ItemPistol extends SmallArm {
    
    public ItemPistol(){
        super(new FiringMode[] { FiringMode.SAFE, FiringMode.SEMI });
        this.minDmg = 4;
        this.maxDmg = 6;
        this.knockback = 5;
        this.maxAmmo = 12;
        this.projectileSpeed = 10;
        this.shotSound = "ordnancemod:pistolShot";
        this.shotPitch = 1.0F;
        this.RTMax = 20;
        this.tickShotDelay = 5;
        this.inaccuracy = 1.5F;
        this.recoilMultiplier = 0.4F;
        setDefaults();
        this.ADSMultiplier = 0.9F;

        setUnlocalizedName("ItemPistol");
        setTextureName("ordnancemod:ItemPistol");
    }
    
}
