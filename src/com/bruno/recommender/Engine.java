package com.bruno.recommender;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Engine {

	private static final double QUALITY = 0.5; 
	
	public static List<Event> listRecommendedEvents(List<Event> events, HashMap<String, Tag> tagsFromUser) {
		
		List<Event> recommended = new ArrayList<Event>();
		
		for(Event e : events){
			
			int repeatedTags = getRepeatedTags(e,tagsFromUser);
			double equalTags = getEqualTags(e, tagsFromUser);
			double totalTags = e.getTags().size() + tagsFromUser.size();
			double jaccard = equalTags/(totalTags - repeatedTags);
			
			if(jaccard >= QUALITY)
				recommended.add(e);
		}
		
		return recommended;
	}
	
	private static int getEqualTags(Event event, HashMap<String, Tag> tagsFromUser) {
		int equalTag = 0;
		
		for(Tag t : event.getTags().values()){
			if(tagsFromUser.containsKey(t.getName()))
				equalTag++;
		}
		
		return equalTag;
	}

	private static int getRepeatedTags(Event event, HashMap<String, Tag> tagsFromUser) {
		
		int repeatedTags = 0;
		
		for(Tag t : event.getTags().values()){
			if(tagsFromUser.containsKey(t.getName()))
				repeatedTags++;
		}
		
		return repeatedTags;
	}

	public static boolean isSimilar(Event event, HashMap<String, Tag> tags){
		
		return true;
	}

	public static void removeDuplicatedEvents(List<Event> events, HashMap<String, Event> userEvents) {
		for(Event userEvent : userEvents.values()){
			for(Event e : events){
				if(userEvent.getId() == e.getId()){
					events.remove(e);
					break;
				}
					
			}
		}
		
	}
	
	
}
