package personal.ibonny.matteroverdrive116.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import personal.ibonny.matteroverdrive116.MatterOverdrive116;
import personal.ibonny.matteroverdrive116.container.MatterRecyclerContainer;

public class MatterRecyclerScreen extends ContainerScreen<MatterRecyclerContainer> {
    private final ResourceLocation GUI = new ResourceLocation(MatterOverdrive116.MOD_ID,
            "textures/gui/recycler.png");

    public MatterRecyclerScreen(MatterRecyclerContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
        RenderSystem.color4f(255f, 255f, 255f, 255f);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int i = this.guiLeft;
        int j = this.guiTop;
        this.blit(matrixStack, x, y, 0, 0, 233, 175);

        this.font.drawString(matrixStack, "Testout", 150, 50, TextFormatting.WHITE.getColor());
    }

    @Override
    protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int mouseX, int mouseY) {
//        String s = this.getDisplayName().getUnformattedText();
//
//        this.font.drawString(s, 88 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
//        this.fontRendererObj.drawString("Inventory", 8, 72, 4210752);      //#404040
    }
}
