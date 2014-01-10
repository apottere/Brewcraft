package boozmod.plants.hops;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * @author Andrew Potter (andrew)
 */
public class HopsSeed extends Item {

    public HopsSeed(int id) {
        super(id);
        setMaxStackSize(64);
        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName("seedHops");
        setTextureName("boozmod:seedHops");
    }
}
