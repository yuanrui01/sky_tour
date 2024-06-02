package org.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: yuanrui
 */
public class Case2024060202 {


	public int countDays(int days, int[][] meetings) {
		int[][] mergeTime = merge(meetings);
		int ans = days;
		for (int i = 0; i < mergeTime.length; ++i) {
			ans -= (mergeTime[i][1] - mergeTime[i][0] + 1);
		}

		return ans;
	}

	public static int[][] merge(int[][] intervals) {
		if (intervals.length <= 1) {
			return intervals;
		}
		Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

		List<int[]> merged = new ArrayList<>();
		int[] currentInterval = intervals[0];
		merged.add(currentInterval);

		for (int[] interval : intervals) {
			int currentEnd = currentInterval[1];
			int nextStart = interval[0];
			int nextEnd = interval[1];
			if (currentEnd >= nextStart) {
				currentInterval[1] = Math.max(currentEnd, nextEnd);
			} else {
				currentInterval = interval;
				merged.add(currentInterval);
			}
		}
		return merged.toArray(new int[merged.size()][]);
	}


	public static void main(String[] args) {
		int days = 6;
		int[][] meetings = {{1,6}};

		Case2024060202 case2024060202 = new Case2024060202();
		System.out.println(case2024060202.countDays(days, meetings));
	}
}
