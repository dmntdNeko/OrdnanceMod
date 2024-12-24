package com.example.ordnancemod.smallArms;

public class ItemAssaultRifle extends SmallArm {

    public ItemAssaultRifle() {
        super(new FiringMode[] { FiringMode.SAFE, FiringMode.SEMI, FiringMode.BURST, FiringMode.AUTO });
        this.minDmg = 5;
        this.maxDmg = 7;
        this.knockback = 2;
        this.maxAmmo = 30;
        //this.maxAmmo = 10;
        this.projectileSpeed = 12.5F;
        this.shotSound = "ordnancemod:intermediateShot";
        this.shotPitch = 1.0F;
        this.RTMax = 60;
        this.tickShotDelay = 2;
        this.inaccuracy = 1.0F;
        this.burstCount = 3;
        this.inaccuracyMultiplier = 2.25F;
        this.recoilMultiplier = 0.125F;
        //this.recoilMultiplier = 0.15F;
        this.setDefaults();

        this.ADSMultiplier = 0.9F;
        setUnlocalizedName("ItemAssaultRifle");
        setTextureName("ordnancemod:ItemAssaultRifle");
    }

}
