package com.example.ordnancemod.skinLibrary;

import com.example.ordnancemod.models.modelBench.ModelLahti;
import com.example.ordnancemod.models.modelBench.ModelSmallArm;
import net.minecraft.util.ResourceLocation;

public class LahtiSkins extends SkinLibrary {

    public LahtiSkins(){
        this.hasLibrary = true;
        this.setLibraryName("LahtiSkins");
    }

    private ModelLahti LahtiM1 = new ModelLahti();
    public ModelSmallArm[] model = {LahtiM1};

    private ResourceLocation LahtiT1 = new ResourceLocation("ordnancemod", "textures/entities/lahti.png");
    public ResourceLocation[] texture = {LahtiT1};


}
