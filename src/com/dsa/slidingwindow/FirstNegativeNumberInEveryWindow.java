package com.dsa.slidingwindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegativeNumberInEveryWindow {

	public List<Integer> firstNegative(int[] arr, int k) {
		List<Integer> ans = new ArrayList<>();
		int i = 0;
		int j = 0;

		while (j < arr.length) {
			Queue<Integer> q = new LinkedList<>();
			if (j - i + 1 < k) {
				while (arr[j] < 0) {
					q.add(arr[i]);
				}
			}
			else if(j - i + 1 == k) {
				ans.add(q.peek());
				if(arr[i] == q.peek()) {
					q.remove();
				}
				i++;j++;
			}
		}
		return ans;

	}
}
