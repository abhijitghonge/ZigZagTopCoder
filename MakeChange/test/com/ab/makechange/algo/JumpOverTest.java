package com.ab.makechange.algo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class JumpOverTest {

	@Test
	void jump_over_numbersTest() {
		
		List<Integer> list = Arrays.asList( 3,4,1,2,5,6,9,0,1,2,3,1);
		
		int count =  JumpOverNumbers.jump_over_numbers(list);
		
		assertTrue(count == 4);
	}
	

	@Test
	void jump_over_numbersTest2() {
		
		List<Integer> list = Arrays.asList( 3,4,1,2,5,6,9,0,1,2,3,0);
		
		int count =  JumpOverNumbers.jump_over_numbers(list);
		
		assertTrue(count == -1);
	}

	
	
}
