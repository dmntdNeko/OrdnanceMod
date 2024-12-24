package com.example.ordnancemod.events;

import com.example.ordnancemod.items.ItemAFC;
import com.example.ordnancemod.items.ItemSpeedometer;
import com.example.ordnancemod.smallArms.SmallArm;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import java.math.BigDecimal;
import java.math.RoundingMode;

@SideOnly(Side.CLIENT)
public class HeldItemHUD extends Gui {
    Minecraft mc = Minecraft.getMinecraft();
    double x, y, z, hyp;
    int ticksInHand;

    public HeldItemHUD() {
    }

    @SubscribeEvent(
            priority = EventPriority.NORMAL,
            receiveCanceled = false
    )
    public void onRenderExperienceBar(RenderGameOverlayEvent.Pre event) {
        EntityPlayer player = this.mc.thePlayer;
        ItemStack item = player.getCurrentEquippedItem();
        ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
        if (event.type == ElementType.HOTBAR) {
            if (item != null && item.getItem() instanceof ItemSpeedometer) {
                ticksInHand++;
                ItemSpeedometer speedometer = (ItemSpeedometer) item.getItem();
                double tickrate = speedometer.getTickrate();
                if (ticksInHand >= tickrate) {
                    x = Double.parseDouble(new BigDecimal(Double.toString(player.posX - player.prevPosX)).setScale(2, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString());
                    z = Double.parseDouble(new BigDecimal(Double.toString(player.posZ - player.prevPosZ)).setScale(2, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString());
                    y = Double.parseDouble(new BigDecimal(Double.toString((player.posY - player.prevPosY) * 20)).setScale(2, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString());

                    hyp = Double.parseDouble(new BigDecimal((Double.toString(MathHelper.sqrt_double((x * x) + (z * z)) * 20))).setScale(2, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString());
                    ticksInHand = 0;
                }

                this.mc.fontRenderer.drawString((tickrate / 20) + " seconds/update", sr.getScaledWidth() / 2 + 10, sr.getScaledHeight() / 2 - 20, 10145997);
                this.mc.fontRenderer.drawString(Double.toString(y), sr.getScaledWidth() / 2 + 10, sr.getScaledHeight() / 2 - 7, 14737632);
                this.mc.fontRenderer.drawString(Double.toString(hyp), sr.getScaledWidth() / 2 + 10, sr.getScaledHeight() / 2 + 7, 14737632);
                this.mc.fontRenderer.drawString("blocks/s", sr.getScaledWidth() / 2 + 40, sr.getScaledHeight() / 2 - 7, 16776995);
                this.mc.fontRenderer.drawString("blocks/s", sr.getScaledWidth() / 2 + 40, sr.getScaledHeight() / 2 + 7, 16776995);
            } else if (item != null && item.getItem() instanceof SmallArm) {
                SmallArm SA = (SmallArm) item.getItem();
                this.mc.fontRenderer.drawString(SmallArm.firingModeName(SA.availableFiringModes[SA.firingMode], SA.burstCount), sr.getScaledWidth() / 2 + 15, sr.getScaledHeight() / 2 - 10, 0xE2E2E2);
                //this.mc.fontRenderer.drawString("Inaccuracy: "+SA.getInaccuracy(), sr.getScaledWidth() / 2 - 100, sr.getScaledHeight() / 2, 0xE2E2E2);
                //double pitch = Double.parseDouble(new BigDecimal(Double.toString(player.rotationPitch)).setScale(2, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString());
                //this.mc.fontRenderer.drawString("Player pitch: " + pitch, sr.getScaledWidth() / 2 + 15, sr.getScaledHeight() / 2 - 30, 0xE2E2E2);
                if (SA.currentAmmo > 0) {
                    this.mc.fontRenderer.drawString(SA.currentAmmo + " / " + SA.maxAmmo, sr.getScaledWidth() / 2 + 15, sr.getScaledHeight() / 2, 0xE2E2E2);
                } else {
                    this.mc.fontRenderer.drawString("0 / " + SA.maxAmmo,sr.getScaledWidth() / 2 + 15, sr.getScaledHeight() / 2,0xFF3333);
                }
                //float pitch  = (float) Double.parseDouble(new BigDecimal(Double.toString(player.rotationPitch)).setScale(2, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString());
                //this.mc.fontRenderer.drawString("Pitch: " + pitch,sr.getScaledWidth() / 2 - 5, sr.getScaledHeight() / 2 + 15,0xFFFF);
            } else if (item != null && item.getItem() instanceof ItemAFC) {
                ItemAFC AFC = (ItemAFC) item.getItem();
                if (AFC.hasBoundSystem) {
                    this.mc.fontRenderer.drawString(AFC.boundSystem.getCurrentAmmo() + "/" + AFC.boundSystem.getMaxAmmo(), sr.getScaledWidth() / 2 + 15, sr.getScaledHeight() / 2, 0xE2E2E2);
                }
            }
        } else if (event.type == ElementType.CROSSHAIRS){
            if (item != null && item.getItem() instanceof SmallArm) {
                SmallArm SA = (SmallArm) item.getItem();
                if (SA.isADS) {
                    event.setCanceled(true);
                }
            }
        }
    }
}
