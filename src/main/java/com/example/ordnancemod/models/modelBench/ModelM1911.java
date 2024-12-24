package com.example.ordnancemod.models.modelBench;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelM1911 extends ModelBase {
    public final ModelRenderer mainModel;
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

    public ModelM1911() {
        textureWidth = 128;
        textureHeight = 128;

        mainModel = new ModelRenderer(this);
        mainModel.setRotationPoint(0.0F, 21.1936F, 0.0F);


        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(-0.1F, -3.0F, -0.6339F);
        mainModel.addChild(cube_r1);
        setRotationAngle(cube_r1, -0.1745F, 0.0F, 3.1416F);
        cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 28, 0.65F, 1.98F, -8.7975F, 1, 10, 4, 0.0F));
        cube_r1.cubeList.add(new ModelBox(cube_r1, 11, 28, -1.45F, 1.98F, -8.7975F, 1, 10, 4, 0.0F));
        cube_r1.cubeList.add(new ModelBox(cube_r1, 27, 28, 0.6F, -3.2321F, -11.5782F, 1, 3, 1, 0.0F));
        cube_r1.cubeList.add(new ModelBox(cube_r1, 31, 15, -1.4F, -3.2321F, -11.5782F, 1, 3, 1, 0.0F));
        cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 0, -1.4F, 0.171F, -9.2307F, 3, 12, 5, 0.0F));

        cube_r2 = new ModelRenderer(this);
        cube_r2.setRotationPoint(-0.1F, -3.0F, -0.6339F);
        mainModel.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, 0.0F, -3.1416F);
        cube_r2.cubeList.add(new ModelBox(cube_r2, 37, 28, -1.4F, 0.8064F, -10.3661F, 3, 5, 1, 0.0F));
        cube_r2.cubeList.add(new ModelBox(cube_r2, 18, 0, 0.35F, -6.1936F, -9.3661F, 1, 1, 1, 0.0F));
        cube_r2.cubeList.add(new ModelBox(cube_r2, 38, 7, -1.15F, -6.1936F, -9.3661F, 1, 1, 1, 0.0F));
        cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 0, -0.4F, -0.1936F, -5.1161F, 1, 3, 1, 0.0F));
        cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 43, -0.4F, 2.8064F, -5.1161F, 1, 1, 4, 0.0F));
        cube_r2.cubeList.add(new ModelBox(cube_r2, 27, 37, -0.9F, -2.3186F, 7.1339F, 2, 2, 6, 0.0F));
        cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 0, -1.4F, -5.1936F, -10.8411F, 3, 3, 24, 0.0F));
        cube_r2.cubeList.add(new ModelBox(cube_r2, 27, 28, -1.4F, -2.1936F, -11.3661F, 3, 2, 19, 0.0F));

        cube_r3 = new ModelRenderer(this);
        cube_r3.setRotationPoint(-0.1F, -3.0F, -0.6339F);
        mainModel.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.0F, 0.0F, 2.3562F);
        cube_r3.cubeList.add(new ModelBox(cube_r3, 31, 7, -0.1156F, -2.5107F, -5.3661F, 1, 1, 4, 0.0F));
        cube_r3.cubeList.add(new ModelBox(cube_r3, 38, 37, 3.3265F, -4.1851F, 11.8839F, 1, 1, 1, 0.0F));
        cube_r3.cubeList.add(new ModelBox(cube_r3, 41, 15, 0.5157F, -1.3743F, 12.3839F, 1, 1, 1, 0.0F));
        cube_r3.cubeList.add(new ModelBox(cube_r3, 38, 40, 2.1825F, -3.041F, -10.9661F, 1, 1, 1, 0.0F));

        cube_r4 = new ModelRenderer(this);
        cube_r4.setRotationPoint(-0.1F, -3.0F, -0.6339F);
        mainModel.addChild(cube_r4);
        setRotationAngle(cube_r4, -0.3054F, 0.0F, 3.1416F);
        cube_r4.cubeList.add(new ModelBox(cube_r4, 18, 28, -0.4F, 1.1572F, -4.6599F, 1, 2, 1, 0.0F));

        cube_r5 = new ModelRenderer(this);
        cube_r5.setRotationPoint(-0.1F, -3.0F, -0.6339F);
        mainModel.addChild(cube_r5);
        setRotationAngle(cube_r5, 0.3054F, 0.0F, -3.1416F);
        cube_r5.cubeList.add(new ModelBox(cube_r5, 27, 37, -0.4F, -0.6653F, -5.4456F, 1, 2, 1, 0.0F));
        cube_r5.cubeList.add(new ModelBox(cube_r5, 0, 18, -1.4F, 0.0274F, 7.0443F, 3, 1, 4, 0.0F));

        cube_r6 = new ModelRenderer(this);
        cube_r6.setRotationPoint(-0.1F, -3.0F, -0.6339F);
        mainModel.addChild(cube_r6);
        setRotationAngle(cube_r6, 0.7854F, 0.0F, -3.1416F);
        cube_r6.cubeList.add(new ModelBox(cube_r6, 17, 5, -0.4F, 0.9024F, -3.4807F, 1, 1, 2, 0.0F));

        cube_r7 = new ModelRenderer(this);
        cube_r7.setRotationPoint(-0.1F, -3.0F, -0.6339F);
        mainModel.addChild(cube_r7);
        setRotationAngle(cube_r7, 1.5708F, 0.0F, -3.1416F);
        cube_r7.cubeList.add(new ModelBox(cube_r7, 12, 0, -0.4F, -0.7019F, -2.3922F, 1, 1, 3, 0.0F));

        cube_r8 = new ModelRenderer(this);
        cube_r8.setRotationPoint(-0.1F, -3.0F, -0.6339F);
        mainModel.addChild(cube_r8);
        setRotationAngle(cube_r8, 0.0F, 0.0F, -2.3562F);
        cube_r8.cubeList.add(new ModelBox(cube_r8, 17, 9, -3.7178F, -3.8592F, 12.3839F, 2, 2, 1, 0.0F));

        cube_r9 = new ModelRenderer(this);
        cube_r9.setRotationPoint(-0.1F, -3.0F, -0.6339F);
        mainModel.addChild(cube_r9);
        setRotationAngle(cube_r9, -3.1416F, 0.0F, 2.0508F);
        cube_r9.cubeList.add(new ModelBox(cube_r9, 13, 14, 4.1772F, 0.997F, -0.1589F, 1, 1, 4, 0.0F));
        cube_r9.cubeList.add(new ModelBox(cube_r9, 31, 15, 4.2659F, 1.0431F, 3.8411F, 1, 1, 7, 0.0F));
        cube_r9.cubeList.add(new ModelBox(cube_r9, 47, 2, 4.2659F, 1.0431F, -13.1589F, 1, 1, 13, 0.0F));

        cube_r10 = new ModelRenderer(this);
        cube_r10.setRotationPoint(-0.1F, -3.0F, -0.6339F);
        mainModel.addChild(cube_r10);
        setRotationAngle(cube_r10, -3.1416F, 0.0F, 1.5708F);
        cube_r10.cubeList.add(new ModelBox(cube_r10, 11, 43, 4.5143F, -0.6192F, -0.1589F, 1, 1, 4, 0.0F));
        cube_r10.cubeList.add(new ModelBox(cube_r10, 27, 28, 4.6143F, -0.6192F, 3.8411F, 1, 1, 7, 0.0F));
        cube_r10.cubeList.add(new ModelBox(cube_r10, 31, 0, 4.6143F, -0.6192F, -13.1589F, 1, 1, 13, 0.0F));

        cube_r11 = new ModelRenderer(this);
        cube_r11.setRotationPoint(-0.1F, -3.0F, -0.6339F);
        mainModel.addChild(cube_r11);
        setRotationAngle(cube_r11, 0.0F, 0.0F, 2.7053F);
        cube_r11.cubeList.add(new ModelBox(cube_r11, 0, 28, 1.0276F, -5.2492F, -10.8411F, 1, 1, 24, 0.0F));

        cube_r12 = new ModelRenderer(this);
        cube_r12.setRotationPoint(-0.1F, -3.0F, -0.6339F);
        mainModel.addChild(cube_r12);
        setRotationAngle(cube_r12, 0.6109F, 0.0F, 3.1416F);
        cube_r12.cubeList.add(new ModelBox(cube_r12, 15, 20, -0.4F, -9.6605F, -10.3141F, 1, 1, 2, 0.0F));

        cube_r13 = new ModelRenderer(this);
        cube_r13.setRotationPoint(-0.1F, -3.0F, -0.6339F);
        mainModel.addChild(cube_r13);
        setRotationAngle(cube_r13, 0.9163F, 0.0F, -3.1416F);
        cube_r13.cubeList.add(new ModelBox(cube_r13, 7, 28, -0.4F, -11.9391F, -5.9121F, 1, 2, 1, 0.0F));

        cube_r14 = new ModelRenderer(this);
        cube_r14.setRotationPoint(-0.1F, -3.0F, -0.6339F);
        mainModel.addChild(cube_r14);
        setRotationAngle(cube_r14, 0.7418F, 0.0F, -3.1416F);
        cube_r14.cubeList.add(new ModelBox(cube_r14, 31, 0, -1.4F, -8.8467F, -8.6852F, 3, 4, 2, 0.0F));
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
