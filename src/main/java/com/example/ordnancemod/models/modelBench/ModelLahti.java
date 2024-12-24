package com.example.ordnancemod.models.modelBench;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLahti extends ModelSmallArm {
    private final ModelRenderer mainModel;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer cube_r3;
    private final ModelRenderer cube_r4;
    private final ModelRenderer cube_r5;
    private final ModelRenderer cube_r6;
    private final ModelRenderer cube_r7;
    private final ModelRenderer cube_r8;
    private final ModelRenderer cube_r9;
    private final ModelRenderer cube_r10;
    private final ModelRenderer cube_r11;
    private final ModelRenderer cube_r12;
    private final ModelRenderer cube_r13;
    private final ModelRenderer cube_r14;
    private final ModelRenderer cube_r15;
    private final ModelRenderer cube_r16;
    private final ModelRenderer cube_r17;
    private final ModelRenderer cube_r18;

    public ModelLahti() {
        this.yOffset = 0.11750F;
        this.scale = 0.028125F;

        textureWidth = 256;
        textureHeight = 256;

        mainModel = new ModelRenderer(this);
        mainModel.setRotationPoint(1.4317F, 17.1139F, -15.6703F);
        setRotationAngle(mainModel, 0.0F, 3.1416F, -3.1416F);
        mainModel.cubeList.add(new ModelBox(mainModel, 0, 0, -4.4317F, -5.1139F, 21.6703F, 7, 9, 26, 0.0F));
        mainModel.cubeList.add(new ModelBox(mainModel, 42, 2, 1.5683F, -2.8639F, 34.6703F, 2, 6, 12, 0.0F));
        mainModel.cubeList.add(new ModelBox(mainModel, 66, 24, 4.5683F, -7.1139F, 8.6703F, 3, 3, 1, 0.0F));
        mainModel.cubeList.add(new ModelBox(mainModel, 60, 62, 4.5683F, -7.1139F, 13.6703F, 3, 3, 1, 0.0F));
        mainModel.cubeList.add(new ModelBox(mainModel, 58, 0, 4.5683F, -8.1139F, -31.3297F, 3, 3, 4, 0.0F));
        mainModel.cubeList.add(new ModelBox(mainModel, 0, 62, -4.4317F, -7.1139F, 2.6703F, 7, 1, 15, 0.0F));
        mainModel.cubeList.add(new ModelBox(mainModel, 121, 82, -3.4317F, -14.1139F, 2.6703F, 5, 7, 15, 0.0F));
        mainModel.cubeList.add(new ModelBox(mainModel, 73, 112, -4.4317F, -6.1139F, 0.6703F, 7, 10, 21, 0.0F));
        mainModel.cubeList.add(new ModelBox(mainModel, 85, 27, -0.1418F, -7.5623F, 34.6703F, 2, 3, 12, 0.0F));
        mainModel.cubeList.add(new ModelBox(mainModel, 20, 13, -5.4317F, -3.1139F, 20.6703F, 1, 2, 2, 0.0F));
        mainModel.cubeList.add(new ModelBox(mainModel, 20, 17, -8.4317F, 2.8861F, 26.6703F, 2, 1, 1, 0.0F));
        mainModel.cubeList.add(new ModelBox(mainModel, 0, 35, -4.4317F, -6.1139F, 47.6703F, 7, 13, 3, 0.0F));
        mainModel.cubeList.add(new ModelBox(mainModel, 0, 15, -4.4317F, -6.1139F, 50.6703F, 7, 2, 6, 0.0F));
        mainModel.cubeList.add(new ModelBox(mainModel, 40, 20, -3.4317F, -8.1139F, 17.6703F, 5, 2, 3, 0.0F));
        mainModel.cubeList.add(new ModelBox(mainModel, 117, 27, -3.4317F, 3.8861F, 19.6703F, 5, 1, 22, 0.0F));
        mainModel.cubeList.add(new ModelBox(mainModel, 40, 48, -2.4317F, 4.8861F, 26.6703F, 2, 6, 3, 0.0F));
        mainModel.cubeList.add(new ModelBox(mainModel, 29, 62, -5.4317F, -5.1139F, -1.3297F, 9, 5, 2, 0.0F));
        mainModel.cubeList.add(new ModelBox(mainModel, 0, 51, -6.4317F, -5.1139F, -27.3297F, 11, 5, 2, 0.0F));
        mainModel.cubeList.add(new ModelBox(mainModel, 85, 57, -4.6817F, -5.1139F, -97.3297F, 7, 4, 17, 0.0F));
        mainModel.cubeList.add(new ModelBox(mainModel, 0, 0, -4.4317F, -6.1139F, -31.3297F, 7, 11, 4, 0.0F));
        mainModel.cubeList.add(new ModelBox(mainModel, 51, 82, 4.5683F, 14.8861F, -39.3297F, 7, 1, 26, 0.0F));
        mainModel.cubeList.add(new ModelBox(mainModel, 51, 82, -13.4317F, 14.8861F, -39.3297F, 7, 1, 26, 0.0F));

        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(5.3183F, -6.8639F, -30.5797F);
        mainModel.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, 0.0F, 0.7854F);
        cube_r1.cubeList.add(new ModelBox(cube_r1, -1, -1, 0.0F, -1.0F, 0.0F, 1, 1, 3, 0.0F));

        cube_r2 = new ModelRenderer(this);
        cube_r2.setRotationPoint(-9.9317F, 11.7345F, -10.4988F);
        mainModel.addChild(cube_r2);
        setRotationAngle(cube_r2, -2.2689F, 0.0F, 0.0F);
        cube_r2.cubeList.add(new ModelBox(cube_r2, 85, 42, -3.5F, -0.5F, -2.0F, 7, 1, 7, 0.0F));
        cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 104, 14.5F, -0.5F, -2.0F, 7, 1, 7, 0.0F));

        cube_r3 = new ModelRenderer(this);
        cube_r3.setRotationPoint(8.0683F, 11.6361F, -43.5797F);
        mainModel.addChild(cube_r3);
        setRotationAngle(cube_r3, -0.6981F, 0.0F, 0.0F);
        cube_r3.cubeList.add(new ModelBox(cube_r3, 40, 35, -3.5F, -0.5F, -6.0F, 7, 1, 12, 0.0F));
        cube_r3.cubeList.add(new ModelBox(cube_r3, 40, 48, -21.5F, -0.5F, -6.0F, 7, 1, 12, 0.0F));

        cube_r4 = new ModelRenderer(this);
        cube_r4.setRotationPoint(-6.7666F, 9.6361F, -29.3297F);
        mainModel.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.0F, 0.0F, 0.5236F);
        cube_r4.cubeList.add(new ModelBox(cube_r4, 20, 35, -0.5F, -6.0F, -1.0F, 1, 12, 2, 0.0F));

        cube_r5 = new ModelRenderer(this);
        cube_r5.setRotationPoint(2.5683F, 10.8861F, -29.3297F);
        mainModel.addChild(cube_r5);
        setRotationAngle(cube_r5, 0.0F, 0.0F, -0.5236F);
        cube_r5.cubeList.add(new ModelBox(cube_r5, 0, 62, 2.0F, -6.0F, -1.0F, 1, 12, 2, 0.0F));

        cube_r6 = new ModelRenderer(this);
        cube_r6.setRotationPoint(-5.6817F, -2.1139F, -1.3297F);
        mainModel.addChild(cube_r6);
        setRotationAngle(cube_r6, 0.0F, 0.0F, 0.7854F);
        cube_r6.cubeList.add(new ModelBox(cube_r6, 85, 27, -1.0F, -1.0F, -26.0F, 2, 2, 28, 0.0F));

        cube_r7 = new ModelRenderer(this);
        cube_r7.setRotationPoint(3.8183F, -2.1139F, -1.3297F);
        mainModel.addChild(cube_r7);
        setRotationAngle(cube_r7, 0.0F, 0.0F, 0.7854F);
        cube_r7.cubeList.add(new ModelBox(cube_r7, 89, 82, -1.0F, -1.0F, -26.0F, 2, 2, 28, 0.0F));

        cube_r8 = new ModelRenderer(this);
        cube_r8.setRotationPoint(-1.6817F, 6.8861F, 15.6703F);
        mainModel.addChild(cube_r8);
        setRotationAngle(cube_r8, 0.0F, 0.0F, 0.7854F);
        cube_r8.cubeList.add(new ModelBox(cube_r8, 0, 82, -8.5F, -9.5F, -90.0F, 4, 4, 43, 0.0F));
        cube_r8.cubeList.add(new ModelBox(cube_r8, 0, 0, -8.0F, -9.0F, -96.0F, 3, 3, 79, 0.0F));

        cube_r9 = new ModelRenderer(this);
        cube_r9.setRotationPoint(-1.4317F, 8.4322F, 22.1869F);
        mainModel.addChild(cube_r9);
        setRotationAngle(cube_r9, 0.2618F, 0.0F, 0.0F);
        cube_r9.cubeList.add(new ModelBox(cube_r9, 0, 15, -1.0F, -4.0F, 0.0F, 2, 6, 0, 0.0F));

        cube_r10 = new ModelRenderer(this);
        cube_r10.setRotationPoint(-1.4317F, 10.6261F, 24.6873F);
        mainModel.addChild(cube_r10);
        setRotationAngle(cube_r10, 1.4399F, 0.0F, 0.0F);
        cube_r10.cubeList.add(new ModelBox(cube_r10, 0, 0, -1.0F, -2.0F, 0.0F, 2, 4, 0, 0.0F));

        cube_r11 = new ModelRenderer(this);
        cube_r11.setRotationPoint(-1.4317F, 6.8861F, 15.6703F);
        mainModel.addChild(cube_r11);
        setRotationAngle(cube_r11, 0.7854F, 0.0F, 0.0F);
        cube_r11.cubeList.add(new ModelBox(cube_r11, 22, 0, -5.0F, -3.0F, 10.0F, 1, 9, 1, 0.0F));

        cube_r12 = new ModelRenderer(this);
        cube_r12.setRotationPoint(-1.4317F, 6.9676F, 15.6599F);
        mainModel.addChild(cube_r12);
        setRotationAngle(cube_r12, 0.7854F, 0.0F, 0.0F);
        cube_r12.cubeList.add(new ModelBox(cube_r12, 0, 23, -3.0F, -5.0F, 12.5F, 7, 2, 1, 0.0F));

        cube_r13 = new ModelRenderer(this);
        cube_r13.setRotationPoint(-0.9317F, -7.1139F, 2.6703F);
        mainModel.addChild(cube_r13);
        setRotationAngle(cube_r13, 0.1309F, 0.0F, 0.0F);
        cube_r13.cubeList.add(new ModelBox(cube_r13, 26, 0, -3.5F, 0.0F, -14.0F, 7, 0, 14, 0.0F));

        cube_r14 = new ModelRenderer(this);
        cube_r14.setRotationPoint(-0.9317F, -15.5535F, 9.52F);
        mainModel.addChild(cube_r14);
        setRotationAngle(cube_r14, 0.2618F, 0.0F, 0.0F);
        cube_r14.cubeList.add(new ModelBox(cube_r14, 0, 82, -2.5F, -3.5F, -7.5F, 5, 7, 15, 0.0F));

        cube_r15 = new ModelRenderer(this);
        cube_r15.setRotationPoint(3.2989F, -4.5925F, -29.3297F);
        mainModel.addChild(cube_r15);
        setRotationAngle(cube_r15, 0.0F, 0.0F, 0.829F);
        cube_r15.cubeList.add(new ModelBox(cube_r15, 40, 35, 0.5F, -3.5F, -2.0F, 2, 7, 4, 0.0F));

        cube_r16 = new ModelRenderer(this);
        cube_r16.setRotationPoint(5.0863F, -4.4129F, 9.1703F);
        mainModel.addChild(cube_r16);
        setRotationAngle(cube_r16, 0.0F, 0.0F, -0.5236F);
        cube_r16.cubeList.add(new ModelBox(cube_r16, 56, 20, -4.0F, -1.5F, -0.5F, 6, 3, 1, 0.0F));
        cube_r16.cubeList.add(new ModelBox(cube_r16, 58, 7, -4.0F, -1.5F, 4.5F, 6, 3, 1, 0.0F));

        cube_r17 = new ModelRenderer(this);
        cube_r17.setRotationPoint(5.0683F, -7.6139F, 12.1703F);
        mainModel.addChild(cube_r17);
        setRotationAngle(cube_r17, -1.5708F, 0.0F, 0.0F);
        cube_r17.cubeList.add(new ModelBox(cube_r17, 6, 62, -0.5F, -2.5F, -0.5F, 3, 6, 1, 0.0F));

        cube_r18 = new ModelRenderer(this);
        cube_r18.setRotationPoint(-2.7297F, 6.8777F, 23.6703F);
        mainModel.addChild(cube_r18);
        setRotationAngle(cube_r18, 0.0F, 0.0F, -0.3491F);
        cube_r18.cubeList.add(new ModelBox(cube_r18, 44, 62, 7.25F, -12.0F, 11.0F, 2, 5, 12, 0.0F));
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