package org.hypnos;

/**
 * 999. 可以被一步捕获的棋子数
 */
public class NumRookCaptures {

	public int numRookCaptures(char[][] board) {
		int[][] ds = {{0,1},{1,0},{0,-1},{-1,0}};
		int i = 0, j = 0;
		int l = 8;
		outerLoop:
		for (i = 0; i < l; ++i) {
			for (j = 0; j < l; ++j) {
				if (board[i][j] == 'R') {
					break outerLoop;
				}
			}
		}
		int count = 0;
		for (int[] d : ds) {
			for (int x = i, y = j; x < l && y < l && x >= 0 && y >= 0; x += d[0], y += d[1]) {
				if (board[x][y] == 'B') {
					break;
				} else if (board[x][y] == 'p') {
					count++;
					break;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		char[][] b = {{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','R','.','.','.','p'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'}};
		NumRookCaptures numRookCaptures = new NumRookCaptures();

		System.out.println(numRookCaptures.numRookCaptures(b));
	}
}
