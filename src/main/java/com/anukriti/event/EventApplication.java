package com.anukriti.event;

import com.anukriti.event.domain.Event;
import com.anukriti.event.domain.User;
import com.anukriti.event.service.EventManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventApplication.class, args);

		EventManager eventManager = new EventManager();

		User u1 = new User("U1", "Aby", "aby@gmail.com");
		User u2 = new User("U2", "Usha", "usha@gmail.com");

		eventManager.addUser(u1);
		eventManager.addUser(u2);

		Event event = new Event("E1", "Tech Conference", 1);
		eventManager.createEvent(event);

		System.out.println(eventManager.register("U1", "E1"));
		System.out.println(eventManager.register("U2", "E1"));
		System.out.println(eventManager.cancel("U2", "E1"));
	}
}
