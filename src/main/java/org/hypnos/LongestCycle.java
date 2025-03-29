package org.hypnos;

/**
 * 2360. 图中的最长环
 */
public class LongestCycle {

	public int longestCycle(int[] edges) {
		int ans = 0;
		int n = edges.length;
		int[] visTime = new int[n];
		int curTime = 1;
		for (int i = 0; i < n; ++i) {
			int x = i;
			int startTime = curTime;
			while (x != -1 && visTime[x] >= 0) {
				visTime[x] = curTime++;
				x = edges[x];
			}
			if (x != - 1 && visTime[x] >= startTime) {
				ans = Math.max(ans, curTime - visTime[x]);
			}
		}

		return ans;
	}
}
