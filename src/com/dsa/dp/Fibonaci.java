package com.dsa.dp;

public class Fibonaci {

	public int fib(int n) {
		int fbnm1 = fib(n - 1);
		int fibnm2 = fib(n - 2);
		int[] qb = new int[n];

		if (qb[n] != 0)
			return qb[n];
		int ans = fbnm1 + fibnm2;
		qb[n] = ans;
		return ans;
	}
}
