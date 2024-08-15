package org.hypnos;

import java.util.Arrays;
import java.util.List;

/**
 * 3148. 矩阵中的最大得分
 */
public class MaxScore3 {

    public int maxScore(List<List<Integer>> grid) {
        int ans = Integer.MIN_VALUE;
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] f = new int[m + 1][n + 1];
        Arrays.fill(f[0], Integer.MAX_VALUE);
        for (int i = 0; i < m; ++i) {
            f[i + 1][0] = Integer.MAX_VALUE;
            List<Integer> row = grid.get(i);
            for (int j = 0; j < n; ++j) {
                int mn = Math.min(f[i + 1][j], f[i][j + 1]);
                int x = row.get(j);
                ans = Math.max(ans, x - mn);
                f[i + 1][j + 1] = Math.min(mn, x);
            }
        }
        return ans;
    }
}
