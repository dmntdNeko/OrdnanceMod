package com.example.ordnancemod.smallArms;

public class ItemSniperRifle extends SmallArm {
    public ItemSniperRifle(){
        super(new FiringMode[] { FiringMode.SAFE, FiringMode.SEMI });
        this.minDmg = 15;
        this.maxDmg = 20;
        this.knockback = 0;
        this.maxAmmo = 6;
        this.projectileSpeed = 20.0F;
        this.shotSound = "ordnancemod:fullPowerShot";
        this.shotPitch = 0.75F;
        this.RTMax = 100;
        this.tickShotDelay = 20;
        this.inaccuracy = 0.25F;
        this.recoilMultiplier = 0.35F;
        this.setDefaults();

        //this.ADSMultiplier = 0.25F;
        this.ADSMultiplier = 0.05F;

        setUnlocalizedName("ItemSniperRifle");
        setTextureName("ordnancemod:ItemSniperRifle");
    }
}
