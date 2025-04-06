package org.hypnos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 368. 最大整除子集
 */
public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int[] memo = new int[n];
        int[] from = new int[n];
        Arrays.fill(from, -1);
        int maxF = 0;
        int maxI = 0;

        for (int i = 0; i < n; i++) {
            int f = dfs(i, nums, memo, from);
            if (f > maxF) {
                maxF = f;
                maxI = i; // 最长合法子序列的最后一个数的下标
            }
        }

        List<Integer> path = new ArrayList<>(maxF); // 预分配空间
        for (int i = maxI; i >= 0; i = from[i]) {
            path.add(nums[i]);
        }
        return path; // 不需要 reverse，任意顺序返回均可
    }

    private int dfs(int i, int[] nums, int[] memo, int[] from) {
        if (memo[i] > 0) { // 之前计算过
            return memo[i];
        }
        int res = 0;
        for (int j = 0; j < i; j++) {
            if (nums[i] % nums[j] != 0) {
                continue;
            }
            int f = dfs(j, nums, memo, from);
            if (f > res) {
                res = f;
                from[i] = j; // 记录最佳转移来源
            }
        }
        return memo[i] = res + 1; // 记忆化
    }
}
