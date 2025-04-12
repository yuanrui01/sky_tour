package org.hypnos;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 3272. 统计好整数的数目
 */
public class CountGoodIntegers {

	public long countGoodIntegers(int n, int k) {
		int[] factorial = new int[n + 1];
		factorial[0] = 1;
		for (int i = 1; i <= n; i++) {
			factorial[i] = factorial[i - 1] * i;
		}

		long ans = 0;
		Set<String> vis = new HashSet<>();
		int base = (int) Math.pow(10, (n - 1) / 2);
		for (int i = base; i < base * 10; i++) { // 枚举回文数左半边
			String s = Integer.toString(i);
			s += new StringBuilder(s).reverse().substring(n % 2);
			if (Long.parseLong(s) % k > 0) { // 回文数不能被 k 整除
				continue;
			}

			char[] sortedS = s.toCharArray();
			Arrays.sort(sortedS);
			if (!vis.add(new String(sortedS))) { // 不能重复统计
				continue;
			}

			int[] cnt = new int[10];
			for (char c : sortedS) {
				cnt[c - '0']++;
			}
			int res = (n - cnt[0]) * factorial[n - 1];
			for (int c : cnt) {
				res /= factorial[c];
			}
			ans += res;
		}
		return ans;
	}
}
