package org.hypnos;

/**
 * 2145. 统计隐藏数组数目
 */
public class NumberOfArrays {

	public int numberOfArrays(int[] differences, int lower, int upper) {
		long sum = 0, min = 0, max = 0;
		for (int d : differences) {
			sum += d;
			min = Math.min(min, sum);
			max = Math.max(max, sum);
		}
		return Math.max((int)(upper - lower + min - max + 1), 0);
	}
}
