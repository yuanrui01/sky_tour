package org.hypnos;

import java.util.Arrays;

/**
 * 1706. 球会落何处
 */
public class FindBall {


	public int[] findBall(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[] ans = new int[n];
		for (int j = 0; j < n; ++j) {
			ans[j] = getFinalPos(grid,m, n, j);
		}
		return ans;
	}

	private int getFinalPos(int[][] grid, int m, int n, int pj) {
		int pi = 0;
		for (int i = 0; i < m; ++i) {
			if (grid[pi][pj] == 1) {
				if (pj == n-1 || grid[pi][pj+1] == -1) {
					return -1;
				} else {
					pj++;
				}
			} else {
				if (pj == 0 || grid[pi][pj-1] == 1) {
					return -1;
				} else {
					pj--;
				}
			}
			pi++;
		}
		return pj;
	}


	public static void main(String[] args) {
		int[][] grid =  {{-1,1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,1,1,-1,-1,-1,1,1,1,-1,-1,1,1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,1,-1,1,-1,-1,1,1,-1,1,-1,-1,-1,-1,1,1,1,1,1,1,-1,1,1,1,-1,1,1,1,-1,-1,-1,1,-1,1,-1,-1,1,1,-1,-1,1,-1,1,-1,1,1,1,-1,-1,-1,-1}};
		FindBall findBall = new FindBall();
		System.out.println(Arrays.toString(findBall.findBall(grid)));
	}
}
