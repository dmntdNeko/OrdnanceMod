package com.example.ordnancemod.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelGriefingTable extends ModelBase {
    public final ModelRenderer mainModel;
    public final ModelRenderer movers;
    public final ModelRenderer cube_r1;
    public final ModelRenderer podgroup;
    public final ModelRenderer podframe;
    public final ModelRenderer pods;
    public final ModelRenderer base;

    public ModelGriefingTable() {
        textureWidth = 256;
        textureHeight = 256;

        mainModel = new ModelRenderer(this);
        //mainModel.setRotationPoint(-1.5F, -3.0F, 3.0F);
        mainModel.setRotationPoint(0F, -3.0F, 0F);
        setRotationAngle(mainModel, 0.0F, 0.0F, -3.1416F);


        movers = new ModelRenderer(this);
        movers.setRotationPoint(0.0F, 13.0F, 0.0F);
        movers.cubeList.add(new ModelBox(movers, 184, 16, 14.0F, -26.0F, -5.0F, 3, 26, 10, 0.0F));
        movers.cubeList.add(new ModelBox(movers, 184, 52, -18.0F, -26.0F, -5.0F, 3, 26, 10, 0.0F));
        movers.cubeList.add(new ModelBox(movers, 90, 24, -16.0F, -1.0F, -8.0F, 31, 1, 16, 0.0F));
        movers.cubeList.add(new ModelBox(movers, 86, 65, -12.0F, -2.0F, -15.0F, 23, 2, 26, 0.0F));

        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(-0.5F, -21.0F, 0.0F);
        setRotationAngle(cube_r1, -0.7854F, 0.0F, 0.0F);
        cube_r1.cubeList.add(new ModelBox(cube_r1, 86, 93, -19.5F, -2.0F, -2.0F, 39, 4, 4, 0.0F));

        podgroup = new ModelRenderer(this);
        podgroup.setRotationPoint(0.0F, -21.0F, 0.0F);


        podframe = new ModelRenderer(this);
        podframe.setRotationPoint(-0.5F, 8.5F, 0.0F);
        podframe.cubeList.add(new ModelBox(podframe, 190, 198, 11.5F, -21.5F, -7.0F, 2, 27, 3, 0.0F));
        podframe.cubeList.add(new ModelBox(podframe, 200, 198, -13.5F, -21.5F, -7.0F, 2, 27, 3, 0.0F));
        podframe.cubeList.add(new ModelBox(podframe, 90, 60, -11.5F, -21.5F, -7.0F, 23, 2, 3, 0.0F));
        podframe.cubeList.add(new ModelBox(podframe, 10, 201, -13.5F, -21.5F, 4.0F, 2, 27, 3, 0.0F));
        podframe.cubeList.add(new ModelBox(podframe, 0, 201, 11.5F, -21.5F, 4.0F, 2, 27, 3, 0.0F));
        podframe.cubeList.add(new ModelBox(podframe, 120, 16, -11.5F, -21.5F, 4.0F, 23, 2, 3, 0.0F));
        podframe.cubeList.add(new ModelBox(podframe, 186, 132, 12.5F, -20.5F, -4.0F, 0, 25, 8, 0.0F));
        podframe.cubeList.add(new ModelBox(podframe, 186, 165, -12.5F, -20.5F, -4.0F, 0, 25, 8, 0.0F));
        podframe.cubeList.add(new ModelBox(podframe, 120, 0, -12.5F, -20.5F, -4.0F, 25, 0, 8, 0.0F));
        podframe.cubeList.add(new ModelBox(podframe, 120, 8, -12.5F, 4.5F, -4.0F, 25, 0, 8, 0.0F));
        podframe.cubeList.add(new ModelBox(podframe, 172, 93, -11.5F, 3.5F, -7.0F, 23, 2, 3, 0.0F));
        podframe.cubeList.add(new ModelBox(podframe, 184, 88, -11.5F, 3.5F, 4.0F, 23, 2, 3, 0.0F));

        pods = new ModelRenderer(this);
        pods.setRotationPoint(-0.5F, 8.5F, 0.0F);
        pods.cubeList.add(new ModelBox(pods, 62, 132, -11.5F, -3.5F, -9.0F, 7, 7, 24, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 202, 186, -10.5F, -2.5F, -13.0F, 5, 5, 4, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 210, 32, -9.5F, -1.5F, -15.0F, 3, 3, 5, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 86, 101, 4.5F, -3.5F, -9.0F, 7, 7, 24, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 202, 168, 5.5F, -2.5F, -13.0F, 5, 5, 4, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 82, 204, 6.5F, -1.5F, -15.0F, 3, 3, 5, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 0, 108, -3.5F, -3.5F, -9.0F, 7, 7, 24, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 202, 177, -2.5F, -2.5F, -13.0F, 5, 5, 4, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 210, 24, -1.5F, -1.5F, -15.0F, 3, 3, 5, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 210, 80, -1.5F, -17.5F, -15.0F, 3, 3, 5, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 210, 15, -2.5F, -18.5F, -13.0F, 5, 5, 4, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 0, 170, -3.5F, -19.5F, -9.0F, 7, 7, 24, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 210, 72, 6.5F, -17.5F, -15.0F, 3, 3, 5, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 158, 208, 5.5F, -18.5F, -13.0F, 5, 5, 4, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 124, 163, 4.5F, -19.5F, -9.0F, 7, 7, 24, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 210, 64, -9.5F, -17.5F, -15.0F, 3, 3, 5, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 140, 208, -10.5F, -18.5F, -13.0F, 5, 5, 4, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 62, 163, -11.5F, -19.5F, -9.0F, 7, 7, 24, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 210, 56, -1.5F, -9.5F, -15.0F, 3, 3, 5, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 122, 205, -2.5F, -10.5F, -13.0F, 5, 5, 4, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 148, 101, -3.5F, -11.5F, -9.0F, 7, 7, 24, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 210, 48, 6.5F, -9.5F, -15.0F, 3, 3, 5, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 64, 204, 5.5F, -10.5F, -13.0F, 5, 5, 4, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 0, 139, 4.5F, -11.5F, -9.0F, 7, 7, 24, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 210, 40, -9.5F, -9.5F, -15.0F, 3, 3, 5, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 46, 204, -10.5F, -10.5F, -13.0F, 5, 5, 4, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 124, 132, -11.5F, -11.5F, -9.0F, 7, 7, 24, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 0, 65, -10.5F, -18.5F, -8.0F, 21, 21, 22, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 180, 41, 7.5F, -14.5F, -14.0F, 1, 13, 1, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 210, 98, -0.5F, -14.5F, -14.0F, 1, 13, 1, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 210, 112, -8.5F, -14.5F, -14.0F, 1, 13, 1, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 120, 21, -6.5F, -0.5F, -14.0F, 13, 1, 1, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 142, 60, -6.5F, -8.5F, -14.0F, 13, 1, 1, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 142, 62, -6.5F, -16.5F, -14.0F, 13, 1, 1, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 74, 129, 7.5F, 1.5F, -14.0F, 1, 1, 1, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 172, 16, 7.5F, 2.5F, -14.0F, 1, 1, 5, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 62, 129, 8.5F, 2.5F, -10.0F, 5, 1, 1, 0.0F));
        pods.cubeList.add(new ModelBox(pods, 176, 208, 12.0F, -2.0F, -9.0F, 2, 6, 4, 0.0F));

        base = new ModelRenderer(this);
        base.setRotationPoint(3.0F, 22.0F, -3.0F);
        base.cubeList.add(new ModelBox(base, 62, 194, -8.0F, -9.0F, -1.0F, 9, 1, 9, 0.0F));
        base.cubeList.add(new ModelBox(base, 0, 0, -23.0F, -8.0F, -9.0F, 39, 3, 21, 0.0F));
        base.cubeList.add(new ModelBox(base, 90, 41, -18.0F, -5.0F, -6.0F, 29, 3, 16, 0.0F));
        base.cubeList.add(new ModelBox(base, 186, 0, -8.0F, -5.0F, 7.0F, 9, 4, 11, 0.0F));
        base.cubeList.add(new ModelBox(base, 156, 198, -8.0F, 3.0F, 18.0F, 9, 2, 8, 0.0F));
        base.cubeList.add(new ModelBox(base, 202, 159, -8.0F, -1.0F, 15.0F, 9, 6, 3, 0.0F));
        base.cubeList.add(new ModelBox(base, 62, 108, 14.0F, -8.0F, -2.0F, 4, 13, 8, 0.0F));
        base.cubeList.add(new ModelBox(base, 98, 194, -25.0F, -8.0F, -2.0F, 4, 13, 8, 0.0F));
        base.cubeList.add(new ModelBox(base, 20, 201, 18.0F, 3.0F, -2.0F, 5, 2, 8, 0.0F));
        base.cubeList.add(new ModelBox(base, 202, 132, -30.0F, 3.0F, -2.0F, 5, 2, 8, 0.0F));
        base.cubeList.add(new ModelBox(base, 0, 24, -8.0F, -5.0F, -32.0F, 9, 5, 36, 0.0F));
        base.cubeList.add(new ModelBox(base, 202, 142, -8.0F, 0.0F, -32.0F, 9, 5, 4, 0.0F));
        base.cubeList.add(new ModelBox(base, 122, 194, -8.0F, 2.0F, -40.0F, 9, 3, 8, 0.0F));
        base.cubeList.add(new ModelBox(base, 202, 151, -7.0F, 3.0F, -46.0F, 7, 2, 6, 0.0F));

        mainModel.addChild(base);
        base.addChild(movers);
        movers.addChild(cube_r1);
        movers.addChild(podgroup);
        podgroup.addChild(podframe);
        podgroup.addChild(pods);
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