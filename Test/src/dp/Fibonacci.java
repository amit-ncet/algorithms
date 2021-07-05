package dp;

import java.util.List;

public class Fibonacci {
	public static void main(String[] args) {
		Fibonacci dp = new Fibonacci();
		int n = 6;
		System.out.println(dp.getFib(n));
		int[] dpa = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			dpa[i] = -1;
		}
		System.out.println(dp.getFibTopDown(n, dpa));
		
		System.out.println(dp.getFibBottomUp(n));
	}

	public int getFib(int n) {
		if (n == 0 || n == 1)
			return n;
		return getFib(n - 1) + getFib(n - 2);
	}

	// DP
	// Top Down : Memoziaztion - recursive
	// Bottom up: Tabulaization - iterative

	//
	public int getFibTopDown(int n, int[] dp) {
		if (n == 0 || n == 1)
			return n;
		if (dp[n] != -1) {
			return dp[n];
		}
		dp[n] = getFibTopDown(n - 1, dp) + getFibTopDown(n - 2, dp);
		return dp[n];
	}

	// Using 1 D array, iterative approach
	public int getFibBottomUp(int n) {
		if (n == 0 || n == 1)
			return 1;
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

}
