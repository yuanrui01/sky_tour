package org.hypnos;

/**
 * LCP 61. 气温变化趋势
 */
public class TemperatureTrend {

	public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
		int n = temperatureB.length - 1;
		int[] delta1 = new int[n];
		int[] delta2 = new int[n];
		for (int i = 0; i < n; ++i) {
			delta1[i] = Integer.compare(temperatureA[i], temperatureA[i + 1]);
			delta2[i] = Integer.compare(temperatureB[i], temperatureB[i + 1]);
		}
		int ans = 0;
		int index= 0;
		while (index < n) {
			int count = 0;
			while (index < n && delta1[index] == delta2[index]) {
				index++;
				count++;
			}
			ans = Math.max(ans, count);
			index++;
		}
		return ans;
	}
}
