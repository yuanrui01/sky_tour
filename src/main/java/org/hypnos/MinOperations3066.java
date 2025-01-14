package org.hypnos;


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 3066. 超过阈值的最少操作数 II
 */
public class MinOperations3066 {


    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int li = -1;
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= k) {
                li = i;
                break;
            } else {
                pq.add(nums[i]);
            }
        }
        if (li == -1 && pq.size() != nums.length) return 0;

        int ans = 0;
        while (!pq.isEmpty()) {
            Integer p1 = pq.poll();
            if (pq.isEmpty()) {
                ans++;
                return ans;
            } else {
                Integer p2 = pq.poll();
                long n = Math.min(p1, p2) * 2L + Math.max(p1, p2);
                if (n < k) {
                    pq.add((int)n);
                }
                ans++;
            }
        }
        return ans;
    }
}
