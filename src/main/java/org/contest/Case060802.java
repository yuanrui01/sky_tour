package org.contest;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author: yuanrui
 */
public class Case060802 {

	static class Node {
		public int index;
		public int val;

		Node(int index, int val) {
			this.index = index;
			this.val = val;
		}
	}

	public int findWinningPlayer(int[] skills, int k) {
		int n = skills.length;
		if (k >= n - 1) {
			int ans = skills[0];
			int maxIndex = 0;
			for (int i = 0; i < n; i++) {
				if (skills[i] > ans) {
					ans = skills[i];
					maxIndex = i;
				}
			}
			return maxIndex;
		}
		// 此时k 小于n,进行模拟

		ArrayDeque<Node> queue = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			queue.add(new Node(i, skills[i]));
		}

		int count = 0;
		while (count < k) {
			Node i1 = queue.poll();
			Node i2 = queue.poll();
			if (i1.val > i2.val) {
				queue.addFirst(i1);
				queue.offer(i2);
				count++;
			} else {
				queue.addFirst(i2);
				queue.offer(i1);
				count = 1;
			}
		}
		return queue.poll().index;
	}


	public static void main(String[] args) {
		int[] skill = {11,9,12,2,20,1,8};
		int k = 3;
		Case060802 case060802 = new Case060802();
		System.out.println(case060802.findWinningPlayer(skill, k));
	}
}
