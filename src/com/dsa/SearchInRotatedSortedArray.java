package com.dsa;

public class SearchInRotatedSortedArray {

	public int searchInRotatedArray(int[] arr ,int tar) {
		int i = 0; int j = arr.length - 1;
		
		while( i <= j) {
			int mid = (i + j) / 2;
			if(arr[mid] == tar)return mid;
			
			if(arr[i] < arr[mid]) {
				if(arr[i] < tar && tar < arr[mid]) {
					 j = mid - 1;
				}else {
					i = mid + 1;
				}
			}
			else {
				if(arr[i] < tar && tar < arr[mid]) {
					 i = mid - 1;
				}else {
					j= mid + 1;
				}
			}
		}
		return - 1;
	}
}
