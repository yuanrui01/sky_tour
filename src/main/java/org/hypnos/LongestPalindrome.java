package org.hypnos;

/**
 * 2131. 连接两字母单词得到的最长回文串
 */
public class LongestPalindrome {

	public int longestPalindrome(String[] words) {
		int[] count = new int[4500];
		int ans = 0;
		for (String word : words) {
			int a = word.charAt(0);
			int b = word.charAt(1);
			count[a * 27 + b]++;
		}
		int dc = 0;
		for (String word : words) {
			int a = word.charAt(0);
			int b = word.charAt(1);
			int k = a * 27 + b;
			if (count[k] <= 0) continue;
			int msk = b * 27 + a;
			if (a == b) dc++;
			count[k]--;
			if (count[msk] > 0) {
				ans += 4;
				if (a == b) {
					dc--;
				}
			}
			count[msk]--;
		}
		if (dc > 0) ans += 2;
		return ans;
	}

	public static void main(String[] args) {
		String[] words = {"ll","lb","bb","bx","xx","lx","xx","lx","ll","xb","bx","lb","bb","lb","bl","bb","bx","xl","lb","xx"};
		LongestPalindrome longestPalindrome = new LongestPalindrome();
		System.out.println(longestPalindrome.longestPalindrome(words));
		System.out.println((int)'a');
	}
}
