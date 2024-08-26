package org.hypnos;


/**
 * 1456. 定长子串中元音的最大数目
 */
public class MaxVowels {

    public int maxVowels(String s, int k) {
		char[] arr = s.toCharArray();
		int len = s.length();
		int tmpAns = 0;
		for (int i = 0; i < k; ++i) {
			char c = arr[i];
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				tmpAns++;
			}
		}
		int ans = tmpAns;
		for (int i = k; i < len; ++i) {
			int c = arr[i];
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				tmpAns++;
			}
			int ck = arr[i - k];
			if (ck == 'a' || ck == 'e' || ck == 'i' || ck == 'o' || ck == 'u') {
				tmpAns--;
			}
			ans = Math.max(ans, tmpAns);
		}
		return ans;
    }
}
