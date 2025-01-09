package org.hypnos;

/**
 * 3297. 统计重新排列后包含另一个字符串的子字符串数目 I
 */
public class ValidSubstringCount {


	public long validSubstringCount(String word1, String word2) {
		long ans = 0L;
		int len1 = word1.length();
		int len2 = word2.length();
		if (len1 < len2) return ans;

		char[] ca1 = word1.toCharArray();
		char[] ca2 = word2.toCharArray();
		int[] process = new int[26];
		int[] target = new int[26];
		for (char c : ca2) {
			target[c - 'a']++;
		}
		for (int i = 0; i < len2 - 1; ++i) {
			process[ca1[i] - 'a']++;
		}
		int left = 0;
		int right = len2 - 2;
		while (left < len1) {
			while (right + 1 < len1 && !check(process, target)) {
				right++;
				process[ca1[right] - 'a']++;
			}
			if (check(process, target)) {
				ans += (len1 - right);
			}
			process[ca1[left++] - 'a']--;
		}
		return ans;
	}

	boolean check(int[] process, int[] target) {
		for (int i = 0; i < 26; ++i) {
			if (target[i] > process[i]) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String word1 = "abcabc";
		String word2 = "abc";
		ValidSubstringCount validSubstringCount = new ValidSubstringCount();
		System.out.println(validSubstringCount.validSubstringCount(word1, word2));
	}
}
