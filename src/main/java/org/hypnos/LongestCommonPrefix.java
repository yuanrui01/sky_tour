package org.hypnos;

/**
 * 14. 最长公共前缀
 */
public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
		String str0 = strs[0];
		for (int i = 0; i < str0.length(); ++i) {
			char c = str0.charAt(i);
			for (String str : strs) {
				if (str.length() == i || str.charAt(i) != c) {
					return str.substring(0, i);
				}
			}
		}
		return str0;
	}


	public static void main(String[] args) {
		LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
		String[] strs = {"flower","flow","flight"};
		System.out.println(longestCommonPrefix.longestCommonPrefix(strs));
	}
}
