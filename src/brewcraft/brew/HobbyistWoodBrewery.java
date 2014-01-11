package brewcraft.brew;

import brewcraft.generic.GenericBlockContainer;
import brewcraft.init.BrewcraftRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.Random;

/**
 * @author Andrew Potter (andrew)
 */
public class HobbyistWoodBrewery extends GenericBlockContainer {

    public HobbyistWoodBrewery(int id, boolean isActive) {
        super(id, Material.wood, "breweryHobbyistWood", isActive);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return null;
    }

    @Override
    public int idDropped(int par1, Random random, int par3) {
        return BrewcraftRegistry.hobbyistWoodBreweryIdle.blockID;
    }
}
