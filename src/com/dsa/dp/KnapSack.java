package com.dsa.dp;

public class KnapSack {

	public int boundedKnapSack(int[]wts,int[]vals,int cap,int n) {
		int[][] dp = new int[n+ 1][cap+1];
		
		for(int i = 1; i <= dp.length; i++) {
			for(int j = 1; j < dp[0].length; j++) {
				if(j >= wts[i - 1]) {
					/*
					   if 5 balls are there,and player is consuming 2 balls and is scoring more than
					   rest of the team then we include sum of all
					*/
					int rcap = j - wts[i - 1];
					if(dp[i - 1][rcap] + vals[i- 1] > dp[i-1][j]) {
						dp[i][j] = dp[i - 1][rcap] + vals[i- 1];  
					}
					
					//player will not bat,as run scored by rest of the team is sufficient.
					else {
						dp[i][j] = dp[i-1][j];
					}
				}
				else {
					//player will not bat,as run scored by rest of the team is sufficient.
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[n][cap];
	}
}
