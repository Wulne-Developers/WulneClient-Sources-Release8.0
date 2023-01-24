package net.wulnemc.core.modules.Other;

import net.wulnemc.wulne.Module.Module;
import net.wulnemc.wulne.Module.ModuleType;
import net.wulnemc.wulne.Module.Value.Numbers;
import net.wulnemc.wulne.Module.Value.Option;
import net.wulnemc.wulne.UI.ClickGui.ClickGuiScreenUI;
import org.lwjgl.input.Keyboard;

public class ClickGui extends Module {
    public static Numbers<Number> r = new Numbers<>("背景R", 94, 0, 255, 1);
    public static Numbers<Number> g = new Numbers<>("背景G", 115, 0, 255, 1);
    public static Numbers<Number> b = new Numbers<>("背景B", 255, 0, 255, 1);
    public static Option chinese = new Option("功能汉化",true);
    public ClickGui() {
        super("ClickGui","设置界面",0,0, ModuleType.Other,false);
        setKey(Keyboard.KEY_RSHIFT);
        addValues(r,g,b,chinese);
    }

    @Override
    public void onEnabled() {
        setEnabled(false);
        mc.displayGuiScreen(new ClickGuiScreenUI());
        super.onEnabled();
    }
}
