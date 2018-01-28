package com.ab.makechange.algo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MakeChangeTest {
	
	private MakeChangeAlgorithm algo= new MakeChangeAlgorithm();

	@Test
	void makeChangeTestOne() {
		int actual = algo.computeChange(1);
		System.out.println("Combinations:["+actual+"]");
		assertTrue(actual==1);
	}

	@Test
	void makeChangeTestTwo() {
		int actual = algo.computeChange(2);
		System.out.println(" Combinations:["+actual+"], expected;["+2+"]");
		assertTrue(actual==2);
	}
	
	@Test
	void makeChangeTestThree() {
		int actual = algo.computeChange(3);
		System.out.println("Combinations:["+actual+"], expected;["+2+"]");
		assertTrue(actual==2);
	}
	
	@Test
	void makeChangeTestFour() {
		int actual = algo.computeChange(4);
		System.out.println("Combinations:["+actual+"], expected;["+3+"]");
		assertTrue(actual==3);
	}
	
	@Test
	void makeChangeTestFive() {
		int actual = algo.computeChange(5);
		System.out.println("Combinations:["+actual+"], expected;["+4+"]");
		assertTrue(actual==4);
	}
	
	@Test
	void makeChangeTestSix() {
		int actual = algo.computeChange(6);
		System.out.println("Combinations:["+actual+"], expected;["+5+"]");
		assertTrue(actual==5);
	}
	
	
	@Test
	void makeChangeTestSeven() {
		int actual = algo.computeChange(7);
		System.out.println("Combinations:["+actual+"], expected;["+6+"]");
		assertTrue(actual==6);
	}
	
	@Test
	void makeChangeTestEight() {
		int actual = algo.computeChange(8);
		System.out.println("Combinations:["+actual+"], expected;["+7+"]");
		assertTrue(actual==7);
	}
	
	
}
