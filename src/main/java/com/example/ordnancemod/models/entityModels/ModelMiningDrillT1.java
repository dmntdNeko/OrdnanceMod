package com.example.ordnancemod.models.entityModels;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMiningDrillT1 extends ModelBase {
    public final ModelRenderer drill;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer cube_r3;
    private final ModelRenderer cube_r4;
    private final ModelRenderer cube_r5;
    private final ModelRenderer cube_r6;
    private final ModelRenderer cube_r7;

    public ModelMiningDrillT1() {
        textureWidth = 128;
        textureHeight = 128;

        drill = new ModelRenderer(this);
        drill.setRotationPoint(0.0F, 8.0F, 0.0F);
        setRotationAngle(drill, 0.0F, 0.0F, -3.1416F);
        drill.cubeList.add(new ModelBox(drill, 0, 0, -0.5F, -16.0F, -0.5F, 1, 32, 1, 0.0F));
        drill.cubeList.add(new ModelBox(drill, 4, 0, 0.0F, 15.0F, -2.0F, 5, 1, 4, 0.0F));
        drill.cubeList.add(new ModelBox(drill, 22, 15, 0.0F, 11.0F, -2.0F, 5, 1, 4, 0.0F));
        drill.cubeList.add(new ModelBox(drill, 36, 35, 0.0F, 7.0F, -2.0F, 5, 1, 4, 0.0F));
        drill.cubeList.add(new ModelBox(drill, 40, 25, 0.0F, 3.0F, -2.0F, 5, 1, 4, 0.0F));
        drill.cubeList.add(new ModelBox(drill, 36, 50, 0.0F, -1.0F, -2.0F, 5, 1, 4, 0.0F));
        drill.cubeList.add(new ModelBox(drill, 54, 55, 0.0F, -5.0F, -2.0F, 5, 1, 4, 0.0F));
        drill.cubeList.add(new ModelBox(drill, 0, 60, 0.0F, -9.0F, -2.0F, 5, 1, 4, 0.0F));
        drill.cubeList.add(new ModelBox(drill, 0, 70, 0.0F, -13.0F, -2.0F, 5, 1, 4, 0.0F));

        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(0.0F, -15.5F, 0.0F);
        drill.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, 0.7854F, 0.0F);
        cube_r1.cubeList.add(new ModelBox(cube_r1, 72, 50, 0.0F, -1.0F, -2.0F, 5, 1, 4, 0.0F));
        cube_r1.cubeList.add(new ModelBox(cube_r1, 54, 65, 0.0F, 3.0F, -2.0F, 5, 1, 4, 0.0F));
        cube_r1.cubeList.add(new ModelBox(cube_r1, 58, 30, 0.0F, 7.0F, -2.0F, 5, 1, 4, 0.0F));
        cube_r1.cubeList.add(new ModelBox(cube_r1, 36, 55, 0.0F, 11.0F, -2.0F, 5, 1, 4, 0.0F));
        cube_r1.cubeList.add(new ModelBox(cube_r1, 18, 50, 0.0F, 15.0F, -2.0F, 5, 1, 4, 0.0F));
        cube_r1.cubeList.add(new ModelBox(cube_r1, 40, 20, 0.0F, 19.0F, -2.0F, 5, 1, 4, 0.0F));
        cube_r1.cubeList.add(new ModelBox(cube_r1, 18, 35, 0.0F, 23.0F, -2.0F, 5, 1, 4, 0.0F));
        cube_r1.cubeList.add(new ModelBox(cube_r1, 22, 10, 0.0F, 27.0F, -2.0F, 5, 1, 4, 0.0F));

        cube_r2 = new ModelRenderer(this);
        cube_r2.setRotationPoint(0.0F, -14.5F, 0.0F);
        drill.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, 2.3562F, 0.0F);
        cube_r2.cubeList.add(new ModelBox(cube_r2, 72, 45, 0.0F, -1.0F, -2.0F, 5, 1, 4, 0.0F));
        cube_r2.cubeList.add(new ModelBox(cube_r2, 36, 65, 0.0F, 3.0F, -2.0F, 5, 1, 4, 0.0F));
        cube_r2.cubeList.add(new ModelBox(cube_r2, 58, 25, 0.0F, 7.0F, -2.0F, 5, 1, 4, 0.0F));
        cube_r2.cubeList.add(new ModelBox(cube_r2, 18, 55, 0.0F, 11.0F, -2.0F, 5, 1, 4, 0.0F));
        cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 50, 0.0F, 15.0F, -2.0F, 5, 1, 4, 0.0F));
        cube_r2.cubeList.add(new ModelBox(cube_r2, 18, 40, 0.0F, 19.0F, -2.0F, 5, 1, 4, 0.0F));
        cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 35, 0.0F, 23.0F, -2.0F, 5, 1, 4, 0.0F));
        cube_r2.cubeList.add(new ModelBox(cube_r2, 22, 5, 0.0F, 27.0F, -2.0F, 5, 1, 4, 0.0F));

        cube_r3 = new ModelRenderer(this);
        cube_r3.setRotationPoint(0.0F, -13.5F, 0.0F);
        drill.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.0F, -2.3562F, 0.0F);
        cube_r3.cubeList.add(new ModelBox(cube_r3, 72, 40, 0.0F, -1.0F, -2.0F, 5, 1, 4, 0.0F));
        cube_r3.cubeList.add(new ModelBox(cube_r3, 18, 65, 0.0F, 3.0F, -2.0F, 5, 1, 4, 0.0F));
        cube_r3.cubeList.add(new ModelBox(cube_r3, 58, 20, 0.0F, 7.0F, -2.0F, 5, 1, 4, 0.0F));
        cube_r3.cubeList.add(new ModelBox(cube_r3, 0, 55, 0.0F, 11.0F, -2.0F, 5, 1, 4, 0.0F));
        cube_r3.cubeList.add(new ModelBox(cube_r3, 36, 45, 0.0F, 15.0F, -2.0F, 5, 1, 4, 0.0F));
        cube_r3.cubeList.add(new ModelBox(cube_r3, 40, 15, 0.0F, 19.0F, -2.0F, 5, 1, 4, 0.0F));
        cube_r3.cubeList.add(new ModelBox(cube_r3, 22, 30, 0.0F, 23.0F, -2.0F, 5, 1, 4, 0.0F));
        cube_r3.cubeList.add(new ModelBox(cube_r3, 22, 0, 0.0F, 27.0F, -2.0F, 5, 1, 4, 0.0F));

        cube_r4 = new ModelRenderer(this);
        cube_r4.setRotationPoint(0.0F, -12.5F, 0.0F);
        drill.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.0F, -0.7854F, 0.0F);
        cube_r4.cubeList.add(new ModelBox(cube_r4, 72, 35, 0.0F, -1.0F, -2.0F, 5, 1, 4, 0.0F));
        cube_r4.cubeList.add(new ModelBox(cube_r4, 0, 65, 0.0F, 3.0F, -2.0F, 5, 1, 4, 0.0F));
        cube_r4.cubeList.add(new ModelBox(cube_r4, 58, 15, 0.0F, 7.0F, -2.0F, 5, 1, 4, 0.0F));
        cube_r4.cubeList.add(new ModelBox(cube_r4, 54, 50, 0.0F, 11.0F, -2.0F, 5, 1, 4, 0.0F));
        cube_r4.cubeList.add(new ModelBox(cube_r4, 18, 45, 0.0F, 15.0F, -2.0F, 5, 1, 4, 0.0F));
        cube_r4.cubeList.add(new ModelBox(cube_r4, 40, 10, 0.0F, 19.0F, -2.0F, 5, 1, 4, 0.0F));
        cube_r4.cubeList.add(new ModelBox(cube_r4, 4, 30, 0.0F, 23.0F, -2.0F, 5, 1, 4, 0.0F));
        cube_r4.cubeList.add(new ModelBox(cube_r4, 4, 20, 0.0F, 27.0F, -2.0F, 5, 1, 4, 0.0F));

        cube_r5 = new ModelRenderer(this);
        cube_r5.setRotationPoint(0.0F, -15.5F, 0.0F);
        drill.addChild(cube_r5);
        setRotationAngle(cube_r5, 0.0F, 1.5708F, 0.0F);
        cube_r5.cubeList.add(new ModelBox(cube_r5, 54, 70, 0.0F, -0.5F, -2.0F, 5, 1, 4, 0.0F));
        cube_r5.cubeList.add(new ModelBox(cube_r5, 54, 60, 0.0F, 3.5F, -2.0F, 5, 1, 4, 0.0F));
        cube_r5.cubeList.add(new ModelBox(cube_r5, 58, 10, 0.0F, 7.5F, -2.0F, 5, 1, 4, 0.0F));
        cube_r5.cubeList.add(new ModelBox(cube_r5, 54, 45, 0.0F, 11.5F, -2.0F, 5, 1, 4, 0.0F));
        cube_r5.cubeList.add(new ModelBox(cube_r5, 0, 45, 0.0F, 15.5F, -2.0F, 5, 1, 4, 0.0F));
        cube_r5.cubeList.add(new ModelBox(cube_r5, 40, 5, 0.0F, 19.5F, -2.0F, 5, 1, 4, 0.0F));
        cube_r5.cubeList.add(new ModelBox(cube_r5, 22, 25, 0.0F, 23.5F, -2.0F, 5, 1, 4, 0.0F));
        cube_r5.cubeList.add(new ModelBox(cube_r5, 4, 15, 0.0F, 27.5F, -2.0F, 5, 1, 4, 0.0F));

        cube_r6 = new ModelRenderer(this);
        cube_r6.setRotationPoint(0.0F, -14.5F, 0.0F);
        drill.addChild(cube_r6);
        setRotationAngle(cube_r6, 0.0F, 3.1416F, 0.0F);
        cube_r6.cubeList.add(new ModelBox(cube_r6, 36, 70, 0.0F, -0.5F, -2.0F, 5, 1, 4, 0.0F));
        cube_r6.cubeList.add(new ModelBox(cube_r6, 36, 60, 0.0F, 3.5F, -2.0F, 5, 1, 4, 0.0F));
        cube_r6.cubeList.add(new ModelBox(cube_r6, 58, 5, 0.0F, 7.5F, -2.0F, 5, 1, 4, 0.0F));
        cube_r6.cubeList.add(new ModelBox(cube_r6, 54, 40, 0.0F, 11.5F, -2.0F, 5, 1, 4, 0.0F));
        cube_r6.cubeList.add(new ModelBox(cube_r6, 36, 40, 0.0F, 15.5F, -2.0F, 5, 1, 4, 0.0F));
        cube_r6.cubeList.add(new ModelBox(cube_r6, 40, 0, 0.0F, 19.5F, -2.0F, 5, 1, 4, 0.0F));
        cube_r6.cubeList.add(new ModelBox(cube_r6, 4, 25, 0.0F, 23.5F, -2.0F, 5, 1, 4, 0.0F));
        cube_r6.cubeList.add(new ModelBox(cube_r6, 4, 10, 0.0F, 27.5F, -2.0F, 5, 1, 4, 0.0F));

        cube_r7 = new ModelRenderer(this);
        cube_r7.setRotationPoint(0.0F, -13.5F, 0.0F);
        drill.addChild(cube_r7);
        setRotationAngle(cube_r7, 0.0F, -1.5708F, 0.0F);
        cube_r7.cubeList.add(new ModelBox(cube_r7, 18, 70, 0.0F, -0.5F, -2.0F, 5, 1, 4, 0.0F));
        cube_r7.cubeList.add(new ModelBox(cube_r7, 18, 60, 0.0F, 3.5F, -2.0F, 5, 1, 4, 0.0F));
        cube_r7.cubeList.add(new ModelBox(cube_r7, 58, 0, 0.0F, 7.5F, -2.0F, 5, 1, 4, 0.0F));
        cube_r7.cubeList.add(new ModelBox(cube_r7, 54, 35, 0.0F, 11.5F, -2.0F, 5, 1, 4, 0.0F));
        cube_r7.cubeList.add(new ModelBox(cube_r7, 40, 30, 0.0F, 15.5F, -2.0F, 5, 1, 4, 0.0F));
        cube_r7.cubeList.add(new ModelBox(cube_r7, 0, 40, 0.0F, 19.5F, -2.0F, 5, 1, 4, 0.0F));
        cube_r7.cubeList.add(new ModelBox(cube_r7, 22, 20, 0.0F, 23.5F, -2.0F, 5, 1, 4, 0.0F));
        cube_r7.cubeList.add(new ModelBox(cube_r7, 4, 5, 0.0F, 27.5F, -2.0F, 5, 1, 4, 0.0F));
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        drill.render(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
