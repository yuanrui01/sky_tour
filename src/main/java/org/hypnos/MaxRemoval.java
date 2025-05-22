package org.hypnos;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * 3362. 零数组变换 III
 */
public class MaxRemoval {

    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int n = nums.length;
        int[] diff = new int[n + 1];
        int sumD = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            sumD += diff[i];
            // 维护左端点 <= i 的区间
            while (j < queries.length && queries[j][0] <= i) {
                pq.add(queries[j][1]);
                j++;
            }
            // 选择右端点最大的区间
            while (sumD < nums[i] && !pq.isEmpty() && pq.peek() >= i) {
                sumD++;
                diff[pq.poll() + 1]--;
            }
            if (sumD < nums[i]) {
                return -1;
            }
        }
        return pq.size();
    }
}
