package org.slide;

import java.util.Arrays;

/**
 * 2067. 等计数子串的数量
 */
public class EqualCountSubstrings {


	public int equalCountSubstrings(String s, int count) {
		int ans = 0;
		int n = s.length();
		int[] sub = new int[26];
		char[] cArr = s.toCharArray();
		for (int i = 1; i <= 26; ++i) {
			int window = i * count;
			if (window > cArr.length)
				break;
			Arrays.fill(sub, 0);
			for (int j = 0; j < window; ++j) {
				sub[cArr[j] - 'a']++;
			}
			if (checkSub(sub, count))
				ans++;
			for (int j = window; j < n; ++j) {
				sub[cArr[j] - 'a']++;
				sub[cArr[j - window] - 'a']--;
				if (checkSub(sub, count))
					ans++;
			}
		}
		return ans;
	}

	private boolean checkSub(int[] sub, int count) {
		for (int i : sub) {
			if (i != 0 && i != count)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String s ="aaabcbbcc";
		int count = 3;
		EqualCountSubstrings equalCountSubstrings = new EqualCountSubstrings();
		System.out.println(equalCountSubstrings.equalCountSubstrings(s, count));
	}
}
