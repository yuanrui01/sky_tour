package org.contest;

import java.util.*;

/**
 * @author: yuanrui
 */
public class Cas91 {

	public int maxScore(List<List<Integer>> grid) {
		int m = grid.size();
		Set<Integer> usedValues = new HashSet<>();
		int totalScore = 0;
		for (int i = 0; i < m; i++) {
			List<Integer> row = grid.get(i);
			List<Integer> sortedRow = new ArrayList<>(row);
			sortedRow.sort(Collections.reverseOrder());
			for (int value : sortedRow) {
				if (!usedValues.contains(value)) {
					usedValues.add(value);
					totalScore += value;
					break;
				}
			}
		}
		return totalScore;
	}

	// 检查 grid[i][j] 在前 i-1 行中是否是唯一的
	private boolean isUnique(List<List<Integer>> grid, int row, int col, int prevCol) {
		for (int r = 0; r < row; r++) {
			if (grid.get(r).contains(grid.get(row).get(col))) {
				return false;
			}
		}
		return true;
	}

	static class SegmentTree {
		private int[] tree;
		private int n;

		public SegmentTree(int[] nums) {
			n = nums.length;
			tree = new int[4 * n];
			build(nums, 0, 0, n - 1);
		}

		private void build(int[] nums, int node, int start, int end) {
			if (start == end) {
				tree[node] = nums[start];
			} else {
				int mid = (start + end) / 2;
				build(nums, 2 * node + 1, start, mid);
				build(nums, 2 * node + 2, mid + 1, end);
				tree[node] = tree[2 * node + 1] ^ tree[2 * node + 2];
			}
		}

		public int query(int L, int R) {
			return query(0, 0, n - 1, L, R);
		}

		private int query(int node, int start, int end, int L, int R) {
			if (R < start || end < L) {
				return 0; // Out of range
			}
			if (L <= start && end <= R) {
				return tree[node]; // Within range
			}
			int mid = (start + end) / 2;
			int leftQuery = query(2 * node + 1, start, mid, L, R);
			int rightQuery = query(2 * node + 2, mid + 1, end, L, R);
			return leftQuery ^ rightQuery; // Combine results
		}
	}

	public int[] maximumSubarrayXor(int[] nums, int[][] queries) {
		int q = queries.length;
		int[] result = new int[q];
		SegmentTree segmentTree = new SegmentTree(nums);
		for (int i = 0; i < q; i++) {
			int li = queries[i][0];
			int ri = queries[i][1];
			result[i] = getMaxXorValue(segmentTree, li, ri);
		}

		return result;
	}

	private int getMaxXorValue(SegmentTree segmentTree, int li, int ri) {
		int maxXor = Integer.MIN_VALUE;
		for (int start = li; start <= ri; start++) {
			int currentXor = 0;
			for (int end = start; end <= ri; end++) {
				currentXor ^= segmentTree.query(start, end);
				maxXor = Math.max(maxXor, currentXor);
			}
		}
		return maxXor;
	}


	public static void main(String[] args) {
		List<List<Integer>> lists = List.of(List.of(1, 2, 3), List.of(4, 3, 2), List.of(1, 1, 1));
		List<List<Integer>> lists1 = List.of(List.of(8, 7, 6), List.of(8, 3, 2));
		List<List<Integer>> grid = List.of(
				List.of(5),
				List.of(7),
				List.of(19),
				List.of(5)
		);


		Cas91 cas91 = new Cas91();
//		System.out.println(cas91.maxScore(lists));
//		System.out.println(cas91.maxScore(lists1));
		System.out.println(cas91.maxScore(grid));
	}
}
