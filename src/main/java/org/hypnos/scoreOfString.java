package org.hypnos;

/**
 * 3110. 字符串的分数
 */
public class scoreOfString {

	public int scoreOfString(String s) {
		int ans = 0;
		for (int i = 1; i < s.length(); ++i) {
			ans += Math.abs(s.charAt(i) - s.charAt(i-1));
		}
		return ans;
	}
}
