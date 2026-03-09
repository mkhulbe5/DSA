package com.dsa.stacks;

import java.util.Stack;

public class NextGreaterElementOnRight {

	
	public int[] solve(int[]arr) {
		Stack<Integer> st = new Stack<>();
		int[] nge = new int[arr.length];
		st.push(arr.length - 1);
		nge[arr.length - 1] = -1;
		for(int i = arr.length - 2; i >=0; i--) {
			while(st.size() > 0 && arr[i] > st.peek()) {
				st.pop();
			}
			
			if(st.size() == 0) {
				nge[i] = -1;
			}
			else {
				nge[i] = st.peek();
			}
			st.push(arr[i]);
			
		}
		return nge;
	}
}
