package com.example.ordnancemod.entities.particles;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class EntityExplodeFXCustom extends EntityFX {

    private double rise;
    private double direction;

    public EntityExplodeFXCustom(World world, double x, double y, double z, double motX, double motY, double motZ) {
        super(world, x, y, z, motX, motY, motZ);
        this.motionX = motX + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.05F);
        this.motionY = motY + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.05F);
        this.motionZ = motZ + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.05F);
        //this.particleRed = this.particleGreen = this.particleBlue = this.rand.nextFloat() * 0.3F + 0.7F; //default smoke
        //this.particleRed = this.particleGreen = this.particleBlue = this.rand.nextFloat() * 0.7F + 0.3F; //weird assorted smoke
        //this.particleRed = this.particleGreen = this.particleBlue = this.rand.nextFloat() * 0.3F + 0.4F; //gray smoke
        this.particleRed = this.particleGreen = this.particleBlue = this.rand.nextFloat() * 0.2F + 0.2F; //dark smoke
        this.particleScale = (this.rand.nextFloat() * this.rand.nextFloat() * 6.0F + 1.0F) * 5;
        this.particleMaxAge = (int) (Math.abs(Math.random() + 1) * 600.0D);
        //this.rise = 0.0001D * this.particleScale;
        this.rise = 0.005D / this.particleScale;
        this.direction = (this.rand.nextBoolean() ? -1 : 1);
    }

    public EntityExplodeFXCustom(World world, double x, double y, double z, double motX, double motY, double motZ, float scale, double maxAge) {
        this(world, x, y, z, motX, motY, motZ);
        this.particleScale = (this.rand.nextFloat() * this.rand.nextFloat() * 6.0F + 1.0F) * scale;
        this.particleMaxAge = (int) (Math.abs(Math.random() + 1) * maxAge);
    }

    @Override
    public void onUpdate()
    {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        if (this.particleAge++ >= this.particleMaxAge)
        {
            this.setDead();
        }
        if (this.particleScale > 1) {
            this.particleScale *= 0.98888F;
        }

        this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
        this.motionY += this.direction * rise;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        //this.motionX *= 0.8999999761581421D;
        //this.motionY *= 0.8999999761581421D;
        //this.motionZ *= 0.8999999761581421D;
        this.motionX *= 0.96D;
        this.motionY *= 0.96D;
        this.motionZ *= 0.96D;

        if (this.onGround)
        {
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
            this.direction = 1;
            //this.motionY *= 5D;
            this.motionY *= 2.5D;
        }
    }

}
