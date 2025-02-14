package org.hypnos;


/**
 * 63. 不同路径 II
 */
public class UniquePathsWithObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int n = obstacleGrid.length;
		int m = obstacleGrid[0].length;
		if (obstacleGrid[n-1][m-1] == 1 || obstacleGrid[0][0] == 1) return 0;
		int[][] memo = new int[n][m];
		memo[0][0] = 1;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (i > 0 && obstacleGrid[i-1][j] != 1) {
					memo[i][j] += memo[i-1][j];
				}
				if (j > 0 && obstacleGrid[i][j-1] != 1) {
					memo[i][j] += memo[i][j-1];
				}
			}
		}
		return memo[n-1][m-1];
    }
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0},{1,1},{0,0}};
        UniquePathsWithObstacles uniquePathsWithObstacles = new UniquePathsWithObstacles();
        System.out.println(uniquePathsWithObstacles.uniquePathsWithObstacles(obstacleGrid));
    }
}
