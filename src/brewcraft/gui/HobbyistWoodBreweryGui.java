package brewcraft.gui;


import brewcraft.brew.HobbyistWoodBrewery;
import brewcraft.init.Brewcraft;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * @author Andrew Potter (andrew)
 */
public class HobbyistWoodBreweryGui extends GuiContainer {

    public TileEntity tileEntity;
    public static final ResourceLocation texture = new ResourceLocation(Brewcraft.MODID, "textures/gui/breweryHobbyistWood.png");

    public HobbyistWoodBreweryGui(InventoryPlayer inventoryPlayer, TileEntity tileEntity) {
        super(new HobbyistWoodBreweryContainer(inventoryPlayer, tileEntity));

        this.tileEntity = tileEntity;
        this.xSize = 176;
        this.ySize = 166;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        String name = "Hobbyist's Wooden Brewery";

        this.fontRenderer.drawString(name, this.xSize / 2 - this.fontRenderer.getStringWidth(name) / 2, 6, 4210752);
        this.fontRenderer.drawString(I18n.getString("container.inventory"), 8, this.ySize - 96, 4210752);

    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
        GL11.glColor4f(1F, 1F, 1F, 1F);
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);

        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }
}
