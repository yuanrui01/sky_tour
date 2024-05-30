package org.hypnos;

import java.util.HashMap;
import java.util.Map;

/**
 * 2107. 分享 K 个糖果后独特口味的数量
 */
public class ShareCandies {

	public int shareCandies(int[] candies, int k) {
		// 先算出不分享的总值
		int totalCount = 0;
		Map<Integer, Integer> totalMap = new HashMap<>();
		for (int candy : candies) {
			totalMap.merge(candy, 1, Integer::sum);
			if (totalMap.get(candy) == 1)
				totalCount++;
		}
		// 初始窗口占用
		for (int i = 0; i < k; ++i) {
			int key = candies[i];
			Integer value = totalMap.get(key);
			if (value == 1)
				totalMap.remove(key);
			else
				totalMap.put(key, value - 1);
		}
		int ans =  totalMap.size();

		for (int i = k ; i < candies.length; ++i) {
			int key = candies[i];
			Integer value = totalMap.get(key);
			if (value == 1) {
				totalMap.remove(key);
			} else {
				totalMap.put(key, value - 1);
			}
			totalMap.merge(candies[i - k], 1, Integer::sum);
			ans = Math.max(ans, totalMap.size());
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] candies ={3,2,2,1,1};
		int k = 4;
		ShareCandies shareCandies = new ShareCandies();
		System.out.println(shareCandies.shareCandies(candies, k));
	}
}
