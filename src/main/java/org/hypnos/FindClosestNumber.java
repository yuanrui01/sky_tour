package org.hypnos;


/**
 * 2239. 找到最接近 0 的数字
 */
public class FindClosestNumber {

    public int findClosestNumber(int[] nums) {
        int ans = nums[0];
        int absA = Math.abs(ans);
        for (int i = 1; i < nums.length; ++i) {
            int absN = Math.abs(nums[i]);
            if (absN < absA || (absN == absA && nums[i] > ans)) {
                ans = nums[i];
                absA = absN;
            }
        }
        return ans;
    }
}
