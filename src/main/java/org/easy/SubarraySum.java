package org.easy;


/**
 * 3427. 变长子数组求和
 */
public class SubarraySum {


    public int subarraySum(int[] nums) {
        int[] s = new int[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            s[i + 1] = nums[i] + s[i];
        }
        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            ans += (s[i+1] - s[Math.max(1, i + 1 - nums[i]) - 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        SubarraySum subarraySum = new SubarraySum();
        int[] nums = {2, 3, 1};
        System.out.println(subarraySum.subarraySum(nums));
    }
}
