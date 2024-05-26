package org.hypnos;

import java.util.Arrays;

/**
 * 2028. 找出缺失的观测数据
 */
public class MissingRolls {

	public int[] missingRolls(int[] rolls, int mean, int n) {
		int m = rolls.length;
		int nm = m + n;
		int sub = nm * mean;
		for (int roll : rolls) sub -= roll;
		if (sub < n || sub > 6 * n)
			return new int[0];
		int[] result = new int[n];
		Arrays.fill(result, 1);
		sub -= n;
		for (int i = 0; i < n && sub > 0; ++i) {
			if (sub <= 5) {
				result[i] += sub;
				break;
			} else {
				result[i] += 5;
				sub -= 5;
			}
		}
		return result;
	}

	public static void main(String[] args) {

		int mean = 4;
		int n = 2;
		int[] rolls = {3,2,4,3};

		int[] ints = new MissingRolls().missingRolls(rolls, mean, n);
		System.out.println(Arrays.toString(ints));
	}
}
