package net.wulnemc.core.events;

import net.wulnemc.wulne.Event.events.Event;
import net.wulnemc.wulne.Event.types.EventTypeCategory;

public class EventTick implements Event {
    public EventTypeCategory eventTypeCategory;
    public EventTick(EventTypeCategory eventTypeCategory) {
        this.eventTypeCategory = eventTypeCategory;
    }

    public EventTypeCategory getEventTypeCategory() {
        return eventTypeCategory;
    }

    public void setEventTypeCategory(EventTypeCategory eventTypeCategory) {
        this.eventTypeCategory = eventTypeCategory;
    }
}
