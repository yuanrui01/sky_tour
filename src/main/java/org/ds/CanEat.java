package org.ds;

import java.util.Arrays;

/**
 * 1744. 你能在你最喜欢的那天吃到你最喜欢的糖果吗？
 */
public class CanEat {

	public boolean[] canEat(int[] candiesCount, int[][] queries) {
		int qLen = queries.length;
		int cLen = candiesCount.length;
		boolean[] ans = new boolean[qLen];
		long[] preSum = new long[cLen + 1];
		preSum[0] = candiesCount[0];
		for (int i = 1; i < cLen; ++i)
			preSum[i] = preSum[i - 1] + candiesCount[i];
		for (int i = 0; i < qLen; ++i) {
			int q0 = queries[i][0];
			int q1 = queries[i][1];
			int q2 = queries[i][2];
			// 区间【x1, x2】与【x3, x4】如果有交集则为true
			long x1 = q1 + 1;
			long x2 = (long) (q1 + 1) * q2;
			long x3 = preSum[q0] - candiesCount[q0] + 1;
			long x4 = preSum[q0];
			ans[i] = !(x3 > x2 || x1 > x4);
		}
		return ans;
	}

	public static void main(String[] args) {

		CanEat canEat = new CanEat();
		int[] cCount = {7,4,5,3,8};
		int[][] queries = {{0,2,2},{4,2,4},{2,13,1000000000}};
		boolean[] booleans = canEat.canEat(cCount, queries);
		System.out.println(Arrays.toString(booleans));
	}
}
