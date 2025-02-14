package org.hypnos;


/**
 * 1742. 盒子中小球的最大数量
 */
public class CountBalls {

    public int countBalls(int lowLimit, int highLimit) {
        int[] count = new int[37];
        for (int n = lowLimit; n <= highLimit; ++n) {
            count[digitSum(n)]++;
        }
        int mx = 0;
        for (int i : count) {
            mx = Math.max(mx, i);
        }
        return mx;
    }

    private int digitSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
