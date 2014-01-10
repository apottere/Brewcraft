package boozmod.init;

import boozmod.generic.GenericItem;
import boozmod.plants.hops.HopsCrop;
import boozmod.plants.hops.HopsSeedTrellis;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;

/**
 * @author Andrew Potter (andrew)
 */
public class BoozModRegistry {

    private static int itemIdCounter = 5000;
    private static int blockIdCounter = 500;

    public static Item hopsFruit;
    public static Item hopsSeed;
    public static ItemSeeds hopsSeedTrellis;
    public static HopsCrop hopsCrop;

    protected static void populateBlocksAndItems() {
        hopsFruit = new GenericItem(itemIdCounter++, 64, "fruitHops", BoozMod.CREATIVE_TAB);
        hopsSeed = new GenericItem(itemIdCounter++, 64, "seedHops", BoozMod.CREATIVE_TAB);
        hopsCrop = new HopsCrop(blockIdCounter++, hopsFruit.itemID);
        hopsSeedTrellis = new HopsSeedTrellis(itemIdCounter++, hopsCrop.blockID, Block.tilledField.blockID);
        hopsCrop.setSeedItem(hopsSeedTrellis.itemID);
    }

    protected static void registerNames() {
        LanguageRegistry.addName(hopsFruit, "Hops");
        LanguageRegistry.addName(hopsSeed, "Hops Seeds");
        LanguageRegistry.addName(hopsSeedTrellis, "Hops Seed Trellis");

        GameRegistry.registerBlock(hopsCrop, "hopsCrop");
    }

    protected static void registerCraftingRecipes() {
        // Add me some crafting.
        GameRegistry.addShapelessRecipe(new ItemStack(hopsSeed, 2), new ItemStack(hopsFruit));
        GameRegistry.addShapelessRecipe(new ItemStack(hopsSeedTrellis, 1), new ItemStack(hopsSeed), new ItemStack(Item.stick), new ItemStack(Item.stick), new ItemStack(Item.stick), new ItemStack(Item.stick));
    }
}
