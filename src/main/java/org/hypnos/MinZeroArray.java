package org.hypnos;

/**
 * 3356. 零数组变换 II
 */
public class MinZeroArray {

	public int minZeroArray(int[] nums, int[][] queries) {
		int left = 0;
		int right = queries.length;
		while (left <= right) {
			int k = left + (right - left) / 2;
			if (isZeroArray(k, nums, queries)) {
				right = k - 1;
			} else {
				left = k + 1;
			}
		}
		return left == queries.length + 1? -1 : left;
	}

	private boolean isZeroArray(int k, int[] nums, int[][] queries) {
		int n = nums.length;
		int[] diff = new int[n + 1];
		for (int i = 0; i < k; ++i) {
			int[] query = queries[i];
			int x = query[2];
			diff[query[0]] += x;
			diff[query[1] + 1] -= x;
		}
		for (int i = 0; i < n; ++i) {
			if (nums[i] > diff[i]) {
				return false;
			}
			diff[i + 1] += diff[i];
		}
		return true;
	}

	public static void main(String[] args) {
		int[] nums = {0};
		int[][] queries = {{0,0,2},{0,0,4},{0,0,4},{0,0,3},{0,0,5}};
		MinZeroArray minZeroArray = new MinZeroArray();
		System.out.println(minZeroArray.minZeroArray(nums, queries));
	}
}
