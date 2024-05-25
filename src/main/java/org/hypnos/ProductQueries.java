package org.hypnos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2438. 二的幂数组中查询范围内的乘积 - 暴力
 */
public class ProductQueries {

	private static final int LIMIT = 1000000007;

	public int[] productQueries(int n, int[][] queries) {
		List<Long> powers = lowbit(n);
		int[] result = new int[queries.length];
		Arrays.fill(result, 1);
		for (int i = 0; i < queries.length; i++) {
			int x = queries[i][0];
			int y = queries[i][1];
			while (x <= y) {
				result[i] = (int) ((result[i] * powers.get(x++)) % LIMIT);
			}
		}
		return result;
	}

	public static List<Long> lowbit(int n) {
		List<Long > powers = new ArrayList<>();
		while (n != 0) {
			long lowbit = n & -n;
			powers.add(lowbit);
			n ^= lowbit;
		}
		return powers;
	}

	public static void main(String[] args) {
//		int n = 919;
//		int[][] queries = {{5,5},{4,4},{0,1},{1,5},{4,6},{6,6},{5,6},{0,3},{5,5},{5,6},{1,2},{3,5},{3,6},{5,5},{4,4},{1,1},{2,4},{4,5},{4,4},{5,6},{0,4},{3,3},{0,4},{0,5},{4,4},{5,5},{4,6},{4,5},{0,4},{6,6},{6,6},{6,6},{2,2},{0,5},{1,4},{0,3},{2,4},{5,5},{6,6},{2,2},{2,3},{5,5},{0,6},{3,3},{6,6},{4,4},{0,0},{0,2},{6,6},{6,6},{3,6},{0,4},{6,6},{2,2},{4,6}};
//		int[] ints = new ProductQueries().productQueries(n, queries);
//		System.out.println(Arrays.toString(ints));

//		System.out.println(minPowersOfTwo(n));

		List<Integer > list = new ArrayList<>();
		int n = 15;
		while (n != 0) {
			int lowbit = n & -n;
			list.add(lowbit);
			n ^= lowbit;
		}
		System.out.println(list);
	}
}
