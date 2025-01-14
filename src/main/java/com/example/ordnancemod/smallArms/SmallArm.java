package com.example.ordnancemod.smallArms;

import com.example.ordnancemod.OrdnanceMod;
import com.example.ordnancemod.entities.EntityMountableWeapon;
import com.example.ordnancemod.entities.EntityProjectile;
import com.example.ordnancemod.skinLibrary.SkinLibrary;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import java.util.Arrays;
import java.util.Random;

public abstract class SmallArm extends Item {

    public ResourceLocation[] texture;
    public ModelBase[] model;
    public int skinID;
    public SkinLibrary library;
    public String libraryName;
    public Random rand = new Random();
    public String shotSound;
    public float shotPitch;
    public FiringMode[] availableFiringModes;
    public NBTTagCompound nbt = new NBTTagCompound();
    public boolean isPlaceable;
    public boolean isADS;

    public int minDmg;
    public int maxDmg;
    public int knockback;
    public int projectileCount;
    public float projectileSpeed;
    public float inaccuracy;
    public float[] inaccuracyArray;
    public float inaccuracyDefault;
    public float inaccuracyMultiplier;

    public int recoilTick;
    public float recoilMultiplier;
    public float RMDefault;
    public boolean shake = true;

    public int shotTick;
    public int reloadTimer;
    public int RTMax;
    public boolean isReloading;
    public int tickShotDelay;
    public int currentAmmo;
    public int maxAmmo;
    public int firingMode;
    public int burstCount;
    public int burstRemaining;

    public boolean LAltDown;
    public int LAltTick;
    public boolean LClickDown;
    public int LClickTick;
    public boolean Shot1Fired;
    public int TSDDefault;
    public int LCRMultiplier;
    public IItemRenderer renderer;
    public float ADSMultiplier;


    public SmallArm(FiringMode[] availableFiringModes) {
        //super.setMaxStackSize(1);
        this.setMaxStackSize(1);
        this.setCreativeTab(OrdnanceMod.modTab);
        this.currentAmmo = 0;
        this.shotTick = -1;
        this.reloadTimer = -1;
        this.firingMode = 0;
        this.inaccuracy = 0;
        this.projectileCount = 1;
        this.burstCount = 0;
        this.recoilMultiplier = 1.0F;
        this.isPlaceable = false;
        this.availableFiringModes = availableFiringModes;
        this.setSkinID(-1);
        this.recoilTick = -1;
        this.isADS = false;
        this.ADSMultiplier = 1.0F;

        this.libraryName = "none";

        MinecraftForge.EVENT_BUS.register(this);
    }

    public void setDefaults(){
        this.inaccuracyDefault = this.inaccuracy;
        this.TSDDefault = this.tickShotDelay;
        this.RMDefault = this.recoilMultiplier;
    }

    public void calculateInaccuracy(){

    }

    public void shoot(World world, EntityPlayer player) {
        this.recoilTick = 2;
        //float modInaccuracy = (this.inaccuracy > 1) ? (float) Math.sqrt(this.inaccuracy) : this.inaccuracy*this.inaccuracy;
        float modInaccuracy;
        if (this.inaccuracy > 1) {
            modInaccuracy = (float) Math.sqrt(this.inaccuracy);
        } else if (this.inaccuracy == 1) {
            modInaccuracy = 0.7F;
        } else {
            modInaccuracy = this.inaccuracy*this.inaccuracy;
        }
        //float tempInaccuracy = (player.isSneaking()) ? modInaccuracy : this.inaccuracy;
        float tempInaccuracy = (this.isADS) ? modInaccuracy : this.inaccuracy;
        //tempInaccuracy = (tempInaccuracy > this.inaccuracy) ? this.inaccuracy * 0.5F : tempInaccuracy;
        EntityProjectile bullet = new EntityProjectile(world, player, projectileSpeed, tempInaccuracy);
        bullet.setDamage(this.minDmg + rand.nextInt(this.maxDmg - this.minDmg + 1));
        bullet.setKnockback(knockback);
        player.worldObj.playSoundAtEntity(player, this.shotSound, 2.5f, this.shotPitch);
        player.worldObj.spawnEntityInWorld(bullet);
        this.currentAmmo--;
    }

    public void shootParticle(World world, EntityPlayer player) {

    }

    public void doRecoil(World world, EntityPlayer player) {
        //player.rotationPitch -= (player.isSneaking()) ? 5.0F * (recoilMultiplier/2) : 5.0F * recoilMultiplier;
        if (world.isRemote) {
            float impulsePoint = (this.recoilTick > 0) ? 1.0F : -1.0F + ((0.5F - recoilMultiplier)/0.5F);
            if (this.tickShotDelay >= 1) {
                if (this.availableFiringModes[firingMode] != FiringMode.SUPPRESSION) {
                    player.rotationPitch -= (player.isSneaking()) ? 10.0F * (recoilMultiplier / 2) * impulsePoint : 10.0F * recoilMultiplier * impulsePoint;
                } else {
                    player.rotationPitch -= (player.isSneaking()) ? 10.0F * (recoilMultiplier / 4) * impulsePoint : 10.0F * (recoilMultiplier / 2) * impulsePoint;
                }
            //}
            //if (this.availableFiringModes[firingMode] != FiringMode.SEMI && recoilTick > -1) {
            //if (recoilTick == 2) {
            shake = !shake;
            //}
            int shakeDir = shake ? 1 : -1;
            //int shakeDir = (rand.nextInt() >= 0) ? 1 : -1;
            player.rotationYaw += (player.isSneaking()) ? 2.5F * (recoilMultiplier / 2) * shakeDir : 2.5F * recoilMultiplier * shakeDir;
            }
        }
    }


    /*
    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            if (player.isSneaking() && this.getCurrentAmmo() <= 0) {
                if (this.getReloadTimer() == -1) {
                    this.setReloadTimer(this.getRTMax());
                    player.addChatComponentMessage(new ChatComponentText("Reloading"));
                }
            } else if (!player.isSneaking()) {
                if (this.getCurrentAmmo() > 0) {
                    this.setCooldown(21);
                } else if (this.getCurrentAmmo() == 0){
                    this.setCurrentAmmo(-1);
                    this.setReloadTimer(-1);
                    this.setCooldown(-1);
                    world.playSoundAtEntity(player,"random.click",1.0f,2.0f);
                    player.addChatComponentMessage(new ChatComponentText("Magazine empty"));
                }
            }
        }
        return stack;
    }*/

    /*public void shotConditionCheck(World world, EntityPlayer player){
        if (!world.isRemote) {
            if (player.isSneaking() && this.getCurrentAmmo() <= 0) {
                if (this.getReloadTimer() == -1) {
                    this.setReloadTimer(this.getRTMax());
                    player.addChatComponentMessage(new ChatComponentText("Reloading"));
                }
            } else {
                if (this.getCurrentAmmo() > 0 && this.shotTick <= 0) {
                    this.setShotTick(tickShotDelay);
                } else if (this.getCurrentAmmo() == 0){
                    this.setCurrentAmmo(-1);
                    this.setReloadTimer(-1);
                    this.setShotTick(-1);
                    world.playSoundAtEntity(player,"random.click",1.0f,2.0f);
                    player.addChatComponentMessage(new ChatComponentText("Magazine empty"));
                }
            }
        }
    }*/

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            doNormalExecution(player);
        }
        return stack;
    }

    public void doNormalExecution(EntityPlayer player) {
        if (this.currentAmmo <= 0) {
            this.isADS = false;
            if (this.reloadTimer == -1) {
                this.reloadTimer = this.RTMax;
                player.addChatComponentMessage(new ChatComponentText("Reloading"));
            }
        } else {
            this.isADS = !this.isADS;
        }
    }

    public void doWeirdExecution(ItemStack stack) {

        setCurrentAmmo(stack, maxAmmo);
        currentAmmo = getCurrentAmmo(stack);
        System.out.println("Weird execution");
    }

    @SubscribeEvent
    public void onFOVUpdate(FOVUpdateEvent event) {
        if (this.isADS && this.currentAmmo >= 0) {
            event.newfov *= this.ADSMultiplier;
        }
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
            EntityPlayer player = event.player;
            if (player.worldObj.isRemote && this.isADS) {
                float pitchDelta = (float) Mouse.getDY() * 0.01F;
                float yawDelta = (float) Mouse.getDX() * 0.01F;

                player.rotationPitch += pitchDelta;
                player.rotationYaw += yawDelta;
            }
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if (this.isPlaceable) {
            if (!world.isRemote){
                EntityMountableWeapon mount = new EntityMountableWeapon(world,(double)((float)x + 0.5F),(double)((float)y + 0.5F),(double)((float)z + 0.5F),this);
                world.spawnEntityInWorld(mount);
                if (!player.capabilities.isCreativeMode) {
                    player.inventory.setInventorySlotContents(player.inventory.currentItem,null);
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public void shotConditionCheck(World world, EntityPlayer player) {
        if (!world.isRemote) {
            if (this.currentAmmo > 0) {
                switch (availableFiringModes[firingMode]) {
                    case SAFE:
                        break;
                    case SEMI:
                        this.inaccuracy = (this.inaccuracy != this.inaccuracyDefault) ? inaccuracyDefault : this.inaccuracy;
                        if (this.shotTick <= -1 && this.LClickTick >= 0 && !this.Shot1Fired) {
                            this.shotTick = this.tickShotDelay;
                            this.Shot1Fired = true;
                        }
                        break;
                    case BURST:
                        float tempInaccuracy = (this.inaccuracyDefault*(this.inaccuracyMultiplier/2) <= 1) ? 1.25F : this.inaccuracyDefault*(this.inaccuracyMultiplier/2);
                        this.inaccuracy = (this.inaccuracy != this.inaccuracyDefault*(this.inaccuracyMultiplier/2)) ? tempInaccuracy : this.inaccuracy;
                        if (this.shotTick <= -1 && this.LClickTick >= 0 && !this.Shot1Fired) {
                            this.shotTick = this.tickShotDelay * this.burstCount;
                            this.burstRemaining = this.burstCount;
                            this.Shot1Fired = true;
                        }
                        break;
                    case AUTO:
                        this.inaccuracy = (this.inaccuracy != (this.inaccuracyDefault*this.inaccuracyMultiplier)) ? (inaccuracyDefault*inaccuracyMultiplier) : this.inaccuracy;
                        if (this.shotTick <= 0) {
                            this.shotTick = this.tickShotDelay;
                        }
                        break;
                    case PRECISION:
                        this.tickShotDelay = (this.tickShotDelay == this.TSDDefault) ? TSDDefault * LCRMultiplier : this.tickShotDelay;
                        this.inaccuracy = (this.inaccuracy != this.inaccuracyDefault) ? inaccuracyDefault : this.inaccuracy;
                        this.recoilMultiplier = (this.recoilMultiplier != this.RMDefault) ? RMDefault : this.recoilMultiplier;
                        if (this.shotTick <= 0) {
                            this.shotTick = this.tickShotDelay;
                        }
                        break;
                    case SUPPRESSION:
                        this.tickShotDelay = (this.tickShotDelay != this.TSDDefault) ? TSDDefault : this.tickShotDelay;
                        this.inaccuracy = (this.inaccuracy == this.inaccuracyDefault) ? inaccuracyDefault * inaccuracyMultiplier : this.inaccuracy;
                        this.recoilMultiplier = (this.recoilMultiplier == this.RMDefault) ? RMDefault * 2.0F : this.recoilMultiplier;
                        if (this.shotTick <= 0) {
                            this.shotTick = this.tickShotDelay;
                        }
                        break;
                    default:
                        break;
                }
            } else if (this.currentAmmo == 0) {
                this.currentAmmo = -1;
                this.reloadTimer = -1;
                this.shotTick = -1;
                if (Arrays.asList(availableFiringModes).contains(FiringMode.BURST)) {
                    this.burstRemaining = 0;
                }
                world.playSoundAtEntity(player, "random.click", 1.0f, 2.0f);
                player.addChatComponentMessage(new ChatComponentText("Magazine empty"));
            }
        }
    }

    public void onUpdate(ItemStack item, World world, Entity player, int ticks, boolean inHand) {
        super.onUpdate(item, world, player, ticks, inHand);
        EntityPlayer player1 = (EntityPlayer) player;
        boolean flag = player1.getHeldItem() == item && Minecraft.getMinecraft().currentScreen == null;
        this.LAltDown = (flag && Keyboard.isKeyDown(Keyboard.KEY_LMENU));
        this.LClickDown = (flag && Mouse.isButtonDown(0));

        if (LClickDown) {
            if (!world.isRemote) {
                this.shotConditionCheck(world, player1);
            }
        }

        if (flag) {
            player1.isSwingInProgress = false;
            this.changeFireMode(world, player1);
            this.LCTUtil();
        }
        if (flag && LClickTick == -1) {
            if (this.burstRemaining <= 0) {
                this.Shot1Fired = false;
                //this.shotTick = -1;
            }
        }

        if (this.recoilTick > -1) {
            this.doRecoil(world, player1);
            this.recoilTick--;
        }

        if (this.currentAmmo > 0) {
            if (!world.isRemote) {
                if (this.shotTick >= 0) {
                    if (shotTick % tickShotDelay == 0 && shotTick != 0) {
                        this.shoot(world, player1);
                        if (this.burstRemaining > 0) {
                            this.burstRemaining--;
                        }
                    }
                    this.shotTick--;
                }
                /*if (world.getTotalWorldTime() % tickShotDelay == 0 && LClickDown) {
                    this.shoot(world, player1);
                    if (this.burstRemaining > 0) {
                        this.burstRemaining--;
                    }
                }*/
            }
        } else {
            this.shotTick = -1;
            if (this.reloadTimer > 0) {
                this.reloadTimer--;
            } else if (this.reloadTimer == 0) {
                this.reloadTimer = -1;
                this.currentAmmo = this.maxAmmo;
                world.playSoundAtEntity(player1, "random.click", 1.0f, 1.0f);
                player1.addChatComponentMessage(new ChatComponentText("Reloaded"));
            }
        }
    }

    public void changeFireMode(World world, EntityPlayer player) {
        if (this.LAltDown) {
            if (this.LAltTick <= 1) {
                this.LAltTick++;
            }
        } else {
            this.LAltTick = -1;
        }

        if (this.LAltTick == 0) {
            if (!player.isSneaking() && this.firingMode < this.availableFiringModes.length - 1) {
                this.firingMode++;
            } else if (player.isSneaking() && this.firingMode > 0) {
                this.firingMode--;
            }
            world.playSoundAtEntity(player, "random.click", 1.0f, 1.0f);
        }
    }

    public void LCTUtil() {
        if (this.LClickDown) {
            if (this.LClickTick < 1) {
                this.LClickTick++;
            }
        } else {
            this.LClickTick = -1;
        }
    }

    public void setNBTData(ItemStack stack) {
        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
        }

        NBTTagCompound nbt = stack.getTagCompound();
        nbt.setInteger("shotTick",this.shotTick);
        nbt.setInteger("reloadTimer",this.reloadTimer);
        nbt.setInteger("RTMax",this.RTMax);
        nbt.setInteger("tickShotDelay",this.tickShotDelay);
        nbt.setInteger("burstCount",this.burstCount);
        nbt.setInteger("burstRemaining",this.burstRemaining);
        nbt.setInteger("currentAmmo",this.currentAmmo);
        nbt.setInteger("maxAmmo",this.maxAmmo);
        nbt.setInteger("firingMode",this.firingMode);
        nbt.setString("libraryName",this.libraryName);

        stack.setTagCompound(nbt);
    }

    public void getNBTData(ItemStack stack) {
        if (stack.hasTagCompound()) {
            NBTTagCompound tag = stack.getTagCompound();

            this.shotTick = tag.getInteger("shotTick");
            this.reloadTimer = tag.getInteger("reloadTimer");
            this.RTMax = tag.getInteger("RTMax");
            this.tickShotDelay = tag.getInteger("tickShotDelay");
            this.burstCount = tag.getInteger("burstCount");
            this.burstRemaining = tag.getInteger("burstRemaining");
            this.currentAmmo = tag.getInteger("currentAmmo");
            this.maxAmmo = tag.getInteger("maxAmmo");
            this.firingMode = tag.getInteger("firingMode");
            this.libraryName = tag.getString("libraryName");
        }
    }


    //Stat Getters and Setters

    public void setCurrentAmmo(ItemStack stack, int ammo) {
        if (stack.getTagCompound() == null) {
            stack.setTagCompound(new NBTTagCompound());
        }
        stack.stackTagCompound.setInteger("currentAmmo",ammo);
    }

    public int getCurrentAmmo(ItemStack stack) {
        if (stack == null) {
            return 0;
        } else {
            return stack.getTagCompound() == null ? 0 : stack.stackTagCompound.getInteger("currentAmmo");
        }
    }

    public int getSkinID(){return this.skinID;}
    public void setSkinID(int a) {this.skinID = a;}

    public SkinLibrary getLibrary() {return this.library;}
    public void setLibrary(SkinLibrary a) {this.library = a;}

    public String getLibraryName() {
        return this.libraryName;
    }
    public void setLibraryName(String name) {
        this.libraryName = name;
    }


    public enum FiringMode {
        SAFE,
        BOLT,
        SEMI,
        BURST,
        AUTO,
        PRECISION,
        SUPPRESSION
    }

    public static String firingModeName(SmallArm.FiringMode firingMode, int burstCount) {
        switch (firingMode) {
            case SAFE: return "SAFE";
            case BOLT: return "BOLT";
            case SEMI: return "SEMI";
            case BURST: return "BURST("+burstCount+")";
            case AUTO: return "AUTO";
            case PRECISION: return "PRECISION";
            case SUPPRESSION: return "SUPPRESSION";
            default: break;
        }
        return null;
    }

}
