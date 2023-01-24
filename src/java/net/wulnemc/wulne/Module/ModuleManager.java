package net.wulnemc.wulne.Module;

import net.minecraft.client.Minecraft;
import net.wulnemc.core.ClientKotlin;
import net.wulnemc.core.events.EventKey;
import net.wulnemc.core.events.EventRender2D;
import net.wulnemc.core.modules.Movement.Sprint;
import net.wulnemc.core.modules.Other.ClickGui;
import net.wulnemc.core.modules.Other.noCommand;
import net.wulnemc.core.modules.Render.Keystroke;
import net.wulnemc.core.modules.Render.Notification;
import net.wulnemc.wulne.Config.FileManager;
import net.wulnemc.wulne.Event.EventManager;
import net.wulnemc.wulne.Event.EventTarget;
import net.wulnemc.wulne.Module.Value.Mode;
import net.wulnemc.wulne.Module.Value.Numbers;
import net.wulnemc.wulne.Module.Value.Option;
import net.wulnemc.wulne.Module.Value.Value;
import net.wulnemc.wulne.UI.EditHUD.EditHUD;
import net.wulnemc.wulne.WulneClient;
import net.wulnemc.wulne.WulneClientKotlin;
import org.lwjgl.input.Keyboard;

import java.util.*;

public class ModuleManager {
    public List<Module> modules = new ArrayList<Module>();

    public void load() {
        //Movement
        modules.add(new Sprint());
        //Render
        modules.add(new Keystroke());
        modules.add(new Notification());
        //Other
        modules.add(new ClickGui());
        modules.add(new noCommand());

        this.sortModules();
        WulneClientKotlin.pluginManager.onModuleManagerLoad(this);
        EventManager.register(this);
    }

    public List<Module> getModsByCategory(ModuleType m) {
        List<Module> findList = new ArrayList<>();
        for (Module mod : modules) {
            if (mod.getModuleType() == m) {
                findList.add(mod);
            }
        }
        return findList;
    }

    public void addModule(Module module) {
        modules.add(module);
    }

    public void sortModules() {
        modules.sort((m1, m2) -> {
            if (m1.getName().toCharArray()[0] > m2.getName().toCharArray()[0]) {
                return 1;
            }
            return -1;
        });
    }

    public void renderModules() {
        for (Module module : modules) {
            if (module.isEnabled()) {
                module.draw();
            }
        }
    }

    public Module getModByClass(Class<? extends Module> cls) {
        for (Module m : modules) {
            if (m.getClass() != cls) {
                continue;
            }
            return m;
        }
        return null;
    }

    @EventTarget
    public void onRender(EventRender2D eventRender2D) {
        if (!(Minecraft.getMinecraft().currentScreen instanceof EditHUD)) {
            renderModules();
        }
    }

    @EventTarget
    public void onKey(EventKey e) {
        for (Module module : modules) {
            if (module.getKey() == e.getKey()) {
                module.setEnabled(!module.isEnabled());
            }
        }
    }

    public Module getModuleByName(String name) {
        for (Module m : modules) {
            if (!m.getName().equalsIgnoreCase(name))
                continue;
            return m;
        }
        return null;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void readSettings() {
        List<String> enabled = FileManager.read("Module/Enabled.txt");
        Iterator var2 = enabled.iterator();

        while (var2.hasNext()) {
            String v = (String) var2.next();
            Module m = getModuleByName(v);
            if (m != null) {
                m.setEnabled(true);
            }
        }
        List<String> binds = FileManager.read("Module/Binds.txt");
        for (String v : binds) {
            String name = v.split(":")[0];
            String bind = v.split(":")[1];
            Module m = WulneClient.INSTANCE.moduleManager.getModuleByName(name);
            if (m == null)
                continue;
            m.setKey(Keyboard.getKeyIndex(bind.toUpperCase()));
        }
        List<String> x = FileManager.read("Module/X.txt");
        for (String v : x) {
            String name = v.split(":")[0];
            String dragX = v.split(":")[1];
            Module m = WulneClient.INSTANCE.moduleManager.getModuleByName(name);
            if (m == null)
                continue;
            m.setX(Integer.parseInt(dragX));
        }
        List<String> y = FileManager.read("Module/Y.txt");
        for (String v : y) {
            String name = v.split(":")[0];
            String dragY = v.split(":")[1];
            Module m = WulneClient.INSTANCE.moduleManager.getModuleByName(name);
            if (m == null)
                continue;
            m.setY(Integer.parseInt(dragY));
        }
        List<String> vals = FileManager.read("Module/Values.txt");
        for (String v : vals) {
            String name = v.split(":")[0];
            String values = v.split(":")[1];
            Module m = WulneClient.INSTANCE.moduleManager.getModuleByName(name);
            if (m == null)
                continue;
            for (Value value : m.getValues()) {
                if (!value.getName().equalsIgnoreCase(values))
                    continue;
                if (value instanceof Option) {
                    value.setValue(Boolean.parseBoolean(v.split(":")[2]));
                    continue;
                }
                if (value instanceof Numbers) {
                    value.setValue(Double.parseDouble(v.split(":")[2]));
                    continue;
                }
                ((Mode) value).setMode(v.split(":")[2]);
            }
        }
    }

    public void saveSettings() {
        String enable = "";
        Iterator var7 = WulneClient.INSTANCE.moduleManager.modules.iterator();

        while (var7.hasNext()) {
            Module m = (Module) var7.next();
            if (m.isEnabled()) {
                enable = enable + String.format("%s%s", m.getName(), System.lineSeparator());
            }
        }

        FileManager.save("Module/Enabled.txt", enable, false);
        String x = "";
        StringBuilder content = new StringBuilder();

        for (Module m : modules) {
            content.append(
                    String.format("%s:%s%s", m.getName(), Keyboard.getKeyName(m.getKey()), System.lineSeparator()));
        }
        FileManager.save("Module/Binds.txt", content.toString(), false);
        String values = "";
        for (Module m : WulneClient.INSTANCE.moduleManager.getModules()) {
            for (Value v : m.getValues()) {
                values = String.valueOf(values)
                        + String.format("%s:%s:%s%s", m.getName(), v.getName(), v.getValue(), System.lineSeparator());
            }
        }
        FileManager.save("Module/Values.txt", values, false);
        String init = "";
        for (Module m : WulneClient.INSTANCE.moduleManager.modules) {
            init = String.valueOf(init)
                    + String.format("%s:%s%s", m.getName(), m.getX(), System.lineSeparator());
        }
        FileManager.save("Module/X.txt", init, false);
        String inits = "";
        for (Module m : WulneClient.INSTANCE.moduleManager.modules) {
            inits = String.valueOf(inits)
                    + String.format("%s:%s%s", m.getName(), m.getY(), System.lineSeparator());
        }
        FileManager.save("Module/Y.txt", inits, false);
    }
}
