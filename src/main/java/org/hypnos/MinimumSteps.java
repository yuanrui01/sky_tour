package org.hypnos;

/**
 * 2938. 区分黑球与白球
 */
public class MinimumSteps {

	public long minimumSteps(String s) {
		long ans = 0;
		char[] arr = s.toCharArray();
		for (int left = 0, right = 0; right < arr.length; ++right)
			if (arr[right] == '0') {
				ans += (right - left);
				left++;
			}
		return ans;
	}

	public static void main(String[] args) {
		MinimumSteps minimumSteps = new MinimumSteps();
		String s = "101";

		System.out.println(minimumSteps.minimumSteps(s));
	}
}
