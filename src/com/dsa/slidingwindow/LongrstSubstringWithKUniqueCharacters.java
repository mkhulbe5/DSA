package com.dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongrstSubstringWithKUniqueCharacters {

	public int longestSubstringWithKUnique(int[] arr, int k) {
		int i = 0, j = 0;
		int maxLen = 0;
		Map<Integer, Integer> map = new HashMap<>();

		while (j < arr.length) {
			map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);

			while (map.size() > k) {
				map.put(arr[i], map.get(arr[i]) - 1);
				if (map.get(arr[i]) == 0) {
					map.remove(arr[i]);
				}
				i++;
			}

			if (map.size() == k) {
				maxLen = Math.max(maxLen, j - i + 1);
			}

			j++;
		}

		return maxLen;
	}
}
