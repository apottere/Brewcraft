package brewcraft.init;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;

/**
 * @author Andrew Potter (andrew)
 */
@Mod(modid = "BrewcraftModID", name = "Brewcraft", version = "0.0.0")
@NetworkMod(clientSideRequired = true)
public class Brewcraft {

    @Mod.Instance(value = "BrewcraftModID")
    public static Brewcraft instance;

    public static final String TEXTURE_PREFIX = "brewcraft:";
    public static final CreativeTabs CREATIVE_TAB = CreativeTabs.tabMisc;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println("Loading Brewcraft!");
        Configuration configFile = new Configuration(event.getSuggestedConfigurationFile());

        configFile.load();
        configFile.save();
    }

    @Mod.EventHandler
    public void load(FMLInitializationEvent event) {
        BrewcraftRegistry.populateBlocksAndItems();
        BrewcraftRegistry.registerNames();
        BrewcraftRegistry.registerCraftingRecipes();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        System.out.println("Loaded Brewcraft!");
    }
}
