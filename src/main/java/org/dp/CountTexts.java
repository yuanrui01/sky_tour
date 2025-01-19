package org.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 2266. 统计打字方案数
 */
public class CountTexts {

	private static final int MOD = 1_000_000_007;

	private Map<Integer, Integer> cache3 = new HashMap<>();

	private Map<Integer, Integer> cache4 = new HashMap<>();

	private static final Map<Character, Integer> cm = new HashMap<>();

	static {
		cm.put('2', 3);cm.put('3', 3);cm.put('4', 3);
		cm.put('5', 3);cm.put('6', 3);cm.put('7', 4);
		cm.put('8', 3);cm.put('9', 4);
	}

	public int countTexts(String pressedKeys) {
		char[] crr = pressedKeys.toCharArray();
		int length = crr.length;
		long result = 1;
		int index = 0;
		while (index < length) {
			char c = crr[index];
			int conc = 1;
			while (index + 1 < length && crr[index + 1] == c) {
				conc++;
				index++;
			}
			result = result * (cm.get(c) == 3 ? dp3(conc) : dp4(conc)) % MOD;
			index++;
		}
		return (int) result;
	}

	private int dp3(int n) {
		if (n == 1 || n == 0) {
			return 1;
		}
		if (cache3.get(n) != null) {
			return cache3.get(n);
		}
		int result = 0;
		for (int i = 1; i < 4; ++i) {
			if (n - i >= 0) {
				result = (result + dp3(n - i)) % MOD;
			}
		}
		cache3.put(n, result);
		return result;
	}

	private int dp4(int n) {
		if (n == 1 || n == 0) {
			return 1;
		}
		if (cache4.get(n) != null) {
			return cache4.get(n);
		}
		int result = 0;
		for (int i = 1; i < 5; ++i) {
			if (n - i >= 0) {
				result = (result + dp4(n - i)) % MOD;
			}
		}
		cache4.put(n, result);
		return result;
	}

	public static void main(String[] args) {
		String pressedKeys = "222222222222222222222222222222222222";
		CountTexts countTexts = new CountTexts();
		System.out.println(countTexts.countTexts(pressedKeys));
	}
}
