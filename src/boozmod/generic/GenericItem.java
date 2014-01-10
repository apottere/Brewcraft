package boozmod.generic;

import boozmod.init.BoozMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * @author Andrew Potter (andrew)
 */
public class GenericItem extends Item {

    public GenericItem(int id, int stackSize, String name, CreativeTabs tab) {
        super(id);
        setMaxStackSize(stackSize);
        setUnlocalizedName(name);
        setTextureName(BoozMod.TEXTURE_PREFIX + name);
        setCreativeTab(tab);
    }
}
