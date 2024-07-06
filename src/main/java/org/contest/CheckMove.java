package org.contest;

/**
 * 1958. 检查操作是否合法
 */
public class CheckMove {

	public boolean checkMove(char[][] board, int r, int c, char color) {
		board[r][c] = color;
		for (int i = -1; i <= 1; ++i)
			for (int j = -1; j <= 1; ++j)
				if (checkBound(r + i, c + j) && board[r + i][c + j] != '.' && board[r + i][c + j] != color)
					for (int rNext = r + 2 * i, cNext = c + 2 * j;checkBound(rNext, cNext);rNext += i, cNext += j)
						if (board[rNext][cNext] == '.')
							break;
						else if (board[rNext][cNext] == color)
							return true;
		return false;
	}
	private boolean checkBound(int i, int j) { return i >= 0 && i < 8 && j >= 0 && j < 8; }

	public static void main(String[] args) {
		CheckMove checkMove = new CheckMove();
		char[][] board = {{'W','W','W','.','.','B','W','B'},{'W','.','W','B','B','W','B','W'},{'.','W','W','B','.','W','B','W'},{'.','.','B','.','B','.','B','B'},{'.','W','.','.','.','W','B','.'},{'W','W','.','.','B','B','.','.'},{'W','.','W','B','B','B','W','B'},{'B','B','.','W','.','.','.','W'}};
		int r = 4;
		int c = 2;
		char color = 'B';

		System.out.println(checkMove.checkMove(board, r, c, color));
	}
}
