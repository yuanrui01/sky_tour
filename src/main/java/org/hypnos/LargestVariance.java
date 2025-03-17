package org.hypnos;

/**
 * 2272. 最大波动的子字符串
 */
public class LargestVariance {

	public int largestVariance(String S) {
		char[] s = S.toCharArray();
		int ans = 0;
		for (char a = 'a'; a <= 'z'; a++) {
			for (char b = 'a'; b <= 'z'; b++) {
				if (b == a) {
					continue;
				}
				int f0 = 0;
				int f1 = Integer.MIN_VALUE;
				for (char ch : s) {
					if (ch == a) {
						f0 = Math.max(f0, 0) + 1;
						f1++;
					} else if (ch == b) {
						f1 = f0 = Math.max(f0, 0) - 1;
					} // else f0 = Math.max(f0, 0); 可以留到 ch 等于 a 或者 b 的时候计算，f1 不变
					ans = Math.max(ans, f1);
				}
			}
		}
		return ans;
	}
}
