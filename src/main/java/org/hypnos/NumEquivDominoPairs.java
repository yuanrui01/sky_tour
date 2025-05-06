package org.hypnos;

/**
 * 1128. 等价多米诺骨牌对的数量
 */
public class NumEquivDominoPairs {

	public int numEquivDominoPairs(int[][] dominoes) {
		int ans = 0;
		int[][] count = new int[10][10];
		boolean[][] flag = new boolean[10][10];
		for (int[] domino : dominoes) {
			count[domino[0]][domino[1]]++;
		}
		for (int i = 0; i < 10; ++i) {
			for (int j = 0; j < 10; ++j) {
				int c = 0;
				if (!flag[i][j]) {
					c += count[i][j];
					flag[i][j] = true;
				}
				if (!flag[j][i]) {
					c += count[j][i];
					flag[j][i] = true;
				}
				if (c > 1) {
					ans += c * (c - 1) / 2;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[][] dominoes = {{2,1},{5,4},{3,7},{6,2},{4,4},{1,8},{9,6},{5,3},{7,4},{1,9},{1,1},{6,6},{9,6},{1,3},{9,7},{4,7},{5,1},{6,5},{1,6},{6,1},{1,8},{7,2},{2,4},{1,6},{3,1},{3,9},{3,7},{9,1},{1,9},{8,9}};
		NumEquivDominoPairs numEquivDominoPairs = new NumEquivDominoPairs();
		System.out.println(numEquivDominoPairs.numEquivDominoPairs(dominoes));
	}
}
