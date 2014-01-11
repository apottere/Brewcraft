package brewcraft.brew;

import brewcraft.generic.GenericBlockContainer;
import brewcraft.init.Brewcraft;
import brewcraft.init.BrewcraftRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.Random;

/**
 * @author Andrew Potter (andrew)
 */
public class HobbyistWoodBrewery extends GenericBlockContainer {

    private static boolean keepInventory;

    public HobbyistWoodBrewery(int id, boolean isActive) {
        super(id, Material.wood, "breweryHobbyistWood", isActive);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new HobbyistWoodBreweryTileEntity();
    }

    @Override
    public int idDropped(int par1, Random random, int par3) {
        return BrewcraftRegistry.hobbyistWoodBreweryIdle.blockID;
    }

    public static void updateBlockState(boolean b, World worldObj, int xCoord, int yCoord, int zCoord) {
        int i = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
        TileEntity tileEntity = worldObj.getBlockTileEntity(xCoord, yCoord, zCoord);
        keepInventory = true;

        if(b) {
            worldObj.setBlock(xCoord, yCoord, zCoord, BrewcraftRegistry.hobbyistWoodBreweryActive.blockID);
        } else {
            worldObj.setBlock(xCoord, yCoord, zCoord, BrewcraftRegistry.hobbyistWoodBreweryIdle.blockID);
        }

        keepInventory = false;

        worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);

        if(tileEntity != null) {
            tileEntity.validate();
            worldObj.setBlockTileEntity(xCoord, yCoord, zCoord, tileEntity);
        }
    }
}
