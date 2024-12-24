package com.example.ordnancemod.util;

import net.minecraft.util.MathHelper;

import java.util.Random;

public class TrajectoryHelper {

    private Random rand;
    public double motionX, motionY, motionZ;
    public int ticksInGround;
    public float prevRotationYaw;
    public float prevRotationPitch;
    public float rotationYaw;
    public float rotationPitch;

    public TrajectoryHelper(){
    }

    public void setTrajectory(double motX, double motY, double motZ, float speed, float inaccuracy)
    {
        float f2 = MathHelper.sqrt_double(motX * motX + motY * motY + motZ * motZ);
        motX /= (double)f2;
        motY /= (double)f2;
        motZ /= (double)f2;

        motX += this.rand.nextGaussian() * (double)(this.rand.nextBoolean() ? -1 : 1) * 0.005773502D * (double)inaccuracy;
        motY += this.rand.nextGaussian() * (double)(this.rand.nextBoolean() ? -1 : 1) * 0.005773502D * (double)inaccuracy;
        motZ += this.rand.nextGaussian() * (double)(this.rand.nextBoolean() ? -1 : 1) * 0.005773502D * (double)inaccuracy;
        motX *= (double)speed;
        motY *= (double)speed;
        motZ *= (double)speed;
        this.motionX = motX;
        this.motionY = motY;
        this.motionZ = motZ;
        float f3 = MathHelper.sqrt_double(motX * motX + motZ * motZ);
        this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(motX, motZ) * 180.0D / Math.PI);
        this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(motY, (double)f3) * 180.0D / Math.PI);
        this.ticksInGround = 0;
    }

}
