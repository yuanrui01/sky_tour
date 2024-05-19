package org.hypnos;

import java.util.Arrays;
import java.util.List;


/**
 * 120. 三角形最小路径和
 */
public class MinimumTotal {

    private List<List<Integer>> triangle;
    private int[][] cache;

    public int minimumTotal(List<List<Integer>> triangle) {
        this.triangle = triangle;
        this.cache = new int[201][201];
        for (int[] row : cache) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        return minPathSum(0, 0);
    }

    private int minPathSum(int i, int level) {
        if (level == triangle.size() - 1)
            return triangle.get(level).get(i);
        if (cache[i][level] != Integer.MAX_VALUE)
            return cache[i][level];
        if (i < 0 || i >= triangle.get(i).size())
            return Integer.MAX_VALUE;
        int result = Math.min(minPathSum(i, level + 1), minPathSum(i + 1, level + 1)) + triangle.get(level).get(i);
        cache[i][level] = result;
        return result;
    }
}
