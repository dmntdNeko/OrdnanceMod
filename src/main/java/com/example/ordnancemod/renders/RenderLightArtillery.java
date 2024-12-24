package com.example.ordnancemod.renders;

import com.example.ordnancemod.models.ModelLightArtillery;
import com.example.ordnancemod.tileentities.TileOrdnance;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderLightArtillery extends TileEntitySpecialRenderer {

    private ModelLightArtillery model = new ModelLightArtillery();

    public RenderLightArtillery(){}
    private static final ResourceLocation texture = new ResourceLocation("ordnancemod","textures/tileentities/light_artillery.png");

    private void renderArtillery1(TileOrdnance lightArtillery, double x, double y, double z, float f) {
        //float barrelPitchX = (float) ((float) -Math.sin(lightArtillery.getYaw()) * Math.toRadians(lightArtillery.getPitch()));
        //float barrelPitchZ = (float) ((float) Math.cos(lightArtillery.getYaw()) * Math.toRadians(lightArtillery.getPitch()));

        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5, y, z + 0.5);
        this.bindTexture(texture);
        GL11.glRotated(0, 0, 1.0, 0.0);
        this.model.setRotationAngle(model.mainModel, (float) Math.PI, (float) Math.toRadians(lightArtillery.getYaw() + 90 + lightArtillery.rock), 0.0f);
        this.model.mainModel.render(0.1F);
        GL11.glPopMatrix();

        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5, y, z + 0.5);
        //this.model.setRotationAngle(model.barrel, barrelPitchX, (float) Math.toRadians(lightArtillery.getYaw()+90), barrelPitchZ);
        //this.model.setRotationAngle(model.barrel, (float)Math.PI, (float) Math.toRadians(lightArtillery.getYaw()+90), (float) Math.toRadians(lightArtillery.getPitch()));
        //this.model.setRotationAngle(model.barrel, (float) Math.PI, (float) Math.toRadians(lightArtillery.getYaw()+90), (float) Math.toRadians(45.0F));
        //this.model.setRotationAngle(model.barrel, (float) ((float) Math.PI+Math.toRadians(lightArtillery.getYaw()-90)), (float) -Math.toRadians(-90+Math.cos(lightArtillery.getPitch())), (float) Math.toRadians(Math.sin(lightArtillery.getPitch())));

        this.model.setRotationAngle(model.cannon, (float) Math.PI, (float) Math.toRadians(lightArtillery.getYaw() + 90 + lightArtillery.rock),0.0F);
        this.model.cannon.render(0.1F);
        GL11.glPopMatrix();
    }

    private void renderArtillery2(TileOrdnance lightArtillery, double x, double y, double z, float f) {
        float yaw = (float) Math.toRadians(lightArtillery.getYaw());
        float pitch = lightArtillery.getPitch() * yaw;
        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5, y, z + 0.5);
        this.bindTexture(texture);
        GL11.glRotated(pitch, 1.0, 0, 0);
        this.model.cannon.rotateAngleY = yaw;
        //GL11.glRotated(Math.PI,1.0,0,0);
        this.model.cannon.render(0.0625F);
        //GL11.glPopMatrix();

        //GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5, y, z + 0.5);
        //GL11.glRotated((float) Math.PI,0,1.0,0);
        this.model.mainModel.rotateAngleY = yaw;
        this.model.mainModel.render(0.0625F);
        GL11.glPopMatrix();
    }

    private void renderArtillery3(TileOrdnance lightArtillery, double x, double y, double z, float f) {
        float baseYaw = (float) (Math.toRadians(lightArtillery.getBaseYaw()));
        float yaw = (float) (Math.toRadians(lightArtillery.getYaw())) - baseYaw;
        float pitch = (float) (Math.toRadians(lightArtillery.getPitch()));
        float rock = (float) Math.toRadians(180 - lightArtillery.rock);
        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5, y-0.1875, z + 0.5);
        this.bindTexture(texture);
        this.model.base.rotateAngleY = baseYaw;
        this.model.movers.rotateAngleY = yaw;
        this.model.cannon.setRotationPoint(0.0F,-5.0F,0.0F);
        //this.model.setRotationAngle(model.cannon, pitch, 0, 0);
        this.model.cannon.rotateAngleX = pitch;
        this.model.mainModel.render(0.0625F);
        GL11.glPopMatrix();
    }


    @Override
    public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
        this.renderArtillery3((TileOrdnance) tileentity,x,y,z,f);
    }

}
