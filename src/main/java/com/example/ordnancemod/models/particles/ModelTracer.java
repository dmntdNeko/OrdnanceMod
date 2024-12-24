package com.example.ordnancemod.models.particles;// Made with Blockbench 4.11.1
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTracer extends ModelBase {
    public final ModelRenderer modelMain;

    public ModelTracer() {
        textureWidth = 64;
        textureHeight = 64;

        modelMain = new ModelRenderer(this);
        modelMain.setRotationPoint(0.0F, 24.0F, 0.0F);
        modelMain.cubeList.add(new ModelBox(modelMain, 0, 0, -2.0F, -4.0F, -12.0F, 4, 4, 24, 0.0F));
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        modelMain.render(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}