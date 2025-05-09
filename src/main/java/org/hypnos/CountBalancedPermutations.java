package org.hypnos;

import java.util.Arrays;

/**
 * 3343. 统计平衡排列的数目
 */
public class CountBalancedPermutations {

	private static final int MOD = 1_000_000_007;
	private static final int MX = 41;

	private static final long[] F = new long[MX]; // f[i] = i!
	private static final long[] INV_F = new long[MX]; // inv_f[i] = i!^-1

	static {
		F[0] = 1;
		for (int i = 1; i < MX; i++) {
			F[i] = F[i - 1] * i % MOD;
		}
		INV_F[MX - 1] = pow(F[MX - 1], MOD - 2);
		for (int i = MX - 1; i > 0; i--) {
			INV_F[i - 1] = INV_F[i] * i % MOD;
		}
	}

	public int countBalancedPermutations(String num) {
		int[] cnt = new int[10];
		int total = 0;
		for (char c : num.toCharArray()) {
			cnt[c - '0']++;
			total += c - '0';
		}

		if (total % 2 > 0) {
			return 0;
		}

		for (int i = 1; i < 10; i++) {
			cnt[i] += cnt[i - 1];
		}

		int n = num.length();
		int n1 = n / 2;
		int[][][] memo = new int[10][n1 + 1][total / 2 + 1];
		for (int[][] mat : memo) {
			for (int[] row : mat) {
				Arrays.fill(row, -1);
			}
		}
		return (int) (F[n1] * F[n - n1] % MOD * dfs(9, n1, total / 2, cnt, memo) % MOD);
	}

	private int dfs(int i, int left1, int leftS, int[] cnt, int[][][] memo) {
		if (i < 0) {
			return leftS == 0 ? 1 : 0;
		}
		if (memo[i][left1][leftS] != -1) {
			return memo[i][left1][leftS];
		}
		long res = 0;
		int c = cnt[i] - (i > 0 ? cnt[i - 1] : 0);
		int left2 = cnt[i] - left1;
		for (int k = Math.max(c - left2, 0); k <= Math.min(c, left1) && k * i <= leftS; k++) {
			long r = dfs(i - 1, left1 - k, leftS - k * i, cnt, memo);
			res = (res + r * INV_F[k] % MOD * INV_F[c - k]) % MOD;
		}
		return memo[i][left1][leftS] = (int) res;
	}

	private static long pow(long x, int n) {
		long res = 1;
		for (; n > 0; n /= 2) {
			if (n % 2 > 0) {
				res = res * x % MOD;
			}
			x = x * x % MOD;
		}
		return res;
	}
}
