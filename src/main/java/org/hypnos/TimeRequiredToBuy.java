package org.hypnos;

/**
 * 2073. 买票需要的时间
 */
public class TimeRequiredToBuy {

	public int timeRequiredToBuy(int[] tickets, int k) {
		if (k == 0 && tickets[0] == 1)  return 1;
		int ans = 0;
		int n = tickets.length;
		int kv = tickets[k];
		for (int i = 0; i < n; ++i) {
			if (i < k) {
				ans += Math.min(kv - 1, tickets[i] - 1);
			} else {
				ans += Math.min(kv - 1, tickets[i]);
			}
		}
		return ans + k + 1;
	}

	public static void main(String[] args) {
		int[] tickets = {84,49,5,24,70,77,87,8};
		int k = 3;
		TimeRequiredToBuy timeRequiredToBuy = new TimeRequiredToBuy();
		System.out.println(timeRequiredToBuy.timeRequiredToBuy(tickets, k));
	}
}
