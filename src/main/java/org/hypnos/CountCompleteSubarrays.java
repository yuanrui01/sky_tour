package org.hypnos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 2799. 统计完全子数组的数目
 */
public class CountCompleteSubarrays {

	public int countCompleteSubarrays(int[] nums) {
		int ans = 0;
		int n = nums.length;
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}
		int diffCount = set.size();

		int left = 0;
		int right = 0;
		Map<Integer, Integer> cnt = new HashMap<>();

		while (right < n) {
			cnt.merge(nums[right], 1, Integer::sum);
			if (cnt.size() == diffCount) {
				while (left <= right && cnt.size() == diffCount) {
					ans += (n - right);
					Integer curCnt = cnt.get(nums[left]);
					if (curCnt == 1) {
						cnt.remove(nums[left]);
					} else {
						cnt.merge(nums[left], -1, Integer::sum);
					}
					left++;
				}
			}
			right++;
		}
		return ans;
	}
}
