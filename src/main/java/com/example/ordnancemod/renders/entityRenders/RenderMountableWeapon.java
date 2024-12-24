package com.example.ordnancemod.renders.entityRenders;

import com.example.ordnancemod.entities.EntityMountableWeapon;
import com.example.ordnancemod.skinLibrary.LMGSkins;
import com.example.ordnancemod.skinLibrary.LahtiSkins;
import com.example.ordnancemod.skinLibrary.SkinLibrary;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderMountableWeapon extends Render {

    private SkinLibrary library = new SkinLibrary();
    private LMGSkins lmg = new LMGSkins();
    private LahtiSkins lahti = new LahtiSkins();


    public RenderMountableWeapon() {

    }

    @Override
    public void doRender(Entity entity, double x, double y, double z, float yaw, float pitch) {
        if (entity instanceof EntityMountableWeapon) {
            EntityMountableWeapon mount = (EntityMountableWeapon) entity;
            if (entity.worldObj.isRemote) {
                if ("LMG".equals(mount.libraryName)) {
                    //System.out.println("Mount " + mount.libraryName + " can be rendered here! It's an LMG!");
                    this.library = lmg;
                } else if ("lahti".equals(mount.libraryName)) {
                    //System.out.println("Mount " + mount.libraryName + " can be rendered here! It's a Lahti!");
                    this.library = lahti;
                }

                /*if (mount.libraryName == "LMG") {
                    this.library = lmg;
                } else if (mount.libraryName == "lahti") {
                    this.library = lahti;
                } else {
                    this.library = lahti;
                }*/
            }
            //System.out.println(this.library.getLibraryName());
            //System.out.println("Name: " + mount.libraryName);
            int skinID = mount.getSkinID();

            //System.out.println("~~~~~~~~~~~~~~~~~~~~");
            //System.out.println("Skin # " + skinID + " of library " + this.library.getLibraryName());
            //System.out.println("~~~~~~~~~~~~~~~~~~~~");
            if (skinID < 0 || skinID >= library.texture.length) {
                skinID = 0;
            }
            GL11.glPushMatrix();
            if (entity.ticksExisted >= 4) {
                if (this.library instanceof LMGSkins) {
                    //float yOffset = this.library.getModel(skinID).yOffset;
                    LMGSkins lmg = (LMGSkins) this.library;
                    float yOffset = lmg.model[skinID].yOffset;
                    GL11.glTranslated(x, y - yOffset, z);
                    this.bindTexture(lmg.texture[skinID]);
                    //lmg.model[skinID].render(entity, 0, 0, 0, 0, 0, 0.016875F); //default
                    lmg.model[skinID].render(entity, 0, 0, 0, 0, 0, lmg.model[skinID].scale);
                } else if (this.library instanceof LahtiSkins) {
                    LahtiSkins lahti = (LahtiSkins) this.library;
                    float yOffset = lahti.model[skinID].yOffset;
                    GL11.glTranslated(x, y - yOffset, z);
                    this.bindTexture(lahti.texture[skinID]);
                    lahti.model[skinID].render(entity, 0, 0, 0, 0, 0, lahti.model[skinID].scale);
                    //lahti.model[skinID].render(entity, 0, 0, 0, 0, 0, 0.016875F); //default
                }
            }
            GL11.glPopMatrix();
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return null;
    }
}
