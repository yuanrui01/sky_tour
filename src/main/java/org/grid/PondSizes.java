package org.grid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 面试题 16.19. 水域大小
 */
public class PondSizes {

    private static final int[][] dirs = {{0,1},{1,1},{1,0},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1}};

    public int[] pondSizes(int[][] land) {
        List<Integer> ans = new ArrayList<>();
        int m = land.length;
        int n = land[0].length;
        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (land[i][j] == 0 && !vis[i][j]) {
                    ans.add(dfs(land, vis, m, n, i, j));
                }
            }
        }
        Collections.sort(ans);
        return ans.stream().mapToInt(i->i).toArray();
    }

    private int dfs(int[][] land, boolean[][] vis, int m, int n, int i, int j) {
        int res = 1;
        vis[i][j] = true;
        for (int[] dir : dirs) {
            int newX  = i + dir[0];
            int newY = j + dir[1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && land[newX][newY] == 0 && !vis[newX][newY]) {
                res += dfs(land, vis, m, n, newX, newY);
            }
        }
        return res;
    }
}
