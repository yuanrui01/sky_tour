package org.contest;

import java.util.*;

/**
 * @author: yuanrui
 */
public class Case2024061603 {

	public long maximumTotalDamage(int[] power) {
		Map<Integer, Integer> countMap = new HashMap<>();
		for (int p : power)
			countMap.merge(p, 1, Integer::sum);
		// 获取所有的不同伤害值，并排序
		int[] keys = countMap.keySet().stream().mapToInt(i->i).toArray();
		Arrays.sort(keys);
		int n = keys.length;
		long[] dp = new long[n];
		dp[0] = (long) keys[0] * countMap.get(keys[0]);
		for (int i = 1; i < n; i++) {
			long currentSum = (long)keys[i] * countMap.get(keys[i]);
			dp[i] = currentSum;
			dp[i] = Math.max(dp[i], dp[i - 1]);
			for (int j = i - 1; j >= 0; j--) {
				int previousDamage = keys[j];
				if (previousDamage <= keys[i] - 3) {
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
