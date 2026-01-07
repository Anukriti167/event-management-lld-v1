package com.anukriti.event.service;

import com.anukriti.event.domain.Event;
import com.anukriti.event.domain.User;

import java.util.HashMap;
import java.util.Map;

public class EventManager {
    private final Map<String, Event> events = new HashMap<>();
    private final Map<String, User> users = new HashMap<>();

    public void addUser(User user){
        users.put(user.getUserId(), user);
    }

    public void createEvent(Event event){
        events.put(event.getEventId(), event);
    }

    public boolean register(String userId, String eventId){
        User user = users.get(userId);
        Event event = events.get(eventId);

        if(user == null || event == null){
            throw new IllegalArgumentException("User or Event not found");
        }
        if(event.getAvailableSeats() <= 0) return false;

        return event.registerUser(userId);
    }

    public boolean cancel(String userId, String eventId){
        Event event = events.get(eventId);

        if(event == null){
            throw new IllegalArgumentException("Event not found");
        }
        return event.cancelRegistration(userId);
    }
}
