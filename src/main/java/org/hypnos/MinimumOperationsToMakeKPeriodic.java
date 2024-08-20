package org.hypnos;

import java.util.HashMap;
import java.util.Map;

/**
 * 3137. K 周期字符串需要的最少操作次数
 */
public class MinimumOperationsToMakeKPeriodic {


	public int minimumOperationsToMakeKPeriodic(String word, int k) {
		int n = word.length();
		int mx = 1;
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i <= n - k; i += k) {
			String sub = word.substring(i, i + k);
			Integer count = map.get(sub);
			if (count == null) {
				map.put(sub, 1);
			} else {
				map.put(sub, ++count);
				mx = Math.max(mx, count);
			}
		}
		return n / k - mx;
	}

	public static void main(String[] args) {
		String word = "leetcodeleet";
		int k = 4;
		MinimumOperationsToMakeKPeriodic minimumOperationsToMakeKPeriodic = new MinimumOperationsToMakeKPeriodic();
		System.out.println(minimumOperationsToMakeKPeriodic.minimumOperationsToMakeKPeriodic(word,k));
	}
}
