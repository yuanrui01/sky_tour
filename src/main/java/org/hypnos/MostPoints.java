package org.hypnos;


import java.util.HashMap;
import java.util.Map;

/**
 * 2140. 解决智力问题
 */
public class MostPoints {

    public long mostPoints(int[][] questions) {
        Map<Integer, Long> cache = new HashMap<>();
        return dfs(0, questions.length, questions, cache);
    }

    private long dfs(int i, int n, int[][] questions, Map<Integer, Long> cache) {
        if (i >= n) {
            return 0;
        }
        if (cache.get(i) != null) {
            return cache.get(i);
        }
        // 1. 解决
        long s1 = questions[i][0] + dfs(i + questions[i][1] + 1, n, questions, cache);
        // 2. 跳过
        long s2 = dfs(i + 1, n, questions, cache);
        long ans = Math.max(s1, s2);
        cache.put(i, ans);
        return ans;
    }


    public long mostPoints2(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        for (int i = n - 1; i >= 0; i--) {
            int p = questions[i][0];
            int b = questions[i][1];
            dp[i] = Math.max(p + (i + b + 1 >= n ? 0 : dp[i + b + 1]), i + 1 >= n ? 0 : dp[i+1]);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        MostPoints mostPoints = new MostPoints();
        int[][] questions = {{1,1},{2,2},{3,3},{4,4},{5,5}};
        System.out.println(mostPoints.mostPoints2(questions));
    }
}
