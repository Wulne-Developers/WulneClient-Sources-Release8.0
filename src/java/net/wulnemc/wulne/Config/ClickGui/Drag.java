package net.wulnemc.wulne.Config.ClickGui;

import net.wulnemc.wulne.Config.FileManager;
import net.wulnemc.wulne.UI.ClickGui.ClickGuiScreenUI;

import java.util.List;

public class Drag {
    public void save() {
        String inits = "";
        inits = String.valueOf(inits)
                + String.format("%s:%s%s","ClickGuiX", ClickGuiScreenUI.getWindowX(), System.lineSeparator());
        FileManager.save("ClickGui/ClickGuiX.txt", inits, false);
        String init = "";
        init = String.valueOf(init)
                + String.format("%s:%s%s","ClickGuiY", ClickGuiScreenUI.getWindowY(), System.lineSeparator());
        FileManager.save("ClickGui/ClickGuiY.txt", init, false);
    }

    public void load() {
        List<String> x = FileManager.read("ClickGui/ClickGuiX.txt");
        for (String v : x) {
            String dragX = v.split(":")[1];
            ClickGuiScreenUI.setWindowX(Float.parseFloat(dragX));
        }
        List<String> y = FileManager.read("ClickGui/ClickGuiY.txt");
        for (String v : y) {
            String dragY = v.split(":")[1];
            ClickGuiScreenUI.setWindowY(Float.parseFloat(dragY));
        }
    }
}
