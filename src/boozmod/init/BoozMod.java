package boozmod.init;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import net.minecraftforge.common.Configuration;

/**
 * @author Andrew Potter (andrew)
 */
@Mod(modid = "BoozModModID", name = "BoozMod", version = "0.0.0")
@NetworkMod(clientSideRequired = true)
public class BoozMod {

    @Mod.Instance(value = "BoozModModID")
    public static BoozMod instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println("Loading BoozMod!");
        Configuration configFile = new Configuration(event.getSuggestedConfigurationFile());

        configFile.load();
        configFile.save();
    }

    @Mod.EventHandler
    public void load(FMLInitializationEvent event) {
        BoozModRegistry.populateBlocksAndItems();
        BoozModRegistry.registerNames();
        BoozModRegistry.registerCraftingRecipes();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        System.out.println("Loaded ScrewDryads!");
    }
}
