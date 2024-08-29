package org.slide;

import java.util.HashMap;
import java.util.Map;

/**
 * 2107. 分享 K 个糖果后独特口味的数量
 */
public class ShareCandies {

	public int shareCandies(int[] candies, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < candies.length; ++i) {
			map.merge(candies[i], 1, Integer::sum);
		}
		for (int i = 0; i < k; ++i) {
			Integer i1 = map.get(candies[i]);
			if (i1 == 1){
				map.remove(candies[i]);
			} else {
				map.put(candies[i], i1 - 1);
			}
		}
		int ans = map.size();
		for (int i = k; i < candies.length; ++i) {
			map.merge(candies[i - k], 1, Integer::sum);
			Integer i1 = map.get(candies[i]);
			if (i1 == 1) {
				map.remove(candies[i]);
			} else {
				map.put(candies[i], i1 - 1);
			}
			ans = Math.max(ans, map.size());
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
