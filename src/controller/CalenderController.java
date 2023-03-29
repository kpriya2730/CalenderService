package controller;

import model.CreateEventStrategyType;
import model.Event;
import model.SlotType;
import model.User;
import service.EventService;
import service.UserService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CalenderController {

    EventService eventService;
    SimpleDateFormat sdf;

    public CalenderController() {
        this.eventService = new EventService();
        this.sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
    }

    public Event createEvent(String name, String description, User organizer, List<User> attendees, String startTime, String endTime, SlotType slotType, CreateEventStrategyType createEventStrategyType) throws ParseException {
        Date startDate = sdf.parse(startTime);
        Date endDate = sdf.parse(endTime);
        Event event = eventService.createEvent(name, description, organizer, attendees, startDate, endDate, slotType, createEventStrategyType);
        return event;
    }

    public List<Event> printEventsForUser(User user){
        System.out.println("User "+user.getName()+" events:");
        List<Event> events = eventService.getEventsForUser(user);
        for (Event event : events){
            event.printEvent();
        }

        return events;
    }

    public boolean deleteEventForUser(int userId, int eventId){
        return eventService.deleteEventForUser(userId, eventId);
    }
}
