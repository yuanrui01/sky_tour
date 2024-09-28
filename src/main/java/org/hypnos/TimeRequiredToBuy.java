package org.hypnos;

/**
 * 2073. 买票需要的时间
 */
public class TimeRequiredToBuy {

	public int timeRequiredToBuy(int[] tickets, int k) {
		int ans = 0;
		for (int i = 0; i < tickets.length; ++i) {
			ans += Math.min(tickets[i], tickets[k] - (i > k ? 1 : 0));
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] tickets = {84,49,5,24,70,77,87,8};
		int k = 3;
		TimeRequiredToBuy timeRequiredToBuy = new TimeRequiredToBuy();
		System.out.println(timeRequiredToBuy.timeRequiredToBuy(tickets, k));
	}
}
