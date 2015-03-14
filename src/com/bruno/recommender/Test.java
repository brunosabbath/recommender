package com.bruno.recommender;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test {
	
	public static void main(String[] args) {
		
		List<Event> events = build();
		
		User user = new User(1, "Bruno");
		user.addEventToUser(events.get(0));
		user.addEventToUser(events.get(2));
		
		HashMap<String, Tag> tagsFromUser = user.getTagsFromUser();//get tags from user
		
		Engine.removeDuplicatedEvents(events,user.getEvents());
		List<Event> listRecommendedEvents = Engine.listRecommendedEvents(events, tagsFromUser);
		
		listAllEvents(listRecommendedEvents);
		
	}

	private static void listAllEvents(List<Event> events) {
		for(Event e: events){
			System.out.println("Event: " + e.getName());
			for(Tag t: e.getTags().values()){
				System.out.println("\t" + t.getName());
			}
			System.out.println("---------------------\n");
		}
		
	}


	private static List<Event> build() {
		List<Event> events = new ArrayList<Event>();
		
		Tag t1 = new Tag("sport");
		Tag t2 = new Tag("football");
		Tag t3 = new Tag("free food");
		Tag t4 = new Tag("nightlife");
		Tag t5 = new Tag("drink");
		Tag t6 = new Tag("memorial stadium");
		Tag t7 = new Tag("party");
		Tag t8 = new Tag("live music");
		Tag t9 = new Tag("rock");
		Tag t10 = new Tag("country music");
		Tag t11 = new Tag("arts");
		Tag t12 = new Tag("pinnacle arena");
		Tag t13 = new Tag("concert");
		Tag t14 = new Tag("unl");
		Tag t15 = new Tag("religious");
		
		Event e1 = new Event("rush", 1);
		e1.addTagToEvent(t12);
		e1.addTagToEvent(t13);
		e1.addTagToEvent(t9);
		e1.addTagToEvent(t8);
		
		Event e2 = new Event("free food unl", 2);
		e2.addTagToEvent(t3);
		e2.addTagToEvent(t7);
		e2.addTagToEvent(t14);
		
		Event e3 = new Event("roots - blues mesengers", 3);
		e3.addTagToEvent(t9);
		e3.addTagToEvent(t13);
		e3.addTagToEvent(t8);
		
		Event e4 = new Event("thai food FREEEEEE", 4);
		e4.addTagToEvent(t3);
		
		Event e5 = new Event("pray", 5);
		e5.addTagToEvent(t15);
		
		Event e6 = new Event("zztop", 6);
		e6.addTagToEvent(t9);
		e6.addTagToEvent(t13);
		e6.addTagToEvent(t8);
		e6.addTagToEvent(t12);
		
		Event e7 = new Event("the zoo", 7);
		e7.addTagToEvent(t9);
		e7.addTagToEvent(t13);
		e7.addTagToEvent(t8);
		
		events.add(e1);
		events.add(e2);
		events.add(e3);
		events.add(e4);
		events.add(e5);
		events.add(e6);
		events.add(e7);
		
		return events;
	}
	
}
