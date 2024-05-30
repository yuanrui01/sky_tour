package org.hypnos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1852. 每个子数组的数字种类数
 */
public class DistinctNumbers {

	public int[] distinctNumbers(int[] nums, int k) {
		int n = nums.length;
		int[] ans =  new int[n - k + 1];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < k; ++i) {
			map.merge(nums[i], 1, Integer::sum);
		}
		ans[0] = map.size();
		for (int i = k; i < n; ++i) {
			map.merge(nums[i], 1, Integer::sum);
			Integer imk = map.get(nums[i - k]);
			if (imk == 1)
				map.remove(nums[i - k]);
			else
				map.put(nums[i - k], imk - 1);
			ans[i - k + 1] = map.size();
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = {1,2,3,2,2,1,3};
		int k = 3;
		DistinctNumbers distinctNumbers = new DistinctNumbers();
		int[] ints = distinctNumbers.distinctNumbers(nums, k);
		System.out.println(Arrays.toString(ints));
	}
}
