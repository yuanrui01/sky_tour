package org.contest;

import java.util.PriorityQueue;

/**
 * @author: yuanrui
 */
public class Case2024082501 {

	public int[] getFinalState(int[] nums, int k, int multiplier) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> {
			if (nums[a] == nums[b]) return Integer.compare(a, b);
			return Integer.compare(nums[a], nums[b]);
		});
		for (int i = 0; i < nums.length; i++) {
			minHeap.offer(i);
		}
		for (int i = 0; i < k; i++) {
			int index = minHeap.poll();
			nums[index] *= multiplier;
			minHeap.offer(index);
		}
		return nums;
	}

	public static void main(String[] args) {
		Case2024082501 case2024082501 = new Case2024082501();


	}
}
