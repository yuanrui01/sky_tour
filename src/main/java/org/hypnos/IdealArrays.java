package org.hypnos;

import java.util.ArrayList;
import java.util.List;

/**
 * 2338. 统计理想数组的数目
 */
public class IdealArrays {

	private static final int MOD = 1_000_000_007;
	private static final int MAX_N = 10_000;
	private static final int MAX_E = 13;

	private static final List<Integer>[] EXP = new ArrayList[MAX_N + 1];
	private static final int[][] C = new int[MAX_N + MAX_E][MAX_E + 1];

	private static boolean done = false;

	private void init() {
		// 这样写比 static block 更快
		if (done) {
			return;
		}
		done = true;

		// EXP[x] 为 x 分解质因数后，每个质因数的指数
		for (int x = 1; x < EXP.length; x++) {
			EXP[x] = new ArrayList<>();
			int t = x;
			for (int i = 2; i * i <= t; i++) {
				int e = 0;
				for (; t % i == 0; t /= i) {
					e++;
				}
				if (e > 0) {
					EXP[x].add(e);
				}
			}
			if (t > 1) {
				EXP[x].add(1);
			}
		}

		// 预处理组合数
		for (int i = 0; i < MAX_N + MAX_E; i++) {
			C[i][0] = 1;
			for (int j = 1; j <= Math.min(i, MAX_E); j++) {
				C[i][j] = (C[i - 1][j] + C[i - 1][j - 1]) % MOD;
			}
		}
	}

	public int idealArrays(int n, int maxValue) {
		init();
		long ans = 0;
		for (int x = 1; x <= maxValue; x++) {
			long mul = 1;
			for (int e : EXP[x]) {
				mul = mul * C[n + e - 1][e] % MOD;
			}
			ans += mul;
		}
		return (int) (ans % MOD);
	}
}
