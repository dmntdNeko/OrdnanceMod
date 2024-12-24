package com.example.ordnancemod.models;

// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWeaponSystem extends ModelBase {
    public final ModelRenderer mainModel;
    public final ModelRenderer mainbody;
    public final ModelRenderer barrel;
    public final ModelRenderer ammobox;

    public ModelWeaponSystem() {
        textureWidth = 128;
        textureHeight = 128;

        mainModel = new ModelRenderer(this);
        mainModel.setRotationPoint(0.0F, 16.0F, 0.0F);
        setRotationAngle(mainModel, 0.0F, 0.0F, -3.1416F);


        mainbody = new ModelRenderer(this);
        //mainbody.setRotationPoint(5.0F, 6.0F, -6.0F);
        mainbody.setRotationPoint(5.5F, 6.0F, -6.0F);
        mainModel.addChild(mainbody);
        mainbody.cubeList.add(new ModelBox(mainbody, 37, 48, -11.0F, -6.0F, -3.0F, 11, 9, 23, 0.0F));
        mainbody.cubeList.add(new ModelBox(mainbody, 51, 0, -11.0F, -10.0F, 8.0F, 11, 2, 10, 0.0F));
        mainbody.cubeList.add(new ModelBox(mainbody, 51, 38, -11.0F, -8.0F, 8.0F, 11, 2, 2, 0.0F));
        mainbody.cubeList.add(new ModelBox(mainbody, 0, 37, -11.0F, -9.0F, 18.0F, 11, 3, 2, 0.0F));
        mainbody.cubeList.add(new ModelBox(mainbody, 23, 24, -5.0F, -13.0F, 1.0F, 1, 7, 1, 0.0F));
        mainbody.cubeList.add(new ModelBox(mainbody, 4, 24, -7.0F, -13.0F, 1.0F, 1, 7, 1, 0.0F));
        mainbody.cubeList.add(new ModelBox(mainbody, 0, 19, -6.0F, -13.0F, 1.0F, 1, 1, 1, 0.0F));
        mainbody.cubeList.add(new ModelBox(mainbody, 23, 19, -2.0F, 1.0F, -7.0F, 1, 1, 4, 0.0F));
        mainbody.cubeList.add(new ModelBox(mainbody, 0, 19, -10.0F, 1.0F, -7.0F, 1, 1, 4, 0.0F));
        mainbody.cubeList.add(new ModelBox(mainbody, 0, 24, -2.0F, -5.0F, -7.0F, 1, 7, 1, 0.0F));
        mainbody.cubeList.add(new ModelBox(mainbody, 9, 23, -10.0F, -5.0F, -7.0F, 1, 7, 1, 0.0F));

        barrel = new ModelRenderer(this);
        barrel.setRotationPoint(5.0F, 8.0F, -13.0F);
        mainModel.addChild(barrel);
        barrel.cubeList.add(new ModelBox(barrel, 51, 12, -10.0F, -10.0F, 27.0F, 9, 9, 5, 0.0F));
        barrel.cubeList.add(new ModelBox(barrel, 0, 64, -9.0F, -9.0F, 32.0F, 7, 7, 5, 0.0F));
        barrel.cubeList.add(new ModelBox(barrel, 0, 19, -8.0F, -8.0F, 37.0F, 5, 5, 13, 0.0F));
        barrel.cubeList.add(new ModelBox(barrel, 0, 0, -7.0F, -7.0F, 33.0F, 3, 3, 45, 0.0F));
        barrel.cubeList.add(new ModelBox(barrel, 51, 26, -8.0F, -8.0F, 78.0F, 5, 5, 7, 0.0F));
        barrel.cubeList.add(new ModelBox(barrel, 0, 48, -7.0F, -4.0F, 27.0F, 3, 4, 12, 0.0F));
        barrel.cubeList.add(new ModelBox(barrel, 0, 48, -6.0F, -3.0F, 32.0F, 1, 1, 35, 0.0F));
        barrel.cubeList.add(new ModelBox(barrel, 0, 6, -8.0F, -8.0F, 64.0F, 5, 5, 1, 0.0F));
        barrel.cubeList.add(new ModelBox(barrel, 0, 0, -8.0F, -8.0F, 55.0F, 5, 5, 1, 0.0F));
        barrel.cubeList.add(new ModelBox(barrel, 26, 3, -7.0F, -3.0F, 64.0F, 3, 2, 1, 0.0F));
        barrel.cubeList.add(new ModelBox(barrel, 26, 0, -7.0F, -3.0F, 55.0F, 3, 2, 1, 0.0F));

        ammobox = new ModelRenderer(this);
        ammobox.setRotationPoint(5.0F, 6.0F, -6.0F);
        mainModel.addChild(ammobox);
        ammobox.cubeList.add(new ModelBox(ammobox, 0, 0, -18.0F, -3.0F, 8.0F, 7, 7, 12, 0.0F));
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