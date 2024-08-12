package org.contest;

import java.util.Arrays;

/**
 * @author: yuanrui
 */
public class Case2024081103 {

	private int MOD = 1_000_000_007;
	private int[][][] memo;
	private int LIMIT = 1000;

	public int countOfPairs(int[] nums) {
		int n = nums.length;
		memo = new int[n][LIMIT + 1][LIMIT + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= LIMIT; j++) {
				Arrays.fill(memo[i][j], -1);
			}
		}
		return dfs(nums, 0, 0, LIMIT);
	}

	private int dfs(int[] nums, int idx, int prev, int maxArr2) {
		if (idx == nums.length) {
			return 1;
		}
		if (memo[idx][prev][maxArr2] != -1) {
			return memo[idx][prev][maxArr2];
		}

		int count = 0;
		for (int arr1 = prev; arr1 <= nums[idx]; arr1++) {
			int arr2 = nums[idx] - arr1;
			if (arr2 <= maxArr2) {
				count = (count + dfs(nums, idx + 1, arr1, arr2)) % MOD;
			}
		}

		memo[idx][prev][maxArr2] = count;
		return count;
	}


	public static void main(String[] args) {
		int[] nums = {14,36,48,17,38,30,48,3,3,24};

		Case2024081103 case2024081103 = new Case2024081103();

		System.out.println(case2024081103.countOfPairs(nums));
	}
}
