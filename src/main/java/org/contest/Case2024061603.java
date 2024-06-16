package org.contest;

import java.util.*;

/**
 * @author: yuanrui
 */
public class Case2024061603 {

	public long maximumTotalDamage(int[] power) {
		Map<Integer, Integer> countMap = new HashMap<>();
		for (int p : power) {
			countMap.put(p, countMap.getOrDefault(p, 0) + 1);
		}

		// 获取所有的不同伤害值，并排序
		List<Integer> keys = new ArrayList<>(countMap.keySet());
		Collections.sort(keys);

		int n = keys.size();
		long[] dp = new long[n];

		for (int i = 0; i < n; i++) {
			int damage = keys.get(i);
			long currentSum = (long)damage * countMap.get(damage);
			dp[i] = currentSum;
			if (i > 0) {
				dp[i] = Math.max(dp[i], dp[i - 1]);
			}
			for (int j = i - 1; j >= 0; j--) {
				int previousDamage = keys.get(j);
				if (previousDamage <= damage - 3) {
					dp[i] = Math.max(dp[i], currentSum + dp[j]);
					break;
				}
			}
		}
		return dp[n - 1];

	}

	public static void main(String[] args) {
		Case2024061603 case2024061603 = new Case2024061603();
		int[] power = new int[]{7,1,6,6};
		System.out.println(case2024061603.maximumTotalDamage(power));
	}
}
