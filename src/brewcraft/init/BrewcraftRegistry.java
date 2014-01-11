package brewcraft.init;

import brewcraft.brew.HobbyistWoodBrewery;
import brewcraft.brew.HobbyistWoodBreweryTileEntity;
import brewcraft.generic.GenericItem;
import brewcraft.generic.GenericTileEntityTuple;
import brewcraft.gui.GuiHandler;
import brewcraft.plants.hops.HopsCrop;
import brewcraft.plants.hops.HopsSeedTrellis;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

/**
 * @author Andrew Potter (andrew)
 */
public class BrewcraftRegistry {

    private static int itemIdCounter = 5000;
    private static int blockIdCounter = 500;
    private static int tileEntityIdCounter = 0;

    public static Item hopsFruit;
    public static Item hopsSeed;
    public static ItemSeeds hopsSeedTrellis;
    public static HopsCrop hopsCrop;

    public static BlockContainer hobbyistWoodBreweryIdle;
    public static BlockContainer hobbyistWoodBreweryActive;
    public static GenericTileEntityTuple hobbyistWoodBreweryTileEntity;

    protected static void populateBlocksAndItems() {
        GuiHandler guiHandler = new GuiHandler();

        // Hops registry
        hopsFruit = new GenericItem(itemIdCounter++, 64, "fruitHops", Brewcraft.CREATIVE_TAB);
        hopsSeed = new GenericItem(itemIdCounter++, 64, "seedHops", Brewcraft.CREATIVE_TAB);

        hopsCrop = new HopsCrop(blockIdCounter++, hopsFruit.itemID);
        hopsCrop.setCreativeTab(Brewcraft.CREATIVE_TAB);

        hopsSeedTrellis = new HopsSeedTrellis(itemIdCounter++, hopsCrop.blockID, Block.tilledField.blockID);
        hopsSeedTrellis.setCreativeTab(Brewcraft.CREATIVE_TAB);
        hopsCrop.setSeedItem(hopsSeedTrellis.itemID);

        // Brewery registry
        hobbyistWoodBreweryIdle = new HobbyistWoodBrewery(blockIdCounter++, false);
        hobbyistWoodBreweryActive = new HobbyistWoodBrewery(blockIdCounter++, true);
        hobbyistWoodBreweryIdle.setCreativeTab(Brewcraft.CREATIVE_TAB);
        hobbyistWoodBreweryActive.setCreativeTab(Brewcraft.CREATIVE_TAB);
        hobbyistWoodBreweryTileEntity = new GenericTileEntityTuple(HobbyistWoodBreweryTileEntity.class, tileEntityIdCounter++);
        guiHandler.addTileEntityTuple(hobbyistWoodBreweryTileEntity);

        NetworkRegistry.instance().registerGuiHandler(Brewcraft.instance, guiHandler);
    }

    protected static void registerNames() {
        LanguageRegistry.addName(hopsFruit, "Hops");
        LanguageRegistry.addName(hopsSeed, "Hops Seeds");
        LanguageRegistry.addName(hopsSeedTrellis, "Hops Seed Trellis");

        LanguageRegistry.addName(hobbyistWoodBreweryIdle, "Hobbyist's Wooden Brewery");

        GameRegistry.registerBlock(hopsCrop, "hopsCrop");
        GameRegistry.registerBlock(hobbyistWoodBreweryIdle, "breweryHobbyistWood");
        GameRegistry.registerBlock(hobbyistWoodBreweryActive, "breweryHobbyistWoodActive");

        GameRegistry.registerTileEntity(hobbyistWoodBreweryTileEntity.tileEntityClass, "tileEntityBreweryHobbyistWood");

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
