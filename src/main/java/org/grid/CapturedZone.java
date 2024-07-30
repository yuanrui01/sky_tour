package org.grid;

import java.util.ArrayList;
import java.util.List;


/**
 * 130. 被围绕的区域
 */
public class CapturedZone {

    private static final int[][] dirs = {{0,1}, {1,0}, {0,-1},{-1,0}};

    private final List<int[]> points = new ArrayList<>();

    private boolean flag = true;

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        List<int[]> all = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'O' && !vis[i][j]) {
                    flag = true;
                    points.clear();
                    dfs(board, vis, m, n, i, j);
                    if (flag)
                        all.addAll(points);
                }
            }
        }
        draw(board, all);
    }

    private void draw(char[][] board, List<int[]> points) {
        for (int[] point : points) {
            board[point[0]][point[1]] = 'X';
        }
    }

    private void dfs(char[][] board, boolean[][] vis, int m, int n, int i, int j) {
        vis[i][j] = true;
        points.add(new int[]{i,j});
        for (int[] dir : dirs) {
            int newX = i + dir[0];
            int newY = j + dir[1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                if (board[newX][newY] == 'O' && !vis[newX][newY]) {
                    dfs(board, vis, m, n, newX, newY);
                }
            } else {
                flag = false;
            }
        }
    }
}
