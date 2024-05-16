package org.hypnos;


/**
 * 1953. 你可以工作的最大周数
 */
public class NumberOfWeeks {

    public long canPartition(int[] milestones) {
        long totalSum = 0;
        for (int num : milestones) {
            totalSum += num;
        }

        long target = totalSum / 2;
        boolean[] dp = new boolean[(int)(target + 1)];
        dp[0] = true;

        for (int num : milestones) {
            for (long j = target; j >= num; j--) {
                dp[(int)j] = dp[(int)j] || dp[(int)(j - num)];
            }
        }

        long sum1 = 0;
        for (long i = target; i >= 0; i--) {
            if (dp[(int)i]) {
                sum1 = i;
                break;
            }
        }

        long sum2 = totalSum - sum1;
        long abs = Math.abs(sum2 - sum1);
        if (abs > 0) abs--;
        return totalSum - abs;
    }

    public static void main(String[] args) {
        NumberOfWeeks numberOfWeeks = new NumberOfWeeks();
        int[] nums = {5,2,1};

    }
}
