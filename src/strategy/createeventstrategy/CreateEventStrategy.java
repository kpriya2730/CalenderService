package strategy.createeventstrategy;

import model.Event;
import model.Slot;
import model.User;

import java.util.List;

public interface CreateEventStrategy {
    Event createEvent(String name, String description, User organizer, List<User> attendees, Slot slot);
}
