package org.dp;

import java.util.Arrays;

/**
 * 902. 最大为 N 的数字组合
 */
public class AtMostNGivenDigitSet {

	public int atMostNGivenDigitSet(String[] digits, int n) {
		int[] is = new int[digits.length];
		for (int i = 0; i < digits.length; ++i) {
			is[i] = digits[i].charAt(0) - '0';
		}
		char[] s = Integer.toString(n).toCharArray();
		int[] memo = new int[s.length];
		Arrays.fill(memo, -1);
		return dfs(0, is, true, false, s, memo);
	}

	private int dfs(int i, int[] digits, boolean isLimit, boolean isNum, char[] s, int[] memo) {
		if (i == s.length) {
			return isNum ? 1 : 0;
		}
		if (!isLimit && isNum && memo[i] >= 0) {
			return memo[i];
		}
		int res = 0;
		if (!isNum) {
			res = dfs(i + 1, digits, false, false, s, memo);
		}
		int up = isLimit ? s[i] - '0' : 9;
		for (int d : digits) {
			if (d > up) break;
			res += dfs(i + 1, digits, isLimit && d == up, true, s, memo);
		}
		if (!isLimit && isNum) {
			memo[i] = res;
		}
		return res;
	}
}
