package org.hypnos;

import java.util.HashMap;
import java.util.Map;

/**
 * 2981. 找出出现至少三次的最长特殊子字符串 I - 暴力
 */
public class MaximumLength {

	public int maximumLength(String s) {
		int ans = -1;
		char[] sArr = s.toCharArray();
		int n = sArr.length;
		for (int window = n - 1; window >= 1; --window) {
			Map<String, Integer> map = new HashMap<>();
			for (int i = 0; i < n - window + 1; ++i) {
				boolean flag = true;
				for (int j = i; j < i + window; ++j) {
					if (sArr[i] != sArr[j]) {
						flag = false;
						break;
					}
				}
				if (flag)
					map.merge(s.substring(i, i + window), 1, Integer::sum);
			}
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				if (entry.getValue() >= 3) {
					return window;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		String s = "cccerrrecdcdccedecdcccddeeeddcdcddedccdceeedccecde";
		MaximumLength maximumLength = new MaximumLength();
		System.out.println(maximumLength.maximumLength(s));
	}
}
