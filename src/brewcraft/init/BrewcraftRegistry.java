package brewcraft.init;

import brewcraft.brew.HobbyistWoodBrewery;
import brewcraft.generic.GenericItem;
import brewcraft.plants.hops.HopsCrop;
import brewcraft.plants.hops.HopsSeedTrellis;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;

/**
 * @author Andrew Potter (andrew)
 */
public class BrewcraftRegistry {

    private static int itemIdCounter = 5000;
    private static int blockIdCounter = 500;

    public static Item hopsFruit;
    public static Item hopsSeed;
    public static ItemSeeds hopsSeedTrellis;
    public static HopsCrop hopsCrop;

    public static BlockContainer hobbyistWoodBreweryIdle;
    public static BlockContainer hobbyistWoodBreweryActive;

    protected static void populateBlocksAndItems() {
        // Hops registry
        hopsFruit = new GenericItem(itemIdCounter++, 64, "fruitHops", Brewcraft.CREATIVE_TAB);
        hopsSeed = new GenericItem(itemIdCounter++, 64, "seedHops", Brewcraft.CREATIVE_TAB);
        hopsCrop = new HopsCrop(blockIdCounter++, hopsFruit.itemID);
        hopsSeedTrellis = new HopsSeedTrellis(itemIdCounter++, hopsCrop.blockID, Block.tilledField.blockID);
        hopsCrop.setSeedItem(hopsSeedTrellis.itemID);

        // Brewery registry
        hobbyistWoodBreweryIdle = new HobbyistWoodBrewery(blockIdCounter++, false);
        hobbyistWoodBreweryActive = new HobbyistWoodBrewery(blockIdCounter++, true);
    }

    protected static void registerNames() {
        LanguageRegistry.addName(hopsFruit, "Hops");
        LanguageRegistry.addName(hopsSeed, "Hops Seeds");
        LanguageRegistry.addName(hopsSeedTrellis, "Hops Seed Trellis");

        LanguageRegistry.addName(hobbyistWoodBreweryIdle, "Hobbyist's Wooden Brewery");

        GameRegistry.registerBlock(hopsCrop, "hopsCrop");
        GameRegistry.registerBlock(hobbyistWoodBreweryIdle, "breweryHobbyistWoodIdle");
        GameRegistry.registerBlock(hobbyistWoodBreweryActive, "breweryHobbyistWoodActive");
    }

    protected static void registerCraftingRecipes() {
        // Add me some crafting.
        GameRegistry.addShapelessRecipe(new ItemStack(hopsSeed, 2), new ItemStack(hopsFruit));
        GameRegistry.addShapelessRecipe(new ItemStack(hopsSeedTrellis, 1), new ItemStack(hopsSeed), new ItemStack(Item.stick), new ItemStack(Item.stick), new ItemStack(Item.stick), new ItemStack(Item.stick));

        GameRegistry.addShapedRecipe(new ItemStack(hobbyistWoodBreweryIdle), "XXX", "X X", "XYX",
                'X', new ItemStack(Block.wood),
                'Y', new ItemStack(Item.ingotIron)
        );
    }
}
