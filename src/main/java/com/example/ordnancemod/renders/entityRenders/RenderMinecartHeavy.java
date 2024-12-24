package com.example.ordnancemod.renders.entityRenders;

import com.example.ordnancemod.entities.EntityMinecartHeavy;
import com.example.ordnancemod.models.ModelWeaponSystem;
import com.example.ordnancemod.models.entityModels.ModelMinecartHeavy;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderMinecartHeavy extends Render {


    private static final ResourceLocation texture = new ResourceLocation("ordnancemod","textures/entities/minecartHeavy.png");
    private static final ResourceLocation textureWeapon = new ResourceLocation("ordnancemod","textures/tileentities/HeavyMG.png");
    protected ModelBase modelMinecartHeavy;
    private ModelMinecartHeavy model = new ModelMinecartHeavy();
    private ModelWeaponSystem weaponModel = new ModelWeaponSystem();

    public RenderMinecartHeavy(ModelBase model, float shadowSize) {
        this.modelMinecartHeavy = model;
        this.shadowSize = shadowSize;
    }

    @Override
    public void doRender(Entity entity, double x, double y, double z, float yaw, float pitch) {
        GL11.glPushMatrix();
        GL11.glTranslated(x,y+3.0,z);
        this.bindTexture(texture);
        GL11.glRotated(Math.toDegrees(Math.PI),1.0F,0.0,0);

        /*
        if (entity.riddenByEntity!=null) {
            GL11.glRotated(-entity.riddenByEntity.rotationYaw+90, 0, 1, 0);
            GL11.glRotated(entity.riddenByEntity.rotationPitch, 0, 0, 1);
        }
        this.bindTexture(texture);
        this.modelMinecartHeavy.render(entity,0.0F,0.0F,0.0F,0.0F,0.0F,0.1F);
        GL11.glPopMatrix();
        */
        this.model.cart.render(0.1F);
        this.model.platform.render(0.1F);
        GL11.glPopMatrix();

        GL11.glPushMatrix();
        this.bindTexture(textureWeapon);
        //GL11.glTranslated(x,y+1.125,z);
        if (entity.riddenByEntity!=null) {
            EntityMinecartHeavy turret = (EntityMinecartHeavy) entity;
            GL11.glTranslated(x - (0.5 * Math.sin(Math.toRadians(entity.riddenByEntity.rotationYaw))),y+1.625,z + (0.5 * Math.cos(Math.toRadians(entity.riddenByEntity.rotationYaw))));
            float nyaw = (float) Math.toRadians(-turret.getTurretYaw()-90);
            //this.model.setRotationAngle(model.turret, (float)Math.PI, nyaw,0.0F);
            this.model.setRotationAngle(model.turret, (float)Math.PI, (float) Math.toRadians(-entity.riddenByEntity.rotationYaw-90),0.0F);
            //System.out.println("Entity yaw: "+turret.getTurretYaw());
            //this.weaponModel.setRotationAngle(weaponModel.mainModel, (float)Math.PI, (float) Math.toRadians(-entity.riddenByEntity.rotationYaw+180),0.0F);
            this.weaponModel.mainModel.rotateAngleY = (float) Math.toRadians(entity.riddenByEntity.rotationYaw);
            this.weaponModel.mainModel.setRotationPoint(0.0F,-1F,0.0F);
            this.weaponModel.setRotationAngle(weaponModel.mainModel, (float) ((float) Math.PI + Math.toRadians(-entity.riddenByEntity.rotationPitch)),(float) Math.toRadians(-entity.riddenByEntity.rotationYaw+180),0);
            this.weaponModel.render(null,0,0,0,0,0,0.025F);
        }
        //this.model.turret.render(0.1F);
        GL11.glPopMatrix();
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return texture;
    }
}
