package org.contest;

/**
 * @author: yuanrui
 */
public class Case2024092203 {

	public long validSubstringCount(String word1, String word2) {
		int[] countWord2 = new int[26];
		for (char c : word2.toCharArray()) {
			countWord2[c - 'a']++;
		}
		long result = 0;
		int[] countWindow = new int[26];
		int left = 0;
		int required = 0;
		int matched = 0;
		for (int count : countWord2) {
			if (count > 0) required++;
		}
		for (int right = 0; right < word1.length(); right++) {
			char rightChar = word1.charAt(right);
			countWindow[rightChar - 'a']++;
			if (countWindow[rightChar - 'a'] == countWord2[rightChar - 'a']) {
				matched++;
			}
			while (matched == required) {
				result += (word1.length() - right);
				char leftChar = word1.charAt(left);
				countWindow[leftChar - 'a']--;
				if (countWindow[leftChar - 'a'] < countWord2[leftChar - 'a']) {
					matched--;
				}
				left++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Case2024092203 case2024092203 = new Case2024092203();
		String word1  = "bcca";
		String word2 = "abc";

		System.out.println(case2024092203.validSubstringCount(word1, word2));
	}
}
