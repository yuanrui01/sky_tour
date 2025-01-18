package org.hypnos;

/**
 * 14. 最长公共前缀
 */
public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
		int length = Integer.MAX_VALUE;
		for (String str : strs) {
			length = Math.min(length, str.length());
		}
		int ans = 0;
		tag:
		for (int i = 0; i < length; ++i) {
			char c = strs[0].charAt(i);
			for (int j = 1; j < strs.length; ++j) {
				if (strs[j].charAt(i) != c) {
					break tag;
				}
			}
			ans++;
		}
		return ans > 0 ? strs[0].substring(0, ans) : "";
	}


	public static void main(String[] args) {
		LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
		String[] strs = {"flower","flow","flight"};
		System.out.println(longestCommonPrefix.longestCommonPrefix(strs));
	}
}
