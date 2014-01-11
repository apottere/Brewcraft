package brewcraft.gui;

import brewcraft.generic.GenericTileEntityTuple;
import brewcraft.init.BrewcraftRegistry;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Andrew Potter (andrew)
 */
public class GuiHandler implements IGuiHandler {

    private Set<GenericTileEntityTuple> tileEntityTuples = new HashSet<>();

    public void addTileEntityTuple(GenericTileEntityTuple tileEntityTuple) {
        tileEntityTuples.add(tileEntityTuple);
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        if(tileEntity != null) {
            for(GenericTileEntityTuple tileEntityTuple : tileEntityTuples) {
                if(ID == tileEntityTuple.id && tileEntityTuple.tileEntityClass.isInstance(tileEntity)) {
                    return new HobbyistWoodBreweryContainer(player.inventory, tileEntity);
                }
            }
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        if(tileEntity != null) {
            for(GenericTileEntityTuple tileEntityTuple : tileEntityTuples) {
                if(ID == tileEntityTuple.id && tileEntityTuple.tileEntityClass.isInstance(tileEntity)) {
                    return new HobbyistWoodBreweryGui(player.inventory, tileEntity);
                }
            }
        }
        return null;
    }

}
