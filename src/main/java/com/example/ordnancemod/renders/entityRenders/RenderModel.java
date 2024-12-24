package com.example.ordnancemod.renders.entityRenders;

import com.example.ordnancemod.models.entityModels.ModelDebugCube;
import com.example.ordnancemod.models.entityModels.ModelMiningDrillT1;
import com.example.ordnancemod.models.entityModels.ModelRachne;
import com.example.ordnancemod.models.modelBench.*;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderModel extends Render {

    private ResourceLocation textureLahti = new ResourceLocation("ordnancemod","textures/entities/lahti.png");
    private ResourceLocation textureFG42 = new ResourceLocation("ordnancemod","textures/entities/fg42.png");
    private ResourceLocation textureMG42 = new ResourceLocation("ordnancemod","textures/entities/mg42.png");
    private ResourceLocation textureChingChengHanji = new ResourceLocation("ordnancemod","textures/entities/chingchenghanji.png");
    private ResourceLocation textureM16A1 = new ResourceLocation("ordnancemod","textures/entities/m16a1.png");
    private ResourceLocation textureDebugCube = new ResourceLocation("ordnancemod","textures/entities/debugCube.png");
    private ResourceLocation textureMiningDrillT1 = new ResourceLocation("ordnancemod","textures/entities/miningDrillT1.png");

    private ResourceLocation textureRachne = new ResourceLocation("ordnancemod","textures/entities/rachne.png");

    private ModelBase model;
    private ModelLahti modelLahti;
    private ModelFG42 modelFG42;
    private ModelMG42 modelMG42;
    private ModelChingChengHanji modelChingChengHanji;
    private ModelM16A1 modelM16A1;
    private ModelDebugCube modelDebugCube;
    private ModelMiningDrillT1 modelMiningDrillT1;

    private ModelRachne modelRachne;

    private float angle;

    public RenderModel(ModelBase model, float shadowSize) {
        //this.model = model;
        this.model = new ModelDebugCube();
        this.modelDebugCube = (ModelDebugCube) this.model;
        this.modelRachne = new ModelRachne();
        //this.model = new ModelMiningDrillT1();
        //this.modelLahti = (ModelLahti) model;
        //this.modelFG42 = (ModelFG42) model;
        //this.modelMG42 = (ModelMG42) model;
        //this.modelChingChengHanji = (ModelChingChengHanji) model;
        //this.modelM16A1 = (ModelM16A1) model;
        this.shadowSize = shadowSize;

    }

    @Override
    public void doRender(Entity entity, double x, double y, double z, float yaw, float pitch) {
        GL11.glPushMatrix();
        //GL11.glTranslated(x,y-0.5F,z); //Default translation
        GL11.glTranslated(x,y+2.6875F,z+2.0F); //Rachne Translation
        //GL11.glTranslated(x,y-1.3125D,z);
        //GL11.glTranslated(x,y-0.625,z);
        //GL11.glTranslated(x,y+0.125D,z);
        //GL11.glTranslated(x,y+0.375F,z); //Mining Drill Y-offset
        //this.bindTexture(textureChingChengHanji);
        //this.bindTexture(textureDebugCube);
        //this.bindTexture(textureM16A1);
        //this.bindTexture(textureDebugCube);

        this.bindTexture(textureRachne);

        /*this.angle += 1.5F;
        if (this.angle >= 360) {
            this.angle = 0;
        }
        GL11.glRotated(-angle,0,1.0D,0);
        */ //ChingChengHanji spin

        this.angle += 1.5F;
        if (this.angle >= 360) {
            this.angle = 0;
        }
        //GL11.glRotated(angle,0,1.0D,0);
        //this.modelDebugCube.mainModel.rotateAngleX = (float) Math.toRadians(this.angle);
        //this.modelDebugCube.mainModel.rotateAngleZ = (float) Math.toRadians(this.angle);
        //this.modelDebugCube.mainModel.rotateAngleY = (float) Math.toRadians(this.angle);

        //this.modelLahti.mainModel.rotateAngleY = (float) Math.toRadians(180);
        //this.model.render(entity,0,0,0,0,0,0.1F); //1.6 times increase
        //this.model.render(entity,0,0,0,0,0,0.0625F); //Default scale
        this.modelRachne.Rachne.rotateAngleX = (float) Math.PI;
        this.modelRachne.render(entity,0,0,0,0,0,0.0625F);
        //this.model.render(entity,0,0,0,0,0,0.03125F); //ChingChengHanji scale
        //this.model.render(entity,0,0,0,0,0,0.015F);
        GL11.glPopMatrix();
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return null;
    }
}
