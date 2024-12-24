package com.example.ordnancemod.renders;

import com.example.ordnancemod.models.ModelWeaponSystem;
import com.example.ordnancemod.tileentities.TileWeaponPlatform;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderWeaponSystem extends TileEntitySpecialRenderer {

    private ModelWeaponSystem model = new ModelWeaponSystem();

    public RenderWeaponSystem(){}
    private static final ResourceLocation texture = new ResourceLocation("examplemod","textures/tileentities/HeavyMG.png");

    public void render(TileWeaponPlatform system, double x, double y, double z, float f){
        GL11.glPushMatrix();
        GL11.glTranslated(x+0.4375, y+0.5, z+0.5);
        this.model.setRotationAngle(model.mainModel, (float) Math.toRadians(system.getPitch()),(float) Math.toRadians(system.getYaw()), (float) Math.PI);
        this.bindTexture(texture);
        this.model.mainModel.render(0.03125F);
        GL11.glPopMatrix();
    }

    @Override
    public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f) {
        render((TileWeaponPlatform) tile,x,y,z,f);
    }
}
