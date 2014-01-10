package boozmod.plants.hops;

import net.minecraft.block.BlockCrops;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;

/**
 * @author Andrew Potter (andrew)
 */
public class HopsCrop extends BlockCrops {

    private int seed;
    private final int fruit;

    public HopsCrop(int id, int fruit) {
        super(id);
        this.fruit = fruit;

        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName("cropHops");
        setTextureName("boozmod:cropHops");
    }

    @Override
    public int getSeedItem() {
        return seed;
    }

    public void setSeedItem(int id) {
        this.seed = id;
    }

    @Override
    public int getCropItem() {
        return fruit;
    }

    @Override
    public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<>();
        ret.add(new ItemStack(this.fruit, world.rand.nextInt(2) + 1, 0));
        ret.add(new ItemStack(Item.stick.itemID, 4, 0));

        return ret;
    }
}
