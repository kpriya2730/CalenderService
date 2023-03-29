package service;

import factory.CreateEventStrategyFactory;
import model.*;
import strategy.createeventstrategy.CreateEventStrategy;

import java.util.*;

public class EventService {

    Map<Integer, Map<Integer, Event>> userIdEventIdEventMap;

    public EventService() {
        this.userIdEventIdEventMap = new HashMap<>();
    }

    public Event createEvent(String name, String description, User organizer, List<User> attendees, Date startTime, Date endTime, SlotType slotType, CreateEventStrategyType createEventStrategyType){
        CreateEventStrategy createEventStrategy = CreateEventStrategyFactory.getCreateEventStrategy(createEventStrategyType);
        Slot slot = new Slot(startTime, endTime, slotType);
        Event event = createEventStrategy.createEvent(name, description, organizer, attendees, slot);

        for(User attendee : attendees){
            int userId = attendee.getId();
            Map<Integer, Event> eventIdEventMap = userIdEventIdEventMap.getOrDefault(userId, new HashMap<Integer, Event>());
            eventIdEventMap.put(event.getId(), event);
            userIdEventIdEventMap.put(userId, eventIdEventMap);
        }
        return event;
    }

    public List<Event> getEventsForUser(User user){
        List<Event> userEvents = userIdEventIdEventMap.get(user.getId()).values().stream().toList();
        return userEvents;
    }

    public boolean deleteEventForUser(int userId, int eventId){
        Map<Integer, Event> eventIdEventMap = userIdEventIdEventMap.get(userId);
        if(Objects.nonNull(eventIdEventMap) && eventIdEventMap.containsKey(eventId)){
            eventIdEventMap.remove(eventId);
            return true;
        }
        return false;
    }
}
