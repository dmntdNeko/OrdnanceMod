package com.example.ordnancemod.models.modelBench;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMG42 extends ModelSmallArm {

    private final ModelRenderer MainModel;
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
    private final ModelRenderer cube_r19;
    private final ModelRenderer cube_r20;
    private final ModelRenderer cube_r21;
    private final ModelRenderer cube_r22;
    private final ModelRenderer cube_r23;
    private final ModelRenderer cube_r24;
    private final ModelRenderer cube_r25;
    private final ModelRenderer cube_r26;
    private final ModelRenderer cube_r27;
    private final ModelRenderer cube_r28;
    private final ModelRenderer cube_r29;
    private final ModelRenderer cube_r30;
    private final ModelRenderer cube_r31;
    private final ModelRenderer cube_r32;
    private final ModelRenderer cube_r33;
    private final ModelRenderer cube_r34;
    private final ModelRenderer cube_r35;

    public ModelMG42() {
        this.yOffset = 0.3125F;
        this.scale = 0.028125F;

        textureWidth = 256;
        textureHeight = 256;

        MainModel = new ModelRenderer(this);
        MainModel.setRotationPoint(-1.3234F, 19.3978F, 14.7861F);


        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(0.758F, -5.4495F, 1.0312F);
        MainModel.addChild(cube_r1);
        setRotationAngle(cube_r1, -0.3054F, 0.0F, 3.1416F);
        cube_r1.cubeList.add(new ModelBox(cube_r1, 32, 41, 0.0155F, 1.6993F, -20.8747F, 1, 7, 1, 0.0F));
        cube_r1.cubeList.add(new ModelBox(cube_r1, 11, 60, 1.1405F, 1.6993F, -20.8747F, 1, 7, 1, 0.0F));
        cube_r1.cubeList.add(new ModelBox(cube_r1, 42, 57, 0.0655F, 1.5489F, -21.3979F, 2, 7, 2, 0.0F));

        cube_r2 = new ModelRenderer(this);
        cube_r2.setRotationPoint(0.758F, -5.4495F, 1.0312F);
        MainModel.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, 0.0F, -3.1416F);
        cube_r2.cubeList.add(new ModelBox(cube_r2, 20, 12, 6.0655F, 10.0516F, 36.6827F, 2, 1, 2, 0.0F));
        cube_r2.cubeList.add(new ModelBox(cube_r2, 61, 7, -5.9345F, 10.0516F, 36.6827F, 2, 1, 2, 0.0F));
        cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 12, 0.5655F, -4.9484F, 36.6827F, 1, 2, 2, 0.0F));
        cube_r2.cubeList.add(new ModelBox(cube_r2, 14, 41, -1.4345F, -8.9484F, -3.8173F, 5, 1, 2, 0.0F));
        cube_r2.cubeList.add(new ModelBox(cube_r2, 52, 0, -3.4345F, -8.9484F, -12.8173F, 2, 1, 5, 0.0F));
        cube_r2.cubeList.add(new ModelBox(cube_r2, 47, 23, -0.4595F, -7.9484F, -40.8173F, 3, 6, 3, 0.0F));
        cube_r2.cubeList.add(new ModelBox(cube_r2, 42, 41, -0.9345F, -7.9484F, -37.8173F, 4, 4, 5, 0.0F));
        cube_r2.cubeList.add(new ModelBox(cube_r2, 20, 16, 0.0655F, -10.1984F, -0.8173F, 2, 1, 1, 0.0F));
        cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 50, 0.5655F, -8.1234F, 36.1827F, 1, 1, 6, 0.0F));
        cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 41, -1.4345F, -8.9484F, -13.8173F, 3, 1, 7, 0.0F));
        cube_r2.cubeList.add(new ModelBox(cube_r2, 83, 0, -0.4345F, -4.9234F, 4.1827F, 3, 0, 36, 0.0F));
        cube_r2.cubeList.add(new ModelBox(cube_r2, 60, 53, 3.3155F, -8.1984F, -9.3173F, 1, 1, 3, 0.0F));
        cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 58, -0.4345F, -7.9234F, 2.1827F, 3, 3, 2, 0.0F));
        cube_r2.cubeList.add(new ModelBox(cube_r2, 42, 51, -1.4345F, -9.9484F, -6.8173F, 5, 2, 3, 0.0F));
        cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 12, -2.4345F, -9.9484F, -13.8173F, 6, 1, 7, 0.0F));
        cube_r2.cubeList.add(new ModelBox(cube_r2, 16, 45, -1.4345F, -9.9484F, -18.8173F, 5, 2, 5, 0.0F));
        cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 0, -1.4095F, -7.9484F, -32.8173F, 5, 4, 36, 0.0F));

        cube_r3 = new ModelRenderer(this);
        cube_r3.setRotationPoint(0.758F, -5.4495F, 1.0312F);
        MainModel.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.0F, 0.7854F, -3.1416F);
        cube_r3.cubeList.add(new ModelBox(cube_r3, 0, 50, -26.3923F, -2.9484F, 26.8991F, 1, 2, 1, 0.0F));

        cube_r4 = new ModelRenderer(this);
        cube_r4.setRotationPoint(0.758F, -5.4495F, 1.0312F);
        MainModel.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.0F, 0.0F, -2.7925F);
        cube_r4.cubeList.add(new ModelBox(cube_r4, 30, 0, -1.3274F, -4.3766F, 37.1827F, 1, 16, 1, 0.0F));

        cube_r5 = new ModelRenderer(this);
        cube_r5.setRotationPoint(0.758F, -5.4495F, 1.0312F);
        MainModel.addChild(cube_r5);
        setRotationAngle(cube_r5, 0.0F, 0.0F, 2.7925F);
        cube_r5.cubeList.add(new ModelBox(cube_r5, 47, 0, 2.3482F, -3.6411F, 37.1827F, 1, 16, 1, 0.0F));

        cube_r6 = new ModelRenderer(this);
        cube_r6.setRotationPoint(0.758F, -5.4495F, 1.0312F);
        MainModel.addChild(cube_r6);
        setRotationAngle(cube_r6, 0.5672F, 0.0F, 3.1416F);
        cube_r6.cubeList.add(new ModelBox(cube_r6, 0, 33, -1.9345F, -10.1745F, 1.4337F, 6, 1, 1, 0.0F));

        cube_r7 = new ModelRenderer(this);
        cube_r7.setRotationPoint(0.758F, -5.4495F, 1.0312F);
        MainModel.addChild(cube_r7);
        setRotationAngle(cube_r7, -0.1151F, 0.1903F, 2.3486F);
        cube_r7.cubeList.add(new ModelBox(cube_r7, 47, 13, 0.66F, -10.0369F, -13.2612F, 1, 4, 5, 0.0F));

        cube_r8 = new ModelRenderer(this);
        cube_r8.setRotationPoint(0.758F, -5.4495F, 1.0312F);
        MainModel.addChild(cube_r8);
        setRotationAngle(cube_r8, 0.0628F, 0.1923F, -2.3461F);
        cube_r8.cubeList.add(new ModelBox(cube_r8, 22, 16, -9.8022F, -4.0306F, -14.2037F, 1, 4, 5, 0.0F));

        cube_r9 = new ModelRenderer(this);
        cube_r9.setRotationPoint(0.758F, -5.4495F, 1.0312F);
        MainModel.addChild(cube_r9);
        setRotationAngle(cube_r9, 0.0618F, 0.0617F, -2.3543F);
        cube_r9.cubeList.add(new ModelBox(cube_r9, 0, 21, -10.9921F, -4.5163F, -13.1645F, 5, 5, 6, 0.0F));

        cube_r10 = new ModelRenderer(this);
        cube_r10.setRotationPoint(0.758F, -5.4495F, 1.0312F);
        MainModel.addChild(cube_r10);
        setRotationAngle(cube_r10, 0.0F, 0.0873F, -3.1416F);
        cube_r10.cubeList.add(new ModelBox(cube_r10, 55, 13, -5.2352F, -8.9484F, -13.9021F, 5, 2, 1, 0.0F));

        cube_r11 = new ModelRenderer(this);
        cube_r11.setRotationPoint(0.758F, -5.4495F, 1.0312F);
        MainModel.addChild(cube_r11);
        setRotationAngle(cube_r11, -1.2217F, 0.0F, -3.1416F);
        cube_r11.cubeList.add(new ModelBox(cube_r11, 56, 41, -0.4345F, 35.1119F, -15.8849F, 3, 3, 1, 0.0F));

        cube_r12 = new ModelRenderer(this);
        cube_r12.setRotationPoint(0.758F, -5.4495F, 1.0312F);
        MainModel.addChild(cube_r12);
        setRotationAngle(cube_r12, 0.9599F, 0.0F, 3.1416F);
        cube_r12.cubeList.add(new ModelBox(cube_r12, 51, 57, -0.4345F, -38.3423F, -17.4258F, 3, 4, 2, 0.0F));

        cube_r13 = new ModelRenderer(this);
        cube_r13.setRotationPoint(0.758F, -5.4495F, 1.0312F);
        MainModel.addChild(cube_r13);
        setRotationAngle(cube_r13, 0.1745F, 0.0F, 3.1416F);
        cube_r13.cubeList.add(new ModelBox(cube_r13, 15, 53, -0.4095F, -16.2045F, -41.0198F, 3, 4, 3, 0.0F));

        cube_r14 = new ModelRenderer(this);
        cube_r14.setRotationPoint(0.758F, -5.4495F, 1.0312F);
        MainModel.addChild(cube_r14);
        setRotationAngle(cube_r14, -0.0873F, 0.0F, -3.1416F);
        cube_r14.cubeList.add(new ModelBox(cube_r14, 28, 53, -0.4345F, -2.3835F, -42.8318F, 3, 5, 2, 0.0F));
        cube_r14.cubeList.add(new ModelBox(cube_r14, 17, 27, -0.4345F, -8.2756F, -3.5862F, 3, 1, 6, 0.0F));

        cube_r15 = new ModelRenderer(this);
        cube_r15.setRotationPoint(0.758F, -5.4495F, 1.0312F);
        MainModel.addChild(cube_r15);
        setRotationAngle(cube_r15, 0.0F, 0.0F, -1.5708F);
        cube_r15.cubeList.add(new ModelBox(cube_r15, 42, 41, -7.9234F, 0.4345F, 4.1827F, 3, 0, 36, 0.0F));

        cube_r16 = new ModelRenderer(this);
        cube_r16.setRotationPoint(0.758F, -5.4495F, 1.0312F);
        MainModel.addChild(cube_r16);
        setRotationAngle(cube_r16, 0.0F, 0.0F, 0.0F);
        cube_r16.cubeList.add(new ModelBox(cube_r16, 45, 78, -2.5655F, 7.9234F, 4.1827F, 3, 0, 36, 0.0F));

        cube_r17 = new ModelRenderer(this);
        cube_r17.setRotationPoint(0.758F, -5.4495F, 1.0312F);
        MainModel.addChild(cube_r17);
        setRotationAngle(cube_r17, 0.0F, 0.0F, 1.5708F);
        cube_r17.cubeList.add(new ModelBox(cube_r17, 0, 82, 4.9234F, 2.5655F, 4.1827F, 3, 0, 36, 0.0F));

        cube_r18 = new ModelRenderer(this);
        cube_r18.setRotationPoint(0.758F, -5.4495F, 1.0312F);
        MainModel.addChild(cube_r18);
        setRotationAngle(cube_r18, 0.0F, 0.0F, -2.7489F);
        cube_r18.cubeList.add(new ModelBox(cube_r18, 3, 17, -3.0916F, -10.8475F, -0.1994F, 1, 1, 0, 0.0F));

        cube_r19 = new ModelRenderer(this);
        cube_r19.setRotationPoint(0.758F, -5.4495F, 1.0312F);
        MainModel.addChild(cube_r19);
        setRotationAngle(cube_r19, -1.0409F, 0.7119F, 2.329F);
        cube_r19.cubeList.add(new ModelBox(cube_r19, 27, 0, -19.9234F, -33.8245F, 11.9979F, 1, 1, 0, 0.0F));

        cube_r20 = new ModelRenderer(this);
        cube_r20.setRotationPoint(0.758F, -5.4495F, 1.0312F);
        MainModel.addChild(cube_r20);
        setRotationAngle(cube_r20, -0.5299F, 0.7119F, 2.7761F);
        cube_r20.cubeList.add(new ModelBox(cube_r20, 30, 26, -22.5486F, -24.2321F, 23.0553F, 1, 3, 1, 0.0F));

        cube_r21 = new ModelRenderer(this);
        cube_r21.setRotationPoint(0.758F, -5.4495F, 1.0312F);
        MainModel.addChild(cube_r21);
        setRotationAngle(cube_r21, 1.0409F, -0.7119F, 1.5436F);
        cube_r21.cubeList.add(new ModelBox(cube_r21, 0, 17, 32.7806F, 20.0328F, 10.179F, 1, 1, 0, 0.0F));

        cube_r22 = new ModelRenderer(this);
        cube_r22.setRotationPoint(0.758F, -5.4495F, 1.0312F);
        MainModel.addChild(cube_r22);
        setRotationAngle(cube_r22, 0.0F, -0.6545F, 3.1416F);
        cube_r22.cubeList.add(new ModelBox(cube_r22, 0, 41, -10.3429F, -9.9484F, -11.4799F, 1, 1, 2, 0.0F));

        cube_r23 = new ModelRenderer(this);
        cube_r23.setRotationPoint(0.758F, -5.4495F, 1.0312F);
        MainModel.addChild(cube_r23);
        setRotationAngle(cube_r23, 2.3562F, 0.0F, 3.1416F);
        cube_r23.cubeList.add(new ModelBox(cube_r23, 52, 0, 0.5655F, -12.4843F, 12.1363F, 1, 2, 1, 0.0F));

        cube_r24 = new ModelRenderer(this);
        cube_r24.setRotationPoint(0.758F, -5.4495F, 1.0312F);
        MainModel.addChild(cube_r24);
        setRotationAngle(cube_r24, -1.5708F, 0.0F, 3.1416F);
        cube_r24.cubeList.add(new ModelBox(cube_r24, 42, 41, 0.5655F, 17.4094F, -0.7539F, 1, 3, 1, 0.0F));
        cube_r24.cubeList.add(new ModelBox(cube_r24, 20, 0, 0.0655F, 13.4952F, -4.1681F, 2, 6, 1, 0.0F));
        cube_r24.cubeList.add(new ModelBox(cube_r24, 25, 61, 0.0655F, 20.9782F, 1.7188F, 2, 2, 2, 0.0F));
        cube_r24.cubeList.add(new ModelBox(cube_r24, 0, 0, 0.0655F, 20.4952F, -4.1681F, 2, 5, 2, 0.0F));

        cube_r25 = new ModelRenderer(this);
        cube_r25.setRotationPoint(0.758F, -5.4495F, 1.0312F);
        MainModel.addChild(cube_r25);
        setRotationAngle(cube_r25, -3.1416F, 0.0F, 3.1416F);
        cube_r25.cubeList.add(new ModelBox(cube_r25, 34, 61, 0.5655F, 1.1681F, 15.9952F, 1, 2, 1, 0.0F));

        cube_r26 = new ModelRenderer(this);
        cube_r26.setRotationPoint(0.758F, -5.4495F, 1.0312F);
        MainModel.addChild(cube_r26);
        setRotationAngle(cube_r26, 0.0F, -0.6981F, -3.098F);
        cube_r26.cubeList.add(new ModelBox(cube_r26, 17, 21, 3.3376F, -8.157F, -2.0958F, 1, 3, 1, 0.0F));

        cube_r27 = new ModelRenderer(this);
        cube_r27.setRotationPoint(0.758F, -5.4495F, 1.0312F);
        MainModel.addChild(cube_r27);
        setRotationAngle(cube_r27, 0.0F, -0.1745F, 3.1416F);
        cube_r27.cubeList.add(new ModelBox(cube_r27, 56, 29, 3.153F, -7.4484F, 0.6759F, 1, 2, 4, 0.0F));

        cube_r28 = new ModelRenderer(this);
        cube_r28.setRotationPoint(0.758F, -5.4495F, 1.0312F);
        MainModel.addChild(cube_r28);
        setRotationAngle(cube_r28, 0.7854F, 0.0F, -3.1416F);
        cube_r28.cubeList.add(new ModelBox(cube_r28, 60, 17, -0.9345F, -4.8294F, 6.7395F, 4, 1, 1, 0.0F));
        cube_r28.cubeList.add(new ModelBox(cube_r28, 60, 26, -0.9345F, -7.3043F, 4.9717F, 4, 1, 1, 0.0F));

        cube_r29 = new ModelRenderer(this);
        cube_r29.setRotationPoint(0.758F, -5.4495F, 1.0312F);
        MainModel.addChild(cube_r29);
        setRotationAngle(cube_r29, 0.0F, 0.0F, 2.3562F);
        cube_r29.cubeList.add(new ModelBox(cube_r29, 57, 20, 4.2954F, -4.7886F, 40.1827F, 2, 2, 3, 0.0F));
        cube_r29.cubeList.add(new ModelBox(cube_r29, 0, 41, 4.8257F, -4.3189F, 5.6827F, 1, 1, 39, 0.0F));
        cube_r29.cubeList.add(new ModelBox(cube_r29, 9, 51, 4.3131F, -4.8063F, 3.6827F, 2, 2, 2, 0.0F));

        cube_r30 = new ModelRenderer(this);
        cube_r30.setRotationPoint(0.758F, -5.4495F, 1.0312F);
        MainModel.addChild(cube_r30);
        setRotationAngle(cube_r30, 0.0F, 0.0F, 2.5307F);
        cube_r30.cubeList.add(new ModelBox(cube_r30, 58, 48, 7.2374F, -5.2405F, -9.3173F, 1, 1, 3, 0.0F));

        cube_r31 = new ModelRenderer(this);
        cube_r31.setRotationPoint(0.758F, -5.4495F, 1.0312F);
        MainModel.addChild(cube_r31);
        setRotationAngle(cube_r31, 0.0F, -0.48F, -3.1416F);
        cube_r31.cubeList.add(new ModelBox(cube_r31, 0, 21, -3.3487F, -6.6984F, -15.482F, 1, 4, 1, 0.0F));

        cube_r32 = new ModelRenderer(this);
        cube_r32.setRotationPoint(0.758F, -5.4495F, 1.0312F);
        MainModel.addChild(cube_r32);
        setRotationAngle(cube_r32, 0.0F, 0.3927F, 3.1416F);
        cube_r32.cubeList.add(new ModelBox(cube_r32, 16, 61, 9.2133F, -5.1984F, -14.8265F, 1, 1, 3, 0.0F));

        cube_r33 = new ModelRenderer(this);
        cube_r33.setRotationPoint(0.758F, -5.4495F, 1.0312F);
        MainModel.addChild(cube_r33);
        setRotationAngle(cube_r33, 0.0F, 0.0F, 2.7489F);
        cube_r33.cubeList.add(new ModelBox(cube_r33, 27, 2, 4.0604F, -10.032F, -0.1994F, 1, 1, 0, 0.0F));

        cube_r34 = new ModelRenderer(this);
        cube_r34.setRotationPoint(0.758F, -5.4495F, 1.0312F);
        MainModel.addChild(cube_r34);
        setRotationAngle(cube_r34, -0.3054F, 0.0F, 3.1416F);
        cube_r34.cubeList.add(new ModelBox(cube_r34, 52, 7, 0.0655F, -9.1377F, -3.6144F, 2, 1, 4, 0.0F));

        cube_r35 = new ModelRenderer(this);
        cube_r35.setRotationPoint(0.758F, -5.4495F, 1.0312F);
        MainModel.addChild(cube_r35);
        setRotationAngle(cube_r35, 0.2182F, 0.0F, 3.1416F);
        cube_r35.cubeList.add(new ModelBox(cube_r35, 0, 0, -1.4345F, -13.7854F, -25.218F, 5, 2, 9, 0.0F));
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        MainModel.render(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
}
