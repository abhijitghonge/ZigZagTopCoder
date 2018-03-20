package com.ag.zigzag.tests;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ag.zigzag.Tuple;
import com.ag.zigzag.algo.ZigZagAlgorithm;

public class ZigZagTestRunner {
	private ZigZagAlgorithm algo = new ZigZagAlgorithm();

	private Tuple<int[], Integer>[] testScenarios ;
	private int testCases = 6;

	@SuppressWarnings("unchecked")
	@BeforeEach
	public void setup() {
		testScenarios = new Tuple[testCases];
		int index = 0;
		testScenarios[index++] = new Tuple<int[], Integer>(new int[]{ 374, 40, 854, 203, 203, 156, 362, 279, 812, 955, 
				600, 947, 978, 46, 100, 953, 670, 862, 568, 188, 
				67, 669, 810, 704, 52, 861, 49, 640, 370, 908, 
				477, 245, 413, 109, 659, 401, 483, 308, 609, 120, 
				249, 22, 176, 279, 23, 22, 617, 462, 459, 244 }, 36);
		
		testScenarios[index++] = new Tuple<int[], Integer>(new int[]{ 1, 7, 4, 9, 2, 5 }, 6);
		testScenarios[index++] = new Tuple<int[], Integer>(new int[]{ 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 }, 7);
		testScenarios[index++] = new Tuple<int[], Integer>(new int[]{ 44 }, 1);
		testScenarios[index++] = new Tuple<int[], Integer>(new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 2);
		testScenarios[index++] = new Tuple<int[], Integer>(new int[]{ 70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32 }, 8);
		
	}

	@Test
	public void runTests() {
		for (int index = 0; index < testScenarios.length; index++) {
			Tuple<int[], Integer> scenario= testScenarios[index];
			int[] testSequence =  scenario.key;
			Integer actual= algo.longestZigZag(testSequence);
			System.out.println("Actual["+actual+"], Expected["+scenario.value+"]");
			assertThat(actual, is(scenario.value));
		}
	}

}
