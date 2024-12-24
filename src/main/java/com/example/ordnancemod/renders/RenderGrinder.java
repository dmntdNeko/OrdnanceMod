package com.example.ordnancemod.renders;

import com.example.ordnancemod.models.ModelGrinder;
import com.example.ordnancemod.tileentities.TileGrinder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderGrinder extends TileEntitySpecialRenderer {

    private ModelGrinder model = new ModelGrinder();
    private static final ResourceLocation texture = new ResourceLocation("examplemod", "textures/tileentities/grinder.png");

    public Minecraft mc = Minecraft.getMinecraft();
    public EntityPlayer player = mc.thePlayer;
    public int intTimer = 0;
    public float angle = 0;
    private final float maxRenderDistance = 16.0F;

    public RenderGrinder() {
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f) {
        if (tileEntity instanceof TileGrinder) {
            TileGrinder grinder = (TileGrinder) tileEntity;

            GL11.glPushMatrix();
            this.bindTexture(texture);
            GL11.glTranslated(x + 0.5, y + 1.6875, z + 0.5);
            GL11.glRotated(180, 1.0, 0.0, 0.0);

            if (grinder.getActive()) {
                if (this.angle >= 360) {
                    this.angle = 0;
                }
                this.angle += 4.0F;
            }
            //this.model.setRotationAngle(model.blade_shaft, (float) Math.toRadians(grinder.getSpinAngle()), 0.0f, 0.0F);
            this.model.setRotationAngle(model.blade_shaft, (float) Math.toRadians(this.angle), 0.0f, 0.0F);

            this.model.blade_shaft.render(0.0625F);
            GL11.glPopMatrix();
        }
    }
}
