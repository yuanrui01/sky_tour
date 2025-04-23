package org.hypnos;

import java.util.HashMap;
import java.util.Map;

/**
 * 1399. 统计最大组的数目
 */
public class CountLargestGroup {

	public int countLargestGroup(int n) {
		Map<Integer, Integer> bitSum = new HashMap<>();
		int max = 0;
		for (int i = 1; i <= n; ++i) {
			int s = 0;
			int t = i;
			while (t != 0) {
				s += t % 10;
				t /= 10;
			}
			max = Math.max(bitSum.merge(s, 1, Integer::sum), max);
		}
		int cnt = 0;
		for (Integer v : bitSum.values()) {
			if (v == max) cnt++;
		}
		return cnt;
	}


	public static void main(String[] args) {
		CountLargestGroup countLargestGroup = new CountLargestGroup();
		System.out.println(countLargestGroup.countLargestGroup(13));
	}
}
