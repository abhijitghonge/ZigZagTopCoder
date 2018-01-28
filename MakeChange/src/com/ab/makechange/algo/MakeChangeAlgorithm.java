package com.ab.makechange.algo;

public class MakeChangeAlgorithm {

	private int[] denoms = new int[] { 100, 50, 20, 10, 5, 2, 1 };

	public int findMinIndex(int value) {
		for (int j = 0; j < denoms.length; j++) {
			if (denoms[j] <= value) {
				return j;
			}
		}

		return -1;
	}

	public int computeChange(int value) {
		
		int minIndex = findMinIndex(value);
		return computeChange(minIndex, value);
	}

	/**
	 * Case of 8
	 * Combinations:
	 * 5@0,2@0 - 1,1,1,1,1,1,1,1
	 * 5@0,2@1 = 2,1,1,1,1,1,1
	 * 5@0,2@2 = 2,2,1,1,1,1
	 * 5@0,2@3 = 2,2,2,1,1
	 * 5@0,2@4= 2,2,2,2
	 * 5@1,2@0 = 5,1,1,1
	 * 5@1,2@2 = 5,2,1
	 * 
	 * @param index
	 * @param value
	 * @return
	 */
	private int computeChange(int index, int value) {
		//only one combination of all ones. hence return 1
		if(index >=denoms.length -1 ) return 1;
		
		int combinations = 0;
		int denomValue = denoms[index];
		
		for(int i=0; i*denomValue <= value ; i++) {
			int remainingValue = value - i*denomValue;
			combinations = combinations + computeChange(index+1, remainingValue );
		}
		return combinations;
	}

}
