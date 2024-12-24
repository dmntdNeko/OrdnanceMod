package com.example.ordnancemod.smallArms;

public class ItemBattleRifle extends SmallArm {

    public ItemBattleRifle() {
        super(new FiringMode[] { FiringMode.SAFE, FiringMode.SEMI, FiringMode.AUTO });
        this.minDmg = 8;
        this.maxDmg = 10;
        this.knockback = 1;
        this.maxAmmo = 24;
        //this.maxAmmo = 10;
        this.projectileSpeed = 15F;
        this.shotSound = "ordnancemod:fullPowerShot";
        this.shotPitch = 1.0F;
        this.RTMax = 60;
        this.tickShotDelay = 3;
        this.inaccuracy = 0.75F;
        this.inaccuracyMultiplier = 3.0F;
        this.recoilMultiplier = 0.15F;
        //this.recoilMultiplier = 0.25F;
        this.setDefaults();

        this.ADSMultiplier = 0.8F;
        setUnlocalizedName("ItemBattleRifle");
        setTextureName("ordnancemod:ItemBattleRifle");
    }

}
