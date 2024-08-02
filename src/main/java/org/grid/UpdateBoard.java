package org.grid;


/**
 * 529. 扫雷游戏
 */
public class UpdateBoard {

    private static final int[][] dirs = {{-1, 0}, {-1, 1}, {0, 1},
            {1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length;
        int n = board[0].length;
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else {
            boolean[][] vis = new boolean[m][n];
            dfs(board, vis, m, n, x, y);
        }
        return board;
    }

    private void dfs(char[][] board, boolean[][] vis, int m, int n, int i, int j) {
        vis[i][j] = true;
        if (board[i][j] == 'M') {
            board[i][j] = 'X';
            return;
        }
        int bombCount = 0;
        for (int[] dir : dirs) {
            int newX = i + dir[0];
            int newY = j + dir[1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && board[newX][newY] == 'M') {
                bombCount++;
            }
        }
        if (bombCount == 0) {
            board[i][j] = 'B';
            for (int[] dir : dirs) {
                int newX = i + dir[0];
                int newY = j + dir[1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !vis[newX][newY]) {
                    dfs(board, vis, m, n, newX, newY);
                }
            }
        } else {
            board[i][j] = (char) ('0' + bombCount);
        }
    }
}
