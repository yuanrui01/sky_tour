package org.hypnos;


// 3065. 超过阈值的最少操作数 I
public class MinOperations3065 {

    public int minOperations(int[] nums, int k) {
        int ans= 0;
        for (int num : nums) {
            if (num < k) ans++;
        }
        return ans;
    }
}
