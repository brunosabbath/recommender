package com.bruno.recommender;

public class Tag {
	
	private String name;
	private int value;

	public Tag(String name) {
		this.name = name;
		this.value = 1;
	}
	
	public Tag(){
		this.value = 1;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
