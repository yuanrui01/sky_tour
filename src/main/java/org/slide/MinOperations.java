package org.slide;


/**
 * 1658. 将 x 减到 0 的最小操作数
 */
public class MinOperations {

    public int minOperations(int[] nums, int x) {
        int ans = -1;
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int target = total - x;
        if (target < 0) return -1;
        int sum = 0;
        int left = 0, right = 0;
        int n = nums.length;
        while (right < n) {
            sum += nums[right];
            while (sum > target) {
                sum -= nums[left];
                left++;
            }
            if (sum == target) {
                ans = Math.max(ans, right - left + 1);
            }
            right++;
        }
        return ans == -1 ? -1 : n - ans;
    }

    public static void main(String[] args) {
        MinOperations minOperations = new MinOperations();
        int[] nums = {1,1};
        int x = 3;
        System.out.println(minOperations.minOperations(nums, x));
    }
}
