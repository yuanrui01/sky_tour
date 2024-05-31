package org.hypnos;


/**
 * 2965. 找出缺失和重复的数字
 */
public class FindMissingAndRepeatedValues {

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] count = new int[n * n + 1];
        int[] ans = {0,0};
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                count[grid[i][j]]++;
            }
        }
        for (int i = 1; i < count.length; ++i) {
            if (count[i] == 0)
                ans[1] = i;
            if (count[i] == 2)
                ans[0] = i;
        }
        return ans;
    }
}
