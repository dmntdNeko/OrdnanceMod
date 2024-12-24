package com.example.ordnancemod.models;// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelGrinder extends ModelBase {
    public final ModelRenderer blade_shaft;

    public ModelGrinder() {
        textureWidth = 64;
        textureHeight = 64;

        blade_shaft = new ModelRenderer(this);
        blade_shaft.setRotationPoint(0.0F, 6.0F, 0.0F);
        blade_shaft.cubeList.add(new ModelBox(blade_shaft, 0, 0, -12.0F, -1.0F, -1.0F, 24, 2, 2, 0.0F));
        blade_shaft.cubeList.add(new ModelBox(blade_shaft, 0, 28, 4.0F, -6.0F, -6.0F, 2, 12, 12, 0.0F));
        blade_shaft.cubeList.add(new ModelBox(blade_shaft, 16, 16, -1.0F, -6.0F, -6.0F, 2, 12, 12, 0.0F));
        blade_shaft.cubeList.add(new ModelBox(blade_shaft, 0, 4, -6.0F, -6.0F, -6.0F, 2, 12, 12, 0.0F));
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        blade_shaft.render(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}