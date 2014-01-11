package brewcraft.generic;

import net.minecraft.tileentity.TileEntity;

/**
 * @author Andrew Potter (andrew)
 */
public class GenericTileEntityTuple {

    public final Class<? extends TileEntity> tileEntityClass;
    public final int id;

    public GenericTileEntityTuple(Class<? extends TileEntity> tileEntityClass, int id) {
        this.tileEntityClass = tileEntityClass;
        this.id = id;
    }
}
