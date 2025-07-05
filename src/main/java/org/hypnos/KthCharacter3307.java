package org.hypnos;

/**
 * 3307. 找出第 K 个字符 II
 */
public class KthCharacter3307 {

	public char kthCharacter(long k, int[] operations) {
		k--;
		int inc = 0;
		for (int i = 63 - Long.numberOfLeadingZeros(k); i >= 0; i--) {
			inc += k >> i & operations[i];
		}
		return (char) ('a' + inc % 26);
	}
}
