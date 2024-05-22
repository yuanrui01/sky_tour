package org.hypnos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2316. 统计无向图中无法互相到达点对数
 */
public class CountPairs {

    public long countPairs(int n, int[][] edges) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] edge : edges) {
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int total = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int size = 0;
            if (!visited[i]) {
                size += dfs(g, visited, i);
                ans += (long) size * total;
                total += size;
            }
        }
        return ans;
    }

    private int dfs(List<Integer>[] g, boolean[] visited, int i) {
        visited[i] = true;
        int size = 1;
        for (Integer newI : g[i]) {
            if (!visited[newI])
                size += dfs(g, visited, newI);
        }
        return size;
    }

}
