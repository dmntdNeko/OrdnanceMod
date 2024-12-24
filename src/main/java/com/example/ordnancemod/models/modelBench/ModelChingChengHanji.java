package com.example.ordnancemod.models.modelBench;
// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelChingChengHanji extends ModelBase {
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
    private final ModelRenderer hexadecagon2;
    private final ModelRenderer hexadecagon_r1;
    private final ModelRenderer hexadecagon_r2;
    private final ModelRenderer hexadecagon_r3;
    private final ModelRenderer hexadecagon_r4;
    private final ModelRenderer hexadecagon;
    private final ModelRenderer hexadecagon_r5;
    private final ModelRenderer hexadecagon_r6;
    private final ModelRenderer hexadecagon_r7;
    private final ModelRenderer hexadecagon_r8;

    public ModelChingChengHanji() {
        textureWidth = 512;
        textureHeight = 512;

        MainModel = new ModelRenderer(this);
        MainModel.setRotationPoint(-0.1499F, 66.5938F, 1.6832F);
        setRotationAngle(MainModel, 0.0F, 0.0F, -3.1416F);
        MainModel.cubeList.add(new ModelBox(MainModel, 194, 262, -13.8501F, 12.4062F, -14.6832F, 28, 14, 23, 0.0F));
        MainModel.cubeList.add(new ModelBox(MainModel, 330, 296, -13.8501F, 5.4062F, -14.6832F, 28, 14, 19, 0.0F));
        MainModel.cubeList.add(new ModelBox(MainModel, 331, 259, -13.8501F, 20.4062F, -16.6832F, 28, 14, 21, 0.0F));
        MainModel.cubeList.add(new ModelBox(MainModel, 330, 206, -15.8501F, -12.5938F, -17.6832F, 32, 18, 20, 0.0F));
        MainModel.cubeList.add(new ModelBox(MainModel, 112, 178, 7.1499F, -16.5938F, -19.6832F, 11, 13, 12, 0.0F));
        MainModel.cubeList.add(new ModelBox(MainModel, 0, 172, -17.8501F, -16.5938F, -19.6832F, 11, 13, 12, 0.0F));
        MainModel.cubeList.add(new ModelBox(MainModel, 0, 0, -9.8501F, -17.5938F, -11.6832F, 20, 19, 20, 0.0F));
        MainModel.cubeList.add(new ModelBox(MainModel, 44, 86, -6.8501F, -7.5938F, 8.3168F, 13, 9, 3, 0.0F));
        MainModel.cubeList.add(new ModelBox(MainModel, 0, 143, -4.8501F, 31.4062F, 2.3168F, 13, 5, 9, 0.0F));
        MainModel.cubeList.add(new ModelBox(MainModel, 0, 0, -1.8501F, -8.5938F, 10.3168F, 3, 2, 2, 0.0F));

        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(3.4505F, -1.7975F, 13.778F);
        MainModel.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.6077F, -0.0376F, 0.1705F);
        cube_r1.cubeList.add(new ModelBox(cube_r1, 251, 5, -9.5F, -4.5F, -1.0F, 3, 11, 0, 0.0F));

        cube_r2 = new ModelRenderer(this);
        cube_r2.setRotationPoint(3.4505F, -1.7975F, 13.778F);
        MainModel.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.6077F, 0.0376F, -0.1705F);
        cube_r2.cubeList.add(new ModelBox(cube_r2, 238, 5, -1.5F, -5.5F, 0.0F, 3, 11, 0, 0.0F));

        cube_r3 = new ModelRenderer(this);
        cube_r3.setRotationPoint(-10.8501F, -15.5938F, -4.6832F);
        MainModel.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.2182F, 0.0F, -1.1781F);
        cube_r3.cubeList.add(new ModelBox(cube_r3, 0, 0, 4.0F, 17.0F, -6.0F, 8, 7, 2, 0.0F));

        cube_r4 = new ModelRenderer(this);
        cube_r4.setRotationPoint(-10.8501F, -15.5938F, -4.6832F);
        MainModel.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.2182F, 0.0F, 1.1781F);
        cube_r4.cubeList.add(new ModelBox(cube_r4, 0, 9, -3.0F, -3.0F, -1.0F, 8, 7, 2, 0.0F));

        cube_r5 = new ModelRenderer(this);
        cube_r5.setRotationPoint(0.1499F, -21.5938F, -0.6832F);
        MainModel.addChild(cube_r5);
        setRotationAngle(cube_r5, -0.1309F, 0.0F, 0.0F);
        cube_r5.cubeList.add(new ModelBox(cube_r5, 0, 40, -3.0F, -6.0F, -3.0F, 6, 1, 6, 0.0F));
        cube_r5.cubeList.add(new ModelBox(cube_r5, 44, 143, -4.0F, -5.0F, -4.0F, 8, 4, 8, 0.0F));
        cube_r5.cubeList.add(new ModelBox(cube_r5, 44, 40, -1.0F, -8.0F, -1.0F, 2, 1, 2, 0.0F));
        cube_r5.cubeList.add(new ModelBox(cube_r5, 0, 57, -2.0F, -7.0F, -2.0F, 4, 1, 4, 0.0F));
        cube_r5.cubeList.add(new ModelBox(cube_r5, 0, 40, -3.0F, -4.0F, -3.0F, 6, 4, 6, 0.0F));
        cube_r5.cubeList.add(new ModelBox(cube_r5, 60, 0, -2.0F, -3.0F, -2.0F, 4, 4, 4, 0.0F));

        cube_r6 = new ModelRenderer(this);
        cube_r6.setRotationPoint(16.2481F, 31.1444F, -0.3F);
        MainModel.addChild(cube_r6);
        setRotationAngle(cube_r6, 0.0448F, -0.0899F, 0.5118F);
        cube_r6.cubeList.add(new ModelBox(cube_r6, 112, 0, -41.0F, 10.0F, -1.0F, 26, 10, 12, 0.0F));

        cube_r7 = new ModelRenderer(this);
        cube_r7.setRotationPoint(17.1499F, 27.4062F, -4.6832F);
        MainModel.addChild(cube_r7);
        setRotationAngle(cube_r7, 0.0448F, 0.0899F, -0.5118F);
        cube_r7.cubeList.add(new ModelBox(cube_r7, 112, 22, -16.0F, -2.0F, -2.0F, 26, 10, 12, 0.0F));

        cube_r8 = new ModelRenderer(this);
        cube_r8.setRotationPoint(12.3686F, 29.3866F, 16.8451F);
        MainModel.addChild(cube_r8);
        setRotationAngle(cube_r8, 0.0F, 0.3491F, 0.3927F);
        cube_r8.cubeList.add(new ModelBox(cube_r8, 0, 119, -31.5F, 3.0F, -34.0F, 20, 12, 12, 0.0F));

        cube_r9 = new ModelRenderer(this);
        cube_r9.setRotationPoint(19.6363F, 26.3763F, -4.7679F);
        MainModel.addChild(cube_r9);
        setRotationAngle(cube_r9, 0.0F, -0.3491F, -0.3927F);
        cube_r9.cubeList.add(new ModelBox(cube_r9, 112, 126, -10.5F, -6.0F, -6.0F, 19, 12, 12, 0.0F));

        cube_r10 = new ModelRenderer(this);
        cube_r10.setRotationPoint(-6.1209F, 7.6427F, 13.0258F);
        MainModel.addChild(cube_r10);
        setRotationAngle(cube_r10, 0.0934F, 0.1537F, 0.1373F);
        cube_r10.cubeList.add(new ModelBox(cube_r10, 152, 44, -6.0F, -5.0F, -6.0F, 12, 10, 8, 0.0F));

        cube_r11 = new ModelRenderer(this);
        cube_r11.setRotationPoint(14.6505F, 7.0071F, 1.974F);
        MainModel.addChild(cube_r11);
        setRotationAngle(cube_r11, 0.0961F, 0.6536F, 0.1323F);
        cube_r11.cubeList.add(new ModelBox(cube_r11, 112, 44, -29.0F, -2.0F, -31.0F, 8, 10, 24, 0.0F));

        cube_r12 = new ModelRenderer(this);
        cube_r12.setRotationPoint(4.2367F, 6.748F, 15.4085F);
        MainModel.addChild(cube_r12);
        setRotationAngle(cube_r12, 1.0647F, -1.4836F, -1.1368F);
        cube_r12.cubeList.add(new ModelBox(cube_r12, 44, 39, -5.0F, -5.0F, -7.0F, 6, 10, 12, 0.0F));

        cube_r13 = new ModelRenderer(this);
        cube_r13.setRotationPoint(14.6505F, 7.0071F, 1.974F);
        MainModel.addChild(cube_r13);
        setRotationAngle(cube_r13, 0.0961F, -0.6536F, -0.1323F);
        cube_r13.cubeList.add(new ModelBox(cube_r13, 112, 92, -3.0F, -5.0F, -12.0F, 8, 10, 24, 0.0F));

        cube_r14 = new ModelRenderer(this);
        cube_r14.setRotationPoint(18.4133F, -2.8392F, -9.5202F);
        MainModel.addChild(cube_r14);
        setRotationAngle(cube_r14, -1.3963F, -0.3054F, 0.1745F);
        cube_r14.cubeList.add(new ModelBox(cube_r14, 0, 39, -40.0F, -15.0F, -4.0F, 10, 9, 24, 0.0F));

        cube_r15 = new ModelRenderer(this);
        cube_r15.setRotationPoint(18.4133F, -2.8392F, -9.5202F);
        MainModel.addChild(cube_r15);
        setRotationAngle(cube_r15, -1.3963F, 0.3054F, -0.0873F);
        cube_r15.cubeList.add(new ModelBox(cube_r15, 0, 86, -5.0F, -5.0F, -12.0F, 10, 9, 24, 0.0F));

        hexadecagon2 = new ModelRenderer(this);
        hexadecagon2.setRotationPoint(0.1499F, -18.5938F, -1.6832F);
        MainModel.addChild(hexadecagon2);
        setRotationAngle(hexadecagon2, -0.0873F, 0.0F, 0.0F);
        hexadecagon2.cubeList.add(new ModelBox(hexadecagon2, 224, 0, -7.5587F, -2.0F, -38.0F, 15, 3, 76, 0.0F));
        hexadecagon2.cubeList.add(new ModelBox(hexadecagon2, 328, 171, -38.0F, -2.0F, -7.5587F, 76, 3, 15, 0.0F));

        hexadecagon_r1 = new ModelRenderer(this);
        hexadecagon_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        hexadecagon2.addChild(hexadecagon_r1);
        setRotationAngle(hexadecagon_r1, 0.0F, -0.3927F, 0.0F);
        hexadecagon_r1.cubeList.add(new ModelBox(hexadecagon_r1, 0, 327, -38.0F, -2.0F, -7.5587F, 76, 3, 15, 0.0F));
        hexadecagon_r1.cubeList.add(new ModelBox(hexadecagon_r1, 222, 178, -7.5587F, -2.0F, -38.0F, 15, 3, 76, 0.0F));

        hexadecagon_r2 = new ModelRenderer(this);
        hexadecagon_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
        hexadecagon2.addChild(hexadecagon_r2);
        setRotationAngle(hexadecagon_r2, 0.0F, 0.3927F, 0.0F);
        hexadecagon_r2.cubeList.add(new ModelBox(hexadecagon_r2, 328, 189, -38.0F, -2.0F, -7.5587F, 76, 3, 15, 0.0F));
        hexadecagon_r2.cubeList.add(new ModelBox(hexadecagon_r2, 224, 92, -7.5587F, -2.0F, -38.0F, 15, 3, 76, 0.0F));

        hexadecagon_r3 = new ModelRenderer(this);
        hexadecagon_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
        hexadecagon2.addChild(hexadecagon_r3);
        setRotationAngle(hexadecagon_r3, 0.0F, -0.7854F, 0.0F);
        hexadecagon_r3.cubeList.add(new ModelBox(hexadecagon_r3, 116, 182, -7.5587F, -2.0F, -38.0F, 15, 3, 76, 0.0F));

        hexadecagon_r4 = new ModelRenderer(this);
        hexadecagon_r4.setRotationPoint(0.0F, 0.0F, 0.0F);
        hexadecagon2.addChild(hexadecagon_r4);
        setRotationAngle(hexadecagon_r4, 0.0F, 0.7854F, 0.0F);
        hexadecagon_r4.cubeList.add(new ModelBox(hexadecagon_r4, 222, 257, -7.5587F, -2.0F, -38.0F, 15, 3, 76, 0.0F));

        hexadecagon = new ModelRenderer(this);
        hexadecagon.setRotationPoint(0.1499F, 41.4062F, -1.6832F);
        MainModel.addChild(hexadecagon);
        hexadecagon.cubeList.add(new ModelBox(hexadecagon, 112, 6, -7.9565F, -5.0F, -40.0F, 15, 6, 80, 0.0F));
        hexadecagon.cubeList.add(new ModelBox(hexadecagon, 0, 283, -40.0F, -5.0F, -7.9565F, 80, 6, 15, 0.0F));

        hexadecagon_r5 = new ModelRenderer(this);
        hexadecagon_r5.setRotationPoint(0.0F, 0.0F, 0.0F);
        hexadecagon.addChild(hexadecagon_r5);
        setRotationAngle(hexadecagon_r5, 0.0F, -0.3927F, 0.0F);
        hexadecagon_r5.cubeList.add(new ModelBox(hexadecagon_r5, 0, 261, -40.0F, -5.0F, -7.9565F, 80, 6, 15, 0.0F));
        hexadecagon_r5.cubeList.add(new ModelBox(hexadecagon_r5, 0, 86, -7.9565F, -5.0F, -40.0F, 15, 6, 80, 0.0F));

        hexadecagon_r6 = new ModelRenderer(this);
        hexadecagon_r6.setRotationPoint(0.0F, 0.0F, 0.0F);
        hexadecagon.addChild(hexadecagon_r6);
        setRotationAngle(hexadecagon_r6, 0.0F, 0.3927F, 0.0F);
        hexadecagon_r6.cubeList.add(new ModelBox(hexadecagon_r6, 0, 305, -40.0F, -5.0F, -7.9565F, 80, 6, 15, 0.0F));
        hexadecagon_r6.cubeList.add(new ModelBox(hexadecagon_r6, 112, 92, -7.9565F, -5.0F, -40.0F, 15, 6, 80, 0.0F));

        hexadecagon_r7 = new ModelRenderer(this);
        hexadecagon_r7.setRotationPoint(0.0F, 0.0F, 0.0F);
        hexadecagon.addChild(hexadecagon_r7);
        setRotationAngle(hexadecagon_r7, 0.0F, -0.7854F, 0.0F);
        hexadecagon_r7.cubeList.add(new ModelBox(hexadecagon_r7, 0, 0, -7.9565F, -5.0F, -40.0F, 15, 6, 80, 0.0F));

        hexadecagon_r8 = new ModelRenderer(this);
        hexadecagon_r8.setRotationPoint(0.0F, 0.0F, 0.0F);
        hexadecagon.addChild(hexadecagon_r8);
        setRotationAngle(hexadecagon_r8, 0.0F, 0.7854F, 0.0F);
        hexadecagon_r8.cubeList.add(new ModelBox(hexadecagon_r8, 0, 172, -7.9565F, -5.0F, -40.0F, 15, 6, 80, 0.0F));
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