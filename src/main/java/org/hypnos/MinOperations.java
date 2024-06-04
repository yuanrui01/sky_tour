package org.hypnos;


/**
 * 1658. 将 x 减到 0 的最小操作数
 */
public class MinOperations {

    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums)
            sum += num;
        int target = sum - x;
        if (target < 0)
            return -1;
        if (target == 0)
            return n;
        int ans = -1;
        int tSum = 0;
        int left = 0;
        int right = 0;
        while (right < n) {
            tSum += nums[right];
            while (tSum > target) {
                tSum -= nums[left];
                left++;
            }
            if (tSum == target)
                ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans == -1 ? -1 : (n - ans);
    }

    public static void main(String[] args) {
        int[] nums = {3,2,20,1,1,3};
        int x = 10;
        MinOperations minOperations = new MinOperations();

        System.out.println(minOperations.minOperations(nums, x));
    }
}
