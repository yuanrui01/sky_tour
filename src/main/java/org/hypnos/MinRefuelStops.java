package org.hypnos;

import java.util.PriorityQueue;

/**
 * 871. 最低加油次数
 */
public class MinRefuelStops {

	public int minRefuelStops(int target, int startFuel, int[][] stations) {
		int ans = 0;
		int curFuel = startFuel;
		int prePosition = 0;
		PriorityQueue<Integer> fuelHeap = new PriorityQueue<>((a, b) -> b - a);
		for (int[] station : stations) {
			int targetPosition = station[0];
			curFuel -= targetPosition - prePosition;
			while (!fuelHeap.isEmpty() && curFuel < 0) {
				curFuel += fuelHeap.poll();
				ans++;
			}
			if (curFuel < 0) return -1;
			fuelHeap.offer(station[1]);
			prePosition = targetPosition;
		}
		curFuel -= target - prePosition;
		while (!fuelHeap.isEmpty() && curFuel < 0) {
			curFuel += fuelHeap.poll();
			ans++;
		}
		return curFuel < 0 ? -1 : ans;
	}
}
