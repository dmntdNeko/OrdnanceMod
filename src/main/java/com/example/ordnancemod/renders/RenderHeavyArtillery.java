package com.example.ordnancemod.renders;

import com.example.ordnancemod.entities.EntityHeavyArtillery;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderHeavyArtillery extends Render {

    private static final ResourceLocation heavyArtilleryTextures = new ResourceLocation("ordnancemod","textures/entities/heavy_artillery.png");
    protected ModelBase modelHeavyArtillery;
    private static final String __OBFID = "CL_00000981";

    public RenderHeavyArtillery(ModelBase modelBase, float shadowSize){
        this.shadowSize = shadowSize;
        this.modelHeavyArtillery = modelBase;
    }

    public void renderHeavyArtillery(EntityHeavyArtillery entity, double posX, double posY, double posZ, float yaw, float banking)
    {
        GL11.glPushMatrix();

        this.modelHeavyArtillery.render(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    @Override
    public void doRender(Entity entity, double posX, double posY, double posZ, float yaw, float banking) {
        this.renderHeavyArtillery((EntityHeavyArtillery)entity, posX, posY, posZ, yaw, banking);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return heavyArtilleryTextures;
    }
}
