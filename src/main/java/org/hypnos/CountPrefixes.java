package org.hypnos;

/**
 * 2255. 统计是给定字符串前缀的字符串数目
 */
public class CountPrefixes {

	public int countPrefixes(String[] words, String s) {
		int cnt = 0;
		for (String word : words) {
			if (s.startsWith(word)) {
				cnt++;
			}
		}
		return cnt;
	}
}
