package org.hypnos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 2101. 引爆最多的炸弹
 */
public class MaximumDetonation {

    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        int ans = 0;
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j) continue;
                if (reach(bombs, i, j))
                    g[i].add(j);
            }
        }

        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(vis, false);
            ans = Math.max(ans, dfs(bombs, g, vis, i));
        }
        return ans;
    }

    private int dfs(int[][] bombs, List<Integer>[] g, boolean[] vis, int i) {
        int ans = 1;
        vis[i] = true;
        for (Integer v : g[i]) {
            if (!vis[v] && reach(bombs, i, v)) {
                ans = ans + dfs(bombs, g, vis, v);
            }
        }
        return ans;
    }

    private boolean reach(int[][] bombs, int i, int j) {
        int[] bomb1 = bombs[i];
        int[] bomb2 = bombs[j];
        long i1 = Math.abs(bomb1[0] - bomb2[0]);
        long i2 = Math.abs(bomb1[1] - bomb2[1]);
        long dis1 = i1*i1 + i2*i2;
        long dis2 = (long)bomb1[2] * bomb1[2];
        return dis1 <= dis2;
    }

    public static void main(String[] args) {
        MaximumDetonation maximumDetonation = new MaximumDetonation();
        int[][] bombs = {{2, 1, 3}, {6, 1, 4}};
        System.out.println(maximumDetonation.maximumDetonation(bombs));
    }
}
