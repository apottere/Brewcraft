package brewcraft.brew;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

/**
 * @author Andrew Potter (andrew)
 */
public class HobbyistWoodBreweryTileEntity extends TileEntity implements ISidedInventory {

    private String localizedName;
    private ItemStack[] slots = new ItemStack[3];

    private int burnDurationDone;
    private int burnDurationMax;
    private int burnTicksLeft;

    private int furnaceSpeed = 200;

    public int getSlotsSize() {
        return slots.length;
    }

    @Override
    public void updateEntity() {
        if(this.burnTicksLeft > 0) {
            this.burnTicksLeft--;
        }

        if(!this.worldObj.isRemote) {
            if(this.burnTicksLeft <= 0) {
                if(this.canSmelt()) {
                    this.burnTicksLeft = this.getItemBurnTicks(this.slots[0]);
                    HobbyistWoodBrewery.updateBlockState(true, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
                    if(this.burnTicksLeft > 0 && this.slots[0] != null) {
                        this.slots[0].stackSize--;
                        if(this.slots[0].stackSize <= 0) {
                            this.slots[0] = null;
                        }
                    }
                } else {
                    HobbyistWoodBrewery.updateBlockState(false, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
                }
            }
        }

    }

    private boolean canSmelt() {
        return true;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int var1) {
        switch (var1) {
            case 0:
                return new int[] {2};

            case 1:
                return new int[] {1};

            default:
                return new int[0];
        }
    }

    @Override
    public boolean canInsertItem(int i, ItemStack itemstack, int j) {
        return this.isItemValidForSlot(i, itemstack);
    }

    @Override
    public boolean canExtractItem(int i, ItemStack itemstack, int j) {
        return j == 0 && i == 2;
    }

    @Override
    public int getSizeInventory() {
        return 0;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        return null;
    }

    @Override
    public ItemStack decrStackSize(int i, int j) {
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i) {
        return null;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemstack) {

    }

    @Override
    public String getInvName() {
        return null;
    }

    @Override
    public boolean isInvNameLocalized() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 0;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer) {
        if(this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) == this) {
            return entityplayer.getDistance((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64D;
        }
        return false;
    }

    @Override
    public void openChest() {

    }

    @Override
    public void closeChest() {

    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemstack) {
        switch (i) {
            case 0:
                return this.isItemFuel(itemstack);
            case 1:
                return true;

            default:
                return false;
        }
    }

    private boolean isItemFuel(ItemStack itemStack) {
        return getItemBurnTicks(itemStack) > 0;
    }

    private int getItemBurnTicks(ItemStack itemStack) {
        if(itemStack == null) {
            return 0;
        } else {
            int i = itemStack.itemID;

            if(i == Item.stick.itemID) return 100;
            if(i == Item.coal.itemID) return 1600;
            if(i == Item.bucketLava.itemID) return 20000;
            if(i == Item.blazeRod.itemID) return 2400;


            return GameRegistry.getFuelValue(itemStack);
        }
    }
}
