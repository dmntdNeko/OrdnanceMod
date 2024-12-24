package com.example.ordnancemod.entities;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.util.*;
import net.minecraft.world.World;

import java.util.List;

public class EntityProjectile extends EntityArrow{

    private int serverPosX = -1;
    private int serverPosY = -1;
    private int serverPosZ = -1;

    public boolean inGround;
    public boolean didFirstImpact;

    private float inaccuracy;

    private Block stuckIn;
    private int stuckInData;
    private int ticksInGround;
    private int ticksInAir;
    private int ticksExisted;
    private double damage;
    private int knockback;
    private boolean doImpact;

    //private double gravity = 0.0125D;
    //private double gravity = 0.002D;

    //private double gravity = 0.025D; default 2.5 blocks/s
    //private double gravity = 0.1D; modified for faster projectiles

    private double gravity = 0.05D;

    public EntityProjectile(World world) {
        super(world);
    }

    public EntityProjectile(World world, double x, double y, double z)
    {
        super(world);
        this.renderDistanceWeight = 10.0D;
        this.setSize(0.1F, 0.1F);
        this.setPosition(x, y, z);
        this.yOffset = 0.0F;
    }

    public EntityProjectile(World world, EntityLivingBase shooter, EntityLivingBase hitEntity, float velocity, float inaccuracy)
    {
        super(world);
        this.renderDistanceWeight = 10.0D;
        this.shootingEntity = shooter;

        if (shooter instanceof EntityPlayer)
        {
            this.canBePickedUp = 1;
        }

        this.posY = shooter.posY + (double)shooter.getEyeHeight() - 0.10000000149011612D;
        double d0 = hitEntity.posX - shooter.posX;
        double d1 = hitEntity.boundingBox.minY + (double)(hitEntity.height / 3.0F) - this.posY;
        double d2 = hitEntity.posZ - shooter.posZ;
        double d3 = (double)MathHelper.sqrt_double(d0 * d0 + d2 * d2);

        if (d3 >= 1.0E-7D)
        {
            float f2 = (float)(Math.atan2(d2, d0) * 180.0D / Math.PI) - 90.0F;
            float f3 = (float)(-(Math.atan2(d1, d3) * 180.0D / Math.PI));
            double d4 = d0 / d3;
            double d5 = d2 / d3;
            this.setLocationAndAngles(shooter.posX + d4, this.posY, shooter.posZ + d5, f2, f3);
            this.yOffset = 0.0F;
            float f4 = (float)d3 * 0.2F;
            this.setThrowableHeading(d0, d1 + (double)f4, d2, velocity, inaccuracy);
        }
    }

    public EntityProjectile(World world, EntityLivingBase shooter, float projectileSpeed, float inaccuracy)
    {
        super(world);
        this.shouldDoImpact(true);
        this.renderDistanceWeight = 10.0D;
        this.shootingEntity = shooter;

        if (shooter instanceof EntityPlayer)
        {
            this.canBePickedUp = 1;
        }

        this.setSize(0.5F, 0.5F);
        this.setLocationAndAngles(shooter.posX, shooter.posY + (double)shooter.getEyeHeight(), shooter.posZ, shooter.rotationYaw, shooter.rotationPitch);
        this.posX -= (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
        this.posY -= 0.10000000149011612D;
        this.posZ -= (double)(MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.yOffset = 0.0F;
        this.motionX = (double)(-MathHelper.sin((float) Math.toRadians(this.rotationYaw)) * MathHelper.cos((float) Math.toRadians(this.rotationPitch)));
        this.motionZ = (double)(MathHelper.cos((float) Math.toRadians(this.rotationYaw)) * MathHelper.cos((float) Math.toRadians(this.rotationPitch)));
        this.motionY = (double)(-MathHelper.sin((float) Math.toRadians(this.rotationPitch)));
        this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, projectileSpeed, inaccuracy);
    }

    @Override
    public void setThrowableHeading(double motX, double motY, double motZ, float speed, float inaccuracy)
    {
        float f2 = MathHelper.sqrt_double(motX * motX + motY * motY + motZ * motZ);
        motX /= (double)f2;
        motY /= (double)f2;
        motZ /= (double)f2;

        /*
        motX += (this.rand.nextGaussian()/3) * (double)(this.rand.nextBoolean() ? -1 : 1) * 0.00281249993D  * (double)inaccuracy;
        motY += (this.rand.nextGaussian()/3) * (double)(this.rand.nextBoolean() ? -1 : 1) * 0.00281249993D * (double)inaccuracy;
        motZ += (this.rand.nextGaussian()/3) * (double)(this.rand.nextBoolean() ? -1 : 1) * 0.00281249993D * (double)inaccuracy;
        */

        //0.002886751D
        //0.005773502D
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

    @Override
    public void onUpdate()
    {
        //super.onUpdate();

        //this.gravity *= 1.05F;
        //this.gravity *= 1.025F;
        //this.gravity += 0.002D;

        if (!this.worldObj.isRemote) {
            this.ticksExisted++;
            if (this.ticksExisted >= 1800) {
                this.setDead();
            }
        }

        if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F)
        {
            float f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
            this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(this.motionY, (double)f) * 180.0D / Math.PI);
        }

        Block block = this.worldObj.getBlock(this.serverPosX, this.serverPosY, this.serverPosZ);

        if (block.getMaterial() != Material.air)
        {
            block.setBlockBoundsBasedOnState(this.worldObj, this.serverPosX, this.serverPosY, this.serverPosZ);
            AxisAlignedBB axisalignedbb = block.getCollisionBoundingBoxFromPool(this.worldObj, this.serverPosX, this.serverPosY, this.serverPosZ);

            if (axisalignedbb != null && axisalignedbb.isVecInside(Vec3.createVectorHelper(this.posX, this.posY, this.posZ)))
            {
                this.inGround = true;
            }
        }

        if (this.arrowShake > 0)
        {
            --this.arrowShake;
        }

        if (this.inGround)
        {
            int j = this.worldObj.getBlockMetadata(this.serverPosX, this.serverPosY, this.serverPosZ);

            if (!this.didFirstImpact) {
                //this.worldObj.spawnParticle("largeexplode", this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0);
                this.didFirstImpact = true;
            }


            if (block == this.stuckIn && j == this.stuckInData)
            {
                ++this.ticksInGround;

                if (this.ticksInGround == 2)
                {
                    if (!this.worldObj.isRemote) {
                        //entityBullet bullet = new entityBullet(this.worldObj, this.posX, this.posY, this.posZ);
                        //this.worldObj.spawnEntityInWorld(bullet);
                        this.spawnBullet();
                        this.setDead();
                    }
                }
            }
            else
            {
                this.inGround = false;
                this.motionX *= (double)(this.rand.nextFloat() * 0.2F);
                this.motionY *= (double)(this.rand.nextFloat() * 0.2F);
                this.motionZ *= (double)(this.rand.nextFloat() * 0.2F);
                this.ticksInGround = 0;
                this.ticksInAir = 0;
            }
        }
        else
        {
            ++this.ticksInAir;
            Vec3 vec31 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
            Vec3 vec3 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            MovingObjectPosition movingobjectposition = this.worldObj.func_147447_a(vec31, vec3, false, true, false);
            vec31 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
            vec3 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);

            if (movingobjectposition != null)
            {
                vec3 = Vec3.createVectorHelper(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
            }

            Entity entity = null;
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
            double d0 = 0.0D;
            int i;
            float f1;

            for (i = 0; i < list.size(); ++i)
            {
                Entity entity1 = (Entity)list.get(i);

                if (entity1.canBeCollidedWith() && (entity1 != this.shootingEntity || this.ticksInAir >= 5))
                {
                    f1 = 0.3F;
                    AxisAlignedBB axisalignedbb1 = entity1.boundingBox.expand((double)f1, (double)f1, (double)f1);
                    MovingObjectPosition movingobjectposition1 = axisalignedbb1.calculateIntercept(vec31, vec3);

                    if (movingobjectposition1 != null)
                    {
                        double d1 = vec31.distanceTo(movingobjectposition1.hitVec);

                        if (d1 < d0 || d0 == 0.0D)
                        {
                            entity = entity1;
                            d0 = d1;
                        }
                    }
                }
            }

            if (entity != null)
            {
                movingobjectposition = new MovingObjectPosition(entity);
            }

            if (movingobjectposition != null && movingobjectposition.entityHit != null && movingobjectposition.entityHit instanceof EntityPlayer)
            {
                EntityPlayer entityplayer = (EntityPlayer)movingobjectposition.entityHit;

                if (entityplayer.capabilities.disableDamage || this.shootingEntity instanceof EntityPlayer && !((EntityPlayer)this.shootingEntity).canAttackPlayer(entityplayer))
                {
                    movingobjectposition = null;
                }
            }

            float f2;
            float f4;

            if (movingobjectposition != null)
            {
                if (movingobjectposition.entityHit != null)
                {
                    this.doImpactEffect();
                    //f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
                    f2 = 1;
                    int k = MathHelper.ceiling_double_int((double)f2 * this.damage);

                    if (this.getIsCritical())
                    {
                        k += this.rand.nextInt(k / 2 + 2);
                    }

                    DamageSource damagesource = null;

                    if (this.shootingEntity == null)
                    {
                        damagesource = DamageSource.causeArrowDamage(this, this);
                    }
                    else
                    {
                        damagesource = DamageSource.causeArrowDamage(this, this.shootingEntity);
                    }

                    if (this.isBurning() && !(movingobjectposition.entityHit instanceof EntityEnderman))
                    {
                        movingobjectposition.entityHit.setFire(5);
                    }

                    if (movingobjectposition.entityHit.attackEntityFrom(damagesource, (float)k))
                    {
                        if (movingobjectposition.entityHit instanceof EntityLivingBase)
                        {
                            EntityLivingBase entitylivingbase = (EntityLivingBase)movingobjectposition.entityHit;
                            entitylivingbase.hurtResistantTime = entitylivingbase.hurtResistantTime/10;

                            if (!this.worldObj.isRemote)
                            {
                                entitylivingbase.setArrowCountInEntity(entitylivingbase.getArrowCountInEntity() + 1);
                            }

                            if (this.knockback > 0)
                            {
                                f4 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);

                                if (f4 > 0.0F)
                                {
                                    //movingobjectposition.entityHit.addVelocity(this.motionX * (double)this.knockback * 0.6000000238418579D / (double)f4, 0.0D, this.motionZ * (double)this.knockback * 0.6000000238418579D / (double)f4);
                                    movingobjectposition.entityHit.addVelocity((double)this.knockback * 0.6000000238418579D / (double)f4, 0.0D, (double)this.knockback * 0.6000000238418579D / (double)f4);
                                }
                            }

                            if (this.shootingEntity != null && this.shootingEntity instanceof EntityLivingBase)
                            {
                                EnchantmentHelper.func_151384_a(entitylivingbase, this.shootingEntity);
                                EnchantmentHelper.func_151385_b((EntityLivingBase)this.shootingEntity, entitylivingbase);
                            }

                            if (this.shootingEntity != null && movingobjectposition.entityHit != this.shootingEntity && movingobjectposition.entityHit instanceof EntityPlayer && this.shootingEntity instanceof EntityPlayerMP)
                            {
                                ((EntityPlayerMP)this.shootingEntity).playerNetServerHandler.sendPacket(new S2BPacketChangeGameState(6, 0.0F));
                            }
                        }

                        this.playSound(this.getHitSound(), 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));

                        if (!(movingobjectposition.entityHit instanceof EntityEnderman))
                        {
                            this.setDead();
                        }
                    }
                    else
                    {
                        //Accelerator???
                        /*this.motionX *= -0.10000000149011612D;
                        this.motionY *= -0.10000000149011612D;
                        this.motionZ *= -0.10000000149011612D;
                        this.rotationYaw += 180.0F;
                        this.prevRotationYaw += 180.0F;
                        this.ticksInAir = 0;*/
                        this.setDead();
                    }
                }
                else
                {
                    this.serverPosX = movingobjectposition.blockX;
                    this.serverPosY = movingobjectposition.blockY;
                    this.serverPosZ = movingobjectposition.blockZ;
                    this.stuckIn = this.worldObj.getBlock(this.serverPosX, this.serverPosY, this.serverPosZ);
                    this.stuckInData = this.worldObj.getBlockMetadata(this.serverPosX, this.serverPosY, this.serverPosZ);
                    this.motionX = (double)((float)(movingobjectposition.hitVec.xCoord - this.posX));
                    this.motionY = (double)((float)(movingobjectposition.hitVec.yCoord - this.posY));
                    this.motionZ = (double)((float)(movingobjectposition.hitVec.zCoord - this.posZ));
                    f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
                    this.posX -= this.motionX / (double)f2 * 0.05000000074505806D;
                    this.posY -= this.motionY / (double)f2 * 0.05000000074505806D;
                    this.posZ -= this.motionZ / (double)f2 * 0.05000000074505806D;
                    if (this.stuckIn.getMaterial() == Material.iron){
                        Float soundPitch = (this.rand.nextFloat() * 0.2F + 0.9F);
                        this.playSound("examplemod:impactMetalNear", 5.0F, 1.2F / soundPitch);
                        this.playSound("examplemod:impactMetalFar", 20.0F, 1.2F / soundPitch);
                    } else {
                        this.playSound("examplemod:HMGImpact", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
                    }
                    this.inGround = true;
                    this.arrowShake = 7;
                    this.setIsCritical(false);

                    if (this.stuckIn.getMaterial() != Material.air)
                    {
                        this.stuckIn.onEntityCollidedWithBlock(this.worldObj, this.serverPosX, this.serverPosY, this.serverPosZ, this);
                    }
                }
            }

            if (this.getIsCritical())
            {
                for (i = 0; i < 4; ++i)
                {
                    this.worldObj.spawnParticle("crit", this.posX + this.motionX * (double)i / 4.0D, this.posY + this.motionY * (double)i / 4.0D, this.posZ + this.motionZ * (double)i / 4.0D, -this.motionX, -this.motionY + 0.2D, -this.motionZ);
                }
            }

            this.posX += this.motionX;
            this.posY += this.motionY;
            this.posZ += this.motionZ;
            f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);

            for (this.rotationPitch = (float)(Math.atan2(this.motionY, (double)f2) * 180.0D / Math.PI); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F)
            {
                ;
            }

            while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
            {
                this.prevRotationPitch += 360.0F;
            }

            while (this.rotationYaw - this.prevRotationYaw < -180.0F)
            {
                this.prevRotationYaw -= 360.0F;
            }

            while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
            {
                this.prevRotationYaw += 360.0F;
            }

            this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
            this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
            float f3 = 0.99F;
            f1 = 0.05F;

            if (this.isInWater())
            {
                for (int l = 0; l < 4; ++l)
                {
                    f4 = 0.25F;
                    this.worldObj.spawnParticle("bubble", this.posX - this.motionX * (double)f4, this.posY - this.motionY * (double)f4, this.posZ - this.motionZ * (double)f4, this.motionX, this.motionY, this.motionZ);
                }

                f3 = 0.8F;
            }

            if (this.isWet())
            {
                this.extinguish();
            }

            this.motionX *= (double)f3;
            this.motionY *= (double)f3;
            this.motionZ *= (double)f3;
            this.motionY -= gravity;
            this.setPosition(this.posX, this.posY, this.posZ);
            this.func_145775_I();
        }
    }

    public void doImpactEffect() {
    }

    public void spawnBullet(){
        EntityBullet bullet = new EntityBullet(this.worldObj, this.posX, this.posY, this.posZ);
        this.worldObj.spawnEntityInWorld(bullet);
    }

    public void setInaccuracy(float inaccuracy){this.inaccuracy = inaccuracy;}
    public void setDamage(double damage) {this.damage = damage;}
    public void setGravity(double gravity) {this.gravity = gravity;}
    public void setKnockback(int knockback) {this.knockback = knockback;}
    public void shouldDoImpact(boolean should) {this.doImpact = should;}

    public int getTicksInGround() {return this.ticksInGround;}
    public boolean getInGround() {return this.inGround;}
    public String getHitSound() {return "examplemod:HMGImpact";}
}