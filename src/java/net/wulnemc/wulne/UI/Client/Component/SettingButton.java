package net.wulnemc.wulne.UI.Client.Component;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.wulnemc.wulne.Util.Font.FontLoaders;
import net.wulnemc.wulne.Util.Render.RenderUtil;

public class SettingButton extends GuiButton {
    public SettingButton(int buttonId, int x, int y, String buttonText) {
        super(buttonId, x, y,64, 64,buttonText);
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY) {
        if (this.visible) {
            RenderUtil.drawImage(new ResourceLocation("WulneClientAssets/MainGui/Setting.png"),xPosition,yPosition,50,50);
            boolean flag = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;

            if (flag) {
                RenderUtil.drawImage(new ResourceLocation("WulneClientAssets/MainGui/flag/Setting.png"),xPosition,yPosition,50,50);
                FontLoaders.msFont18.drawString(I18n.format("menu.options", new Object[0]),xPosition + 15,yPosition + 50 + 3,-1);
            }
        }
    }
}
