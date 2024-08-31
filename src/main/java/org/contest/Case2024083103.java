package org.contest;

import java.util.*;

/**
 * @author: yuanrui
 */
public class Case2024083103 {

	public long countGoodIntegers(int n, int k) {
		long[][][] dp = new long[n + 1][k][1 << 10];
		dp[0][0][0] = 1;
		for (int length = 0; length < n; length++) {
			for (int mod = 0; mod < k; mod++) {
				for (int mask = 0; mask < (1 << 10); mask++) {
					if (dp[length][mod][mask] > 0) {
						for (int digit = 0; digit < 10; digit++) {
							if (length == 0 && digit == 0) continue;
							int newMod = (mod * 10 + digit) % k;
							int newMask = mask ^ (1 << digit);
							dp[length + 1][newMod][newMask] += dp[length][mod][mask];
						}
					}
				}
			}
		}

		long count = 0;
		for (int mask = 0; mask < (1 << 10); mask++) {
			if (isValidKPalindrome(mask, n, k)) {
				count += dp[n][0][mask];
			}
		}
		return count;
	}

	private static boolean isValidKPalindrome(int mask, int n, int k) {
		int oddCount = 0;
		for (int i = 0; i < 10; i++) {
			if ((mask & (1 << i)) != 0) {
				oddCount++;
			}
		}
		return oddCount <= k && (n - oddCount) % 2 == 0;
	}

	public static void main(String[] args) {
		Case2024083103 case2024083103 = new Case2024083103();
		int n = 3;
		int k = 5;
		System.out.println(case2024083103.countGoodIntegers(n, k));
	}
}
