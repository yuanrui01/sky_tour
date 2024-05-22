package org.hypnos;


import java.util.Arrays;

/**
 * 1971. 寻找图中是否存在路径 - 路径压缩 + 按秩合并
 */
public class ValidPath {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] parents = new int[n];
        int[] depths = new int[n];
        Arrays.fill(depths, 1);
        for (int i = 0; i < n; i++)
            parents[i] = i;
        for (int[] edge : edges)
            union(parents, depths, edge[0], edge[1]);
        return find(parents, source) == find(parents, destination);
    }

    private void union(int[] parents, int[] depths, int i, int j) {
        int iRoot = find(parents, i);
        int jRoot = find(parents, j);
        if (iRoot != jRoot) {
            if (depths[iRoot] < depths[jRoot]) {
                parents[iRoot] = jRoot;
            } else {
                parents[jRoot] = iRoot;
                if (depths[iRoot] == depths[jRoot]) {
                    depths[iRoot]++;
                }
            }
        }
    }

    private int find(int[] parents, int i) {
        return parents[i] == i ? i : (parents[i] = find(parents, parents[i]));
    }
}
