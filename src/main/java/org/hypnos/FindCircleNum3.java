package org.hypnos;


/**
 * 547. 省份数量 - 路径压缩 + 按秩合并
 */
public class FindCircleNum3 {

    private int[] parent;
    private int[] depth;
    private int mergeCount;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        this.parent = new int[n];
        this.depth = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            depth[i] = 1;
        }

        mergeCount = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                if (isConnected[i][j] == 1)
                    union(i, j);
            }
        }
        return n - mergeCount;
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

    public static void main(String[] args) {
        int[][] isConnected = {{1,0,0},{0,1,0},{0,0,1}};
        FindCircleNum3 findCircleNum3 = new FindCircleNum3();
        System.out.println(findCircleNum3.findCircleNum(isConnected));
    }
}
