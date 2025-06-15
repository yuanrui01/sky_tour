package org.hypnos;

/**
 * 1432. 改变一个整数能得到的最大差值
 */
public class MaxDiff {

	// 把第一个字符变成1或者把第二个字符变成0
	public int maxDiff(int num) {
		char[] s = String.valueOf(num).toCharArray();
		char firstNot9 = '.';
		char c0 = s[0];
		char cs = '.';
		for (char c : s) {
			if (c != '9' && firstNot9 == '.') {
				firstNot9 = c;
			}
			if (c != c0 && c != '0' && cs == '.') {
				cs = c;
			}
		}
		int a9 = 0;
		int a1 = 0;
		int as = 0;
		for (char c : s) {
			a9 = (c == firstNot9 ? 9 : (c - '0')) + a9 * 10;
			a1 = (c == c0 ? 1 : (c-'0')) + a1 * 10;
			as = (c == cs ? 0 : (c-'0')) + as * 10;
		}
		if (as > 0) {
			return a9 - Math.min(a1, as);
		}
		return a9 - a1;
	}

	public static void main(String[] args) {
		MaxDiff maxDiff = new MaxDiff();
		System.out.println(maxDiff.maxDiff(1101057));
	}
}
