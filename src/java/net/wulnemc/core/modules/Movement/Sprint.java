package net.wulnemc.core.modules.Movement;

import net.wulnemc.wulne.Module.Module;
import net.wulnemc.wulne.Module.ModuleType;

public class Sprint extends Module {
    public Sprint() {
        super("Sprint","自动疾跑",0,0,ModuleType.Movement,false);
    }

    @Override
    public void onEnabled() {
        mc.gameSettings.keyBindSprint.Doing = true;
    }

    @Override
    public void onDisable() {
        mc.gameSettings.keyBindSprint.Doing = false;
    }
}
