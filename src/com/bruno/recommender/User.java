package com.bruno.recommender;

import java.util.HashMap;
import java.util.List;

public class User {

	private int id;
	private String name;
	private HashMap<String, Event> events;

	public User(int id, String name) {
		this.id = id;
		this.name = name;
		this.events = new HashMap<String, Event>();
	}
	
	public User(){
		this.events = new HashMap<String, Event>();
	}

	public HashMap<String,Tag> getTagsFromUser(){
		HashMap<String, Tag> tags = new HashMap<String, Tag>();
		
		for(Event e : events.values()){
			for(Tag t: e.getTags().values()){
				
				if(tags.containsKey(t.getName())){
					Tag newTag = tags.get(t.getName());
					newTag.setValue(newTag.getValue()+1);
					tags.put(newTag.getName(), newTag);
				}
				else
					tags.put(t.getName(), t);
				
			}
		}
		return tags;
	}
	
	public void addEventToUser(Event event){
		this.events.put(event.getName(), event);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<String, Event> getEvents() {
		return events;
	}

	public void setEvents(HashMap<String, Event> events) {
		this.events = events;
	}
	
}
