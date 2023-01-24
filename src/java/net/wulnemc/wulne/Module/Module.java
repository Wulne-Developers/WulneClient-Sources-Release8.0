package net.wulnemc.wulne.Module;

import net.minecraft.client.Minecraft;
import net.wulnemc.core.modules.Other.ClickGui;
import net.wulnemc.wulne.Event.EventManager;
import net.wulnemc.wulne.Module.Value.Value;
import net.wulnemc.wulne.UI.Notification.Notification;
import net.wulnemc.wulne.UI.Notification.NotificationManager;
import net.wulnemc.wulne.Util.DraggableComponent;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Module {
    public Minecraft mc = Minecraft.getMinecraft();
    public String name;
    public String Chinesename;
    public boolean enabled;
    public boolean isString;
    public List<Value> values = new ArrayList<>();
    public DraggableComponent drag;
    public ModuleType moduleType;
    public int x;
    public int y;
    public int k;

    public Module(String name,String Chinesename,int x, int y,ModuleType moduleType,boolean isString) {
        this.name = name;
        this.Chinesename = Chinesename;
        this.isString = isString;
        this.x = x;
        this.y = y;
        this.moduleType = moduleType;
        this.enabled = false;

        drag = new DraggableComponent(this.x,this.y, this.getWidth(), this.getHeight(), new Color(0, 0, 0, 0).getRGB());
    }

    public void setY(int y) {
        this.drag.setyPosition(y);
    }

    public void setX(int x) {
        this.drag.setxPosition(x);
    }

    public String getChinesename() {
        return Chinesename;
    }

    public void setChinesename(String chinesename) {
        Chinesename = chinesename;
    }

    public int getWidth() {
        return 50;
    }

    public ModuleType getModuleType() {
        return moduleType;
    }

    public void setModuleType(ModuleType moduleType) {
        this.moduleType = moduleType;
    }

    public void setK(int k) {
        this.k = k;
    }

    public int getHeight() {
        return 50;
    }

    public void setString(boolean string) {
        isString = string;
    }

    public boolean isString() {
        return isString;
    }


    public int getKey() {
        return k;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return drag.getxPosition();
    }

    public int getY() {
        return drag.getyPosition();
    }


    public void setEnabled(boolean enabled) {
        this.enabled = enabled;

        if (enabled) {
            onEnabled();
            if ((boolean) ClickGui.chinese.getValue()) {
                NotificationManager.sendClientMessage(getChinesename() + "已开启", Notification.Type.INFO);
            } else {
                NotificationManager.sendClientMessage(getName() + " Enabled", Notification.Type.INFO);
            }
        } else {
            onDisable();
            if ((boolean) ClickGui.chinese.getValue()) {
                NotificationManager.sendClientMessage(getChinesename() + "已关闭", Notification.Type.INFO);
            } else {
                NotificationManager.sendClientMessage(getName() + "Disable", Notification.Type.INFO);
            }
        }
    }

    public void setKey(int k) {
        this.k = k;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void onEnabled() {
        EventManager.register(this);
    }

    public void onDisable() {
        EventManager.unregister(this);
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void addValues(Value... values) {
        Value[] v1 = values;
        int vl = values.length;

        for (int i = 0; i < vl; ++i) {
            Value value = v1[i];
            this.values.add(value);
        }
    }

    public List<Value> getValues() {
        return values;
    }

    public void draw() {}

    public void renderItem(int mouseX, int mouseY) {
        drag.draw(mouseX, mouseY);
    }
}
