package org.grid;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 542. 01 矩阵
 */
public class UpdateMatrix {

    private int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int i = p[0];
            int j = p[1];
            for (int[] d : dirs) {
                int x = i + d[0];
                int y = j + d[1];
                if (x >= 0 && x < m && y >= 0 && y < n && mat[x][y] == 1 && ans[x][y] == 0) {
                    ans[x][y] = ans[i][j] + 1;
                    queue.add(new int[]{x, y});
                }
            }
        }
        return ans;
    }
}
