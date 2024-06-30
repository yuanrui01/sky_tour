package org.contest;

/**
 * @author: yuanrui
 */
public class Case2024063003 {

	public int maximumLength(int[] nums, int k) {
		int n = nums.length;
		if (n == 0)
			return 0;
		int[][] dp = new int[n][k];
		for (int i = 0; i < n; i++)
			for (int r = 0; r < k; r++)
				dp[i][r] = 1;

		int ans = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				int modK = (nums[j] + nums[i]) % k;
				dp[i][modK] = Math.max(dp[i][modK], dp[j][modK] + 1);
				ans = Math.max(ans, dp[i][modK]);
			}
		}
		return ans;
	}


	public static void main(String[] args) {

		Case2024062203 case2024062203 = new Case2024062203();


	}
}
