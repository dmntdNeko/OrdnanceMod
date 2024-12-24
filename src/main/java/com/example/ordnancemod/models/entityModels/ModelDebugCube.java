package com.example.ordnancemod.models.entityModels;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDebugCube extends ModelBase {
    public final ModelRenderer mainModel;

    public ModelDebugCube() {
        textureWidth = 64;
        textureHeight = 64;

        mainModel = new ModelRenderer(this);
        mainModel.setRotationPoint(0.0F, 16.0F, 0.0F);
        setRotationAngle(mainModel, 0.0F, 0.0F, -3.1416F);
        mainModel.cubeList.add(new ModelBox(mainModel, 0, 0, -8.0F, -8.0F, -8.0F, 16, 16, 16, 0.0F));
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        mainModel.render(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
