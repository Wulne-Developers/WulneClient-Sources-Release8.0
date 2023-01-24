package net.wulnemc.wulne.UI.EditHUD;

import net.minecraft.client.gui.GuiScreen;
import net.wulnemc.wulne.Module.Module;
import net.wulnemc.wulne.Util.ChromaText;
import net.wulnemc.wulne.Util.Font.FontLoaders;
import net.wulnemc.wulne.Util.Render.HUDRenderUtil;
import net.wulnemc.wulne.WulneClient;

public class EditHUD extends GuiScreen {
    protected boolean hovered;

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.drawDefaultBackground();
        for (Module module : WulneClient.INSTANCE.moduleManager.modules) {
            if (module.isString) {
                if (module.isEnabled()) {
                    module.renderItem(mouseX, mouseY);
                    this.hovered = mouseX >= module.getX() && mouseX <= module.getX() + module.getWidth() &&mouseY  >= module.getY() && mouseY <= module.getY() + module.getHeight();
                    if (hovered) {
                        HUDRenderUtil.drawHollowRect(module.getX(), module.getY(), module.getWidth(), module.getHeight(), ChromaText.drawChroma(10));
                        FontLoaders.msFont14.drawString(module.name + " " + "x：" + module.getX() + " " + "y：" + module.getY(), module.getX(), module.getY() - FontLoaders.msFont14.FONT_HEIGHT, -1);
                        continue;
                    } else {
                        HUDRenderUtil.drawHollowRect(module.getX(), module.getY(), module.getWidth(), module.getHeight(), ChromaText.drawChroma(10));
                    }
                }
            }
        }
    }
}
