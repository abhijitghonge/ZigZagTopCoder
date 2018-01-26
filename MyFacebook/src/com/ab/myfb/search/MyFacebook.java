package com.ab.myfb.search;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.ab.myfb.data.Person;

public class MyFacebook {
	private Map<Integer, Person> personCache= new HashMap<Integer, Person>();
	
	/**
	 * TODO: Abstract into a Junit later
	 */
	public void addToCache(Person person) {
		personCache.put(person.getId(), person);
		
	}
	
	public Person get(int id) {
		return personCache.get(id);
		
	}
	
	/**
	 * This is like a basket to hold visited nodes and work Queue
	 * @author abhij
	 *
	 */
	private class SearchData {
		
		Map<Integer, PathNode> visited = new HashMap<Integer, PathNode>();
		
		Queue<PathNode> workQueue = new LinkedList<PathNode>();
		
		public SearchData(Person root) {
			
			PathNode  rootNode= new PathNode(root, null); 
			
			workQueue.offer(rootNode);
			visited.put(root.getId(), rootNode);
		}
		
		@Override
		public String toString() {
			return "SearchData [visited=" + visited + ", workQueue=" + workQueue + "]";
		}

	}
	
	/**
	 * Collapse the 2 paths and merge it into one
	 * @param sourcePath
	 * @param destinationPath
	 * @return SearchPath that is nothing but a linkedlist of merged paths
	 */
	public List<Person> collapse(PathNode primaryPath, PathNode secondaryPath) {
		LinkedList<Person> linkedPath = new LinkedList<Person>();
		
		linkedPath.add(primaryPath.getPerson());
		
		while(primaryPath.hasPrevious()) {
			linkedPath.addFirst(primaryPath.previous.getPerson());
			primaryPath = primaryPath.previous;
		}
		
		while(secondaryPath.hasPrevious()) {
			linkedPath.addLast(secondaryPath.previous.getPerson());
			secondaryPath =secondaryPath.previous;
		}
		
		System.out.println("Linked Path:["+linkedPath+"]");
		return linkedPath;
		
	}
	
	
	/**
	 * Should give back the SearchPath/List of minimum distance between friends
	 * @param id1
	 * @param id2
	 * @return
	 */
	public List<Person> findPath(int id1, int id2) {
		
		//Get the person and first visit it by converting into a path node
		SearchData source = new SearchData(personCache.get(id1));
		SearchData destination = new SearchData(personCache.get(id2));
		
		System.out.println("Source: ["+source+"]");
		System.out.println("Destination: ["+destination+"]");
		
		while(!source.workQueue.isEmpty() && !destination.workQueue.isEmpty()) {
			
			//Find collision between source and destination
			Person found = findCollision(source, destination);
			
			//If destination visited map has it then collapse the paths
			if(found != null) {
				PathNode sourcePath =  source.visited.get(found.getId());
				PathNode destinationPath =  destination.visited.get(found.getId());
				return collapse(sourcePath, destinationPath);
			}
			
		
			//Find collision between source and destination
			found = findCollision(destination,  source);
			
			//If destination visited map has it then collapse the paths
			if(found != null) {
				PathNode sourcePath =  source.visited.get(found.getId());
				PathNode destinationPath =  destination.visited.get(found.getId());
				return collapse(sourcePath, destinationPath);
			}
		}
		
		return new LinkedList<Person>();
		
	}
	
	/**
	 * find the collision between source and destination by looking up source person in destination
	 * @param primary
	 * @param secondary
	 * @return
	 */
	private Person findCollision(SearchData primary, SearchData secondary) {
		// take a person from queue and visit his friends
		PathNode primaryNode =  primary.workQueue.poll();
		Person person= primaryNode.getPerson();
		
		System.out.println("Primary Person:["+person+"]");
		
		System.out.println("SEcondary.visited:["+secondary.visited+"]");
		//If destination visited map has it then collapse the paths
		if(secondary.visited.containsKey(person.getId())) {
			return person;
		}
		
		//Add friends of Source to work Queue
		for(Person friend: person.getFriends()) {
			if(primary.visited.containsKey(friend.getId())) {
				//if already visited, then don't add to work queue
				continue;
			}
			//Create a linkage with previous node
			PathNode parked = new PathNode(friend, primaryNode);
			primary.workQueue.offer(parked);
			primary.visited.put(friend.getId(), parked);
			System.out.println("Parked["+ parked+"]");
		}
		

		return null;
	}

	@Override
	public String toString() {
		return "MyFacebook [personCache=" + personCache + "]";
	}
	
	
}
