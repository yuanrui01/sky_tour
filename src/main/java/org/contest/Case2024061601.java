package org.contest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yuanrui
 */
public class Case2024061601 {

	private static final int HOUR = 24;

	public long countCompleteDayPairs(int[] hours) {
		Map<Integer, Integer> remainderCount = new HashMap<>();
		int count = 0;
		for (int hour : hours) {
			int remainder = hour % HOUR;
			int complement = (HOUR - remainder) % HOUR;
			if (remainderCount.containsKey(complement)) {
				count += remainderCount.get(complement);
			}
			remainderCount.merge(remainder, 1, Integer::sum);
		}
		return count;
	}


	public static void main(String[] args) {
		Case2024061601 case2024061601 = new Case2024061601();

		int[] hours = new int[]{72,48,24,3};

		System.out.println(case2024061601.countCompleteDayPairs(hours));
	}
}
