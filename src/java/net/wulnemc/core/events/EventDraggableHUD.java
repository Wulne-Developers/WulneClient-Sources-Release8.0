package net.wulnemc.core.events;

import net.wulnemc.wulne.Event.events.Event;

public class EventDraggableHUD implements Event {
    private int mouseX;
    private int mouseY;

    public EventDraggableHUD(int mouseX,int mouseY) {
        this.mouseX = mouseX;
        this.mouseY = mouseY;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    public void setMouseX(int mouseX) {
        this.mouseX = mouseX;
    }

    public void setMouseY(int mouseY) {
        this.mouseY = mouseY;
    }
}
