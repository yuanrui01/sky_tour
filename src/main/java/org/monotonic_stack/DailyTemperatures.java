package org.monotonic_stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 739. 每日温度
 */
public class DailyTemperatures {


	public int[] dailyTemperatures(int[] temperatures) {
		int[] ans = new int[temperatures.length];
		Deque<int[]> queue = new LinkedList<>();
		for (int i = 0; i < temperatures.length; ++i) {
			while (!queue.isEmpty() && queue.getLast()[1] < temperatures[i]) {
				int[] pop = queue.removeLast();
				ans[pop[0]] = i - pop[0];
			}
			queue.add(new int[]{i, temperatures[i]});
		}
		while (!queue.isEmpty()) {
			int[] pop = queue.removeLast();
			ans[pop[0]] = 0;
		}
		return ans;
	}


	public static void main(String[] args) {
		int[] temp = {73,74,75,71,69,72,76,73};
		DailyTemperatures dailyTemperatures = new DailyTemperatures();
		System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures(temp)));
	}
}
