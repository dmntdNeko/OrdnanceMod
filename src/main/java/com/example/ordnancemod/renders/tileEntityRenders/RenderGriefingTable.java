package com.example.ordnancemod.renders.tileEntityRenders;

import com.example.ordnancemod.models.ModelGriefingTable;
import com.example.ordnancemod.tileentities.TileGriefingTable;
import com.example.ordnancemod.tileentities.TileOrdnance;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderGriefingTable extends TileEntitySpecialRenderer {
    private ModelGriefingTable model = new ModelGriefingTable();
    private static ResourceLocation texture = new ResourceLocation("ordnancemod","textures/tileentities/griefingtable.png");

    public RenderGriefingTable(){};

    private void renderGriefingTable(TileOrdnance lightArtillery, double x, double y, double z, float f) {
        float baseYaw = (float) (Math.toRadians(lightArtillery.getBaseYaw()));
        float yaw = (float) (Math.toRadians(lightArtillery.getYaw())) - baseYaw;
        float pitch = (float) (Math.toRadians(lightArtillery.getPitch()));
        float rock = (float) Math.toRadians(180 - lightArtillery.rock);
        GL11.glPushMatrix();
        correctPosition(lightArtillery.baseYaw, x, y, z);
        this.bindTexture(texture);
        this.model.base.rotateAngleY = baseYaw;
        this.model.movers.setRotationPoint(-3.125F,-8.75F,0.0F);
        this.model.movers.rotateAngleY = yaw;
        this.model.podgroup.rotateAngleX = pitch;
        //this.model.mainModel.render(0.0625F);
        this.model.mainModel.render(0.04F);
        GL11.glPopMatrix();
    }

    @Override
    public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
        this.renderGriefingTable((TileGriefingTable) tileentity,x,y,z,f);
    }

    public void correctPosition(float angle, double x, double y, double z) {
        if (angle == 90.0F) {
            ///GL11.glTranslated(x + 0.8125F, y + 1.8125F, z + 0.46875F);
            GL11.glTranslated(x + 0.6875F, y + 1.16F, z + 0.4375F); //scale 0.04F
        } else if (angle == 180.0F) {
            //GL11.glTranslated(x + 0.90625F, y + 1.8125F, z + 0.8125F);
            GL11.glTranslated(x + 0.78125F, y + 1.16F, z + 0.6875F); //scale 0.04F
        } else if (angle == 270.0F) {
            //GL11.glTranslated(x + 0.5625F, y + 1.8125F, z + 0.875F);
            GL11.glTranslated(x + 0.5625F, y + 1.16F, z + 0.75F); //scale 0.04F
        } else {
            //GL11.glTranslated(x + 0.46875F, y + 1.8125F, z + 0.5625F);
            GL11.glTranslated(x + 0.46875F, y + 1.16F, z + 0.5625F); //scale 0.04F
        }
    }


}
