package org.hypnos;

import java.util.HashMap;
import java.util.Map;

/**
 * 1922. 统计好数字的数目
 */
public class CountGoodNumbers {

	private long MOD = 1_000_000_007;

	public int countGoodNumbers(long n) {
		Map<Long, Long> cache = new HashMap<>();
		return (int) dfs(n, cache);
	}

	public long dfs(long n, Map<Long, Long> cache) {
		if (n == 1L) return 5L;
		if (n == 2L) return 20L;
		if (cache.get(n) != null) return cache.get(n);
		long l1 = n / 2;
		if (l1 % 2 != 0) l1++;
		long l2 = n - l1;
		long a1 = dfs(l1, cache);
		long a2 = dfs(l2, cache);
		long a3 = (a1*a2) % MOD;
		cache.put(n, a3);
		return a3;
	}

	public static void main(String[] args) {
		CountGoodNumbers countGoodNumbers = new CountGoodNumbers();

		System.out.println(countGoodNumbers.countGoodNumbers(806166225460393L));
	}
}
