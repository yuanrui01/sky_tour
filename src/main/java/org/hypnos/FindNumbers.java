package org.hypnos;


/**
 * 1295. 统计位数为偶数的数字
 */
public class FindNumbers {

    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int x : nums) {
            while (x >= 100) {
                x /= 100;
            }
            if (x >= 10) {
                ans++;
            }
        }
        return ans;
    }
}
