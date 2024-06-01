package org.hypnos;

/**
 * 2730. 找到最长的半重复子字符串
 */
public class LongestSemiRepetitiveSubstring {

	public int longestSemiRepetitiveSubstring(String s) {
		int n = s.length();
		if (n <= 2)
			return n;
		char[] arr = s.toCharArray();
		int ans = 1;
		int left = 0;
		int right = 0;
		int preRepeatIndex = -1;
		while (right < n) {
			while (right + 1 < n && arr[right] != arr[right + 1])
				right++;
			ans = Math.max(ans, right - left + 1);
			if (preRepeatIndex != -1)
				left = Math.max(left, preRepeatIndex);
			preRepeatIndex = right + 1;
			right++;
		}
		return ans;
	}

	public static void main(String[] args) {

		String s = "52233";
		LongestSemiRepetitiveSubstring longestSemiRepetitiveSubstring = new LongestSemiRepetitiveSubstring();
		System.out.println(longestSemiRepetitiveSubstring.longestSemiRepetitiveSubstring(s));
	}
}
