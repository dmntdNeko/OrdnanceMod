package com.example.ordnancemod.entities.particles;

import com.example.ordnancemod.models.particles.ModelTracer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class EntityShotFX extends EntityFX {

    float yaw;
    float pitch;

    public EntityShotFX(World world, double x, double y, double z, double motX, double motY, double motZ) {
        super(world, x, y, z, motX, motY, motZ);
        this.motionX = motX + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.05F);
        this.motionY = motY + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.05F);
        this.motionZ = motZ + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.05F);
        //this.particleRed = this.particleGreen = this.particleBlue = this.rand.nextFloat() * 0.3F + 0.7F; //default smoke
        //this.particleRed = this.particleGreen = this.particleBlue = this.rand.nextFloat() * 0.7F + 0.3F; //weird assorted smoke
        this.particleRed = this.particleGreen = this.particleBlue = this.rand.nextFloat() * 0.3F + 0.4F; //gray smoke
        this.particleScale = (this.rand.nextFloat() * this.rand.nextFloat() * 6.0F + 1.0F) * 5;
        this.particleMaxAge = 20;
        //this.rise = 0.0001D * this.particleScale;
    }

    public EntityShotFX(World world, double x, double y, double z, double motX, double motY, double motZ, float yaw, float pitch) {
        this(world, x, y, z, motX, motY, motZ);
        this.yaw = yaw;
        this.pitch = pitch;
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

        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        //this.motionX *= 0.8999999761581421D;
        //this.motionY *= 0.8999999761581421D;
        //this.motionZ *= 0.8999999761581421D;

        if (this.onGround)
        {
            this.setDead();
        }
    }

    @Override
    public void renderParticle(Tessellator tessellator, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ) {
        GL11.glPushMatrix();

        tessellator.draw();
        // Move to the particle's position
        GL11.glTranslatef((float)(this.prevPosX + (this.posX - this.prevPosX) * (double)partialTicks - interpPosX),
                (float)(this.prevPosY + (this.posY - this.prevPosY) * (double)partialTicks - interpPosY),
                (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * (double)partialTicks - interpPosZ));

        ModelTracer model = new ModelTracer();  // Replace with your custom model
        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("examplemod:textures/entities/tracer.png"));
        GL11.glDisable(GL11.GL_LIGHTING);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,240f,240f);

        GL11.glScalef(0.1F, 0.1F, 0.1F);  // Scale the model down
        model.modelMain.rotateAngleY = (float) Math.toRadians(-yaw);
        model.modelMain.rotateAngleX = (float) Math.toRadians(pitch);
        //model.render(null, 0, 0, 0, 0, 0, 1.0F);
        model.render(null, 0, 0, 0, 0, 0, 0.0625F);

        tessellator.startDrawingQuads();

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }

}

