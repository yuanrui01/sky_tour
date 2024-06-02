package org.hypnos;

import java.util.ArrayList;
import java.util.List;

/**
 * 2024. 考试的最大困扰度
 */
public class MaxConsecutiveAnswers {

	public int maxConsecutiveAnswers(String answerKey, int k) {
		int ans = 0;
		int n = answerKey.length();
		char[] arr = answerKey.toCharArray();
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			char c = arr[i];
			int mark = i;
			while (i + 1 < n && arr[i + 1] == c) {
				++i;
			}
			list.add(new int[]{c, i - mark + 1});
		}

		return ans;
	}
}
