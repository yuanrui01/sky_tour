package org.hypnos;

import java.util.ArrayList;
import java.util.List;

/**
 * 2610. 转换二维数组
 */
public class FindMatrix {

	public List<List<Integer>> findMatrix(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		int[] count = new int[nums.length + 1];
		for (int num : nums) {
			count[num]++;
		}
		while (true) {
			List<Integer> list = new ArrayList<>();
			for (int i = 1; i < count.length; ++i) {
				if (count[i] > 0) {
					list.add(i);
					count[i]--;
				}
			}
			if (!list.isEmpty()) {
				ans.add(list);
			} else {
				break;
			}
		}
		return ans;
	}
}
