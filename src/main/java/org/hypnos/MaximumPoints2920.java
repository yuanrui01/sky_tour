package org.hypnos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 2920. 收集所有金币可获得的最大积分
 */
public class MaximumPoints2920 {

    public int maximumPoints(int[][] edges, int[] coins, int k) {
        List<Integer>[] g = new List[coins.length];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] edge : edges) {
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }
        boolean[] vis = new boolean[coins.length];
        int[][] memo = new int[coins.length][31];
        for (int[] meme : memo) {
            Arrays.fill(meme, Integer.MIN_VALUE);
        }
        return f(0, k, 1, g, vis, coins, memo);
    }

    private int f(int index, int k, int factor, List<Integer>[] g, boolean[] vis, int[] coins, int[][] memo) {
        if (memo[index][factor] != Integer.MIN_VALUE) return memo[index][factor];
        vis[index] = true;
        int s1 = 0;
        int s2 = 0;
        for (Integer v : g[index]) {
            if (!vis[v]) {
                s1 += f(v, k, factor, g, vis, coins, memo);
                if (k > 0 && factor < 30)
                    s2 += f(v, k, factor + 1, g, vis, coins, memo);
            }
        }
        int actV = (coins[index] / (1 << (factor - 1)));
        vis[index] = false;
        return memo[index][factor] = Math.max(actV - k + s1, actV / 2 + s2);
    }

    public static void main(String[] args) {
        MaximumPoints2920 maximumPoints2920 = new MaximumPoints2920();
        int[][] edges = {{1,0},{2,1},{3,1},{2,4},{5,4},{6,3},{6,7}};
        int[] coins = {9,9,5,5,7,9,6,9};
        int k = 8;
        System.out.println(maximumPoints2920.maximumPoints(edges, coins, k));
    }
}
