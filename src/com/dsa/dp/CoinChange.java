package com.dsa.dp;

public class CoinChange {

	public int cointChange(int[]arr,int amt) {
		int[] dp = new int[amt + 1];
		dp[0] = 1;
		for(int i = 0; i < arr.length; i++) {
			for(int  j = arr[i]; j < dp.length; j++) {
				dp[j] += dp[j - arr[i]];
			}
		}
		return dp[amt];
	}
}
