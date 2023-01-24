package net.wulnemc.core.events;

import net.minecraft.client.gui.ScaledResolution;
import net.wulnemc.wulne.Event.events.Event;

public class EventRender2D implements Event {
    public ScaledResolution scaledResolution;
    public float pt;

    public EventRender2D(ScaledResolution scaledResolution,float pt) {
        this.scaledResolution = scaledResolution;
        this.pt = pt;
    }

    public float getPt() {
        return pt;
    }

    public ScaledResolution getSR() {
        return scaledResolution;
    }

    public void setPt(float pt) {
        this.pt = pt;
    }

    public void setScaledResolution(ScaledResolution scaledResolution) {
        this.scaledResolution = scaledResolution;
    }
}
