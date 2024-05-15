package org.hypnos;

import java.util.HashMap;
import java.util.Map;

/**
 * 2244. 完成所有任务需要的最少轮数
 */
public class MinimumRounds {

	public int minimumRounds(int[] tasks) {
		int ans = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int task : tasks)
			map.merge(task, 1, Integer::sum);
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			Integer value = entry.getValue();
			if (value >= 3) {
				int quotient = value / 3;
				int remainder = value % 3;
				ans += quotient;
				if (remainder > 0) {
					ans++;
				}
			} else if (value >= 2) {
				ans++;
			} else {
				return -1;
			}
		}
		return ans;


	}

	public static void main(String[] args) {
		MinimumRounds minimumRounds = new MinimumRounds();
		int[] task = {2,3,3};
		System.out.println(minimumRounds.minimumRounds(task));
	}
}
