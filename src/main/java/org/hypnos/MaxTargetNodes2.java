package org.hypnos;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3373. 连接两棵树后最大目标节点数目 II
 */
public class MaxTargetNodes2 {

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        List<Integer>[] g2 = buildTree(edges2);
        int[] cnt2 = new int[2];
        dfs(0, -1, 0, g2, cnt2);
        int max2 = Math.max(cnt2[0], cnt2[1]);

        List<Integer>[] g1 = buildTree(edges1);
        int[] cnt1 = new int[2];
        dfs(0, -1, 0, g1, cnt1);

        int[] ans = new int[g1.length];
        Arrays.fill(ans, max2);
        dfs1(0, -1, 0, g1, cnt1, ans);
        return ans;
    }

    private List<Integer>[] buildTree(int[][] edges) {
        List<Integer>[] g = new ArrayList[edges.length + 1];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            g[x].add(y);
            g[y].add(x);
        }
        return g;
    }

    private void dfs(int x, int fa, int d, List<Integer>[] g, int[] cnt) {
        cnt[d]++;
        for (int y : g[x]) {
            if (y != fa) {
                dfs(y, x, d ^ 1, g, cnt);
            }
        }
    }

    private void dfs1(int x, int fa, int d, List<Integer>[] g, int[] cnt1, int[] ans) {
        ans[x] += cnt1[d];
        for (int y : g[x]) {
            if (y != fa) {
                dfs1(y, x, d ^ 1, g, cnt1, ans);
            }
        }
    }
}
