package org.dp;

/**
 * 超时写法
 */
public class MaxPoints {

    private int[][] points;
    private int m;
    private int n;
    private long[][] cache;

    public long maxPoints(int[][] points) {
        this.m = points.length;
        this.n = points[0].length;
        this.points = points;
        this.cache = new long[m][n];
        long ans = 0;
        for (int j = 0; j < n; ++j)
            ans = Math.max(ans, dp(0, j));
        return ans;
    }

    private long dp(int i, int j) {
        if (i == m - 1)
            return points[i][j];
        if (cache[i][j] != 0)
            return cache[i][j];
        long ans = 0;
        int y = i + 1;
        for (int x = 0; x < n; ++x) {
            ans = Math.max(ans, dp(y, x) - Math.abs(x - j));
        }
        return cache[i][j] = ans + points[i][j];
    }

    public static void main(String[] args) {
        MaxPoints maxPoints = new MaxPoints();
        int[][] points =  {{1,2,3},{1,5,1},{3,1,1}};
        System.out.println(maxPoints.maxPoints(points));
    }
}
