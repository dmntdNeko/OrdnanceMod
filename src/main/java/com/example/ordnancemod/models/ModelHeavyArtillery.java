package com.example.ordnancemod.models;// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHeavyArtillery extends ModelBase {
	public ModelRenderer mainGun;
	public ModelRenderer platform;
	public ModelRenderer cube_r1;
	public ModelRenderer carriage;
	public ModelRenderer wheelSystem;
	public ModelRenderer axel_r1;
	public ModelRenderer wheel2;
	public ModelRenderer hexadecagon_r1;
	public ModelRenderer hexadecagon_r2;
	public ModelRenderer hexadecagon_r3;
	public ModelRenderer hexadecagon_r4;
	public ModelRenderer wheel1;
	public ModelRenderer hexadecagon_r5;
	public ModelRenderer hexadecagon_r6;
	public ModelRenderer hexadecagon_r7;
	public ModelRenderer hexadecagon_r8;
	public ModelRenderer treads2;
	public ModelRenderer hexadecagon_r9;
	public ModelRenderer hexadecagon_r10;
	public ModelRenderer treads1;
	public ModelRenderer hexadecagon_r11;
	public ModelRenderer hexadecagon_r12;
	public ModelRenderer shield;
	public ModelRenderer cube_r2;
	public ModelRenderer hexadecagon_r13;
	public ModelRenderer hexadecagon_r14;
	public ModelRenderer hexadecagon_r15;
	public ModelRenderer bb_main;
	public ModelRenderer bolt_r1;

	public ModelHeavyArtillery() {
		textureWidth = 512;
		textureHeight = 512;

		mainGun = new ModelRenderer(this);
		mainGun.setRotationPoint(0.0F, -5.0F, -7.0F);
		setRotationAngle(mainGun, -0.1309F, 0.0F, 0.0F);
		mainGun.cubeList.add(new ModelBox(mainGun, 0, 102, -3.5538F, -7.2189F, -88.4164F, 7, 7, 78, 0.0F));
		mainGun.cubeList.add(new ModelBox(mainGun, 130, 159, -4.5538F, -8.2189F, -48.4164F, 9, 9, 40, 0.0F));
		mainGun.cubeList.add(new ModelBox(mainGun, 99, 42, -2.5538F, -14.2189F, -41.4164F, 5, 5, 33, 0.0F));
		mainGun.cubeList.add(new ModelBox(mainGun, 99, 0, -3.5538F, -0.2189F, -43.4164F, 7, 7, 35, 0.0F));
		mainGun.cubeList.add(new ModelBox(mainGun, 142, 42, -6.5538F, -10.2189F, -21.4164F, 12, 13, 14, 0.0F));
		mainGun.cubeList.add(new ModelBox(mainGun, 44, 22, -6.5538F, 0.7811F, -8.4164F, 12, 1, 12, 0.0F));
		mainGun.cubeList.add(new ModelBox(mainGun, 109, 59, 4.4462F, -4.2189F, -7.4164F, 1, 6, 10, 0.0F));
		mainGun.cubeList.add(new ModelBox(mainGun, 0, 102, -6.5538F, -4.2189F, -7.4164F, 1, 6, 10, 0.0F));

		platform = new ModelRenderer(this);
		platform.setRotationPoint(0.0F, -8.0F, -18.0F);
		platform.cubeList.add(new ModelBox(platform, 92, 109, -14.5538F, 10.0F, 15.7291F, 28, 1, 49, 0.0F));
		platform.cubeList.add(new ModelBox(platform, 0, 72, 6.4462F, 10.0F, 6.7291F, 7, 1, 9, 0.0F));
		platform.cubeList.add(new ModelBox(platform, 0, 27, -14.5538F, 10.0F, 6.7291F, 7, 1, 9, 0.0F));

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(7.9462F, 16.5F, 55.2291F);
		platform.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.1309F, 0.0F, 0.0F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 27, -16.5F, -6.5F, 0.5F, 2, 7, 2, 0.0F));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 44, 22, -2.5F, -6.5F, 0.5F, 2, 7, 2, 0.0F));

		carriage = new ModelRenderer(this);
		carriage.setRotationPoint(0.0F, -3.0F, -20.0F);
		setRotationAngle(carriage, -0.1309F, 0.0F, 0.0F);
		carriage.cubeList.add(new ModelBox(carriage, 99, 7, 6.4462F, 3.2832F, -22.7196F, 2, 7, 95, 0.0F));
		carriage.cubeList.add(new ModelBox(carriage, 0, 0, -9.5538F, 3.2832F, -22.7196F, 2, 7, 95, 0.0F));
		carriage.cubeList.add(new ModelBox(carriage, 0, 45, 5.4462F, -3.7168F, -28.7196F, 3, 7, 38, 0.0F));
		carriage.cubeList.add(new ModelBox(carriage, 0, 0, -9.5538F, -3.7168F, -28.7196F, 3, 7, 38, 0.0F));
		carriage.cubeList.add(new ModelBox(carriage, 44, 0, -9.5538F, 2.7832F, 66.7804F, 18, 16, 6, 0.0F));
		carriage.cubeList.add(new ModelBox(carriage, 148, 22, -7.5538F, 4.7832F, -22.2196F, 14, 6, 2, 0.0F));
		carriage.cubeList.add(new ModelBox(carriage, 99, 27, -7.5538F, 4.7832F, -5.2196F, 14, 6, 2, 0.0F));

		wheelSystem = new ModelRenderer(this);
		wheelSystem.setRotationPoint(20.0F, 18.0F, -23.0F);
		

		axel_r1 = new ModelRenderer(this);
		axel_r1.setRotationPoint(-20.0538F, -8.5F, -7.7709F);
		wheelSystem.addChild(axel_r1);
		setRotationAngle(axel_r1, -0.7854F, 0.0F, 0.0F);
		axel_r1.cubeList.add(new ModelBox(axel_r1, 148, 0, -22.5F, -1.5F, -0.5F, 45, 3, 3, 0.0F));

		wheel2 = new ModelRenderer(this);
		wheel2.setRotationPoint(2.0F, 0.0F, 0.0F);
		wheelSystem.addChild(wheel2);
		wheel2.cubeList.add(new ModelBox(wheel2, 198, 60, -10.5538F, -10.2875F, -18.7709F, 6, 4, 23, 0.0F));
		wheel2.cubeList.add(new ModelBox(wheel2, 58, 118, -10.5538F, -19.5F, -9.5584F, 6, 23, 4, 0.0F));

		hexadecagon_r1 = new ModelRenderer(this);
		hexadecagon_r1.setRotationPoint(-7.5538F, -8.0F, -7.2709F);
		wheel2.addChild(hexadecagon_r1);
		setRotationAngle(hexadecagon_r1, -0.3927F, 0.0F, 0.0F);
		hexadecagon_r1.cubeList.add(new ModelBox(hexadecagon_r1, 99, 42, -3.0F, -11.5F, -2.2875F, 6, 23, 4, 0.0F));
		hexadecagon_r1.cubeList.add(new ModelBox(hexadecagon_r1, 198, 33, -3.0F, -2.2875F, -11.5F, 6, 4, 23, 0.0F));

		hexadecagon_r2 = new ModelRenderer(this);
		hexadecagon_r2.setRotationPoint(-7.5538F, -8.0F, -7.2709F);
		wheel2.addChild(hexadecagon_r2);
		setRotationAngle(hexadecagon_r2, 0.3927F, 0.0F, 0.0F);
		hexadecagon_r2.cubeList.add(new ModelBox(hexadecagon_r2, 92, 125, -3.0F, -11.5F, -2.2875F, 6, 23, 4, 0.0F));
		hexadecagon_r2.cubeList.add(new ModelBox(hexadecagon_r2, 0, 203, -3.0F, -2.2875F, -11.5F, 6, 4, 23, 0.0F));

		hexadecagon_r3 = new ModelRenderer(this);
		hexadecagon_r3.setRotationPoint(-7.5538F, -8.0F, -7.2709F);
		wheel2.addChild(hexadecagon_r3);
		setRotationAngle(hexadecagon_r3, -0.7854F, 0.0F, 0.0F);
		hexadecagon_r3.cubeList.add(new ModelBox(hexadecagon_r3, 198, 6, -3.0F, -2.2875F, -11.5F, 6, 4, 23, 0.0F));

		hexadecagon_r4 = new ModelRenderer(this);
		hexadecagon_r4.setRotationPoint(-7.5538F, -8.0F, -7.2709F);
		wheel2.addChild(hexadecagon_r4);
		setRotationAngle(hexadecagon_r4, 0.7854F, 0.0F, 0.0F);
		hexadecagon_r4.cubeList.add(new ModelBox(hexadecagon_r4, 205, 186, -3.0F, -2.2875F, -11.5F, 6, 4, 23, 0.0F));

		wheel1 = new ModelRenderer(this);
		wheel1.setRotationPoint(-27.0F, 0.0F, 0.0F);
		wheelSystem.addChild(wheel1);
		wheel1.cubeList.add(new ModelBox(wheel1, 83, 187, -10.5538F, -10.2875F, -18.7709F, 6, 4, 23, 0.0F));
		wheel1.cubeList.add(new ModelBox(wheel1, 0, 45, -10.5538F, -19.5F, -9.5584F, 6, 23, 4, 0.0F));

		hexadecagon_r5 = new ModelRenderer(this);
		hexadecagon_r5.setRotationPoint(-7.5538F, -8.0F, -7.2709F);
		wheel1.addChild(hexadecagon_r5);
		setRotationAngle(hexadecagon_r5, -0.3927F, 0.0F, 0.0F);
		hexadecagon_r5.cubeList.add(new ModelBox(hexadecagon_r5, 0, 0, -3.0F, -11.5F, -2.2875F, 6, 23, 4, 0.0F));
		hexadecagon_r5.cubeList.add(new ModelBox(hexadecagon_r5, 0, 129, -3.0F, -2.2875F, -11.5F, 6, 4, 23, 0.0F));

		hexadecagon_r6 = new ModelRenderer(this);
		hexadecagon_r6.setRotationPoint(-7.5538F, -8.0F, -7.2709F);
		wheel1.addChild(hexadecagon_r6);
		setRotationAngle(hexadecagon_r6, 0.3927F, 0.0F, 0.0F);
		hexadecagon_r6.cubeList.add(new ModelBox(hexadecagon_r6, 99, 0, -3.0F, -11.5F, -2.2875F, 6, 23, 4, 0.0F));
		hexadecagon_r6.cubeList.add(new ModelBox(hexadecagon_r6, 188, 159, -3.0F, -2.2875F, -11.5F, 6, 4, 23, 0.0F));

		hexadecagon_r7 = new ModelRenderer(this);
		hexadecagon_r7.setRotationPoint(-7.5538F, -8.0F, -7.2709F);
		wheel1.addChild(hexadecagon_r7);
		setRotationAngle(hexadecagon_r7, -0.7854F, 0.0F, 0.0F);
		hexadecagon_r7.cubeList.add(new ModelBox(hexadecagon_r7, 0, 102, -3.0F, -2.2875F, -11.5F, 6, 4, 23, 0.0F));

		hexadecagon_r8 = new ModelRenderer(this);
		hexadecagon_r8.setRotationPoint(-7.5538F, -8.0F, -7.2709F);
		wheel1.addChild(hexadecagon_r8);
		setRotationAngle(hexadecagon_r8, 0.7854F, 0.0F, 0.0F);
		hexadecagon_r8.cubeList.add(new ModelBox(hexadecagon_r8, 197, 109, -3.0F, -2.2875F, -11.5F, 6, 4, 23, 0.0F));

		treads2 = new ModelRenderer(this);
		treads2.setRotationPoint(-29.0F, 0.0F, 0.0F);
		wheelSystem.addChild(treads2);
		treads2.cubeList.add(new ModelBox(treads2, 56, 154, -9.5538F, -10.6853F, -20.7709F, 8, 5, 2, 0.0F));
		treads2.cubeList.add(new ModelBox(treads2, 58, 147, -9.5538F, -10.6853F, 4.2291F, 8, 5, 2, 0.0F));
		treads2.cubeList.add(new ModelBox(treads2, 35, 140, -9.5538F, 3.5F, -9.9562F, 8, 2, 5, 0.0F));
		treads2.cubeList.add(new ModelBox(treads2, 112, 139, -9.5538F, -21.5F, -9.9562F, 8, 2, 5, 0.0F));

		hexadecagon_r9 = new ModelRenderer(this);
		hexadecagon_r9.setRotationPoint(-7.5538F, -8.0F, -7.2709F);
		treads2.addChild(hexadecagon_r9);
		setRotationAngle(hexadecagon_r9, -0.7854F, 0.0F, 0.0F);
		hexadecagon_r9.cubeList.add(new ModelBox(hexadecagon_r9, 112, 146, -2.0F, -2.6853F, 11.5F, 8, 5, 2, 0.0F));
		hexadecagon_r9.cubeList.add(new ModelBox(hexadecagon_r9, 153, 80, -2.0F, -2.6853F, -13.5F, 8, 5, 2, 0.0F));

		hexadecagon_r10 = new ModelRenderer(this);
		hexadecagon_r10.setRotationPoint(-7.5538F, -8.0F, -7.2709F);
		treads2.addChild(hexadecagon_r10);
		setRotationAngle(hexadecagon_r10, 0.7854F, 0.0F, 0.0F);
		hexadecagon_r10.cubeList.add(new ModelBox(hexadecagon_r10, 151, 88, -2.0F, -2.6853F, 11.5F, 8, 5, 2, 0.0F));
		hexadecagon_r10.cubeList.add(new ModelBox(hexadecagon_r10, 30, 156, -2.0F, -2.6853F, -13.5F, 8, 5, 2, 0.0F));

		treads1 = new ModelRenderer(this);
		treads1.setRotationPoint(0.0F, 0.0F, 0.0F);
		wheelSystem.addChild(treads1);
		treads1.cubeList.add(new ModelBox(treads1, 0, 136, -9.5538F, -10.6853F, -20.7709F, 8, 5, 2, 0.0F));
		treads1.cubeList.add(new ModelBox(treads1, 35, 118, -9.5538F, -10.6853F, 4.2291F, 8, 5, 2, 0.0F));
		treads1.cubeList.add(new ModelBox(treads1, 112, 132, -9.5538F, 3.5F, -9.9562F, 8, 2, 5, 0.0F));
		treads1.cubeList.add(new ModelBox(treads1, 112, 125, -9.5538F, -21.5F, -9.9562F, 8, 2, 5, 0.0F));

		hexadecagon_r11 = new ModelRenderer(this);
		hexadecagon_r11.setRotationPoint(-7.5538F, -8.0F, -7.2709F);
		treads1.addChild(hexadecagon_r11);
		setRotationAngle(hexadecagon_r11, -0.7854F, 0.0F, 0.0F);
		hexadecagon_r11.cubeList.add(new ModelBox(hexadecagon_r11, 0, 118, -2.0F, -2.6853F, 11.5F, 8, 5, 2, 0.0F));
		hexadecagon_r11.cubeList.add(new ModelBox(hexadecagon_r11, 35, 129, -2.0F, -2.6853F, -13.5F, 8, 5, 2, 0.0F));

		hexadecagon_r12 = new ModelRenderer(this);
		hexadecagon_r12.setRotationPoint(-7.5538F, -8.0F, -7.2709F);
		treads1.addChild(hexadecagon_r12);
		setRotationAngle(hexadecagon_r12, 0.7854F, 0.0F, 0.0F);
		hexadecagon_r12.cubeList.add(new ModelBox(hexadecagon_r12, 0, 129, -2.0F, -2.6853F, 11.5F, 8, 5, 2, 0.0F));
		hexadecagon_r12.cubeList.add(new ModelBox(hexadecagon_r12, 0, 143, -2.0F, -2.6853F, -13.5F, 8, 5, 2, 0.0F));

		shield = new ModelRenderer(this);
		shield.setRotationPoint(0.0F, -15.7183F, -25.0479F);
		setRotationAngle(shield, -0.1309F, 0.0F, 0.0F);
		shield.cubeList.add(new ModelBox(shield, 92, 109, 6.4462F, 0.4743F, -19.1717F, 19, 14, 2, 0.0F));
		shield.cubeList.add(new ModelBox(shield, 44, 61, -25.5538F, 0.4743F, -19.1717F, 19, 14, 2, 0.0F));

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(7.9462F, 7.5F, 13.2291F);
		shield.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.4363F, 0.0F, 0.0F);
		cube_r2.cubeList.add(new ModelBox(cube_r2, 44, 35, -15.5F, -27.3042F, -6.2223F, 14, 1, 1, 0.0F));
		cube_r2.cubeList.add(new ModelBox(cube_r2, 23, 0, -16.5F, -31.3042F, -6.2223F, 1, 30, 1, 0.0F));
		cube_r2.cubeList.add(new ModelBox(cube_r2, 27, 0, -1.5F, -31.3042F, -6.2223F, 1, 30, 1, 0.0F));

		hexadecagon_r13 = new ModelRenderer(this);
		hexadecagon_r13.setRotationPoint(0.4462F, 0.9182F, 13.3285F);
		shield.addChild(hexadecagon_r13);
		setRotationAngle(hexadecagon_r13, -0.7854F, 0.0F, 0.0F);
		hexadecagon_r13.cubeList.add(new ModelBox(hexadecagon_r13, 0, 187, -26.0F, -4.2671F, -28.6526F, 51, 14, 2, 0.0F));

		hexadecagon_r14 = new ModelRenderer(this);
		hexadecagon_r14.setRotationPoint(-31.5538F, 4.6639F, 11.777F);
		shield.addChild(hexadecagon_r14);
		setRotationAngle(hexadecagon_r14, -0.3927F, 0.0F, 0.0F);
		hexadecagon_r14.cubeList.add(new ModelBox(hexadecagon_r14, 44, 45, 6.0F, -6.0272F, -30.1962F, 19, 14, 2, 0.0F));
		hexadecagon_r14.cubeList.add(new ModelBox(hexadecagon_r14, 35, 102, 38.0F, -6.0272F, -30.1962F, 19, 14, 2, 0.0F));

		hexadecagon_r15 = new ModelRenderer(this);
		hexadecagon_r15.setRotationPoint(-31.5538F, 8.7183F, 11.777F);
		shield.addChild(hexadecagon_r15);
		setRotationAngle(hexadecagon_r15, 0.0436F, 0.0F, 0.0F);
		hexadecagon_r15.cubeList.add(new ModelBox(hexadecagon_r15, 148, 6, 40.0F, 2.4957F, -31.9772F, 13, 14, 2, 0.0F));
		hexadecagon_r15.cubeList.add(new ModelBox(hexadecagon_r15, 0, 156, 9.0F, 2.4957F, -31.9772F, 13, 14, 2, 0.0F));

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		bolt_r1 = new ModelRenderer(this);
		bolt_r1.setRotationPoint(0.4462F, -32.0F, -33.2709F);
		bb_main.addChild(bolt_r1);
		setRotationAngle(bolt_r1, -0.7854F, 0.0F, 0.0F);
		bolt_r1.cubeList.add(new ModelBox(bolt_r1, 99, 80, -12.0F, -3.0F, -2.0F, 22, 5, 5, 0.0F));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		mainGun.render(f5);
		platform.render(f5);
		carriage.render(f5);
		wheelSystem.render(f5);
		shield.render(f5);
		bb_main.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}