package org.hypnos;


/**
 * 2302. 统计得分小于 K 的子数组数目
 */
public class CountSubarrays {

    public long countSubarrays(int[] nums, long k) {
        long count = 0L;
        long n = nums.length;

        long sum = 0L;
        int left = 0;
        int right = 0;
        while (right < n) {
            sum += nums[right];
            while (left <= right && sum * (right - left + 1) >= k) {
                count += (n - right);
                sum -= nums[left++];
            }
            right++;
        }
        return n * (n + 1) / 2 - count;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,4,3,5};
        int k = 10;
        CountSubarrays countSubarrays = new CountSubarrays();
        System.out.println(countSubarrays.countSubarrays(nums, k));
    }
}
