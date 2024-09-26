package org.hypnos;

/**
 * 2535. 数组元素和与数字和的绝对差
 */
public class DifferenceOfSum {

    public int differenceOfSum(int[] nums) {
        int sum = 0;
        int digitSum = 0;

        for (int n : nums) {
            sum += n;
            digitSum += getDigitSum(n);
        }
        return Math.abs(sum - digitSum);
    }

    private int getDigitSum(int n) {
        int sum = 0;
        while(n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
