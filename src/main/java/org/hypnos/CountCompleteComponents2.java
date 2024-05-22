package org.hypnos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 2685. 统计完全连通分量的数量 - DFS做法
 */
public class CountCompleteComponents2 {

    private int v;
    private int e;
    private boolean[] vis;

    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        this.vis = new boolean[n];
        for (int[] edge : edges) {
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (!vis[i]) {
                v = e = 0;
                dfs(g, i);
                if (e == (v * (v - 1)))
                    ans++;
            }
        }
        return ans;
    }

    private void dfs(List<Integer>[] g, int i) {
        vis[i] = true;
        v++;
        e += g[i].size();
        for (Integer y : g[i]) {
            if (!vis[y])
                dfs(g, y);
        }
    }
}
