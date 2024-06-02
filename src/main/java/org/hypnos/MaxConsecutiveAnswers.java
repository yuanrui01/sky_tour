package org.hypnos;

/**
 * 2024. 考试的最大困扰度
 */
public class MaxConsecutiveAnswers {

	public int maxConsecutiveAnswers(String answerKey, int k) {
		char[] arr = answerKey.toCharArray();
		int ans = 0;
		int tLeft = 0, fLeft = 0, right = 0;
		int tCount = 0, fCount = 0;
		while (right < arr.length) {
			if ('T' == arr[right])
				tCount++;
			else
				fCount++;
			while (tCount > k) {
				if (arr[tLeft] == 'T')
					tCount--;
				tLeft++;
			}
			while (fCount > k) {
				if (arr[fLeft] == 'F')
					fCount--;
				fLeft++;
			}
			ans = Math.max(ans, Math.max(Math.max(ans, right - tLeft + 1), Math.max(ans, right - fLeft + 1)));
			right++;
		}
		return ans;
	}
}
