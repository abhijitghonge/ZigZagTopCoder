package com.ab.myfb.search;

import com.ab.myfb.data.Person;

public class PathNode {
	
	private Person person;
	
	PathNode previous; 
	
	public PathNode(Person person,PathNode previous ) {
	
		this.person = person;
		this.previous = previous;
	}

	
	public Person getPerson() {
		return person;
	}
	
	public boolean hasPrevious() {
		return previous != null;
	}


	@Override
	public String toString() {
		return "PathNode [person=" + person +  "previous:["+((previous ==null)? null:previous.person)+"]";
	}

}
