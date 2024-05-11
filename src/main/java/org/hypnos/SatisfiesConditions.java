package org.hypnos;

/**
 * @author: yuanrui
 */
public class SatisfiesConditions {

	public static boolean satisfiesConditions(int[][] grid) {
		boolean result = true;
		int rows = grid.length;
		int cols = grid[0].length;
		for (int i = 0; i < rows - 1; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] != grid[i + 1][j]) {
					return false;
				}
			}
		}

		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols - 1; ++j) {
				if (grid[i][j] == grid[i][j + 1]) {
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		SatisfiesConditions satisfiesConditions = new SatisfiesConditions();

		int[][] grid = {{1,1,1},{0,0,0}};

		System.out.println(satisfiesConditions.satisfiesConditions(grid));
	}
}
