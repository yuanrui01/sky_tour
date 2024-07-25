package org.hypnos;

import java.util.*;

/**
 * 2766. 重新放置石块
 */
public class RelocateMarbles {

	public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
		Set<Integer> set = new HashSet<>(nums.length);
		for (int num : nums)
			set.add(num);
		int i = 0;
		int len = moveFrom.length;
		while (i < len) {
			if (moveFrom[i] != moveTo[i]) {
				set.remove(moveFrom[i]);
				set.add(moveTo[i]);
			}
			++i;
		}
		List<Integer> ans = new ArrayList<>(set);
		Collections.sort(ans);
		return ans;
	}
}
