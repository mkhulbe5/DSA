package com.dsa.dp;

public class ClimbingStairsWithVariableJumps {

	public int climbWithVarJumps(int n,int[]arr) {
		int[] dp = new int[n + 1];
		dp[n] = 1;
		
		for(int i = n-1; i >=0; i--) {
			for(int j = 1; j < arr[i] && i + j < dp.length; j++) {
				dp[i] += dp[i+j];
			}
		}
		return dp[0];
	}
}
