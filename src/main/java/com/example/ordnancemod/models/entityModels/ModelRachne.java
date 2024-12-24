package com.example.ordnancemod.models.entityModels;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRachne extends ModelBase {
    public final ModelRenderer Rachne;
    private final ModelRenderer h_head;
    private final ModelRenderer body;
    private final ModelRenderer Spiderlegs;
    private final ModelRenderer Leggroup1;
    private final ModelRenderer SpdlgL1;
    private final ModelRenderer L2;
    private final ModelRenderer cube_r1;
    private final ModelRenderer L3;
    private final ModelRenderer cube_r2;
    private final ModelRenderer L1;
    private final ModelRenderer cube_r3;
    private final ModelRenderer SpdlgL2;
    private final ModelRenderer L6;
    private final ModelRenderer cube_r4;
    private final ModelRenderer L5;
    private final ModelRenderer cube_r5;
    private final ModelRenderer L4;
    private final ModelRenderer cube_r6;
    private final ModelRenderer SpdlgL3;
    private final ModelRenderer L8;
    private final ModelRenderer cube_r7;
    private final ModelRenderer L7;
    private final ModelRenderer cube_r8;
    private final ModelRenderer L9;
    private final ModelRenderer cube_r9;
    private final ModelRenderer SpdlgL4;
    private final ModelRenderer L11;
    private final ModelRenderer cube_r10;
    private final ModelRenderer L10;
    private final ModelRenderer cube_r11;
    private final ModelRenderer L12;
    private final ModelRenderer cube_r12;
    private final ModelRenderer Leggroup2;
    private final ModelRenderer SpdlgL8;
    private final ModelRenderer L23;
    private final ModelRenderer cube_r13;
    private final ModelRenderer L22;
    private final ModelRenderer cube_r14;
    private final ModelRenderer L24;
    private final ModelRenderer cube_r15;
    private final ModelRenderer SpdlgL7;
    private final ModelRenderer L20;
    private final ModelRenderer cube_r16;
    private final ModelRenderer L19;
    private final ModelRenderer cube_r17;
    private final ModelRenderer L21;
    private final ModelRenderer cube_r18;
    private final ModelRenderer SpdlgL6;
    private final ModelRenderer L17;
    private final ModelRenderer cube_r19;
    private final ModelRenderer L16;
    private final ModelRenderer cube_r20;
    private final ModelRenderer L18;
    private final ModelRenderer cube_r21;
    private final ModelRenderer SpdlgL5;
    private final ModelRenderer L14;
    private final ModelRenderer cube_r22;
    private final ModelRenderer L13;
    private final ModelRenderer cube_r23;
    private final ModelRenderer L15;
    private final ModelRenderer cube_r24;
    private final ModelRenderer Spdbdy;
    private final ModelRenderer Connect;
    private final ModelRenderer Abdomen;
    private final ModelRenderer Abdomen_r1;
    private final ModelRenderer Legs;
    private final ModelRenderer ThighR;
    private final ModelRenderer ThighR_r1;
    private final ModelRenderer ShinR;
    private final ModelRenderer ShinR_r1;
    private final ModelRenderer ThighL;
    private final ModelRenderer ThighL_r1;
    private final ModelRenderer ShinL;
    private final ModelRenderer ShinL_r1;
    private final ModelRenderer Torso;
    private final ModelRenderer torsoupper;
    private final ModelRenderer chestr_r1;
    private final ModelRenderer chestl_r1;
    private final ModelRenderer ArmR;
    private final ModelRenderer MArmR_r1;
    private final ModelRenderer RLowerArm;
    private final ModelRenderer FArmR_r1;
    private final ModelRenderer ArmL;
    private final ModelRenderer MArmL_r1;
    private final ModelRenderer LLowerArm;
    private final ModelRenderer FArmL_r1;
    private final ModelRenderer torsomid;
    private final ModelRenderer torsomid_r1;
    private final ModelRenderer torsolower;
    private final ModelRenderer torsolower_r1;
    private final ModelRenderer Neck;
    private final ModelRenderer tag;
    private final ModelRenderer tag_r1;
    private final ModelRenderer hitbox;

    public ModelRachne() {
        textureWidth = 256;
        textureHeight = 256;

        Rachne = new ModelRenderer(this);
        Rachne.setRotationPoint(-2.5F, -9.0F, -12.75F);


        h_head = new ModelRenderer(this);
        h_head.setRotationPoint(2.5F, 6.25F, 5.5F);
        Rachne.addChild(h_head);
        h_head.cubeList.add(new ModelBox(h_head, 0, 83, -3.5F, -7.25F, -3.5F, 7, 7, 7, 0.0F));
        h_head.cubeList.add(new ModelBox(h_head, 60, 79, -4.0F, -7.5F, -4.0F, 8, 8, 8, 0.0F));

        body = new ModelRenderer(this);
        body.setRotationPoint(2.5F, 18.25F, 14.5F);
        Rachne.addChild(body);


        Spiderlegs = new ModelRenderer(this);
        Spiderlegs.setRotationPoint(0.0F, 14.75F, -1.75F);
        body.addChild(Spiderlegs);


        Leggroup1 = new ModelRenderer(this);
        Leggroup1.setRotationPoint(0.0F, 0.0F, 0.0F);
        Spiderlegs.addChild(Leggroup1);


        SpdlgL1 = new ModelRenderer(this);
        SpdlgL1.setRotationPoint(-7.625F, -8.5F, -2.7375F);
        Leggroup1.addChild(SpdlgL1);
        setRotationAngle(SpdlgL1, -0.2877F, -0.5467F, 0.5175F);


        L2 = new ModelRenderer(this);
        L2.setRotationPoint(-13.825F, 0.0F, -0.125F);
        SpdlgL1.addChild(L2);
        setRotationAngle(L2, 0.0F, 0.0F, -0.6981F);


        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(-3.675F, 0.0F, 4.875F);
        L2.addChild(cube_r1);
        setRotationAngle(cube_r1, -3.1416F, 0.0F, 3.1416F);
        cube_r1.cubeList.add(new ModelBox(cube_r1, 56, 95, -2.375F, -1.0F, 3.8875F, 12, 2, 2, 0.0F));
        cube_r1.cubeList.add(new ModelBox(cube_r1, 118, 76, -5.125F, -1.5F, 3.3625F, 3, 3, 3, 0.0F));

        L3 = new ModelRenderer(this);
        L3.setRotationPoint(-13.925F, 0.0F, 0.0F);
        L2.addChild(L3);
        setRotationAngle(L3, 0.0F, 0.0F, -0.6981F);


        cube_r2 = new ModelRenderer(this);
        cube_r2.setRotationPoint(10.25F, 0.0F, 4.875F);
        L3.addChild(cube_r2);
        setRotationAngle(cube_r2, -3.1416F, 0.0F, 3.1416F);
        cube_r2.cubeList.add(new ModelBox(cube_r2, 54, 115, 8.875F, -1.5F, 3.3625F, 3, 3, 3, 0.0F));
        cube_r2.cubeList.add(new ModelBox(cube_r2, 28, 93, 11.625F, -1.0F, 3.8875F, 12, 2, 2, 0.0F));

        L1 = new ModelRenderer(this);
        L1.setRotationPoint(0.125F, 0.0F, -0.075F);
        SpdlgL1.addChild(L1);


        cube_r3 = new ModelRenderer(this);
        cube_r3.setRotationPoint(-17.625F, 0.0F, 4.825F);
        L1.addChild(cube_r3);
        setRotationAngle(cube_r3, -3.1416F, 0.0F, 3.1416F);
        cube_r3.cubeList.add(new ModelBox(cube_r3, 0, 97, -16.625F, -1.0F, 3.8875F, 12, 2, 2, 0.0F));
        cube_r3.cubeList.add(new ModelBox(cube_r3, 82, 118, -19.125F, -1.5F, 3.3625F, 3, 3, 3, 0.0F));

        SpdlgL2 = new ModelRenderer(this);
        SpdlgL2.setRotationPoint(-7.625F, -8.5F, 0.5125F);
        Leggroup1.addChild(SpdlgL2);
        setRotationAngle(SpdlgL2, -0.1128F, -0.2368F, 0.4498F);


        L6 = new ModelRenderer(this);
        L6.setRotationPoint(0.125F, 0.0F, -0.075F);
        SpdlgL2.addChild(L6);


        cube_r4 = new ModelRenderer(this);
        cube_r4.setRotationPoint(-17.625F, 0.0F, 4.825F);
        L6.addChild(cube_r4);
        setRotationAngle(cube_r4, -3.1416F, 0.0F, 3.1416F);
        cube_r4.cubeList.add(new ModelBox(cube_r4, 56, 99, -16.625F, -1.0F, 3.8875F, 12, 2, 2, 0.0F));
        cube_r4.cubeList.add(new ModelBox(cube_r4, 14, 119, -19.125F, -1.5F, 3.3625F, 3, 3, 3, 0.0F));

        L5 = new ModelRenderer(this);
        L5.setRotationPoint(-13.825F, 0.0F, -0.125F);
        SpdlgL2.addChild(L5);
        setRotationAngle(L5, 0.0F, 0.0F, -0.6981F);


        cube_r5 = new ModelRenderer(this);
        cube_r5.setRotationPoint(-3.675F, 0.0F, 4.875F);
        L5.addChild(cube_r5);
        setRotationAngle(cube_r5, -3.1416F, 0.0F, 3.1416F);
        cube_r5.cubeList.add(new ModelBox(cube_r5, 84, 97, -2.375F, -1.0F, 3.8875F, 12, 2, 2, 0.0F));
        cube_r5.cubeList.add(new ModelBox(cube_r5, 94, 118, -5.125F, -1.5F, 3.3625F, 3, 3, 3, 0.0F));

        L4 = new ModelRenderer(this);
        L4.setRotationPoint(-13.925F, 0.0F, 0.0F);
        L5.addChild(L4);
        setRotationAngle(L4, 0.0F, 0.0F, -0.6981F);


        cube_r6 = new ModelRenderer(this);
        cube_r6.setRotationPoint(10.25F, 0.0F, 4.875F);
        L4.addChild(cube_r6);
        setRotationAngle(cube_r6, -3.1416F, 0.0F, 3.1416F);
        cube_r6.cubeList.add(new ModelBox(cube_r6, 118, 82, 8.875F, -1.5F, 3.3625F, 3, 3, 3, 0.0F));
        cube_r6.cubeList.add(new ModelBox(cube_r6, 28, 97, 11.625F, -1.0F, 3.8875F, 12, 2, 2, 0.0F));

        SpdlgL3 = new ModelRenderer(this);
        SpdlgL3.setRotationPoint(-7.625F, -8.5F, 3.7625F);
        Leggroup1.addChild(SpdlgL3);
        setRotationAngle(SpdlgL3, 0.1128F, 0.2368F, 0.4498F);


        L8 = new ModelRenderer(this);
        L8.setRotationPoint(-13.825F, 0.0F, -0.125F);
        SpdlgL3.addChild(L8);
        setRotationAngle(L8, 0.0F, 0.0F, -0.6981F);


        cube_r7 = new ModelRenderer(this);
        cube_r7.setRotationPoint(-3.675F, 0.0F, 4.875F);
        L8.addChild(cube_r7);
        setRotationAngle(cube_r7, -3.1416F, 0.0F, 3.1416F);
        cube_r7.cubeList.add(new ModelBox(cube_r7, 28, 101, -2.375F, -1.0F, 3.8875F, 12, 2, 2, 0.0F));
        cube_r7.cubeList.add(new ModelBox(cube_r7, 38, 119, -5.125F, -1.5F, 3.3625F, 3, 3, 3, 0.0F));

        L7 = new ModelRenderer(this);
        L7.setRotationPoint(-13.925F, 0.0F, 0.0F);
        L8.addChild(L7);
        setRotationAngle(L7, 0.0F, 0.0F, -0.6981F);


        cube_r8 = new ModelRenderer(this);
        cube_r8.setRotationPoint(10.25F, 0.0F, 4.875F);
        L7.addChild(cube_r8);
        setRotationAngle(cube_r8, -3.1416F, 0.0F, 3.1416F);
        cube_r8.cubeList.add(new ModelBox(cube_r8, 26, 119, 8.875F, -1.5F, 3.3625F, 3, 3, 3, 0.0F));
        cube_r8.cubeList.add(new ModelBox(cube_r8, 0, 101, 11.625F, -1.0F, 3.8875F, 12, 2, 2, 0.0F));

        L9 = new ModelRenderer(this);
        L9.setRotationPoint(0.125F, 0.0F, -0.075F);
        SpdlgL3.addChild(L9);


        cube_r9 = new ModelRenderer(this);
        cube_r9.setRotationPoint(-17.625F, 0.0F, 4.825F);
        L9.addChild(cube_r9);
        setRotationAngle(cube_r9, -3.1416F, 0.0F, 3.1416F);
        cube_r9.cubeList.add(new ModelBox(cube_r9, 84, 101, -16.625F, -1.0F, 3.8875F, 12, 2, 2, 0.0F));
        cube_r9.cubeList.add(new ModelBox(cube_r9, 66, 119, -19.125F, -1.5F, 3.3625F, 3, 3, 3, 0.0F));

        SpdlgL4 = new ModelRenderer(this);
        SpdlgL4.setRotationPoint(-7.625F, -8.5F, 7.0125F);
        Leggroup1.addChild(SpdlgL4);
        setRotationAngle(SpdlgL4, 0.2877F, 0.5467F, 0.5175F);


        L11 = new ModelRenderer(this);
        L11.setRotationPoint(-13.825F, 0.0F, -0.125F);
        SpdlgL4.addChild(L11);
        setRotationAngle(L11, 0.0F, 0.0F, -0.6981F);


        cube_r10 = new ModelRenderer(this);
        cube_r10.setRotationPoint(-3.675F, 0.0F, 4.875F);
        L11.addChild(cube_r10);
        setRotationAngle(cube_r10, -3.1416F, 0.0F, 3.1416F);
        cube_r10.cubeList.add(new ModelBox(cube_r10, 104, 0, -2.375F, -1.0F, 3.8875F, 12, 2, 2, 0.0F));
        cube_r10.cubeList.add(new ModelBox(cube_r10, 120, 88, -5.125F, -1.5F, 3.3625F, 3, 3, 3, 0.0F));

        L10 = new ModelRenderer(this);
        L10.setRotationPoint(-13.925F, 0.0F, 0.0F);
        L11.addChild(L10);
        setRotationAngle(L10, 0.0F, 0.0F, -0.6981F);


        cube_r11 = new ModelRenderer(this);
        cube_r11.setRotationPoint(10.25F, 0.0F, 4.875F);
        L10.addChild(cube_r11);
        setRotationAngle(cube_r11, -3.1416F, 0.0F, 3.1416F);
        cube_r11.cubeList.add(new ModelBox(cube_r11, 0, 120, 8.875F, -1.5F, 3.3625F, 3, 3, 3, 0.0F));
        cube_r11.cubeList.add(new ModelBox(cube_r11, 56, 103, 11.625F, -1.0F, 3.8875F, 12, 2, 2, 0.0F));

        L12 = new ModelRenderer(this);
        L12.setRotationPoint(0.125F, 0.0F, -0.075F);
        SpdlgL4.addChild(L12);


        cube_r12 = new ModelRenderer(this);
        cube_r12.setRotationPoint(-17.625F, 0.0F, 4.825F);
        L12.addChild(cube_r12);
        setRotationAngle(cube_r12, -3.1416F, 0.0F, 3.1416F);
        cube_r12.cubeList.add(new ModelBox(cube_r12, 104, 4, -16.625F, -1.0F, 3.8875F, 12, 2, 2, 0.0F));
        cube_r12.cubeList.add(new ModelBox(cube_r12, 120, 113, -19.125F, -1.5F, 3.3625F, 3, 3, 3, 0.0F));

        Leggroup2 = new ModelRenderer(this);
        Leggroup2.setRotationPoint(0.0F, 0.0F, 0.0F);
        Spiderlegs.addChild(Leggroup2);


        SpdlgL8 = new ModelRenderer(this);
        SpdlgL8.setRotationPoint(8.125F, -8.5F, -2.7375F);
        Leggroup2.addChild(SpdlgL8);
        setRotationAngle(SpdlgL8, -2.8539F, -0.5467F, 2.6241F);


        L23 = new ModelRenderer(this);
        L23.setRotationPoint(-13.825F, 0.0F, -0.125F);
        SpdlgL8.addChild(L23);
        setRotationAngle(L23, 0.0F, 0.0F, -0.6981F);


        cube_r13 = new ModelRenderer(this);
        cube_r13.setRotationPoint(-3.675F, 0.0F, 4.875F);
        L23.addChild(cube_r13);
        setRotationAngle(cube_r13, -3.1416F, 0.0F, 3.1416F);
        cube_r13.cubeList.add(new ModelBox(cube_r13, 104, 48, -2.375F, -1.0F, 3.8875F, 12, 2, 2, 0.0F));
        cube_r13.cubeList.add(new ModelBox(cube_r13, 114, 125, -5.125F, -1.5F, 3.3625F, 3, 3, 3, 0.0F));

        L22 = new ModelRenderer(this);
        L22.setRotationPoint(-13.925F, 0.0F, 0.0F);
        L23.addChild(L22);
        setRotationAngle(L22, 0.0F, 0.0F, -0.6981F);


        cube_r14 = new ModelRenderer(this);
        cube_r14.setRotationPoint(10.25F, 0.0F, 4.875F);
        L22.addChild(cube_r14);
        setRotationAngle(cube_r14, -3.1416F, 0.0F, 3.1416F);
        cube_r14.cubeList.add(new ModelBox(cube_r14, 102, 125, 8.875F, -1.5F, 3.3625F, 3, 3, 3, 0.0F));
        cube_r14.cubeList.add(new ModelBox(cube_r14, 104, 44, 11.625F, -1.0F, 3.8875F, 12, 2, 2, 0.0F));

        L24 = new ModelRenderer(this);
        L24.setRotationPoint(0.125F, 0.0F, -0.075F);
        SpdlgL8.addChild(L24);


        cube_r15 = new ModelRenderer(this);
        cube_r15.setRotationPoint(-17.625F, 0.0F, 4.825F);
        L24.addChild(cube_r15);
        setRotationAngle(cube_r15, -3.1416F, 0.0F, 3.1416F);
        cube_r15.cubeList.add(new ModelBox(cube_r15, 104, 52, -16.625F, -1.0F, 3.8875F, 12, 2, 2, 0.0F));
        cube_r15.cubeList.add(new ModelBox(cube_r15, 0, 126, -19.125F, -1.5F, 3.3625F, 3, 3, 3, 0.0F));

        SpdlgL7 = new ModelRenderer(this);
        SpdlgL7.setRotationPoint(8.125F, -8.5F, 0.5125F);
        Leggroup2.addChild(SpdlgL7);
        setRotationAngle(SpdlgL7, -3.0288F, -0.2368F, 2.6918F);


        L20 = new ModelRenderer(this);
        L20.setRotationPoint(-13.825F, 0.0F, -0.125F);
        SpdlgL7.addChild(L20);
        setRotationAngle(L20, 0.0F, 0.0F, -0.6981F);


        cube_r16 = new ModelRenderer(this);
        cube_r16.setRotationPoint(-3.675F, 0.0F, 4.875F);
        L20.addChild(cube_r16);
        setRotationAngle(cube_r16, -3.1416F, 0.0F, 3.1416F);
        cube_r16.cubeList.add(new ModelBox(cube_r16, 104, 36, -2.375F, -1.0F, 3.8875F, 12, 2, 2, 0.0F));
        cube_r16.cubeList.add(new ModelBox(cube_r16, 36, 125, -5.125F, -1.5F, 3.3625F, 3, 3, 3, 0.0F));

        L19 = new ModelRenderer(this);
        L19.setRotationPoint(-13.925F, 0.0F, 0.0F);
        L20.addChild(L19);
        setRotationAngle(L19, 0.0F, 0.0F, -0.6981F);


        cube_r17 = new ModelRenderer(this);
        cube_r17.setRotationPoint(10.25F, 0.0F, 4.875F);
        L19.addChild(cube_r17);
        setRotationAngle(cube_r17, -3.1416F, 0.0F, 3.1416F);
        cube_r17.cubeList.add(new ModelBox(cube_r17, 24, 125, 8.875F, -1.5F, 3.3625F, 3, 3, 3, 0.0F));
        cube_r17.cubeList.add(new ModelBox(cube_r17, 104, 32, 11.625F, -1.0F, 3.8875F, 12, 2, 2, 0.0F));

        L21 = new ModelRenderer(this);
        L21.setRotationPoint(0.125F, 0.0F, -0.075F);
        SpdlgL7.addChild(L21);


        cube_r18 = new ModelRenderer(this);
        cube_r18.setRotationPoint(-17.625F, 0.0F, 4.825F);
        L21.addChild(cube_r18);
        setRotationAngle(cube_r18, -3.1416F, 0.0F, 3.1416F);
        cube_r18.cubeList.add(new ModelBox(cube_r18, 104, 40, -16.625F, -1.0F, 3.8875F, 12, 2, 2, 0.0F));
        cube_r18.cubeList.add(new ModelBox(cube_r18, 62, 125, -19.125F, -1.5F, 3.3625F, 3, 3, 3, 0.0F));

        SpdlgL6 = new ModelRenderer(this);
        SpdlgL6.setRotationPoint(8.125F, -8.5F, 3.7625F);
        Leggroup2.addChild(SpdlgL6);
        setRotationAngle(SpdlgL6, 3.0288F, 0.2368F, 2.6918F);


        L17 = new ModelRenderer(this);
        L17.setRotationPoint(-13.825F, 0.0F, -0.125F);
        SpdlgL6.addChild(L17);
        setRotationAngle(L17, 0.0F, 0.0F, -0.6981F);


        cube_r19 = new ModelRenderer(this);
        cube_r19.setRotationPoint(-3.675F, 0.0F, 4.875F);
        L17.addChild(cube_r19);
        setRotationAngle(cube_r19, -3.1416F, 0.0F, 3.1416F);
        cube_r19.cubeList.add(new ModelBox(cube_r19, 104, 24, -2.375F, -1.0F, 3.8875F, 12, 2, 2, 0.0F));
        cube_r19.cubeList.add(new ModelBox(cube_r19, 124, 103, -5.125F, -1.5F, 3.3625F, 3, 3, 3, 0.0F));

        L16 = new ModelRenderer(this);
        L16.setRotationPoint(-13.925F, 0.0F, 0.0F);
        L17.addChild(L16);
        setRotationAngle(L16, 0.0F, 0.0F, -0.6981F);


        cube_r20 = new ModelRenderer(this);
        cube_r20.setRotationPoint(10.25F, 0.0F, 4.875F);
        L16.addChild(cube_r20);
        setRotationAngle(cube_r20, -3.1416F, 0.0F, 3.1416F);
        cube_r20.cubeList.add(new ModelBox(cube_r20, 90, 124, 8.875F, -1.5F, 3.3625F, 3, 3, 3, 0.0F));
        cube_r20.cubeList.add(new ModelBox(cube_r20, 104, 20, 11.625F, -1.0F, 3.8875F, 12, 2, 2, 0.0F));

        L18 = new ModelRenderer(this);
        L18.setRotationPoint(0.125F, 0.0F, -0.075F);
        SpdlgL6.addChild(L18);


        cube_r21 = new ModelRenderer(this);
        cube_r21.setRotationPoint(-17.625F, 0.0F, 4.825F);
        L18.addChild(cube_r21);
        setRotationAngle(cube_r21, -3.1416F, 0.0F, 3.1416F);
        cube_r21.cubeList.add(new ModelBox(cube_r21, 104, 28, -16.625F, -1.0F, 3.8875F, 12, 2, 2, 0.0F));
        cube_r21.cubeList.add(new ModelBox(cube_r21, 12, 125, -19.125F, -1.5F, 3.3625F, 3, 3, 3, 0.0F));

        SpdlgL5 = new ModelRenderer(this);
        SpdlgL5.setRotationPoint(8.125F, -8.5F, 7.0125F);
        Leggroup2.addChild(SpdlgL5);
        setRotationAngle(SpdlgL5, 2.8539F, 0.5467F, 2.6241F);


        L14 = new ModelRenderer(this);
        L14.setRotationPoint(-13.825F, 0.0F, -0.125F);
        SpdlgL5.addChild(L14);
        setRotationAngle(L14, 0.0F, 0.0F, -0.6981F);


        cube_r22 = new ModelRenderer(this);
        cube_r22.setRotationPoint(-3.675F, 0.0F, 4.875F);
        L14.addChild(cube_r22);
        setRotationAngle(cube_r22, -3.1416F, 0.0F, 3.1416F);
        cube_r22.cubeList.add(new ModelBox(cube_r22, 104, 12, -2.375F, -1.0F, 3.8875F, 12, 2, 2, 0.0F));
        cube_r22.cubeList.add(new ModelBox(cube_r22, 50, 121, -5.125F, -1.5F, 3.3625F, 3, 3, 3, 0.0F));

        L13 = new ModelRenderer(this);
        L13.setRotationPoint(-13.925F, 0.0F, 0.0F);
        L14.addChild(L13);
        setRotationAngle(L13, 0.0F, 0.0F, -0.6981F);


        cube_r23 = new ModelRenderer(this);
        cube_r23.setRotationPoint(10.25F, 0.0F, 4.875F);
        L13.addChild(cube_r23);
        setRotationAngle(cube_r23, -3.1416F, 0.0F, 3.1416F);
        cube_r23.cubeList.add(new ModelBox(cube_r23, 120, 119, 8.875F, -1.5F, 3.3625F, 3, 3, 3, 0.0F));
        cube_r23.cubeList.add(new ModelBox(cube_r23, 104, 8, 11.625F, -1.0F, 3.8875F, 12, 2, 2, 0.0F));

        L15 = new ModelRenderer(this);
        L15.setRotationPoint(0.125F, 0.0F, -0.075F);
        SpdlgL5.addChild(L15);


        cube_r24 = new ModelRenderer(this);
        cube_r24.setRotationPoint(-17.625F, 0.0F, 4.825F);
        L15.addChild(cube_r24);
        setRotationAngle(cube_r24, -3.1416F, 0.0F, 3.1416F);
        cube_r24.cubeList.add(new ModelBox(cube_r24, 104, 16, -16.625F, -1.0F, 3.8875F, 12, 2, 2, 0.0F));
        cube_r24.cubeList.add(new ModelBox(cube_r24, 78, 124, -19.125F, -1.5F, 3.3625F, 3, 3, 3, 0.0F));

        Spdbdy = new ModelRenderer(this);
        Spdbdy.setRotationPoint(0.0F, -0.25F, 0.25F);
        body.addChild(Spdbdy);
        Spdbdy.cubeList.add(new ModelBox(Spdbdy, 60, 58, -6.5F, 2.0F, -7.0F, 13, 7, 14, 0.0F));

        Connect = new ModelRenderer(this);
        Connect.setRotationPoint(0.0F, 6.0F, 7.5F);
        Spdbdy.addChild(Connect);
        Connect.cubeList.add(new ModelBox(Connect, 92, 89, -6.0F, -3.5F, -1.0F, 12, 6, 2, 0.0F));

        Abdomen = new ModelRenderer(this);
        Abdomen.setRotationPoint(0.0F, 6.0F, 7.75F);
        Spdbdy.addChild(Abdomen);


        Abdomen_r1 = new ModelRenderer(this);
        Abdomen_r1.setRotationPoint(0.0F, 0.0F, 0.975F);
        Abdomen.addChild(Abdomen_r1);
        setRotationAngle(Abdomen_r1, 0.1309F, 0.0F, 0.0F);
        Abdomen_r1.cubeList.add(new ModelBox(Abdomen_r1, 0, 58, -7.0F, -6.0F, -1.0F, 14, 9, 16, 0.0F));

        Legs = new ModelRenderer(this);
        Legs.setRotationPoint(-0.05F, 2.5F, -8.0F);
        body.addChild(Legs);
        setRotationAngle(Legs, -0.3927F, 0.0F, 0.0F);


        ThighR = new ModelRenderer(this);
        ThighR.setRotationPoint(2.1F, 0.3266F, -0.1353F);
        Legs.addChild(ThighR);
        setRotationAngle(ThighR, -0.1745F, 0.0F, 0.0F);


        ThighR_r1 = new ModelRenderer(this);
        ThighR_r1.setRotationPoint(-1.0F, -6.1173F, -0.9103F);
        ThighR.addChild(ThighR_r1);
        setRotationAngle(ThighR_r1, -0.3927F, 0.0F, 0.0F);
        ThighR_r1.cubeList.add(new ModelBox(ThighR_r1, 38, 105, -1.0F, 3.2426F, 1.2426F, 4, 10, 4, 0.0F));

        ShinR = new ModelRenderer(this);
        ShinR.setRotationPoint(-0.05F, 7.195F, -3.3844F);
        ThighR.addChild(ShinR);
        setRotationAngle(ShinR, 0.3491F, 0.0F, 0.0F);


        ShinR_r1 = new ModelRenderer(this);
        ShinR_r1.setRotationPoint(-1.5F, -6.1966F, -2.0255F);
        ShinR.addChild(ShinR_r1);
        setRotationAngle(ShinR_r1, 1.3526F, 0.0F, 0.0F);
        ShinR_r1.cubeList.add(new ModelBox(ShinR_r1, 96, 105, 0.05F, 3.2078F, -6.6662F, 3, 10, 3, 0.0F));

        ThighL = new ModelRenderer(this);
        ThighL.setRotationPoint(-2.0F, 0.3266F, -0.1353F);
        Legs.addChild(ThighL);
        setRotationAngle(ThighL, -0.1745F, 0.0F, 0.0F);


        ThighL_r1 = new ModelRenderer(this);
        ThighL_r1.setRotationPoint(-1.0F, -6.1173F, -0.9103F);
        ThighL.addChild(ThighL_r1);
        setRotationAngle(ThighL_r1, -0.3927F, 0.0F, 0.0F);
        ThighL_r1.cubeList.add(new ModelBox(ThighL_r1, 22, 105, -1.0F, 3.2426F, 1.2426F, 4, 10, 4, 0.0F));

        ShinL = new ModelRenderer(this);
        ShinL.setRotationPoint(0.05F, 7.195F, -3.3844F);
        ThighL.addChild(ShinL);
        setRotationAngle(ShinL, 0.3491F, 0.0F, 0.0F);


        ShinL_r1 = new ModelRenderer(this);
        ShinL_r1.setRotationPoint(-0.5F, -6.1966F, -2.0255F);
        ShinL.addChild(ShinL_r1);
        setRotationAngle(ShinL_r1, 1.3526F, 0.0F, 0.0F);
        ShinL_r1.cubeList.add(new ModelBox(ShinL_r1, 84, 105, -1.05F, 3.2078F, -6.6662F, 3, 10, 3, 0.0F));

        Torso = new ModelRenderer(this);
        Torso.setRotationPoint(1.5F, -13.933F, -13.567F);
        body.addChild(Torso);


        torsoupper = new ModelRenderer(this);
        torsoupper.setRotationPoint(-1.5F, 6.0F, 5.0F);
        Torso.addChild(torsoupper);
        torsoupper.cubeList.add(new ModelBox(torsoupper, 28, 83, -4.0F, -2.317F, -2.683F, 8, 5, 5, 0.0F));

        chestr_r1 = new ModelRenderer(this);
        chestr_r1.setRotationPoint(1.5F, 0.0F, -3.0F);
        torsoupper.addChild(chestr_r1);
        setRotationAngle(chestr_r1, 0.5236F, 0.0873F, 0.0F);
        chestr_r1.cubeList.add(new ModelBox(chestr_r1, 114, 56, -2.0F, -1.5F, -1.5F, 4, 3, 3, 0.0F));

        chestl_r1 = new ModelRenderer(this);
        chestl_r1.setRotationPoint(-1.5F, 0.0F, -3.0F);
        torsoupper.addChild(chestl_r1);
        setRotationAngle(chestl_r1, 0.5236F, -0.0873F, 0.0F);
        chestl_r1.cubeList.add(new ModelBox(chestl_r1, 0, 114, -2.0F, -1.5F, -1.5F, 4, 3, 3, 0.0F));

        ArmR = new ModelRenderer(this);
        ArmR.setRotationPoint(6.0F, -0.317F, -0.183F);
        torsoupper.addChild(ArmR);
        setRotationAngle(ArmR, -1.3927F, -0.3969F, -1.9094F);
        ArmR.cubeList.add(new ModelBox(ArmR, 54, 107, -2.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F));

        MArmR_r1 = new ModelRenderer(this);
        MArmR_r1.setRotationPoint(-4.0F, 5.5F, 0.5F);
        ArmR.addChild(MArmR_r1);
        setRotationAngle(MArmR_r1, 0.0F, 0.0F, 1.5708F);
        MArmR_r1.cubeList.add(new ModelBox(MArmR_r1, 114, 69, -7.0F, -2.0F, -2.0F, 3, 4, 3, 0.0F));

        RLowerArm = new ModelRenderer(this);
        RLowerArm.setRotationPoint(-6.0F, 0.0F, 0.0F);
        ArmR.addChild(RLowerArm);
        setRotationAngle(RLowerArm, 0.0F, -1.2217F, 0.0F);


        FArmR_r1 = new ModelRenderer(this);
        FArmR_r1.setRotationPoint(-2.0F, 5.5F, 0.5F);
        RLowerArm.addChild(FArmR_r1);
        setRotationAngle(FArmR_r1, 0.0F, 0.0F, 1.5708F);
        FArmR_r1.cubeList.add(new ModelBox(FArmR_r1, 108, 113, -7.0F, -2.0F, -2.0F, 3, 9, 3, 0.0F));

        ArmL = new ModelRenderer(this);
        ArmL.setRotationPoint(-6.0F, -0.317F, -0.183F);
        torsoupper.addChild(ArmL);
        setRotationAngle(ArmL, 1.3927F, -0.3969F, -1.2322F);
        ArmL.cubeList.add(new ModelBox(ArmL, 108, 105, -2.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F));

        MArmL_r1 = new ModelRenderer(this);
        MArmL_r1.setRotationPoint(-4.0F, -0.5F, 0.5F);
        ArmL.addChild(MArmL_r1);
        setRotationAngle(MArmL_r1, 0.0F, 0.0F, 1.5708F);
        MArmL_r1.cubeList.add(new ModelBox(MArmL_r1, 114, 62, -1.0F, -2.0F, -2.0F, 3, 4, 3, 0.0F));

        LLowerArm = new ModelRenderer(this);
        LLowerArm.setRotationPoint(-6.0F, 0.0F, 0.0F);
        ArmL.addChild(LLowerArm);
        setRotationAngle(LLowerArm, 0.0F, -1.2217F, 0.0F);


        FArmL_r1 = new ModelRenderer(this);
        FArmL_r1.setRotationPoint(-2.0F, -0.5F, 0.5F);
        LLowerArm.addChild(FArmL_r1);
        setRotationAngle(FArmL_r1, 0.0F, 0.0F, 1.5708F);
        FArmL_r1.cubeList.add(new ModelBox(FArmL_r1, 70, 107, -1.0F, -2.0F, -2.0F, 3, 9, 3, 0.0F));

        torsomid = new ModelRenderer(this);
        torsomid.setRotationPoint(-1.5F, 13.0F, 5.0F);
        Torso.addChild(torsomid);


        torsomid_r1 = new ModelRenderer(this);
        torsomid_r1.setRotationPoint(-0.5F, -2.817F, -0.183F);
        torsomid.addChild(torsomid_r1);
        setRotationAngle(torsomid_r1, 0.1309F, 0.0F, 0.0F);
        torsomid_r1.cubeList.add(new ModelBox(torsomid_r1, 0, 105, -3.0F, -2.0F, -2.0F, 7, 5, 4, 0.0F));

        torsolower = new ModelRenderer(this);
        torsolower.setRotationPoint(-1.5F, 16.0F, 8.0F);
        Torso.addChild(torsolower);


        torsolower_r1 = new ModelRenderer(this);
        torsolower_r1.setRotationPoint(0.0F, -1.567F, -1.683F);
        torsolower.addChild(torsolower_r1);
        setRotationAngle(torsolower_r1, 0.2618F, 0.0F, 0.0F);
        torsolower_r1.cubeList.add(new ModelBox(torsolower_r1, 92, 79, -4.0F, -2.0F, -3.0F, 8, 5, 5, 0.0F));

        Neck = new ModelRenderer(this);
        Neck.setRotationPoint(-1.5F, -3.317F, 2.567F);
        Torso.addChild(Neck);
        Neck.cubeList.add(new ModelBox(Neck, 112, 97, -2.0F, 5.0F, 0.0F, 4, 2, 4, 0.0F));

        tag = new ModelRenderer(this);
        tag.setRotationPoint(0.0F, 5.325F, 0.0F);
        Neck.addChild(tag);


        tag_r1 = new ModelRenderer(this);
        tag_r1.setRotationPoint(0.0F, 0.675F, 2.0F);
        tag.addChild(tag_r1);
        setRotationAngle(tag_r1, -0.3491F, 0.0F, 0.0F);
        tag_r1.cubeList.add(new ModelBox(tag_r1, 54, 83, -0.5F, -0.2305F, -2.1143F, 1, 2, 0, 0.0F));

        hitbox = new ModelRenderer(this);
        hitbox.setRotationPoint(-0.25F, -5.0F, -8.0F);
        hitbox.cubeList.add(new ModelBox(hitbox, 0, 134, -12.75F, -3.0F, -5.0F, 26, 32, 26, 0.0F));
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        Rachne.render(f5);
        hitbox.render(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
