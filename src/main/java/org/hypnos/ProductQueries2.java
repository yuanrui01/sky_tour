package org.hypnos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2438. 二的幂数组中查询范围内的乘积 - 预处理
 */
public class ProductQueries2 {

	private static final int LIMIT = 1000000007;

	public int[] productQueries(int n, int[][] queries) {
		List<Integer> powers = lowbit(n);

		int m = powers.size();
		int[][] products = new int[m][m];
		for (int i = 0; i < m; i++) {
			products[i][i] = powers.get(i);
			for (int j = i + 1; j < m; j++) {
				products[i][j] = (int) ((1L * products[i][j - 1] * powers.get(j)) % LIMIT) ;
			}
		}

		int[] result = new int[queries.length];
		Arrays.fill(result, 1);
		for (int i = 0; i < queries.length; i++) {
			result[i] = products[queries[i][0]][queries[i][1]];
		}
		return result;
	}

	public static List<Integer> lowbit(int n) {
		List<Integer > powers = new ArrayList<>();
		while (n != 0) {
			int lowbit = n & -n;
			powers.add(lowbit);
			n ^= lowbit;
		}
		return powers;
	}
}
