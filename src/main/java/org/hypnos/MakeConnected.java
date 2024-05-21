package org.hypnos;


import java.util.Arrays;

/**
 * 1319. 连通网络的操作次数
 */
public class MakeConnected {

    private int[] parent;
    private int[] depth;
    private int mergeCount;

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1)
            return -1;
        parent = new int[n];
        depth = new int[n];
        Arrays.fill(depth, 1);
        mergeCount = 0;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < connections.length; i++) {
            union(connections[i][0], connections[i][1]);
        }

        return n - mergeCount - 1;
    }

    private void union(int i, int j) {
        int iRoot = find(i);
        int jRoot = find(j);
        if (iRoot != jRoot) {
            mergeCount++;
            if (depth[iRoot] < depth[jRoot]) {
                parent[iRoot] = jRoot;
            } else {
                parent[jRoot] = iRoot;
                if (depth[iRoot] == depth[jRoot])
                    depth[iRoot]++;
            }
        }
    }

    private int find(int i) {
        return parent[i] == i ? i : (parent[i] = find(parent[i]));
    }
}
