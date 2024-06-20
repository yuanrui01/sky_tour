package org.ds;

import java.util.HashMap;
import java.util.Map;

/**
 * 1814. 统计一个数组中好对子的数目
 */
public class CountNicePairs {

	private static final int LIMIT = 1_000_000_007;
	public int countNicePairs(int[] nums) {
		int ans = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			int index = (num - rev(num)) % LIMIT;
			Integer count = map.get(index);
			if (count != null) {
				ans = (ans + count) % LIMIT;
				map.put(index, count + 1);
			} else {
				map.put(index, 1);
			}
		}
		return ans;
	}

	// 逆序数，好好记
	private int rev(int num) {
		if (num == 0) return 0;
		int newN = 0;
		while (num != 0) {
			newN = 10 * newN + (num % 10) ;
			num /= 10;
		}
		return newN;
	}

	public static void main(String[] args) {
		int[] nums = {352171103,442454244,42644624,152727101,413370302,293999243};
		CountNicePairs countNicePairs = new CountNicePairs();
		System.out.println(countNicePairs.countNicePairs(nums));
	}
}
