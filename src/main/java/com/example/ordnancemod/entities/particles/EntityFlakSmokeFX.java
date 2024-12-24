package com.example.ordnancemod.entities.particles;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityExplodeFX;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class EntityFlakSmokeFX extends EntityExplodeFX {

    private double rise;
    private double direction;

    public EntityFlakSmokeFX(World world, double x, double y, double z, double motX, double motY, double motZ, float maxSize) {
        super(world, x, y, z, motX, motY, motZ);
        this.particleScale = (float) (Math.random() * maxSize + 1.0F);
        this.particleMaxAge = (int) (this.particleScale * 50);
        this.motionX = this.motionY = this.motionZ = 0;
        this.particleRed = this.particleGreen = this.particleBlue = (float)(Math.random() * 0.30000001192092896D);
        this.rise = 0.00001D * this.particleScale;
        this.direction = (this.rand.nextBoolean() ? -1 : 1);
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

        this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
        this.motionX += this.direction * rise;
        this.motionY += this.direction * rise;
        this.motionZ += this.direction * rise;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.8999999761581421D;
        this.motionY *= 0.8999999761581421D;
        this.motionZ *= 0.8999999761581421D;

        if (this.onGround)
        {
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
        }
    }
}
