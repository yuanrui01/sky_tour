package org.hypnos;

/**
 * @author: yuanrui
 */
public class CanCompleteCircuit {

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int ans = 0;
		int cal = 0;
		int min = 0;
		int n = gas.length;
		for (int i = 0; i < n; ++i) {
			cal += gas[i] - cost[i];
			if (cal < min) {
				ans = i + 1;
				min = cal;
			}
		}
		return cal < 0 ? -1 : ans;
	}
}
