package org.hypnos;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * 909. 蛇梯棋
 */
public class SnakesAndLadders {

	public int snakesAndLadders(int[][] board) {
		int n = board.length;
		int target = n*n;
		boolean[] vis = new boolean[target + 1];
		Map<Integer, Integer> tunnel = new HashMap<>();
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				int x = board[i][j];
				if (x != -1) {
					tunnel.put(getPos(i,j,n), x);
				}
			}
		}
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[]{1,0});
		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			int p0 = p[0];
			int p1 = p[1];
			if (p0 == target) {
				return p1;
			}
			int upper = Math.min(p0 + 6, target);
			int nd = p1+1;
			for (int i = p0 + 1; i <= upper; ++i) {
				int nxt = tunnel.get(i) == null ? i : tunnel.get(i);
				if (!vis[nxt]) {
					vis[nxt] = true;
					queue.add(new int[]{nxt, nd});
				}
			}
		}
		return -1;
	}

	private int getPos(int i, int j, int n) {
		int ai = n - i - 1;
		if ((ai&1) == 0) {
			return n*ai + j + 1;
		} else {
			return (ai + 1) * n - j;
		}
	}

	public static void main(String[] args) {
		SnakesAndLadders snakesAndLadders = new SnakesAndLadders();

		int[][] board = {{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}};
		System.out.println(snakesAndLadders.snakesAndLadders(board));
	}
}
