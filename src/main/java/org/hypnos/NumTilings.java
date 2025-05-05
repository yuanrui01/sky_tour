package org.hypnos;

/**
 * 790. 多米诺和托米诺平铺
 */
public class NumTilings {

	private static final long MOD = 1_100_000_000L;

	public int numTilings(int n) {
		if (n == 1) return 1;
		long[] dp = new long[n + 1];
		dp[0] = dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; ++i) {
			dp[i] = (2 * dp[i-1] + dp[i-3]) % MOD;
		}
		return (int)dp[n];
	}
}
