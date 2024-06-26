package org.dp;


/**
 * 2267. 检查是否有合法括号字符串路径
 */
public class HasValidPath {

    private int m;
    private int n;
    private char[][] grid;
    private boolean[][][] vis;

    public boolean hasValidPath(char[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;
        if ((m + n - 1) % 2 != 0 || grid[0][0] == ')' || grid[m - 1][n - 1] == '(')
            return false;
        this.vis = new boolean[m][n][(m + n + 1) / 2];
        return dfs(0, 0, 0);
    }

    private boolean dfs(int i, int j, int c) {  
        if (c > m - i + n - j - 1)
            return false;
        if (i == m - 1 && j == n - 1)
            return c == 1;
        if (vis[i][j][c]) // 访问过还在跑就是失败的
            return false;
        vis[i][j][c] = true;
        c += grid[i][j] == ')' ? -1 : 1;
        return c >= 0 && (i < m - 1 && dfs(i + 1, j, c) || j < n - 1 && dfs(i, j + 1, c));
    }
}
