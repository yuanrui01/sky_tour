package org.dp;


/**
 * 70. 爬楼梯
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        int f0 = 1;
        int f1 = 1;
        for (int i = 2; i <= n; ++i) {
            int t = f1;
            f1 = f0 + f1;
            f0 = t;
        }
        return f1;
    }
}
