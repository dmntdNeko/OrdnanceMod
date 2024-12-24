package com.example.ordnancemod.models.entityModels;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMinecartHeavy extends ModelBase {
    /*private final ModelRenderer minecartHeavy;
    

    public ModelMinecartHeavy() {
        textureWidth = 128;
        textureHeight = 128;

        minecartHeavy = new ModelRenderer(this);
        minecartHeavy.setRotationPoint(0.0F, 0.0F, 0.0F);
        minecartHeavy.cubeList.add(new ModelBox(minecartHeavy, 0, 0, -9.0F, -3.0F, -8.0F, 18, 1, 16, 0.0F));
        minecartHeavy.cubeList.add(new ModelBox(minecartHeavy, 36, 26, -9.0F, -3.0F, -8.0F, 18, 8, 1, 0.0F));
        minecartHeavy.cubeList.add(new ModelBox(minecartHeavy, 18, 17, -9.0F, -3.0F, 7.0F, 18, 8, 1, 0.0F));
        minecartHeavy.cubeList.add(new ModelBox(minecartHeavy, 18, 27, 8.0F, -3.0F, -8.0F, 1, 10, 16, 0.0F));
        minecartHeavy.cubeList.add(new ModelBox(minecartHeavy, 0, 17, -9.0F, -3.0F, -8.0F, 1, 10, 16, 0.0F));
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        minecartHeavy.render(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }*/

    public final ModelRenderer cart;
    public final ModelRenderer platform;
    public final ModelRenderer turret;
    public final ModelRenderer octagon;
    public final ModelRenderer octagon_r1;
    public final ModelRenderer turretwall;
    public final ModelRenderer cube_r1;
    public final ModelRenderer cube_r2;
    public final ModelRenderer cube_r3;
    public final ModelRenderer cube_r4;
    public final ModelRenderer cube_r5;
    public final ModelRenderer cube_r6;
    public final ModelRenderer cube_r7;
    public final ModelRenderer turretgun;

    public ModelMinecartHeavy() {
        textureWidth = 128;
        textureHeight = 128;

        cart = new ModelRenderer(this);
        cart.setRotationPoint(0.0F, 24.0F, 0.0F);
        cart.cubeList.add(new ModelBox(cart, 0, 0, -9.0F, 2.0F, -8.0F, 18, 1, 16, 0.0F));
        cart.cubeList.add(new ModelBox(cart, 64, 38, -9.0F, -5.0F, -8.0F, 18, 8, 1, 0.0F));
        cart.cubeList.add(new ModelBox(cart, 64, 29, -9.0F, -5.0F, 7.0F, 18, 8, 1, 0.0F));
        cart.cubeList.add(new ModelBox(cart, 52, 1, 8.0F, -7.0F, -8.0F, 1, 10, 16, 0.0F));
        cart.cubeList.add(new ModelBox(cart, 0, 51, -9.0F, -7.0F, -8.0F, 1, 10, 16, 0.0F));

        platform = new ModelRenderer(this);
        platform.setRotationPoint(0.0F, 25.0F, 0.0F);
        platform.cubeList.add(new ModelBox(platform, 0, 17, -8.0F, -9.0F, -7.0F, 16, 1, 14, 0.0F));
        platform.cubeList.add(new ModelBox(platform, 52, 0, 4.0F, -8.0F, -7.0F, 4, 8, 4, 0.0F));
        platform.cubeList.add(new ModelBox(platform, 0, 51, -8.0F, -8.0F, -7.0F, 4, 8, 4, 0.0F));
        platform.cubeList.add(new ModelBox(platform, 0, 0, -8.0F, -8.0F, 3.0F, 4, 8, 4, 0.0F));
        platform.cubeList.add(new ModelBox(platform, 18, 77, 4.0F, -8.0F, 3.0F, 4, 8, 4, 0.0F));

        turret = new ModelRenderer(this);
        turret.setRotationPoint(0.0F, 25.0F, 0.0F);


        octagon = new ModelRenderer(this);
        octagon.setRotationPoint(8.0F, -2.0F, -8.0F);
        turret.addChild(octagon);
        octagon.cubeList.add(new ModelBox(octagon, 0, 32, -11.3137F, -8.0F, -1.0F, 6, 1, 18, 0.0F));
        octagon.cubeList.add(new ModelBox(octagon, 18, 52, -17.0F, -8.0F, 4.6863F, 18, 1, 6, 0.0F));

        octagon_r1 = new ModelRenderer(this);
        octagon_r1.setRotationPoint(-8.0F, -8.0F, 8.0F);
        octagon.addChild(octagon_r1);
        setRotationAngle(octagon_r1, 0.0F, -0.7854F, 0.0F);
        octagon_r1.cubeList.add(new ModelBox(octagon_r1, 34, 60, -9.0F, 0.0F, -3.3137F, 18, 1, 6, 0.0F));
        octagon_r1.cubeList.add(new ModelBox(octagon_r1, 32, 33, -3.3137F, 0.0F, -9.0F, 6, 1, 18, 0.0F));

        turretwall = new ModelRenderer(this);
        turretwall.setRotationPoint(10.0F, -2.0F, -8.0F);
        turret.addChild(turretwall);
        turretwall.cubeList.add(new ModelBox(turretwall, 10, 32, -1.0F, -13.0F, 4.0F, 1, 6, 2, 0.0F));
        turretwall.cubeList.add(new ModelBox(turretwall, 0, 32, -1.0F, -13.0F, 10.0F, 1, 6, 2, 0.0F));

        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(-3.182F, -8.5F, 1.5251F);
        turretwall.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, 0.7854F, 0.0F);
        cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 32, -0.5F, -4.5F, -4.0F, 1, 6, 8, 0.0F));

        cube_r2 = new ModelRenderer(this);
        cube_r2.setRotationPoint(-9.6569F, -8.5F, -1.1569F);
        turretwall.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, 1.5708F, 0.0F);
        cube_r2.cubeList.add(new ModelBox(cube_r2, 32, 32, -0.5F, -4.5F, -4.0F, 1, 6, 8, 0.0F));

        cube_r3 = new ModelRenderer(this);
        cube_r3.setRotationPoint(-20.3744F, -8.5F, 5.7678F);
        turretwall.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.0F, 2.3562F, 0.0F);
        cube_r3.cubeList.add(new ModelBox(cube_r3, 34, 68, -0.5F, -4.5F, 2.0F, 1, 6, 8, 0.0F));

        cube_r4 = new ModelRenderer(this);
        cube_r4.setRotationPoint(-18.8137F, -9.0F, 14.0F);
        turretwall.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.0F, 3.1416F, 0.0F);
        cube_r4.cubeList.add(new ModelBox(cube_r4, 52, 68, -0.5F, -4.0F, 2.0F, 1, 6, 8, 0.0F));

        cube_r5 = new ModelRenderer(this);
        cube_r5.setRotationPoint(-16.1317F, -9.0F, 14.4749F);
        turretwall.addChild(cube_r5);
        setRotationAngle(cube_r5, 0.0F, -2.3562F, 0.0F);
        cube_r5.cubeList.add(new ModelBox(cube_r5, 70, 0, -0.5F, -4.0F, -4.0F, 1, 6, 8, 0.0F));

        cube_r6 = new ModelRenderer(this);
        cube_r6.setRotationPoint(-4.6569F, -9.0F, 15.1569F);
        turretwall.addChild(cube_r6);
        setRotationAngle(cube_r6, 0.0F, -1.5708F, 0.0F);
        cube_r6.cubeList.add(new ModelBox(cube_r6, 70, 68, 1.5F, -4.0F, 1.0F, 1, 6, 8, 0.0F));

        cube_r7 = new ModelRenderer(this);
        cube_r7.setRotationPoint(-1.0607F, -9.0F, 8.1109F);
        turretwall.addChild(cube_r7);
        setRotationAngle(cube_r7, 0.0F, -0.7854F, 0.0F);
        cube_r7.cubeList.add(new ModelBox(cube_r7, 0, 77, 2.5F, -4.0F, 2.0F, 1, 6, 8, 0.0F));

        turretgun = new ModelRenderer(this);
        turretgun.setRotationPoint(0.0F, -1.0F, 0.0F);
        turret.addChild(turretgun);
        turretgun.cubeList.add(new ModelBox(turretgun, 46, 27, 4.0F, -12.0F, -0.5F, 24, 1, 1, 0.0F));
        turretgun.cubeList.add(new ModelBox(turretgun, 0, 46, 1.0F, -12.5F, -1.0F, 7, 2, 2, 0.0F));
        turretgun.cubeList.add(new ModelBox(turretgun, 5, 21, 6.0F, -13.0F, -1.5F, 1, 4, 3, 0.0F));
        turretgun.cubeList.add(new ModelBox(turretgun, 0, 17, 2.0F, -13.0F, -1.5F, 1, 4, 3, 0.0F));
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        cart.render(f5);
        platform.render(f5);
        turret.render(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
