package org.contest;

import java.util.ArrayList;
import java.util.List;

/**
 * 线段树模板
 */
public class Case2024061604 {

	class SegmentTree {
		private int[] tree;
		private int n;

		public SegmentTree(int n) {
			this.n = n;
			this.tree = new int[4 * n];
		}

		// 获取中间点
		private int getMid(int start, int end) {
			return start + (end - start) / 2;
		}

		// 构建线段树
		public void build(int[] nums) {
			buildTree(nums, 0, n - 1, 0);
		}

		// 递归构建线段树
		private void buildTree(int[] nums, int start, int end, int node) {
			if (start == end) {
				// 如果 start == end，我们在叶节点存储是否为峰值
				tree[node] = isPeak(nums, start) ? 1 : 0;
			} else {
				int mid = getMid(start, end);
				buildTree(nums, start, mid, 2 * node + 1);
				buildTree(nums, mid + 1, end, 2 * node + 2);
				tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
			}
		}

		// 检查一个位置是否是峰值
		private boolean isPeak(int[] nums, int i) {
			if (i <= 0 || i >= n - 1) return false;
			return nums[i] > nums[i - 1] && nums[i] > nums[i + 1];
		}

		// 查询区间[l, r]中的峰值数量
		public int query(int l, int r) {
			return queryRange(0, n - 1, l, r, 0);
		}

		// 递归查询
		private int queryRange(int start, int end, int l, int r, int node) {
			if (l > end || r < start) return 0; // 超出范围
			if (l <= start && r >= end) return tree[node]; // 完全包含

			int mid = getMid(start, end);
			return queryRange(start, mid, l, r, 2 * node + 1) +
					queryRange(mid + 1, end, l, r, 2 * node + 2);
		}

		// 更新某个位置的值
		public void update(int[] nums, int index, int value) {
			nums[index] = value;
			updateValue(0, n - 1, index, nums, 0);
			// 更新相邻的两个位置的峰值状态
			if (index > 0) {
				updateValue(0, n - 1, index - 1, nums, 0);
			}
			if (index < n - 1) {
				updateValue(0, n - 1, index + 1, nums, 0);
			}
		}

		// 递归更新
		private void updateValue(int start, int end, int index, int[] nums, int node) {
			if (start == end) {
				tree[node] = isPeak(nums, start) ? 1 : 0;
			} else {
				int mid = getMid(start, end);
				if (index <= mid) {
					updateValue(start, mid, index, nums, 2 * node + 1);
				} else {
					updateValue(mid + 1, end, index, nums, 2 * node + 2);
				}
				tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
			}
		}
	}

	public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
		List<Integer> ans = new ArrayList<>();
		int n = nums.length;
		SegmentTree tree = new SegmentTree(n);
		tree.build(nums);
		for (int[] query : queries) {
			if (query[0] == 1) {
				int li = query[1];
				int ri = query[2];
				if (li < 0 || ri >= n || li >= ri) {
					ans.add(0);
				} else {
					int peakCount = tree.query(li + 1, ri - 1);
					ans.add(peakCount);
				}
			} else {
				int index = query[1];
				int val = query[2];
				tree.update(nums, index, val);
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{4,1,4,2,1,5};
		int[][] queries =  {{2,2,4},{1,0,2},{1,0,4}};

		Case2024061604 case2024061604 = new Case2024061604();
		System.out.println(case2024061604.countOfPeaks(nums,queries));
	}
}
