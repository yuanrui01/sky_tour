package org.hypnos;

/**
 * 2566. 替换一个数字后的最大差值
 */
public class MinMaxDifference {

	public int minMaxDifference(int num) {
		char[] s = String.valueOf(num).toCharArray();
		char firstC = s[0];
		char firstNot9 = '.';
		for (char c : s) {
			if (c != '9') {
				firstNot9 = c;
				break;
			}
		}
		int mx = 0;
		int mn = 0;
		for (char c : s) {
			mx = (c == firstNot9 ? 9 : (c - '0')) + mx * 10;
			mn = (c == firstC ? 0 : (c-'0')) + mn * 10;
		}
		return mx - mn;
	}

	public static void main(String[] args) {
		int num = 11891;
		MinMaxDifference minMaxDifference = new MinMaxDifference();
		System.out.println(minMaxDifference.minMaxDifference(num));
	}
}
