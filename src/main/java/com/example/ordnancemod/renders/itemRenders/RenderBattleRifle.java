package com.example.ordnancemod.renders.itemRenders;

import com.example.ordnancemod.models.modelBench.ModelFG42;
import com.example.ordnancemod.smallArms.ItemBattleRifle;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RenderBattleRifle implements IItemRenderer {
    public ResourceLocation texture = new ResourceLocation("ordnancemod", "textures/entities/fg42.png");
    public ModelFG42 model;

    public RenderBattleRifle() {
        this.model = new ModelFG42();
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
    public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {
        float scale = 1F;
        if (item.getItem() instanceof ItemBattleRifle) {
            ItemBattleRifle battleRifle = (ItemBattleRifle) item.getItem();
            switch (type) {
                case EQUIPPED:
                    GL11.glPushMatrix();
                    GL11.glScalef(scale, scale, scale);
                    Minecraft.getMinecraft().renderEngine.bindTexture(texture);
                    GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
                    //GL11.glRotatef(-40.0F, 0.0F, 0.0F, 1.0F);
                    GL11.glTranslatef(0.25F, 1.2F, -0.2F);
                    model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
                    GL11.glPopMatrix();
                    break;
                case EQUIPPED_FIRST_PERSON:
                    GL11.glPushMatrix();
                    GL11.glScalef(scale, scale, scale);
                    Minecraft.getMinecraft().renderEngine.bindTexture(texture);
                    GL11.glRotatef(-225.0F, 0.0F, 1.0F, 0.0F);
                    //GL11.glRotatef(133.0F, 0.0F, 0.0F, 1.0F);
                    //GL11.glTranslatef(-0.5F, 0.2F, -0.7F); //default
                    if (battleRifle.isADS) {
                        GL11.glTranslatef(1.07F, 0.35F, -1F);
                    } else {
                        GL11.glTranslatef(0.55F, 0.3F, -0.7F);
                    }
                    model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
                    GL11.glPopMatrix();
                    break;
                case ENTITY:
                    GL11.glPushMatrix();
                    float tempScale = (float) (scale*0.75);
                    GL11.glScalef(tempScale, tempScale, tempScale);
                    Minecraft.getMinecraft().renderEngine.bindTexture(texture);
                    //GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
                    //GL11.glRotatef(0.0F, 0.0F, 1.0F, 0.0F);
                    //GL11.glRotatef(45.0F, 0.0F, 0.0F, 1.0F);
                    model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
                    GL11.glPopMatrix();
                    break;
                default:
                    break;
            }
        }
    }
}