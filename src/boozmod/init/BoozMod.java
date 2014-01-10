package boozmod.init;

import boozmod.plants.hops.HopsCrop;
import boozmod.plants.hops.HopsFruit;
import boozmod.plants.hops.HopsSeed;
import boozmod.plants.hops.HopsSeedTrellis;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
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

        Item hopsFruit = new HopsFruit(5001);
        LanguageRegistry.addName(hopsFruit, "Hops");

        Item hopsSeed = new HopsSeed(5002);
        LanguageRegistry.addName(hopsSeed, "Hops Seeds");

        HopsCrop hopsCrop = new HopsCrop(503, hopsFruit.itemID);

        ItemSeeds hopsSeedTrellis = new HopsSeedTrellis(5003, hopsCrop.blockID, Block.tilledField.blockID);
        LanguageRegistry.addName(hopsSeedTrellis, "Hops Seed Trellis");

        hopsCrop.setSeedItem(hopsSeedTrellis.itemID);
        GameRegistry.registerBlock(hopsCrop, "hopsCrop");

        // Add me some crafting.
        GameRegistry.addShapelessRecipe(new ItemStack(hopsSeed, 2), new ItemStack(hopsFruit));
        GameRegistry.addShapelessRecipe(new ItemStack(hopsSeedTrellis, 1), new ItemStack(hopsSeed), new ItemStack(Item.stick), new ItemStack(Item.stick), new ItemStack(Item.stick), new ItemStack(Item.stick));
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        System.out.println("Loaded ScrewDryads!");
    }
}
