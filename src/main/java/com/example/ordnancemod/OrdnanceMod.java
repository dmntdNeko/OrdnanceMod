package com.example.ordnancemod;

import com.example.ordnancemod.blocks.*;
import com.example.ordnancemod.events.HeldItemHUD;
import com.example.ordnancemod.gui.GuiHandler;
import com.example.ordnancemod.items.*;
import com.example.ordnancemod.misc.TabExampleMod;
import com.example.ordnancemod.network.*;
import com.example.ordnancemod.renders.itemRenders.*;
import com.example.ordnancemod.smallArms.*;
import com.example.ordnancemod.tileentities.TileGriefingTable;
import com.example.ordnancemod.tileentities.TileGrinder;
import com.example.ordnancemod.tileentities.TileOrdnance;
import com.example.ordnancemod.tileentities.TileTurntable;
import com.example.ordnancemod.util.CommonProxy;
import com.example.ordnancemod.util.OrdnanceChunkLoadingCallback;
import com.example.ordnancemod.world.OrdnanceWorldGen;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.common.ForgeChunkManager;
import net.minecraftforge.common.MinecraftForge;

import java.util.logging.LogManager;
import java.util.logging.Logger;

@Mod(modid = "ordnancemod", name = "Ordnance Mod",version = "1.0")
public class OrdnanceMod
{
    public static final SimpleNetworkWrapper NETWORK = NetworkRegistry.INSTANCE.newSimpleChannel("ordnancemod");
    public static final Logger LOGGER = LogManager.getLogManager().getLogger("ordnancemod");

    public static Item itemAFC;
    public static Item itemAutocannon;
    public static Item itemHeavyArtillery;
    public static Item itemModelSpawner;
    public static Item itemSpeedometer;
    public static Item itemTileTester;
    public static Item itemTestGun;
    public static Item itemScrap;

    public static Item itemBullet;

    public static Block blockGrinder;
    public static Block blockOrdnance;
    public static Block blockTurntable;
    public static Block blockWeaponPlatform;
    public static Block blockGriefingTable;

    public static Block blockCompactScrap;
    public static Block blockLoosenedScrap;


    @Mod.Instance("ordnancemod")
    public static OrdnanceMod INSTANCE;
    @SidedProxy(clientSide="com.example.ordnancemod.util.ClientProxy",serverSide="com.example.ordnancemod.util.CommonProxy")
    public static CommonProxy proxy;
    public static Item item;
    public static TabExampleMod modTab= new TabExampleMod(CreativeTabs.getNextID(),"TabOrdnanceMod");


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        //tabExampleMod modTab= new tabExampleMod(CreativeTabs.getNextID(),"tabExampleMod");
        
        //config handling
        //item init
        this.registerSmallArms(event.getSide().isClient());

        itemAFC = new ItemAFC().setUnlocalizedName("ItemAFC").setTextureName("ordnancemod:ItemAFC").setCreativeTab(modTab);
        itemAutocannon = new ItemAutocannon().setUnlocalizedName("ItemAutocannon").setTextureName("ordnancemod:ItemAutocannon").setCreativeTab(modTab);
        //itemBattleRifle = new itemBattleRifle().setUnlocalizedName("itemBattleRifle").setTextureName("examplemod:itemBattleRifle").setCreativeTab(modTab);
        itemHeavyArtillery = new ItemHeavyArtillery().setUnlocalizedName("ItemHeavyArtillery").setTextureName("ordnancemod:ItemHeavyArtillery").setCreativeTab(modTab);
        itemModelSpawner = new ItemModelSpawner().setUnlocalizedName("ItemModelSpawner").setTextureName("ordnancemod:ItemModelSpawner").setCreativeTab(modTab);
        itemSpeedometer = new ItemSpeedometer().setUnlocalizedName("ItemSpeedometer").setTextureName("ordnancemod:ItemSpeedometer").setCreativeTab(modTab);
        itemTestGun = new ItemTestGun().setUnlocalizedName("ItemTestGun").setTextureName("ordnancemod:ItemTestGun").setCreativeTab(modTab);
        itemTileTester = new ItemTileTester().setUnlocalizedName("ItemTileTester").setTextureName("ordnancemod:ItemTileTester").setCreativeTab(modTab);

        itemScrap = new ItemScrap().setUnlocalizedName("ItemScrap").setTextureName("ordnancemod:ItemScrap").setCreativeTab(modTab);

        itemBullet = new ItemBullet().setUnlocalizedName("ItemBullet").setTextureName("ordnancemod:ItemBullet").setCreativeTab(modTab);

        //block init
        blockGrinder = new BlockGrinder(Material.iron).setBlockName("BlockGrinder").setBlockTextureName("ordnancemod:BlockGrinder").setCreativeTab(modTab);
        blockOrdnance = new BlockOrdnance(Material.circuits).setBlockName("BlockOrdnance").setCreativeTab(modTab);
        blockGriefingTable = new BlockGriefingTable(Material.circuits).setBlockName("BlockGriefingTable").setCreativeTab(modTab);
        blockTurntable = new BlockTurntable(Material.circuits).setBlockName("BlockTurntable").setCreativeTab(modTab);
        blockWeaponPlatform = new BlockWeaponPlatform(Material.circuits).setBlockName("BlockWeaponPlatform").setCreativeTab(modTab);

        blockCompactScrap = new BlockCompactScrap(Material.rock).setBlockName("BlockCompactScrap").setBlockTextureName("ordnancemod:BlockCompactScrap").setCreativeTab(modTab);
        blockLoosenedScrap = new BlockLoosenedScrap(Material.rock).setBlockName("BlockLoosenedScrap").setBlockTextureName("ordnancemod:BlockLoosenedScrap").setCreativeTab(modTab);

        //tile init


        //registration
        GameRegistry.registerItem(itemAFC, itemAFC.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(itemAutocannon, itemAutocannon.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(itemHeavyArtillery, itemHeavyArtillery.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(itemModelSpawner, itemModelSpawner.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(itemSpeedometer, itemSpeedometer.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(itemTestGun, itemTestGun.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(itemTileTester, itemTileTester.getUnlocalizedName().substring(5));

        GameRegistry.registerItem(itemScrap, itemScrap.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(itemBullet, itemBullet.getUnlocalizedName().substring(5));

        GameRegistry.registerBlock(blockGrinder, blockGrinder.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(blockOrdnance, blockOrdnance.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(blockWeaponPlatform, blockWeaponPlatform.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(blockGriefingTable, blockGriefingTable.getUnlocalizedName().substring(5));

        GameRegistry.registerBlock(blockCompactScrap, blockCompactScrap.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(blockLoosenedScrap, blockLoosenedScrap.getUnlocalizedName().substring(5));

        GameRegistry.registerWorldGenerator(new OrdnanceWorldGen(),0);

        //EntityRegistry.registerModEntity();
        proxy.registerRenderers();
        proxy.registerEntities();
        proxy.registerEventHandlers();

    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        GameRegistry.registerTileEntity(TileGrinder.class,"TileGrinder");
        GameRegistry.registerTileEntity(TileOrdnance.class,"TileLightArtillery");
        GameRegistry.registerTileEntity(TileTurntable.class,"TileTurntable");
        GameRegistry.registerTileEntity(TileGriefingTable.class,"TileGriefingTable");

        NETWORK.registerMessage(TileGrinderPacketHandler.class, TileGrinderPacket.class,0,Side.CLIENT);
        NETWORK.registerMessage(EntityMountableWeaponPacket.Handler.class, EntityMountableWeaponPacket.class, 1, Side.CLIENT);
        NETWORK.registerMessage(ItemAutocannonPacketClient.Handler.class, ItemAutocannonPacketClient.class,2,Side.CLIENT);
        NETWORK.registerMessage(ItemAutocannonPacketServer.Handler.class, ItemAutocannonPacketServer.class,3,Side.SERVER);

        ForgeChunkManager.setForcedChunkLoadingCallback(this, new OrdnanceChunkLoadingCallback());

        NetworkRegistry.INSTANCE.registerGuiHandler(OrdnanceMod.INSTANCE,new GuiHandler());

        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());

    }

    @EventHandler
    @SideOnly(Side.CLIENT)
    public void postInit(FMLPostInitializationEvent event){
        MinecraftForge.EVENT_BUS.register(new HeldItemHUD());
    }

    void registerSmallArms(boolean isClient){
        this.addSmallArms(new ItemPistol(), "ItemPistol",isClient, new RenderPistol());
        this.addSmallArms(new ItemAssaultRifle(), "ItemAssaultRifle", isClient, new RenderAssaultRifle());
        this.addSmallArms(new ItemBattleRifle(), "ItemBattleRifle", isClient, new RenderBattleRifle());
        this.addSmallArms(new ItemLMG(), "ItemLMG", isClient, new RenderLMG());
        this.addSmallArms(new ItemSMG(), "ItemSMG", isClient, null);
        this.addSmallArms(new ItemSniperRifle(), "ItemSniperRifle", isClient, null);

        this.addSmallArms(new ItemLahti(), "ItemLahti", isClient, new RenderLahti());
    }

    private void addSmallArms(SmallArm smallArm, String unlocalizedName, boolean isClient, IItemRenderer renderer){
        GameRegistry.registerItem(smallArm,unlocalizedName.substring(4));
        if (isClient) {
            proxy.registerItemRenderers(smallArm, renderer);
        }
    }
}
