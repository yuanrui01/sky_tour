package org.hypnos;

/**
 * 2643. 一最多的行
 */
public class RowAndMaximumOnes {

	public int[] rowAndMaximumOnes(int[][] mat) {
		int[] ans = {0, 0};
		int n = mat.length;
		int m = mat[0].length;
		for (int i = 0; i < n; ++i) {
			int cnt = 0;
			for (int j = 0; j < m; ++j) {
				cnt += mat[i][j];
			}
			if (cnt > ans[1]) {
				ans[0] = i;
				ans[1] = cnt;
			}
		}
		return ans;
	}
}
