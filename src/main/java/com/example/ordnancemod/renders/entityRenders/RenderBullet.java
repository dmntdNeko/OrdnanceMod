package com.example.ordnancemod.renders.entityRenders;

import com.example.ordnancemod.entities.EntityBullet;
import com.example.ordnancemod.models.entityModels.ModelBullet;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class RenderBullet extends Render {

    //private static final ResourceLocation texture = new ResourceLocation("examplemod","textures/entities/bullet.png");
    private static final ResourceLocation texture = new ResourceLocation("ordnancemod", "textures/items/ItemBullet.png");
    private ModelBullet model = new ModelBullet();
    private float spin = 0;

    private Item item;
    private int damage;

    public RenderBullet(Item itemBullet, int damage) {
        this.item = itemBullet;
        this.damage = damage;
    }

    public RenderBullet(Item itemBullet) {
        this(itemBullet, 0);
    }


    public void doRender(Entity entity, double x, double y, double z, float yaw, float pitch) {
        this.render(entity, x, y, z, yaw, pitch);
    }

    public void render(Entity entity, double x, double y, double z, float yaw, float pitch) {
        EntityBullet bullet = (EntityBullet) entity;
        IIcon iicon = this.item.getIconFromDamage(this.damage);

        if (iicon != null) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float) x, (float) y, (float) z);
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            GL11.glScalef(0.5F, 0.5F, 0.5F);
            this.bindEntityTexture(entity);
            Tessellator tessellator = Tessellator.instance;

            this.renderIcon(tessellator, iicon);
            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
            GL11.glPopMatrix();
        }
    }

    private void renderIcon(Tessellator tesselator, IIcon iicon) {
        float f = iicon.getMinU();
        float f1 = iicon.getMaxU();
        float f2 = iicon.getMinV();
        float f3 = iicon.getMaxV();
        float f4 = 1.0F;
        float f5 = 0.5F;
        float f6 = 0.25F;
        GL11.glRotatef(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        tesselator.startDrawingQuads();
        tesselator.setNormal(0.0F, 1.0F, 0.0F);
        tesselator.addVertexWithUV((double) (0.0F - f5), (double) (0.0F - f6), 0.0D, (double) f, (double) f3);
        tesselator.addVertexWithUV((double) (f4 - f5), (double) (0.0F - f6), 0.0D, (double) f1, (double) f3);
        tesselator.addVertexWithUV((double) (f4 - f5), (double) (f4 - f6), 0.0D, (double) f1, (double) f2);
        tesselator.addVertexWithUV((double) (0.0F - f5), (double) (f4 - f6), 0.0D, (double) f, (double) f2);
        tesselator.draw();
    }

    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return TextureMap.locationItemsTexture;
    }

}
