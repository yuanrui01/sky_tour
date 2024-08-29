package org.slide;

/**
 * 1176. 健身计划评估
 * @author: yuanrui
 */
public class DietPlanPerformance {

	public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
		int ans = 0;
		int sum = 0;
		for (int i = 0; i < k; ++i) {
			sum += calories[i];
		}
		ans += getScore(sum, lower, upper);
		for (int i = k; i < calories.length; ++i) {
			sum -= calories[i - k];
			sum += calories[i];
			ans += getScore(sum, lower, upper);
		}
		return ans;
	}

	private int getScore(int x, int lower, int upper) {
		if (x > upper)
			return 1;
		if (x < lower)
			return -1;
		return 0;
	}

}
