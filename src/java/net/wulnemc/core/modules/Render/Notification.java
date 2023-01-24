package net.wulnemc.core.modules.Render;

import net.wulnemc.core.events.EventRender2D;
import net.wulnemc.wulne.Event.EventTarget;
import net.wulnemc.wulne.Module.Module;
import net.wulnemc.wulne.Module.ModuleType;
import net.wulnemc.wulne.UI.Notification.NotificationManager;

public class Notification extends Module {
    public Notification() {
        super("Notification","模块启用提示",0,0, ModuleType.Render,false);
    }

    @EventTarget
    public void onRender(EventRender2D e) {
        NotificationManager.INSTANCE.drawNotifications();
    }
}
