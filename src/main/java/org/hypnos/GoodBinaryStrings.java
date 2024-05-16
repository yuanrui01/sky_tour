package org.hypnos;

/**
 * 2533. 好二进制字符串的数量
 */
public class GoodBinaryStrings {

	private static final int LIMIT = 1000000007;

	public int goodBinaryStrings(int minLength, int maxLength, int oneGroup, int zeroGroup) {
		long ans = 0;
		long[] memo = new long[maxLength + 1];
		memo[0] = 1;
		for (int i = 1; i <= maxLength; ++i) {
			long f1 = (i - zeroGroup >= 0) ? memo[i - zeroGroup] : 0;
			long f2 = (i - oneGroup >= 0) ? memo[i - oneGroup] : 0;
			memo[i] = (f1 + f2) % LIMIT;
			if (i >= minLength)
				ans = (ans + memo[i]) % LIMIT;
		}
		return (int) ans;
	}
}
