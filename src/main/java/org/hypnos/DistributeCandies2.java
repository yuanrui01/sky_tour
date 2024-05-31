package org.hypnos;

/**
 * 2929. 给小朋友们分糖果 II - 组合数学之容斥原理
 */
public class DistributeCandies2 {

	public long distributeCandies(int n, int limit) {
		return c2(n + 2) - 3 * c2(n - limit + 1) + 3 * c2(n - 2 * limit) - c2(n - 3 * limit -1);
	}

	private long c2(int n) {
		return n > 1 ? (long) n * (n - 1) / 2 : 0;
	}
}
