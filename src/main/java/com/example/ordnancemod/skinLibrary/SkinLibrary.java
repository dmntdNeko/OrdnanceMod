package com.example.ordnancemod.skinLibrary;

import com.example.ordnancemod.models.modelBench.ModelSmallArm;
import net.minecraft.util.ResourceLocation;

public class SkinLibrary {

    private String LibraryName;
    public boolean hasLibrary;

    public SkinLibrary(){
        this.hasLibrary = false;
    }

    public SkinLibrary(String name){
        this.LibraryName = name;
        this.hasLibrary = true;
    }


    public ModelSmallArm[] model = {};

    public ResourceLocation[] texture = {};

    public String getLibraryName() {return this.LibraryName;}
    public void setLibraryName(String a) {this.LibraryName = a;}

    public ModelSmallArm getModel(int skinID) {
        return this.model[skinID];
    }

    public ResourceLocation getTexture(int skinID) {
        return this.texture[skinID];
    }

}
