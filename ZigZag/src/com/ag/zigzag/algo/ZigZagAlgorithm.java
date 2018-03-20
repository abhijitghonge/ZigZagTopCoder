package com.ag.zigzag.algo;

import com.ag.zigzag.Tuple;

public class ZigZagAlgorithm {

	public enum State {
		START, ZIG, ZAG
	};

	private int[] longestSubSequence;
	private State subsequenceState = State.START;

	public int longestZigZag(int[] sequence) {
		subsequenceState = State.START;
		int longestZigZagLength = -1;
		longestSubSequence = new int[sequence.length];

		// length is 0
		if (sequence.length == 0) {
			return longestZigZagLength;
		}

		int subsquenceIndex = 0;
		longestSubSequence[subsquenceIndex] = sequence[0];

		for (int index = 1; index < sequence.length; index++) {
			// Trend check,
			Tuple<Boolean, State> trend = checkTrend(sequence, longestSubSequence, subsequenceState, index,
					subsquenceIndex);
			
			subsequenceState = trend.value;
			
			if (trend.key == Boolean.FALSE) {
				// if no trend change, then keep replacing the latest subsequence element
				longestSubSequence[subsquenceIndex] = sequence[index];
			} else  {
				// if trend changed, add to the subsequence element
				longestSubSequence[++subsquenceIndex] = sequence[index];

			} 

		}
		longestZigZagLength = subsquenceIndex + 1;

		print(longestSubSequence);

		return longestZigZagLength;

	}

	public void print(int[] sequence) {
		StringBuilder sequenceStr = new StringBuilder();
		for (int i = 0; i < sequence.length; i++) {
			sequenceStr.append(sequence[i] + ",");
		}

		System.out.println(sequenceStr);

	}

	public Tuple<Boolean, State> checkTrend(int[] sequence, int[] subsequence, State subsequenceState,
			int sequenceIndex, int subsequenceIndex) {

		// if current > previous, and trend is changed, return Tuple(changed=true,
		// state=new Trend(zig))
		if (sequence[sequenceIndex] > subsequence[subsequenceIndex] && subsequenceState != State.ZIG) {
			return new Tuple<Boolean, ZigZagAlgorithm.State>(true, State.ZIG);
		} else if (sequence[sequenceIndex] < subsequence[subsequenceIndex] && subsequenceState != State.ZAG) {
			// else if current < previous, and trend is changed, return Tuple(changed=true,
			// state= new Trend(Zag))
			return new Tuple<Boolean, ZigZagAlgorithm.State>(true, State.ZAG);

		} else if (sequence[sequenceIndex] > subsequence[subsequenceIndex] && subsequenceState == State.ZIG) {
			// else if current > previous, and trend is unchanged, return
			// Tuple(changed=false, state=new Trend(zig))
			return new Tuple<Boolean, ZigZagAlgorithm.State>(false, State.ZIG);
		} else if (sequence[sequenceIndex] < subsequence[subsequenceIndex] && subsequenceState == State.ZAG) {
			// else if current < previous, and trend is unchanged, return
			// Tuple(changed=false, state= new Trend(Zag))
			return new Tuple<Boolean, ZigZagAlgorithm.State>(false, State.ZAG);
		} else  {
			// else if current = previous, and trend is changed, return Tuple(changed=true,
			// state=flat)
			return new Tuple<Boolean, ZigZagAlgorithm.State>(false, subsequenceState);
		} 
	}
}
