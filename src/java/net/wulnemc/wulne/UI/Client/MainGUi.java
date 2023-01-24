package net.wulnemc.wulne.UI.Client;

import net.minecraft.client.gui.*;
import net.minecraft.realms.RealmsBridge;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.demo.DemoWorldServer;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.WorldInfo;
import net.optifine.reflect.Reflector;
import net.wulnemc.core.ClientJava;
import net.wulnemc.wulne.UI.Client.Component.*;
import net.wulnemc.wulne.Util.Font.FontLoaders;
import java.awt.*;
import java.io.IOException;

public class MainGUi extends GuiScreen {
    long initTime = System.currentTimeMillis();

    public MainGUi() {}

    @Override
    public void initGui() {
        int j = this.height / 4 + 48;
        this.buttonList.add(new SingPlayerButton(1,this.width / 2 - 80, j + 20,""));
        this.buttonList.add(new MuPlayerButton(2,this.width / 2 - 80 + 50 + 2, j + 20,""));
        this.buttonList.add(new RealmsButton(3,this.width / 2 - 80 - 50 - 2, j + 20,""));
        this.buttonList.add(new SettingButton(4,this.width / 2 - 80 + 50 + 2 + 50 + 2, j + 20,""));
        this.buttonList.add(new exitButton(5,this.width / 2 - 80 + 50 + 2 + 50 + 2 + 50 + 2, j + 20,""));

        super.initGui();

        initTime = System.currentTimeMillis();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        int j = this.height / 4 + 48;
        this.drawDefaultBackground();
        this.mc.getTextureManager().bindTexture(new ResourceLocation("WulneClientAssets/MainGui/back.png"));
        Gui.drawModalRectWithCustomSizedTexture(0, 0, 0.0F, 0.0F, this.width, this.height, (float)this.width, (float)this.height);
        FontLoaders.msFont72.drawString("WulneClient",this.width / 2 - 108, j - 30,new Color(229, 229, 229,255).getRGB());
        FontLoaders.msFont22.drawString(ClientJava.INSTANCE.version,this.width / 2 - 108, j - 18,new Color(229, 229, 229,255).getRGB());
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.id == 0)
        {
            this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
        }

        if (button.id == 1)
        {
            this.mc.displayGuiScreen(new GuiSelectWorld(this));
        }

        if (button.id == 2)
        {
            this.mc.displayGuiScreen(new GuiMultiplayer(this));
        }

        if (button.id == 3) {
            this.switchToRealms();
        }

        if (button.id == 4) {
            this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
        }

        if (button.id == 5)
        {
            this.mc.shutdown();
        }

        if (button.id == 6 && Reflector.GuiModList_Constructor.exists())
        {
            this.mc.displayGuiScreen((GuiScreen)Reflector.newInstance(Reflector.GuiModList_Constructor, new Object[] {this}));
        }

        if (button.id == 11)
        {
            this.mc.launchIntegratedServer("Demo_World", "Demo_World", DemoWorldServer.demoWorldSettings);
        }

        if (button.id == 12)
        {
            ISaveFormat isaveformat = this.mc.getSaveLoader();
            WorldInfo worldinfo = isaveformat.getWorldInfo("Demo_World");

            if (worldinfo != null)
            {
                GuiYesNo guiyesno = GuiSelectWorld.makeDeleteWorldYesNo(this, worldinfo.getWorldName(), 12);
                this.mc.displayGuiScreen(guiyesno);
            }
        }
    }

    private void switchToRealms()
    {
        RealmsBridge realmsbridge = new RealmsBridge();
        realmsbridge.switchToRealms(this);
    }
}
