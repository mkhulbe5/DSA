package com.dsa.dp;

public class CoinChangePermutation {

	public int coinChangePermutation(int[]coins,int tar) {
		int[] dp = new int[tar + 1];
		
		dp[0] = 1;
		
		for(int amt = 1; amt <= tar; amt++) {
			for(int coin : coins) {
				if(coin <= amt) {
					int ramt = amt - coin;
					dp[amt] += dp[ramt];
				}
			}
		}
		return dp[tar];
	}
}
