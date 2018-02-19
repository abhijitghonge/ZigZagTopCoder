package com.ab.makechange.algo;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Groups {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
	
		int numOfTestCases = s.nextInt();
		int M = 1000000007;
		int[] personsInGroup = new int[numOfTestCases];
		
		for (int i = 0; i < numOfTestCases ; i++) {
			personsInGroup[i] = s.nextInt() %M;
		}


		for (int inputCount = 0; inputCount < personsInGroup.length; inputCount++) {
			int combinations = computeGroupWays(personsInGroup[inputCount]);
			System.out.println(combinations);
		}
	}

	public static int computeGroupWays(int numberOfPersons) {
		if (numberOfPersons == 1) {
			return 1;
		}
		
		if (numberOfPersons == 2) {
			return 2;
		}

		/**
		 * Find combinations for each combination of number of persons in the group
		 */

		int combinations = 0;
		int maxInGroup = numberOfPersons / 2;
		for (int i = 1; i <= maxInGroup; i++) {
			int numerator = 1;
			for (int count = numberOfPersons - i + 1; count <= numberOfPersons; count++)
				numerator = numerator * count;

			// Factorial for denominator
			int denominator = 1;
			for (int j = 1; j <= i; j++) {
				denominator = denominator * j;
			}
			combinations = combinations+ numerator/denominator;
		}
		
		
		
		return combinations *2;//multiplying by 2 consider switch between group A and group B
	}
}
