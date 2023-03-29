import controller.CalenderController;
import model.CreateEventStrategyType;
import model.Event;
import model.SlotType;
import model.User;
import service.UserService;

import java.text.ParseException;
import java.util.List;

public class CalenderServiceDriver {
    public static void main(String[] args) throws ParseException {
        System.out.println("Hello world!");

        UserService userService = new UserService();

        User user1 = userService.createUser("Krishna", "krishna1@gmail.com");
        User user2 = userService.createUser("Aman", "aman@gmail.com");
        User user3 = userService.createUser("Jayanth", "jayanth@gmail.com");

        CalenderController calenderController = new CalenderController();

        // Create event of type working hours for one user (self)
        Event event1 = calenderController.createEvent("My working hours", "working hours", user1, List.of(user1), "2018-07-14T14:30:00+0530", "2018-07-14T15:30:00+0530", SlotType.WORKING_HOURS, CreateEventStrategyType.CONFLICTS_UNCHECKED);

        // Create event of type working hours for one user (self)
        calenderController.createEvent("My working hours", "working hours", user1, List.of(user1), "2018-07-14T14:30:00+0530", "2018-07-14T15:30:00+0530", SlotType.BUSY, CreateEventStrategyType.CONFLICTS_UNCHECKED);

        // Create event of type working hours for multiple users
        calenderController.createEvent("My working hours", "working hours", user1, List.of(user1, user2, user3), "2018-07-14T14:30:00+0530", "2018-07-14T15:30:00+0530", SlotType.BUSY, CreateEventStrategyType.CONFLICTS_UNCHECKED);

        // Delete event for user
        calenderController.deleteEventForUser(user1.getId(), event1.getId());

    }
}