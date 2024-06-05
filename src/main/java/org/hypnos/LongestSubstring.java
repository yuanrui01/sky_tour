package org.hypnos;

/**
 * 395. 至少有 K 个重复字符的最长子串
 */
public class LongestSubstring {

	public int longestSubstring(String s, int k) {
		int n = s.length();
		if (n < k)
			return 0;
		int[] cntArr = new int[26];
		for (int i = 0; i < n; ++i)
			cntArr[s.charAt(i) - 'a']++;
		for (int i = 0; i < 26; ++i) {
			int count = cntArr[i];
			if (count > 0 && count < k) {
				int res = 0;
				for (String sub : s.split(String.valueOf(((char) (i + 'a')))))
					res = Math.max(res, longestSubstring(sub, k));
				return res;
			}
		}
		return n;
	}
}
