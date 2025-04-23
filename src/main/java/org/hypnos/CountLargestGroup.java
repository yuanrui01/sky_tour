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
		int ans = 0;
		for (int i = 1; i <= n; ++i) {
			int s = 0;
			int t = i;
			while (t != 0) {
				s += t % 10;
				t /= 10;
			}
			int na = bitSum.merge(s, 1, Integer::sum);
			if (na > max) {
				ans = 1;
				max = na;
			} else if (na == max) {
				ans++;
			}
		}
		return ans;
	}


	public static void main(String[] args) {
		CountLargestGroup countLargestGroup = new CountLargestGroup();
		System.out.println(countLargestGroup.countLargestGroup(13));
	}
}
