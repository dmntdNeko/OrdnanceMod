package com.example.ordnancemod.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLightArtillery extends ModelBase {
    public final ModelRenderer mainModel;
    public final ModelRenderer pitchSwivel_r1;
    public final ModelRenderer base;
    public final ModelRenderer movers;
    public final ModelRenderer cannon;

    public ModelLightArtillery() {
        textureWidth = 256;
        textureHeight = 256;

        mainModel = new ModelRenderer(this);
        mainModel.setRotationPoint(0.0F, 1.0F, 0.0F);
        setRotationAngle(mainModel, 0.0F, 0.0F, -3.1416F);


        pitchSwivel_r1 = new ModelRenderer(this);
        pitchSwivel_r1.setRotationPoint(0.0F, -5.0F, 0.0F);
        //mainModel.addChild(pitchSwivel_r1);
        setRotationAngle(pitchSwivel_r1, -0.7854F, 0.0F, 0.0F);
        pitchSwivel_r1.cubeList.add(new ModelBox(pitchSwivel_r1, 0, 18, -8.0F, -2.0F, -1.0F, 16, 3, 3, 0.0F));

        base = new ModelRenderer(this);
        base.setRotationPoint(0.0F, 0.0F, 0.0F);
        mainModel.addChild(base);
        base.cubeList.add(new ModelBox(base, 54, 0, -10.0F, -7.0F, -11.0F, 20, 4, 20, 0.0F));
        base.cubeList.add(new ModelBox(base, 46, 43, -14.0F, -6.0F, -24.0F, 6, 4, 34, 0.0F));
        base.cubeList.add(new ModelBox(base, 0, 39, 8.0F, -6.0F, -24.0F, 6, 4, 34, 0.0F));

        movers = new ModelRenderer(this);
        movers.setRotationPoint(0.0F, -10.0F, 0.0F);
        //mainModel.addChild(movers);
        movers.cubeList.add(new ModelBox(movers, 16, 39, -7.0F, -8.0F, -2.0F, 2, 9, 6, 0.0F));
        movers.cubeList.add(new ModelBox(movers, 46, 39, 5.0F, -5.0F, -7.0F, 2, 5, 5, 0.0F));
        movers.cubeList.add(new ModelBox(movers, 0, 39, 5.0F, -8.0F, -2.0F, 2, 9, 6, 0.0F));
        movers.cubeList.add(new ModelBox(movers, 46, 49, -7.0F, -5.0F, -7.0F, 2, 5, 5, 0.0F));
        movers.cubeList.add(new ModelBox(movers, 76, 24, -8.0F, 0.0F, -10.0F, 16, 3, 16, 0.0F));
        movers.cubeList.add(new ModelBox(movers, 70, 81, -5.0F, -6.0F, -8.0F, 10, 4, 11, 0.0F));

        cannon = new ModelRenderer(this);
        cannon.setRotationPoint(0.0F, 0.0F, 0.0F);
        //mainModel.addChild(cannon);
        cannon.cubeList.add(new ModelBox(cannon, 38, 81, -3.0F, -7.0F, 2.0F, 6, 6, 20, 0.0F));
        cannon.cubeList.add(new ModelBox(cannon, 0, 0, -4.0F, -8.0F, -8.0F, 8, 8, 10, 0.0F));
        cannon.cubeList.add(new ModelBox(cannon, 0, 77, -2.0F, -6.0F, 22.0F, 4, 4, 30, 0.0F));
        cannon.cubeList.add(new ModelBox(cannon, 0, 24, -3.0F, -7.0F, 52.0F, 6, 6, 7, 0.0F));
        cannon.cubeList.add(new ModelBox(cannon, 0, 0, -4.0F, -1.0F, -13.0F, 8, 1, 38, 0.0F));

        base.addChild(movers);
        movers.addChild(pitchSwivel_r1);
        movers.addChild(cannon);
        //pitchSwivel_r1.addChild(cannon);
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