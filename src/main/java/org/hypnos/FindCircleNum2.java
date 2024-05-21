package org.hypnos;

/**
 * 547. 省份数量 - 并查集-路径压缩写法
 */
public class FindCircleNum2 {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; ++j) {
               if (isConnected[i][j] == 1) {
                   union(parents, i, j);
               }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (parents[i] == i)
                ans++;
        }
        return ans;
    }

    private void union(int[] parents, int i, int j) {
        parents[find(parents, i)] = parents[find(parents, j)];
    }

    private int find(int[] parents, int i) {
        return parents[i] == i ? i : (parents[i] = find(parents, parents[i]));
    }
}
