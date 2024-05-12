package org.hypnos;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yuanrui
 */
public class FindPermutationDifference {

	public int findPermutationDifference(String s, String t) {
		Map<Character, Integer> tMap = new HashMap<>();
		char[] charArrayt = t.toCharArray();
		char[] charArrays = s.toCharArray();
		int ans = 0;
		for (int i = 0; i < charArrayt.length; i++) {
			tMap.put(charArrayt[i], i);
		}

		for (int i = 0; i < charArrays.length; i++) {
			ans += Math.abs(i - tMap.get(charArrays[i]));
		}
		return ans;
	}

	public static void main(String[] args) {

		int permutationDifference = new FindPermutationDifference().findPermutationDifference("rwohu", "rwuoh");
		System.out.println(
				permutationDifference
		);
	}
}
