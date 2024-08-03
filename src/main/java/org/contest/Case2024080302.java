package org.contest;

/**
 * @author: yuanrui
 */
public class Case2024080302 {

	public int minFlips(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int rowFlips = 0;
		int colFlips = 0;
		for (int[] rows : grid) {
			for (int i = 0; i < n / 2; i++) {
				if (rows[i] != rows[n - 1 - i]) {
					rowFlips++;
				}
			}
		}
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < m / 2; i++) {
				if (grid[i][j] != grid[m - 1 - i][j]) {
					colFlips++;
				}
			}
		}
		return Math.min(rowFlips, colFlips);
	}

	private static int minFlipsForPalindrome(int[] array) {
		int flips = 0;
		int len = array.length;
		for (int i = 0; i < len / 2; i++) {
			if (array[i] != array[len - 1 - i]) {
				flips++;
			}
		}
		return flips;
	}


	public static void main(String[] args) {

	}
}
