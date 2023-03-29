package model;

import exception.InvalidEventParametersException;

import java.util.List;

public class Event extends BaseModel{
    private int id;
    private String name;
    private String description;
    private User organizer;
    private List<User> attendees;
    private Slot slot;

    private Event(Builder builder) {
        super();
        this.name = builder.name;
        this.description = builder.description;
        this.organizer = builder.organizer;
        this.attendees = builder.attendees;
        this.slot = builder.slot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOrganizer() {
        return organizer;
    }

    public void setOrganizer(User organizer) {
        this.organizer = organizer;
    }

    public List<User> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<User> attendees) {
        this.attendees = attendees;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public void printEvent(){
        System.out.println(String.format("name: {}, description: {}", this.name, this.description));
    }

    public static Builder builder(){
        Builder b = new Builder();
        return b;
    }

    public static class Builder{
        private String name;
        private String description;
        private User organizer;
        private List<User> attendees;
        private Slot slot;
        private Builder(){}

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setOrganizer(User organizer) {
            this.organizer = organizer;
            return this;
        }

        public Builder setAttendees(List<User> attendees) {
            this.attendees = attendees;
            return this;
        }

        public Builder setSlot(Slot slot) {
            this.slot = slot;
            return this;
        }

        private boolean validateEvent(){
            return false;
        }

        public Event build() {
            try {
                validateEvent();
            } catch (Exception e) {
                throw new InvalidEventParametersException("Could not create event: " + e.getMessage());
            }

            return new Event(this);
        }
    }
}
