package com.familycraftmc.familycraftmod;

import com.familycraftmc.familycraftmod.blocks.FCBlocks;
import com.familycraftmc.familycraftmod.items.FCItems;
import com.familycraftmc.familycraftmod.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = FamilyCraftMod.MODID, version = FamilyCraftMod.VERSION, name = FamilyCraftMod.NAME)
public class FamilyCraftMod
{
    public static final String MODID = "familycraftmod";
    public static final String VERSION = "0.1";
    public static final String NAME = "Family Craft Mod";

    @SidedProxy(clientSide = "com.familycraftmc.familycraftmod.proxy.ClientProxy", serverSide = "com.familycraftmc.familycraftmod.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static Logger logger;

    @Mod.Instance
    public static FamilyCraftMod instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        FCConfig.init(event.getSuggestedConfigurationFile());

        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);

        FCBlocks.register();
        FCItems.register();


    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }

    public static CreativeTabs fcTab = new CreativeTabs("familyCraft") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Items.ACACIA_BOAT);
        }
    };
}
