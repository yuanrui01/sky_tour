package org.contest;

import java.util.Arrays;

/**
 * 100333. 统计逆序对的数目
 */
public class Case2024062204 {

	private static final int MOD = 1_000_000_007;

	public int numberOfPermutations(int n, int[][] requirements) {
		int mx = 0;
		int[] ec = new int[n];
		Arrays.fill(ec, -1);
		for (int[] requirement : requirements) {
			mx = Math.max(mx, requirement[1]);
			ec[requirement[0]] = requirement[1];
		}
		if (ec[0] > 0)
			return 0;
		int[][] dp = new int[n][mx + 1];
		dp[0][0] = 1;
		for (int i = 1; i < n; ++i) {
			int l = 0;
			int r = mx;
			if (ec[i] >= 0)
				l = r = ec[i];
			for (int j = l; j <= r; ++j) {
				for (int det = 0; det <= i && det <=j; det++) {
					dp[i][j] = (dp[i][j] + dp[i - 1][j - det]) % MOD;
				}
			}
		}

		return dp[n - 1][ec[n - 1]];
	}

	public static void main(String[] args) {
		int n = 3;
		int[][] req = {{1,1},{0,0},{2,2}};
		Case2024062204 case2024062204 = new Case2024062204();
		System.out.println(case2024062204.numberOfPermutations(n, req));
	}
}
