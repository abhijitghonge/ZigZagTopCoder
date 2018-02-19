package com.ab.makechange.algo;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Test {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numOfInput = Integer.parseInt(s.nextLine());
		int[] numbers = new int[numOfInput];

		StringTokenizer tokenizer = new StringTokenizer(s.nextLine());
		int count = 0;
		while (tokenizer.hasMoreTokens()) {
			numbers[count] = Integer.parseInt(tokenizer.nextToken());
			count++;
		}

		for (int inputCount = 0; inputCount < numbers.length; inputCount++) {
			int number = numbers[inputCount];
			for (count = 1; count <= number; count++) {
				if (count % 3 == 0 && count % 5 == 0) {
					System.out.println("FizzBuzz");
				}else if (count % 3 == 0) {
					System.out.println("Fizz");
				} else if (count % 5 == 0) {
					System.out.println("Buzz");
				} else {
					System.out.println(count);
				}

			}
		}
		
		s.close();

	}

}
