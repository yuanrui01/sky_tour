package org.hypnos;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1438. 绝对差不超过限制的最长连续子数组
 */
public class LongestSubarray2 {

    public int longestSubarray(int[] nums, int limit) {
        int ans = 0;
        int left = 0;
        int right = 0;
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        int n = nums.length;
        while (right < n) {
            maxQueue.offer(nums[right]);
            minQueue.offer(nums[right]);
            while (!checkQueue(maxQueue, nums[right], limit) || !checkQueue(minQueue, nums[right], limit)) {
                maxQueue.remove(nums[left]);
                minQueue.remove(nums[left]);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }

    private boolean checkQueue(PriorityQueue<Integer> queue, int target, int limit) {
        if (queue.isEmpty())
            return true;
        return Math.abs(queue.peek() - target) <= limit;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,2,2,4,4,2,2};
        int limit = 0;
        LongestSubarray2 longestSubarray2 = new LongestSubarray2();
        System.out.println(longestSubarray2.longestSubarray(nums, limit));
    }
}
