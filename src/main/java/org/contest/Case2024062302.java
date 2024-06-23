package org.contest;

/**
 * @author: yuanrui
 */
public class Case2024062302 {

	public int minimumArea(int[][] grid) {
		int x1 = 0, x2 = 0, y1 = 0, y2 = 0;

		int m = grid.length;
		int n = grid[0].length;
		for (int j = 0; j < n; ++j) {
			boolean found = false;
			for (int i = 0; i < m; ++i) {
				if (grid[i][j] == 1) {
					y1 = j;
					found = true;
					break;
				}
			}
			if (found)
				break;
		}

		for (int j = n - 1; j >= 0; j--) {
			boolean found = false;
			for (int i = 0; i < m; ++i) {
				if (grid[i][j] == 1) {
					y2 = j;
					found = true;
					break;
				}
			}
			if (found)
				break;
		}

		for (int i = 0; i < m; ++i) {
			boolean found = false;
			for (int j = 0; j < n; ++j) {
				if (grid[i][j] == 1) {
					x1 = i;
					found = true;
					break;
				}
			}
			if (found)
				break;
		}

		for (int i = m - 1; i >= 0; --i) {
			boolean found = false;
			for (int j = 0; j < n; ++j) {
				if (grid[i][j] == 1) {
					x2 = i;
					found = true;
					break;
				}
			}
			if (found)
				break;
		}

		return (x2 - x1 + 1) * (y2 - y1 + 1);
	}


	public static void main(String[] args) {
		Case2024062302 case2024062302 = new Case2024062302();

		int[][] grid  = {{0,0}, {1,0}};

		System.out.println(case2024062302.minimumArea(grid));
	}
}
