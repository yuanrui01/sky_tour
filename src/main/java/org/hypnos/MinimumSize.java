package org.hypnos;


/**
 * 1760. 袋子里最少数目的球
 */
public class MinimumSize {

    public int minimumSize(int[] nums, int maxOperations) {
        int mx = 0;
        for (int x : nums) {
            mx = Math.max(mx, x);
        }
        int left = 1;
        int right = mx;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(nums, maxOperations, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[] nums, int maxOperations, int m) {
        int cnt = 0;
        for (int x : nums) {
            cnt += (x - 1) / m;
        }
        return cnt <= maxOperations;
    }
}
