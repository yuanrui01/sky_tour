package org.dp;

/**
 * @author: yuanrui
 */
public class MincostTickets {

	public int mincostTickets(int[] days, int[] costs) {
		int limit = days[days.length - 1];
		int[] dp = new int[limit + 1];
		for (int i = 1, j = 0; i <= limit; ++i) {
			if (days[j] == i) {
				int cost1 = dp[i - 1] + costs[0];
				int cost2 = dp[Math.max(0, i - 7)] + costs[1];
				int cost3 = dp[Math.max(0, i - 30)] + costs[2];
				dp[i] = Math.min(cost1, Math.min(cost2, cost3));
				j++;
			} else {
				dp[i] = dp[i - 1];
			}
		}
		return dp[limit];
	}

	public static void main(String[] args) {
		int[] days = {1,4,6,7,8,20};
		int[] costs = {2, 7, 15};
		MincostTickets mincostTickets = new MincostTickets();

		System.out.println(mincostTickets.mincostTickets(days, costs));
	}
}
