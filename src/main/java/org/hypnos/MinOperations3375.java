package org.hypnos;

import java.util.*;

/**
 * 3375. 使数组的值全部为 K 的最少操作次数
 */
public class MinOperations3375 {

    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        if (nums[0] < k) return -1;
        int ans = 0;
        if (nums[0] == k) ans = -1;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            int x = nums[i];
            while (i + 1 < n && nums[i+1] == x) {
                i++;
            }
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5,2,5,4,5};
        int k = 2;
        MinOperations3375 minOperations3375 = new MinOperations3375();

        System.out.println(minOperations3375.minOperations(nums, k));
    }
}
