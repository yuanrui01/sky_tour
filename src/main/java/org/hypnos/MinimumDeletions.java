package org.hypnos;

import java.util.Arrays;

/**
 * 3085. 成为 K 特殊字符串需要删除的最少字符数
 */
public class MinimumDeletions {

	public int minimumDeletions(String word, int k) {
		final int SIGMA = 26;
		int[] cnt = new int[SIGMA];
		for (char c : word.toCharArray()) {
			cnt[c - 'a']++;
		}
		Arrays.sort(cnt);

		int maxSave = 0;
		int s = 0;
		int right = 0;
		for (int base : cnt) {
			while (right < SIGMA && cnt[right] <= base + k) {
				s += cnt[right];
				right++;
			}
			// 现在 s 表示出现次数不变的字母个数之和
			// 再加上出现次数减少为 base+k 的 SIGMA-right 种字母，即为保留的字母总数
			maxSave = Math.max(maxSave, s + (base + k) * (SIGMA - right));
			// 下一轮循环 base 全删
			s -= base;
		}

		return word.length() - maxSave;
	}
}
