package com.bruno.recommender;

import java.util.HashMap;

public class Event {

	private int id;
	private String name;
	private HashMap<String, Tag> tags;

	public Event(String name, int id) {
		this.name = name;
		this.id = id;
		this.tags = new HashMap<String, Tag>();
	}
	
	public Event(){
		this.tags = new HashMap<String, Tag>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void addTagToEvent(Tag tag){
		this.tags.put(tag.getName(), tag);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public HashMap<String, Tag> getTags() {
		return tags;
	}

	public void setTags(HashMap<String, Tag> tags) {
		this.tags = tags;
	}
	
}
