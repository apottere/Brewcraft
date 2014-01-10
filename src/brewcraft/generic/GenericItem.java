package brewcraft.generic;

import brewcraft.init.Brewcraft;
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
        setTextureName(Brewcraft.TEXTURE_PREFIX + name);
        setCreativeTab(tab);
    }
}
