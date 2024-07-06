package org.contest;

/**
 * 1958. 检查操作是否合法
 */
public class CheckMove {

	public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
		board[rMove][cMove] = color;

		if (cMove < 6 && (board[rMove][cMove + 1] != '.' && board[rMove][cMove + 1] != color)) {
			for (int i = cMove + 2; i < 8; ++i) {
				if (board[rMove][i] == '.')
					break;
				else if (board[rMove][i] == color)
					return true;
			}
		}

		if (cMove > 1 && (board[rMove][cMove - 1] != '.' && board[rMove][cMove - 1] != color)) {
			for (int i = cMove - 2; i >= 0; --i) {
				if (board[rMove][i] == '.')
					break;
				else if (board[rMove][i] == color)
					return true;
			}
		}

		if (rMove < 6 && (board[rMove + 1][cMove] != '.' && board[rMove + 1][cMove] != color)) {
			for (int i = rMove + 2; i < 8; ++i) {
				if (board[i][cMove] == '.')
					break;
				else if (board[i][cMove] == color)
					return true;
			}
		}

		if (rMove > 1 && (board[rMove - 1][cMove] != '.' && board[rMove - 1][cMove] != color)) {
			for (int i = rMove - 2; i >= 0; --i) {
				if (board[i][cMove] == '.')
					break;
				else if (board[i][cMove] == color)
					return true;
			}
		}

		// 开始检查斜边
		int r1 = rMove + 1;
		int c1 = cMove + 1;
		int r2 = rMove - 1;
		int c2 = cMove - 1;

		if (r1 < 7 && c1 < 7 && board[r1][c1] != '.' && board[r1][c1] != color) {
			int rr1 = r1 + 1;
			int cc1 = c1 + 1;
			while(rr1 < 8 && cc1 < 8) {
				if (board[rr1][cc1] == '.') {
					break;
				} else if (board[rr1][cc1] == color) {
					return true;
				}
				rr1++;
				cc1++;
			}
		}

		if (r2 > 0 && c2 > 0 && board[r2][c2] != '.' && board[r2][c2] != color) {
			int rr1 = r2 - 1;
			int cc1 = c2 - 1;
			while (rr1 >= 0 && cc1 >= 0) {
				if (board[rr1][cc1] == '.') {
					break;
				} else if (board[rr1][cc1] == color) {
					return true;
				}
				rr1--;
				cc1--;
			}
		}

		if (r2 > 0 && c1 < 7 && board[r2][c1] != '.' && board[r2][c1] != color) {
			int rr1 = r2 - 1;
			int cc1 = c1 + 1;
			while(rr1 >= 0 && cc1 < 8) {
				if (board[rr1][cc1] == '.') {
					break;
				} else if (board[rr1][cc1] == color) {
					return true;
				}
				rr1--;
				cc1++;
			}
		}

		if (r1 < 7 && c2 > 0 && board[r1][c2] != '.' && board[r1][c2] != color) {
			int rr1 = r1 + 1;
			int cc1 = c2 - 1;
			while(rr1 < 8 && cc1 >= 0) {
				if (board[rr1][cc1] == '.') {
					break;
				} else if (board[rr1][cc1] == color) {
					return true;
				}
				rr1++;
				cc1--;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		CheckMove checkMove = new CheckMove();
		char[][] board = {{'W','W','W','.','.','B','W','B'},{'W','.','W','B','B','W','B','W'},{'.','W','W','B','.','W','B','W'},{'.','.','B','.','B','.','B','B'},{'.','W','.','.','.','W','B','.'},{'W','W','.','.','B','B','.','.'},{'W','.','W','B','B','B','W','B'},{'B','B','.','W','.','.','.','W'}};
		int r = 4;
		int c = 2;
		char color = 'B';

		System.out.println(checkMove.checkMove(board, r, c, color));
	}
}
