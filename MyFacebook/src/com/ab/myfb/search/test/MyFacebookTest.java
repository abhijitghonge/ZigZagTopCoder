package com.ab.myfb.search.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ab.myfb.data.Person;
import com.ab.myfb.search.MyFacebook;

class MyFacebookTest {
	MyFacebook facebook = new MyFacebook();
	
	@BeforeEach
	void setUp() throws Exception {
		
		int count = 1;
		Person p1 = new Person(count++, "Abhijit");
		Person p2 = new Person(count++, "Baba");
		Person p3 = new Person(count++, "Aai");
		Person p4 = new Person(count++, "Madhuri");
		Person p5 = new Person(count++, "Ali");
		Person p6 = new Person(count++, "Vijay");
		Person p7 = new Person(count++, "Sonam");
		Person p8 = new Person(count++, "Madhuri");
		Person p9 = new Person(count++, "Harish");
		Person p10 = new Person(count++, "Vinay");
		Person p11 = new Person(count++, "Amrish");
		Person p12 = new Person(count++, "Tejas");
		Person p13 = new Person(count++, "Nishant");
		Person p14 = new Person(count++, "Vivek");
		Person p15 = new Person(count++, "Ashish");
		p1.addFriend(p2);
		
		p1.addFriend(p3);
		
		p2.addFriend(p3);
		
		p1.addFriend(p4);
		
		p1.addFriend(p5);
		
		p5.addFriend(p6);
		
		p15.addFriend(p14);
		p14.addFriend(p13);
		p13.addFriend(p12);
		p12.addFriend(p11);
		p11.addFriend(p10);
		p10.addFriend(p9);
		p9.addFriend(p8);
		p9.addFriend(p6);
		
		
		facebook.addToCache(p1);
		facebook.addToCache( p2);
		facebook.addToCache( p3);
		facebook.addToCache( p4);
		facebook.addToCache( p5);
		facebook.addToCache( p6);
		facebook.addToCache( p7);
		facebook.addToCache( p8);
		facebook.addToCache( p9);
		facebook.addToCache( p10);
		facebook.addToCache( p11);
		facebook.addToCache( p12);
		facebook.addToCache( p13);
		facebook.addToCache( p14);
		facebook.addToCache( p15);
		
		System.out.println("facebook:["+facebook+"]");
		
	}

	/**
	 * 
	 */
	@Test
	void findPathTestDirectRelation() {
		
		List<Person> foundPath =  facebook.findPath(1, 3);
		
		List<Person> expectedPath = new LinkedList<Person>();
		
		expectedPath.add(facebook.get(1));
		expectedPath.add(facebook.get(3));
		
		System.out.println("findPathTestDirectRelation ExpectedPath:["+expectedPath+"]");
		System.out.println("ActualPath:["+foundPath+"]");
		boolean equalLists = foundPath.size() == expectedPath.size() && foundPath.containsAll(expectedPath);		
		assertTrue(equalLists);
	}
	
	@Test
	void findPathTestDepth1Relation() {
		
		List<Person> foundPath =  facebook.findPath(4, 5);
		
		List<Person> expectedPath = new LinkedList<Person>();
		
		expectedPath.add(facebook.get(4));
		expectedPath.add(facebook.get(1));
		expectedPath.add(facebook.get(5));
		
		System.out.println("findPathTestDepth1Relation ExpectedPath:["+expectedPath+"]");
		System.out.println("ActualPath:["+foundPath+"]");
		boolean equalLists = foundPath.size() == expectedPath.size() && foundPath.containsAll(expectedPath);		
		assertTrue(equalLists);
	}

	
	@Test
	void findPathTestShortestPath() {
		
		List<Person> foundPath =  facebook.findPath(4, 6);
		
		List<Person> expectedPath = new LinkedList<Person>();
		
		expectedPath.add(facebook.get(4));
		expectedPath.add(facebook.get(1));
		expectedPath.add(facebook.get(5));
		expectedPath.add(facebook.get(6));
		
		System.out.println("findPathTestShortestPath ExpectedPath:["+expectedPath+"]");
		System.out.println("ActualPath:["+foundPath+"]");
		boolean equalLists = foundPath.size() == expectedPath.size() && foundPath.containsAll(expectedPath);		
		assertTrue(equalLists);
	}
	
	@Test
	void findPathTestNegative() {
		
		List<Person> foundPath =  facebook.findPath(7, 15);
		
		System.out.println("findPathTestNegative");
		System.out.println("ActualPath:["+foundPath+"]");
		assertTrue(foundPath.isEmpty());
	}
	
	@Test
	void findPathTestLongPath() {
		
		List<Person> foundPath =  facebook.findPath(1, 15);
		
		List<Person> expectedPath = new LinkedList<Person>();
		
		expectedPath.add(facebook.get(1));
		expectedPath.add(facebook.get(5));
		expectedPath.add(facebook.get(6));
		expectedPath.add(facebook.get(9));
		expectedPath.add(facebook.get(10));
		expectedPath.add(facebook.get(11));
		expectedPath.add(facebook.get(12));
		expectedPath.add(facebook.get(13));
		expectedPath.add(facebook.get(14));
		expectedPath.add(facebook.get(15));
		
		
		System.out.println("findPathTestLongPath ExpectedPath:["+expectedPath+"]");
		System.out.println("ActualPath:["+foundPath+"]");
		boolean equalLists = foundPath.size() == expectedPath.size() && foundPath.containsAll(expectedPath);		
		assertTrue(equalLists);
	}
}
