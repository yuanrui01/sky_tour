package org.hypnos;


import java.util.Arrays;

/**
 * 2234. 花园的最大总美丽值
 */
public class MaximumBeauty {


    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        int n = flowers.length;

        // 如果全部种满，还剩下多少朵花？
        long leftFlowers = newFlowers - (long) target * n; // 先减掉
        for (int i = 0; i < n; i++) {
            flowers[i] = Math.min(flowers[i], target);
            leftFlowers += flowers[i]; // 把已有的加回来
        }

        // 没有种花，所有花园都已种满
        if (leftFlowers == newFlowers) {
            return (long) n * full; // 答案只能是 n*full（注意不能减少花的数量）
        }

        // 可以全部种满
        if (leftFlowers >= 0) {
            // 两种策略取最大值：留一个花园种 target-1 朵花，其余种满；或者，全部种满
            return Math.max((long) (target - 1) * partial + (long) (n - 1) * full, (long) n * full);
        }

        Arrays.sort(flowers); // 时间复杂度的瓶颈在这，尽量写在后面

        long ans = 0;
        long preSum = 0;
        int j = 0;
        // 枚举 i，表示后缀 [i, n-1] 种满（i=0 的情况上面已讨论）
        for (int i = 1; i <= n; i++) {
            // 撤销，flowers[i-1] 不变成 target
            leftFlowers += target - flowers[i - 1];
            if (leftFlowers < 0) { // 花不能为负数，需要继续撤销
                continue;
            }

            // 满足以下条件说明 [0, j] 都可以种 flowers[j] 朵花
            while (j < i && (long) flowers[j] * j <= preSum + leftFlowers) {
                preSum += flowers[j];
                j++;
            }

            // 计算总美丽值
            // 在前缀 [0, j-1] 中均匀种花，这样最小值最大
            long avg = (leftFlowers + preSum) / j; // 由于上面特判了，这里 avg 一定小于 target
            long totalBeauty = avg * partial + (long) (n - i) * full;
            ans = Math.max(ans, totalBeauty);
        }

        return ans;
    }
}
