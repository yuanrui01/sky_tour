package org.ds;

import java.util.Arrays;

/**
 * 3152. 特殊数组 II
 */
public class IsArraySpecial {

	public boolean[] isArraySpecial(int[] nums, int[][] queries) {
		int n = nums.length;
		int qLen = queries.length;
		boolean[] ans = new boolean[qLen];
		int[] pre = new int[n];
		for (int i = 1; i < n; ++i) {
			if (nums[i] % 2 != nums[i - 1] % 2)
				pre[i] = pre[i - 1] + 1;
			else
				pre[i] = pre[i - 1];
		}
		for (int i = 0; i < qLen; ++i) {
			int x1 = queries[i][1];
			int x0 = queries[i][0];
			ans[i] = pre[x1] - pre[x0] == x1 - x0;
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = {3,4,1,2,6};
		int[][] queries = {{0, 4}};
		IsArraySpecial isArraySpecial = new IsArraySpecial();
		boolean[] arraySpecial = isArraySpecial.isArraySpecial(nums, queries);
		System.out.println(Arrays.toString(arraySpecial));
	}
}
