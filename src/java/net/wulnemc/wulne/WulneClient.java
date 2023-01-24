package net.wulnemc.wulne;

import net.wulnemc.wulne.Command.CommandManager;
import net.wulnemc.wulne.Config.ClickGui.Drag;
import net.wulnemc.wulne.Event.EventManager;
import net.wulnemc.wulne.Module.ModuleManager;

public class WulneClient {
    public static WulneClient INSTANCE = new WulneClient();
    public ModuleManager moduleManager;
    public CommandManager commandManager;
    public Drag dragManager;

    public void load() {
        moduleManager = new ModuleManager();
        commandManager = new CommandManager();
        dragManager = new Drag();
    }

    public void init() {
        EventManager.register(this);
        moduleManager.load();
        moduleManager.readSettings();
        commandManager.load();
        dragManager.load();
    }

    public void stop() {
        EventManager.unregister(this);
        moduleManager.saveSettings();
        dragManager.save();
    }
}
