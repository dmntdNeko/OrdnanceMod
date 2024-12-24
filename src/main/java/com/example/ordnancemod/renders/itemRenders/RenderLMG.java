package com.example.ordnancemod.renders.itemRenders;

import com.example.ordnancemod.models.modelBench.ModelMG42;
import com.example.ordnancemod.smallArms.ItemLMG;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RenderLMG implements IItemRenderer {
    public ResourceLocation texture = new ResourceLocation("ordnancemod", "textures/entities/mg42.png");
    public ModelMG42 model;

    public RenderLMG() {
        this.model = new ModelMG42();
    }

    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        switch(type){
            case EQUIPPED:
            case EQUIPPED_FIRST_PERSON:
            case ENTITY:
                return true;
            default:
                return false;
        }
    }

    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        float scale = 1.0F;
        if (item.getItem() instanceof ItemLMG) {
            ItemLMG lmg = (ItemLMG) item.getItem();
            switch (type) {
                case EQUIPPED:
                    GL11.glPushMatrix();
                    float tempScale = (float) (scale*0.55F);
                    GL11.glScalef(tempScale, tempScale, tempScale);
                    Minecraft.getMinecraft().renderEngine.bindTexture(texture);
                    GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
                    //GL11.glRotatef(-40.0F, 0.0F, 0.0F, 1.0F);
                    GL11.glTranslatef(0.25F, 1.0F, -0.2F);
                    model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
                    GL11.glPopMatrix();
                    break;
                case EQUIPPED_FIRST_PERSON:
                    GL11.glPushMatrix();
                    GL11.glScalef(scale, scale, scale);
                    Minecraft.getMinecraft().renderEngine.bindTexture(texture);
                    GL11.glRotatef(-225.0F, 0.0F, 1.0F, 0.0F);
                    //GL11.glRotatef(133.0F, 0.0F, 0.0F, 1.0F);
                    //GL11.glTranslatef(-0.5F, 0.0875F, -0.7F);
                    if (lmg.isADS){
                        GL11.glTranslatef(0.9F, -1.3F, -1.1F);
                    } else {
                        GL11.glTranslatef(-0.5F, -1.5F, -0.7F); //Hip
                    }
                    //model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
                    model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.125F);
                    GL11.glPopMatrix();
                    break;
                case ENTITY:
                    GL11.glPushMatrix();
                    tempScale = (float) (scale*0.45F);
                    GL11.glScalef(tempScale, tempScale, tempScale);
                    Minecraft.getMinecraft().renderEngine.bindTexture(texture);
                    model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.03125F);
                    GL11.glPopMatrix();
                    break;
                default:
                    break;
            }
        }
    }
}