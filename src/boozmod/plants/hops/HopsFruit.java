package boozmod.plants.hops;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * @author Andrew Potter (andrew)
 */
public class HopsFruit extends Item {

    public HopsFruit(int id) {
        super(id);
        setMaxStackSize(64);
        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName("fruitHops");
        setTextureName("boozmod:fruitHops");
    }
}
