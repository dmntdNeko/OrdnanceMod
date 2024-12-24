package com.example.ordnancemod.util;

import com.example.ordnancemod.OrdnanceMod;
import com.example.ordnancemod.entities.*;
import com.example.ordnancemod.entities.particles.*;
import com.example.ordnancemod.models.ModelHeavyArtillery;
import com.example.ordnancemod.models.modelBench.ModelChingChengHanji;
import com.example.ordnancemod.models.entityModels.ModelMinecartHeavy;
import com.example.ordnancemod.models.ModelTurretAutocannon;
import com.example.ordnancemod.renders.*;
import com.example.ordnancemod.renders.entityRenders.*;
import com.example.ordnancemod.renders.tileEntityRenders.RenderGriefingTable;
import com.example.ordnancemod.tileentities.TileGriefingTable;
import com.example.ordnancemod.tileentities.TileGrinder;
import com.example.ordnancemod.tileentities.TileOrdnance;
import com.example.ordnancemod.tileentities.TileWeaponPlatform;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.client.particle.*;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy{
    int ModEntityID;

    public void registerRenderers(){
        //Entity Renders
        RenderingRegistry.registerEntityRenderingHandler(EntityHeavyArtillery.class, new RenderHeavyArtillery(new ModelHeavyArtillery(),1.0f));
        RenderingRegistry.registerEntityRenderingHandler(EntityMinecartHeavy.class, new RenderMinecartHeavy(new ModelMinecartHeavy(), 1.0F));
        RenderingRegistry.registerEntityRenderingHandler(EntityProjectile.class,new RenderProjectile());
        RenderingRegistry.registerEntityRenderingHandler(EntityOrdnanceProjectile.class,new RenderOrdnanceProjectile());
        RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class,new RenderBullet(OrdnanceMod.itemBullet));
        RenderingRegistry.registerEntityRenderingHandler(EntityTurretAutocannon.class, new RenderTurretAutocannon(new ModelTurretAutocannon(),1.0F));

        RenderingRegistry.registerEntityRenderingHandler(EntityMountableWeapon.class, new RenderMountableWeapon());

        RenderingRegistry.registerEntityRenderingHandler(EntityModel.class, new RenderModel(new ModelChingChengHanji(),1.0F));

        //Tile Renders
        ClientRegistry.bindTileEntitySpecialRenderer(TileGrinder.class, new RenderGrinder());
        ClientRegistry.bindTileEntitySpecialRenderer(TileOrdnance.class, new RenderLightArtillery());
        ClientRegistry.bindTileEntitySpecialRenderer(TileWeaponPlatform.class, new RenderWeaponSystem());
        ClientRegistry.bindTileEntitySpecialRenderer(TileGriefingTable.class, new RenderGriefingTable());
    }

    public void registerItemRenderers(Item smallArm, IItemRenderer renderer){
        MinecraftForgeClient.registerItemRenderer(smallArm, renderer);
    }

    public void registerEntities(){
        ModEntityID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerModEntity(EntityBullet.class,"EntityBullet",ModEntityID++, OrdnanceMod.INSTANCE,256,1,false);
        EntityRegistry.registerModEntity(EntityProjectile.class,"EntityProjectile",ModEntityID++, OrdnanceMod.INSTANCE,256,8,true);
        EntityRegistry.registerModEntity(EntityOrdnanceProjectile.class,"EntityOrdnanceProjectile",ModEntityID++, OrdnanceMod.INSTANCE,512,1,true);
        EntityRegistry.registerModEntity(EntityFlakProjectile.class,"EntityFlakProjectile",ModEntityID++, OrdnanceMod.INSTANCE,256,1,true);

        EntityRegistry.registerModEntity(EntityHeavyArtillery.class,"HeavyArtillery",ModEntityID++, OrdnanceMod.INSTANCE,32,20,false);
        EntityRegistry.registerModEntity(EntityMinecartHeavy.class,"HeavyMinecart",ModEntityID++, OrdnanceMod.INSTANCE,64,3,false);
        EntityRegistry.registerModEntity(EntityTurretAutocannon.class,"TurretAutocannon",ModEntityID++, OrdnanceMod.INSTANCE,64,20,false);

        EntityRegistry.registerModEntity(EntityTurretMount.class,"EntityTurretMount",ModEntityID++, OrdnanceMod.INSTANCE,32,20,false);
        EntityRegistry.registerModEntity(EntityMountableWeapon.class,"EntityMountableWeapon",ModEntityID++, OrdnanceMod.INSTANCE,32,20,false);

        EntityRegistry.registerModEntity(EntityModel.class,"EntityModel",ModEntityID++, OrdnanceMod.INSTANCE,32,20,false);

        //Particle Registry
        EntityRegistry.registerModEntity(EntityExplodeFXShortLife.class,"EntityExplodeShort",ModEntityID++, OrdnanceMod.INSTANCE,32,20,false);
    }

    //Default particle spawners
    public void spawnParticle(String name, World world, double posX, double posY, double posZ, double motionX, double motionY, double motionZ) {
        EntityFX fx = null;
        if (name.equals("smoke")) {
            fx = new EntitySmokeFX(world, posX, posY, posZ, 255, 255, 255, 2.5F);
        } else if (name.equals("largesmoke")) {
            fx = new EntitySmokeFX(world, posX, posY, posZ, 255, 255, 255, (float) (Math.random() + 1) * 4.0F);
        } else if (name.equals("crit")) {
            fx = new EntityCritFX(world, posX, posY, posZ, 0, 0, 0);
        } else if (name.equals("flame")) {
            fx = new EntityFlameFX(world, posX, posY, posZ, 0, 0, 0);
        }else if (name.equals("explode")) {
            fx = new EntityExplodeFX(world, posX, posY, posZ, 0, 0, 0);
        } else if (name.equals("explodelong")) {
            fx = new EntityExplodeFXCustom(world, posX, posY, posZ, 0, 0, 0);
        } else if (name.equals("explodeshort")) {
            fx = new EntityExplodeFXShortLife(world, posX, posY, posZ, 0, 0, 0);
        } else if (name.equals("flaksmokesmall")) {
            fx = new EntityFlakSmokeFX(world,posX,posY,posZ,0,0,0, 5);
        } else if (name.equals("flaksmokelarge")) {
            fx = new EntityFlakSmokeFX(world,posX,posY,posZ,0,0,0,20);
        }

        if (fx != null) {
            ((EntityFX)fx).motionX = motionX;
            ((EntityFX)fx).motionY = motionY;
            ((EntityFX)fx).motionZ = motionZ;
            FMLClientHandler.instance().getClient().effectRenderer.addEffect((EntityFX)fx);
        }
    }

    //Special particle spawners with scale and max age
    public void spawnParticle(String name, World world, double posX, double posY, double posZ, double motionX, double motionY, double motionZ, float scale, double maxAge) {
        EntityFX fx = null;
        if (name.equals("explodelong")) {
            fx = new EntityExplodeFXCustom(world, posX, posY, posZ, motionX, motionY, motionZ, scale, maxAge);
        } else if (name.equals("flamebig")) {
            fx = new EntityFlameFXCustom(world, posX, posY, posZ, motionX, motionY, motionZ, scale, maxAge);
        }

        if (fx != null) {
            ((EntityFX)fx).motionX = motionX;
            ((EntityFX)fx).motionY = motionY;
            ((EntityFX)fx).motionZ = motionZ;
            FMLClientHandler.instance().getClient().effectRenderer.addEffect((EntityFX)fx);
        }
    }

    //Special particle spawners with initial facing direction
    public void spawnParticle(String name, World world, double posX, double posY, double posZ, double motionX, double motionY, double motionZ, float yaw, float pitch) {
        EntityFX fx = null;
        if (name.equals("tracer")) {
            fx = new EntityShotFX(world,posX,posY,posZ,motionX,motionY,motionZ,yaw,pitch);
        }

        if (fx != null) {
            ((EntityFX)fx).motionX = motionX;
            ((EntityFX)fx).motionY = motionY;
            ((EntityFX)fx).motionZ = motionZ;
            FMLClientHandler.instance().getClient().effectRenderer.addEffect((EntityFX)fx);
        }
    }

    public static World getClientWorld() {
        return FMLClientHandler.instance().getWorldClient();
    }

}
