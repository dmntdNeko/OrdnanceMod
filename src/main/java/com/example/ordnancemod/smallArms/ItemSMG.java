package com.example.ordnancemod.smallArms;

public class ItemSMG extends SmallArm {

    public ItemSMG() {
        super(new FiringMode[]{FiringMode.SAFE, FiringMode.PRECISION, FiringMode.SUPPRESSION});
        this.minDmg = 4;
        this.maxDmg = 6;
        this.knockback = 4;
        this.maxAmmo = 35;
        this.projectileSpeed = 10.0F;
        this.shotSound = "ordnancemod:pistolShot";
        this.shotPitch = 0.8F;
        this.RTMax = 20;
        this.tickShotDelay = 1;
        this.inaccuracy = 2.0F;
        this.LCRMultiplier = 3;
        this.inaccuracyMultiplier = 4.0F;
        this.recoilMultiplier = 0.15F;
        setDefaults();

        setUnlocalizedName("ItemSMG");
        setTextureName("ordnancemod:ItemSMG");
    }
}
