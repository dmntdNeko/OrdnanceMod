package com.example.ordnancemod.entities.particles;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityExplodeFX;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class EntityExplodeFXShortLife extends EntityExplodeFX {
    public EntityExplodeFXShortLife(World world, double x, double y, double z, double motx, double moty, double motz) {
        super(world, x, y, z, motx, moty, motz);
        this.motionX = this.motionY = this.motionZ = 0;
        this.particleMaxAge = 4;
        this.particleScale = 5.0F;
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

    }
}
