package com.anukriti.event.domain;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class Event {
    private final String eventId;
    private final String title;
    private final int capacity;
    private final Set<String> registeredUsers;
    public Event(String eventId, String title, int capacity){
        this.eventId = eventId;
        this.title = title;
        this.capacity = capacity;
        this.registeredUsers = new HashSet<>();
    }

    public synchronized boolean registerUser(String userId){
        if(registeredUsers.size() >= capacity){
            return false;
        }
        return registeredUsers.add(userId);
    }

    public synchronized boolean cancelRegistration(String userId){
        return registeredUsers.remove(userId);
    }

    public int getAvailableSeats(){
        return capacity - registeredUsers.size();
    }

    public String getEventId() {
        return eventId;
    }

}
