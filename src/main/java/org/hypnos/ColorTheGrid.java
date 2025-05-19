package org.hypnos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1931. 用三种不同颜色为网格涂色
 */
public class ColorTheGrid {

	private static final int MOD = 1_000_000_007;

	public int colorTheGrid(int m, int n) {
		int[] pow3 = new int[m];
		pow3[0] = 1;
		for (int i = 1; i < m; i++) {
			pow3[i] = pow3[i - 1] * 3;
		}

		List<Integer> valid = new ArrayList<>();
		next:
		for (int color = 0; color < pow3[m - 1] * 3; color++) {
			for (int i = 1; i < m; i++) {
				if (color / pow3[i] % 3 == color / pow3[i - 1] % 3) { // 相邻颜色相同
					continue next;
				}
			}
			valid.add(color);
		}

		int nv = valid.size();
		List<Integer>[] nxt = new ArrayList[nv];
		Arrays.setAll(nxt, i -> new ArrayList<>());
		for (int i = 0; i < nv; i++) {
			next2:
			for (int j = 0; j < nv; j++) {
				for (int p3 : pow3)
					if (valid.get(i) / p3 % 3 == valid.get(j) / p3 % 3) { // 相邻颜色相同
						continue next2;
					}
				nxt[i].add(j);
			}
		}

		int[][] memo = new int[n][nv];
		for (int[] row : memo) {
			Arrays.fill(row, -1);
		}

		long ans = 0;
		for (int j = 0; j < nv; j++) {
			ans += dfs(n - 1, j, nxt, memo);
		}
		return (int) (ans % MOD);
	}

	private int dfs(int i, int j, List<Integer>[] nxt, int[][] memo) {
		if (i == 0) {
			return 1; // 找到了一个合法涂色方案
		}
		if (memo[i][j] != -1) { // 之前计算过
			return memo[i][j];
		}
		long res = 0;
		for (int k : nxt[j]) {
			res += dfs(i - 1, k, nxt, memo);
		}
		return memo[i][j] = (int) (res % MOD); // 记忆化
	}
}
