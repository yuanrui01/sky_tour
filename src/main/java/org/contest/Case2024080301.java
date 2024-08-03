package org.contest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yuanrui
 */
public class Case2024080301 {

	public int winningPlayerCount(int n, int[][] pick) {
		int ans = 0;
		Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
		for (int[] ints : pick) {
			Map<Integer, Integer> integerIntegerMap = map.get(ints[0]);
			if (integerIntegerMap == null) {
				integerIntegerMap = new HashMap<>();
				integerIntegerMap.put(ints[1], 1);
				map.put(ints[0], integerIntegerMap);
			} else {
				integerIntegerMap.merge(ints[1], 1, Integer::sum);
			}
		}
		for (Map.Entry<Integer, Map<Integer, Integer>> integerMapEntry : map.entrySet()) {
			Integer key = integerMapEntry.getKey();
			Map<Integer, Integer> value = integerMapEntry.getValue();
			for (Integer i : value.values()) {
				if (i > key) {
					ans++;
					break;
				}
			}
		}
		return ans;
	}
}
