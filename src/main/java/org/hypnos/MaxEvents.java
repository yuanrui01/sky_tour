package org.hypnos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 1353. 最多可以参加的会议数目
 */
public class MaxEvents {

	public int maxEvents(int[][] events) {
		int mx = 0;
		for (int[] e : events) {
			mx = Math.max(mx, e[1]);
		}

		// 按照开始时间分组
		List<Integer>[] groups = new ArrayList[mx + 1];
		Arrays.setAll(groups, i -> new ArrayList<>());
		for (int[] e : events) {
			groups[e[0]].add(e[1]);
		}

		int ans = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i <= mx; i++) {
			// 删除过期会议
			while (!pq.isEmpty() && pq.peek() < i) {
				pq.poll();
			}
			// 新增可以参加的会议
			for (int endDay : groups[i]) {
				pq.offer(endDay);
			}
			// 参加一个结束时间最早的会议
			if (!pq.isEmpty()) {
				ans++;
				pq.poll();
			}
		}
		return ans;
	}
}
