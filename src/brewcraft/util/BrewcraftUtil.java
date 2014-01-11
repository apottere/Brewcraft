package brewcraft.util;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

/**
 * @author Andrew Potter (andrew)
 */
public class BrewcraftUtil {

    public static int getPlayerDirection(EntityLivingBase entityLivingBase) {
        return MathHelper.floor_double((double) (entityLivingBase.rotationYaw * 4.0F / 360F) + 0.5D) & 3;
    }

    public static int translateBlockFacing(int playerFacing) {
        switch(playerFacing) {
            case 0:
                return 2;

            case 1:
                return 5;

            case 2:
                return 3;

            case 3:
                return 4;

            default:
                return 2;
        }
    }
}
