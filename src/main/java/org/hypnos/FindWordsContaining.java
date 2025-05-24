package org.hypnos;

import java.util.ArrayList;
import java.util.List;

/**
 * 2942. 查找包含给定字符的单词
 */
public class FindWordsContaining {

	public List<Integer> findWordsContaining(String[] words, char x) {
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < words.length; ++i) {
			String word = words[i];
			for (int j = 0; j < word.length(); ++j) {
				if (word.charAt(j) == x) {
					ans.add(i);
					break;
				}
			}
		}

		return ans;
	}

}
