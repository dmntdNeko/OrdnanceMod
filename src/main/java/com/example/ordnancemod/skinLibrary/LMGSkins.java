package com.example.ordnancemod.skinLibrary;

import com.example.ordnancemod.models.modelBench.ModelMG42;
import com.example.ordnancemod.models.modelBench.ModelSmallArm;
import net.minecraft.util.ResourceLocation;

public class LMGSkins extends SkinLibrary {

    public LMGSkins(){
        this.hasLibrary = true;
        this.setLibraryName("LMGSkins");
    }

    private ModelMG42 LMG1M = new ModelMG42();
    public ModelSmallArm[] model = {LMG1M};

    private ResourceLocation LMG1T = new ResourceLocation("ordnancemod", "textures/entities/mg42.png");
    public ResourceLocation[] texture = {LMG1T};


}
