package brewcraft.brew;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * @author Andrew Potter (andrew)
 */
public class HobbyistWoodBrewery extends BlockContainer {

    private final boolean isActive;

    public HobbyistWoodBrewery(int id, boolean isActive) {
        super(id, Material.wood);
        this.isActive = isActive;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return null;
    }
}
