package com.example.ordnancemod.gui;

import com.example.ordnancemod.containers.ContainerMinecartHeavy;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiMinecartHeavy extends GuiContainer {
    private static final ResourceLocation bg_texture = new ResourceLocation("ExampleMod:textures/gui/minecartHeavy.png");

    private int xSize;
    private int ySize;

    public GuiMinecartHeavy() {
        super(new ContainerMinecartHeavy());
        this.xSize  = 240;
        this.ySize = 240;
    }

    public GuiMinecartHeavy(ContainerMinecartHeavy container) {
        super(container);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        //super.drawScreen(mouseX,mouseY,partialTicks);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.drawDefaultBackground();
        this.mc.getTextureManager().bindTexture(bg_texture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        drawTexturedModalRect(k,l, 0, 0, this.xSize, this.ySize);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        /*GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        super.drawScreen(mouseX,mouseY,partialTicks);
        this.drawDefaultBackground();
        this.mc.getTextureManager().bindTexture(bg_texture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        drawTexturedModalRect(k,l, 0, 0, this.xSize, this.ySize);
         */
    }
}
