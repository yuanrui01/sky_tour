package org.hypnos;

import java.util.Arrays;
import java.util.Set;

/**
 * 2559. 统计范围内的元音字符串数
 */
public class VvowelStrings {

	private static Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

	public int[] vowelStrings(String[] words, int[][] queries) {
		int[] val = new int[words.length];
		int[] vowelsCount = new int[words.length];

		if (isVowel(words[0])) {
			vowelsCount[0] = 1;
			val[0] = 1;
		}
		for (int i = 1; i < words.length; i++) {
			vowelsCount[i] = vowelsCount[i - 1];
			if (isVowel(words[i])) {
				val[i] = 1;
				vowelsCount[i] += 1;
			}
		}

		int[] result = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			int x = queries[i][0];
			int y = queries[i][1];
			result[i] = (vowelsCount[y] - vowelsCount[x] + val[x]);
		}

		return result;
	}

	private boolean	isVowel(String word) {
		return vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length()-1));
	}

	public static void main(String[] args) {
		String[] words = {"aba","bcb","ece","aa","e"};
		int[][] queries = {{0,2}, {1,4}, {1,1}};
		int[] ints = new VvowelStrings().vowelStrings(words, queries);
		System.out.println(Arrays.toString(ints));
	}
}
