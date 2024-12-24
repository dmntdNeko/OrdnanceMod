package com.example.ordnancemod.models.modelBench;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFG42 extends ModelBase {
private final ModelRenderer bb_main;
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

public ModelFG42() {
        textureWidth = 128;
        textureHeight = 128;

        bb_main = new ModelRenderer(this);
        bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);


        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(-3.0F, -6.9131F, 7.9849F);
        bb_main.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, 0.0F, 3.1416F);
        cube_r1.cubeList.add(new ModelBox(cube_r1, 40, 22, 1.0F, -2.0869F, -17.3327F, 3, 2, 7, 0.0F));
        cube_r1.cubeList.add(new ModelBox(cube_r1, 40, 0, 1.0F, -0.0869F, -17.3327F, 4, 2, 7, 0.0F));
        cube_r1.cubeList.add(new ModelBox(cube_r1, 22, 17, 2.5F, -1.0869F, 26.0151F, 1, 2, 1, 0.0F));
        cube_r1.cubeList.add(new ModelBox(cube_r1, 17, 13, 2.5F, -5.3369F, 27.0151F, 1, 4, 1, 0.0F));
        cube_r1.cubeList.add(new ModelBox(cube_r1, 51, 49, 1.5F, 1.9131F, -16.2349F, 3, 2, 6, 0.0F));
        cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 32, -10.0F, -1.5869F, -17.4849F, 10, 1, 1, 0.0F));
        cube_r1.cubeList.add(new ModelBox(cube_r1, 80, 0, -11.0F, -2.0869F, -16.9849F, 11, 2, 8, 0.0F));
        cube_r1.cubeList.add(new ModelBox(cube_r1, -1, 12, 1.0F, -0.0869F, -20.3327F, 1, 2, 3, 0.0F));
        cube_r1.cubeList.add(new ModelBox(cube_r1, 19, 0, 1.0F, -2.0869F, -25.3327F, 1, 4, 5, 0.0F));
        cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 37, 2.0F, -2.0869F, -25.3327F, 3, 4, 8, 0.0F));
        cube_r1.cubeList.add(new ModelBox(cube_r1, 40, 10, 0.0F, -2.0869F, -17.9849F, 1, 2, 9, 0.0F));
        cube_r1.cubeList.add(new ModelBox(cube_r1, 52, 10, 2.5F, -2.0869F, 9.5151F, 1, 4, 4, 0.0F));

        cube_r2 = new ModelRenderer(this);
        cube_r2.setRotationPoint(-3.0F, -6.9131F, 7.9849F);
        bb_main.addChild(cube_r2);
        setRotationAngle(cube_r2, -0.7854F, 0.0F, -3.1416F);
        cube_r2.cubeList.add(new ModelBox(cube_r2, 25, 21, 5.0F, 2.4634F, -2.8792F, 1, 1, 1, 0.0F));

        cube_r3 = new ModelRenderer(this);
        cube_r3.setRotationPoint(-3.0F, -6.9131F, 7.9849F);
        bb_main.addChild(cube_r3);
        setRotationAngle(cube_r3, -3.1416F, 0.2618F, 0.0F);
        cube_r3.cubeList.add(new ModelBox(cube_r3, 29, 10, 0.3682F, -6.3369F, 13.8972F, 0, 1, 1, 0.0F));

        cube_r4 = new ModelRenderer(this);
        cube_r4.setRotationPoint(-3.0F, -6.9131F, 7.9849F);
        bb_main.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.0F, 0.2618F, 3.1416F);
        cube_r4.cubeList.add(new ModelBox(cube_r4, 29, 13, 6.1465F, -6.3369F, -13.3137F, 0, 1, 1, 0.0F));

        cube_r5 = new ModelRenderer(this);
        cube_r5.setRotationPoint(-3.0F, -6.9131F, 7.9849F);
        bb_main.addChild(cube_r5);
        setRotationAngle(cube_r5, 0.0F, 0.7854F, 3.1416F);
        cube_r5.cubeList.add(new ModelBox(cube_r5, 19, 0, 11.5102F, -5.3369F, -8.2675F, 1, 3, 1, 0.0F));
        cube_r5.cubeList.add(new ModelBox(cube_r5, 22, 13, 13.6703F, -2.0869F, -12.2561F, 2, 2, 1, 0.0F));

        cube_r6 = new ModelRenderer(this);
        cube_r6.setRotationPoint(-3.0F, -6.9131F, 7.9849F);
        bb_main.addChild(cube_r6);
        setRotationAngle(cube_r6, 0.0F, 0.0F, 2.3562F);
        cube_r6.cubeList.add(new ModelBox(cube_r6, 27, 0, 5.3648F, -2.1221F, 27.0151F, 1, 1, 1, 0.0F));
        cube_r6.cubeList.add(new ModelBox(cube_r6, 8, 82, 0.9757F, 2.267F, 9.5151F, 1, 1, 21, 0.0F));
        cube_r6.cubeList.add(new ModelBox(cube_r6, 16, 43, 1.9202F, 0.3224F, 28.0151F, 2, 2, 7, 0.0F));
        cube_r6.cubeList.add(new ModelBox(cube_r6, 69, 84, 2.3899F, 0.8527F, 9.5151F, 1, 1, 19, 0.0F));

        cube_r7 = new ModelRenderer(this);
        cube_r7.setRotationPoint(-3.0F, -6.9131F, 7.9849F);
        bb_main.addChild(cube_r7);
        setRotationAngle(cube_r7, 0.0F, 0.0F, -2.7489F);
        cube_r7.cubeList.add(new ModelBox(cube_r7, 29, 23, 1.1922F, -7.2701F, 27.0151F, 0, 1, 1, 0.0F));

        cube_r8 = new ModelRenderer(this);
        cube_r8.setRotationPoint(-3.0F, -6.9131F, 7.9849F);
        bb_main.addChild(cube_r8);
        setRotationAngle(cube_r8, -3.1416F, 0.0F, -0.3927F);
        cube_r8.cubeList.add(new ModelBox(cube_r8, 30, 20, -4.3511F, -4.974F, -28.0151F, 0, 1, 1, 0.0F));

        cube_r9 = new ModelRenderer(this);
        cube_r9.setRotationPoint(-3.0F, -6.9131F, 7.9849F);
        bb_main.addChild(cube_r9);
        setRotationAngle(cube_r9, -3.1416F, 0.0F, 0.3927F);
        cube_r9.cubeList.add(new ModelBox(cube_r9, 31, 2, -1.3265F, -7.0967F, -28.0151F, 0, 1, 1, 0.0F));

        cube_r10 = new ModelRenderer(this);
        cube_r10.setRotationPoint(-3.0F, -6.9131F, 7.9849F);
        bb_main.addChild(cube_r10);
        setRotationAngle(cube_r10, 0.0F, 0.0F, 2.7489F);
        cube_r10.cubeList.add(new ModelBox(cube_r10, 31, 15, 4.2168F, -4.8006F, 27.0151F, 0, 1, 1, 0.0F));

        cube_r11 = new ModelRenderer(this);
        cube_r11.setRotationPoint(-3.0F, -6.9131F, 7.9849F);
        bb_main.addChild(cube_r11);
        setRotationAngle(cube_r11, 1.5708F, -1.3963F, 0.0F);
        cube_r11.cubeList.add(new ModelBox(cube_r11, 0, 26, 12.38F, 7.7323F, 0.515F, 14, 1, 1, 0.0F));

        cube_r12 = new ModelRenderer(this);
        cube_r12.setRotationPoint(-3.0F, -6.9131F, 7.9849F);
        bb_main.addChild(cube_r12);
        setRotationAngle(cube_r12, -1.5708F, -1.3963F, 3.1416F);
        cube_r12.cubeList.add(new ModelBox(cube_r12, 0, 29, 13.4191F, -2.8393F, 0.515F, 14, 1, 1, 0.0F));

        cube_r13 = new ModelRenderer(this);
        cube_r13.setRotationPoint(-3.0F, -6.9131F, 7.9849F);
        bb_main.addChild(cube_r13);
        setRotationAngle(cube_r13, -0.3927F, 0.0F, 3.1416F);
        cube_r13.cubeList.add(new ModelBox(cube_r13, 0, 0, 2.0F, 8.3692F, -13.1951F, 2, 6, 2, 0.0F));

        cube_r14 = new ModelRenderer(this);
        cube_r14.setRotationPoint(-3.0F, -6.9131F, 7.9849F);
        bb_main.addChild(cube_r14);
        setRotationAngle(cube_r14, 3.1416F, 0.0F, -0.7854F);
        cube_r14.cubeList.add(new ModelBox(cube_r14, 27, 17, -1.7354F, 3.4967F, -9.6673F, 1, 1, 1, 0.0F));

        cube_r15 = new ModelRenderer(this);
        cube_r15.setRotationPoint(-3.0F, -6.9131F, 7.9849F);
        bb_main.addChild(cube_r15);
        setRotationAngle(cube_r15, -3.1416F, 0.0F, 2.8362F);
        cube_r15.cubeList.add(new ModelBox(cube_r15, 0, 0, 2.0672F, -3.3955F, -9.6673F, 2, 1, 35, 0.0F));

        cube_r16 = new ModelRenderer(this);
        cube_r16.setRotationPoint(-3.0F, -6.9131F, 7.9849F);
        bb_main.addChild(cube_r16);
        setRotationAngle(cube_r16, 3.1416F, 0.0F, -2.8362F);
        cube_r16.cubeList.add(new ModelBox(cube_r16, 0, 37, 1.6551F, -1.5913F, -9.6673F, 2, 1, 35, 0.0F));

        cube_r17 = new ModelRenderer(this);
        cube_r17.setRotationPoint(-3.0F, -6.9131F, 7.9849F);
        bb_main.addChild(cube_r17);
        setRotationAngle(cube_r17, 0.0F, 0.0F, -2.3562F);
        cube_r17.cubeList.add(new ModelBox(cube_r17, 0, 18, 2.4967F, -0.7354F, 8.6673F, 2, 1, 1, 0.0F));

        cube_r18 = new ModelRenderer(this);
        cube_r18.setRotationPoint(-3.0F, -6.9131F, 7.9849F);
        bb_main.addChild(cube_r18);
        setRotationAngle(cube_r18, 3.1416F, 0.0F, 0.3054F);
        cube_r18.cubeList.add(new ModelBox(cube_r18, 40, 2, -4.0457F, -3.4638F, -9.6673F, 2, 1, 35, 0.0F));

        cube_r19 = new ModelRenderer(this);
        cube_r19.setRotationPoint(-3.0F, -6.9131F, 7.9849F);
        bb_main.addChild(cube_r19);
        setRotationAngle(cube_r19, -3.1416F, 0.0F, -0.3054F);
        cube_r19.cubeList.add(new ModelBox(cube_r19, 40, 39, -3.6766F, -1.6596F, -9.6673F, 2, 1, 35, 0.0F));

        cube_r20 = new ModelRenderer(this);
        cube_r20.setRotationPoint(-3.0F, -6.9131F, 7.9849F);
        bb_main.addChild(cube_r20);
        setRotationAngle(cube_r20, -2.7053F, 0.0087F, 0.0F);
        cube_r20.cubeList.add(new ModelBox(cube_r20, 0, 50, -4.7566F, 11.8631F, 21.3892F, 4, 8, 4, 0.0F));

        cube_r21 = new ModelRenderer(this);
        cube_r21.setRotationPoint(-3.0F, -6.9131F, 7.9849F);
        bb_main.addChild(cube_r21);
        setRotationAngle(cube_r21, -3.1416F, 0.0F, 0.0F);
        cube_r21.cubeList.add(new ModelBox(cube_r21, 0, 0, -5.0F, -2.006F, 25.2756F, 4, 2, 10, 0.0F));
        cube_r21.cubeList.add(new ModelBox(cube_r21, 32, 76, -5.0F, -2.0869F, -9.6673F, 4, 4, 20, 0.0F));

        cube_r22 = new ModelRenderer(this);
        cube_r22.setRotationPoint(-3.0F, -6.9131F, 7.9849F);
        bb_main.addChild(cube_r22);
        setRotationAngle(cube_r22, 2.7925F, 0.0F, 0.0087F);
        cube_r22.cubeList.add(new ModelBox(cube_r22, 40, 39, -5.039F, -12.0953F, 29.1371F, 4, 11, 4, 0.0F));

        cube_r23 = new ModelRenderer(this);
        cube_r23.setRotationPoint(-3.0F, -6.9131F, 7.9849F);
        bb_main.addChild(cube_r23);
        setRotationAngle(cube_r23, 2.7925F, 0.0087F, 0.0F);
        cube_r23.cubeList.add(new ModelBox(cube_r23, 0, 13, -4.752F, -10.634F, 23.1148F, 4, 4, 8, 0.0F));
        }

@Override
public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        bb_main.render(f5);
        }

public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
        }
        }