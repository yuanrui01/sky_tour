package org.hypnos;


/**
 * 2012. 数组美丽值求和
 */
public class SumOfBeauties {
    public int sumOfBeauties(int[] nums) {
        int ans = 0;
        int mx = nums[0];
        int n = nums.length;
        int[] mn = new int[n];
        mn[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            mn[i] = Math.min(nums[i], mn[i+1]);
        }
        for (int i = 1; i < n - 1; ++i) {
            if (nums[i] > mx && nums[i] < mn[i+1]) {
                ans += 2;
            } else if (nums[i] > nums[i-1] && nums[i] < nums[i+1]) {
                ans++;
            }
            mx = Math.max(mx, nums[i]);
        }
        return ans;
    }
}
