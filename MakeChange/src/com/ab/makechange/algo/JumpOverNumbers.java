package com.ab.makechange.algo;

import java.util.List;

public class JumpOverNumbers {
	
	    public static int jump_over_numbers(List<Integer> list) {
	        int position = 0;
	        int nextJump = 0;
	        int count = 0;
	        // Write your code here
	        while (true){
	        	
	            nextJump+=list.get(position);
	            count++;
	            
	            if((nextJump- position) == 0) {
	            	return -1;
	            }
	            if(nextJump >= list.size() ) {
	            	return count;
	            }
	            
	            position = nextJump;
	            
	        }
	    }
	
}
