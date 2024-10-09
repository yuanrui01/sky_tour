package org.bit;


/**
 * 1521. 找到最接近目标值的函数值
 */
public class ClosestToTarget {

    public int closestToTarget(int[] arr, int target) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            ans = Math.min(ans, Math.abs(x - target));
            for (int j = i - 1; j >= 0 && ((arr[j] & x) != arr[j]); j--) {
                arr[j] &= x;
                ans = Math.min(ans, Math.abs(arr[j] - target));
            }
        }
        return ans;
    }
}
