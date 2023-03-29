package strategy.createeventstrategy;

import model.CreateEventStrategyType;
import model.Event;
import model.Slot;
import model.User;

import java.util.List;

public class CreateEventConflictsUncheckedStrategy implements CreateEventStrategy{
    private CreateEventStrategyType type = CreateEventStrategyType.CONFLICTS_UNCHECKED;
    @Override
    public Event createEvent(String name, String description, User organizer, List<User> attendees, Slot slot) {
        Event event = Event.builder().setName(name).setDescription(description).setOrganizer(organizer).setAttendees(attendees).setSlot(slot).build();
        return event;
    }
}
