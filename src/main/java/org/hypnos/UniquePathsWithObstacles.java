package org.hypnos;


/**
 * 63. 不同路径 II
 */
public class UniquePathsWithObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] memo = new int[m][n];
        if (obstacleGrid[0][0] == 1)
            return 0;
        memo[0][0] = 1;
        for (int x = 0; x < m; ++x) {
            for (int y = 0; y < n; ++y) {
                if (obstacleGrid[x][y] == 1) {
                    memo[x][y] = -1;
                } else {
                    if (y - 1 >= 0 && memo[x][y - 1] != -1)
                        memo[x][y] += memo[x][y - 1];
                    if (x - 1 >= 0 && memo[x-1][y] != -1)
                        memo[x][y] += memo[x-1][y];
                    if (memo[x][y] == 0)
                        memo[x][y] = -1;
                }
            }
        }
        return memo[m-1][n-1] < 0 ? 0 : memo[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0},{1,1},{0,0}};
        UniquePathsWithObstacles uniquePathsWithObstacles = new UniquePathsWithObstacles();
        System.out.println(uniquePathsWithObstacles.uniquePathsWithObstacles(obstacleGrid));
    }
}
