package org.hypnos;


import java.util.HashMap;
import java.util.Map;

/**
 * 2140. 解决智力问题
 */
public class MostPoints {

    public long mostPoints(int[][] questions) {
        Map<Integer, Long> cache = new HashMap<>();
        return dfs(0, questions.length, 0, questions, cache);
    }

    private long dfs(int i, int n, long sum, int[][] questions, Map<Integer, Long> cache) {
        if (i >= n) {
            return sum;
        }
        if (cache.get(i) != null) {
            return cache.get(i);
        }
        // 1. 解决
        long s1 = sum + questions[i][0] + dfs(i + questions[i][1] + 1, n, 0, questions, cache);
        // 2. 跳过
        long s2 = sum + dfs(i + 1, n, 0, questions, cache);
        long ans = Math.max(s1, s2);
        cache.put(i, ans);
        return ans;
    }

    public static void main(String[] args) {
        MostPoints mostPoints = new MostPoints();
        int[][] questions = {{1,1},{2,2},{3,3},{4,4},{5,5}};
        System.out.println(mostPoints.mostPoints(questions));
    }
}
