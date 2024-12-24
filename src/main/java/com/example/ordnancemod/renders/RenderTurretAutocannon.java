package com.example.ordnancemod.renders;


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderTurretAutocannon extends Render {

    private static final ResourceLocation texture = new ResourceLocation("examplemod","textures/entities/turretAutocannon.png");
    protected ModelBase modelTurretAutocannon;

    public RenderTurretAutocannon(ModelBase model, float shadowSize) {
        this.modelTurretAutocannon = model;
        this.shadowSize = shadowSize;
    }

    @Override
    public void doRender(Entity entity, double x, double y, double z, float yaw, float pitch) {
        GL11.glPushMatrix();
        GL11.glTranslated(x,y,z);
        this.bindTexture(texture);
        this.modelTurretAutocannon.render(entity,0.0F,0.0F,0.0F,0.0F,0.0F,0.1F);
        GL11.glPopMatrix();
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return texture;
    }
}
