package com.reymer.events.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.reymer.events.models.Event;
import com.reymer.events.models.User;
import com.reymer.events.repositories.EventRepository;

@Service
public class EventService {
	private final EventRepository eventRepo;

	public EventService(EventRepository eventRepo) {
		this.eventRepo = eventRepo;
	}
	
	public List<Event> findAllEventsInState(String state) {
		return this.eventRepo.findByState(state);
	}
	
	public List<Event> findAllEventsNotInState(String state) {
		return this.eventRepo.findByStateIsNot(state);
	}
	
	public Event findEventById(Long id) {
		return this.eventRepo.findById(id).orElse(null);
	}
	
	public Event createEvent(Event event) {
		return this.eventRepo.save(event);
	}
	
	public Event updateEvent(Event event) {
		return this.eventRepo.save(event);
	}
	
	public void deleteEvent(Long id) {
		this.eventRepo.deleteById(id);
	}
	
	public void addUserToEvent(User user, Event event) {
		event.getEventAttendees().add(user);
		this.eventRepo.save(event);
	}
	
	public void removeUserFromEvent(User user, Event event) {
		event.getEventAttendees().remove(user);
		this.eventRepo.save(event);
	}
}
