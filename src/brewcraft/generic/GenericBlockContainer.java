package brewcraft.generic;

import brewcraft.init.Brewcraft;
import brewcraft.util.BrewcraftUtil;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import java.util.Random;

/**
 * @author Andrew Potter (andrew)
 */
public abstract class GenericBlockContainer extends BlockContainer {

    private final boolean isActive;
    private final String textureName;

    @SideOnly(Side.CLIENT)
    private Icon iconFront;
    @SideOnly(Side.CLIENT)
    private Icon iconSide;
    @SideOnly(Side.CLIENT)
    private Icon iconTop;

    public GenericBlockContainer(int id, Material material, String textureName, boolean isActive) {
        super(id, material);
        this.isActive = isActive;
        this.textureName = textureName;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this.iconFront = iconRegister.registerIcon(Brewcraft.TEXTURE_PREFIX + textureName + "_front_" + (this.isActive ? "active" : "idle"));
        this.iconSide = iconRegister.registerIcon(Brewcraft.TEXTURE_PREFIX + textureName + "_side");
        this.iconTop = iconRegister.registerIcon(Brewcraft.TEXTURE_PREFIX + textureName + "_top");

        this.blockIcon = this.iconFront;
    }

    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int metadata) {

        if(metadata == 0 && side == 3) {
            return this.iconFront;
        }

        switch(side) {
            case BlockSide.BOTTOM:
            case BlockSide.TOP:
                return this.iconTop;

            case BlockSide.LEFT:
            case BlockSide.RIGHT:
            case BlockSide.BACK:
            case BlockSide.FRONT:
                if(side == metadata) {
                    return this.iconFront;
                } else {
                    return this.iconSide;
                }

            default:
                throw new IllegalArgumentException("Incorrect side ordinal: " + side);
        }
    }

    public abstract int idDropped(int par1, Random random, int par3);

    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        int facing = BrewcraftUtil.getPlayerDirection(entityLivingBase);
        world.setBlockMetadataWithNotify(x, y, z, BrewcraftUtil.translateBlockFacing(facing), 2);
    }
}
