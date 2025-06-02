package org.hypnos;

/**
 * 135. 分发糖果
 */
public class Candy {

	public int candy(int[] ratings) {
		int n = ratings.length;
		int ans = n; // 先给每人分一个
		for (int i = 0; i < n; i++) {
			int start = i > 0 && ratings[i - 1] < ratings[i] ? i - 1 : i;

			// 找严格递增段
			while (i + 1 < n && ratings[i] < ratings[i + 1]) {
				i++;
			}
			int top = i; // 峰顶

			// 找严格递减段
			while (i + 1 < n && ratings[i] > ratings[i + 1]) {
				i++;
			}

			int inc = top - start; // start 到 top 严格递增
			int dec = i - top;     // top 到 i 严格递减
			ans += (inc * (inc - 1) + dec * (dec - 1)) / 2 + Math.max(inc, dec);
		}
		return ans;
	}
}
