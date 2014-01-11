package brewcraft.gui;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.tileentity.TileEntity;

/**
 * @author Andrew Potter (andrew)
 */
public class HobbyistWoodBreweryContainer extends Container {

    private TileEntity tileEntity;

    public HobbyistWoodBreweryContainer(InventoryPlayer inventoryPlayer, TileEntity tileEntity) {
        this.tileEntity = tileEntity;
        this.addSlotToContainer(new Slot(inventoryPlayer, 1, 56, 17));
        this.addSlotToContainer(new Slot(inventoryPlayer, 0, 56, 53));
        this.addSlotToContainer(new SlotFurnace(inventoryPlayer.player, inventoryPlayer, 2, 116, 35));

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 9; j++) {
                this.addSlotToContainer(new Slot(inventoryPlayer, i*9 + j,8 + j*18, 84 + i*18));
            }
        }

        for(int j = 0; j < 9; j++) {
            this.addSlotToContainer(new Slot(inventoryPlayer, 3*9 + j, 8 + j*18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityplayer) {
        if(this.tileEntity.worldObj.getBlockTileEntity(this.tileEntity.xCoord, this.tileEntity.yCoord, this.tileEntity.zCoord) == this.tileEntity) {
            return entityplayer.getDistance((double) this.tileEntity.xCoord + 0.5D, (double) this.tileEntity.yCoord + 0.5D, (double) this.tileEntity.zCoord + 0.5D) <= 64D;
        }
        return false;
    }
}
