package com.ab.myfb.data;

import java.util.ArrayList;
import java.util.List;

public class Person {
	
	private int id;

	private String name;
	
	private List<Person> friends = new ArrayList<Person>(); 
	
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Person> getFriends() {
		return friends;
	}

	public void addFriend(Person friend) {
		this.friends.add(friend);
	}

}
