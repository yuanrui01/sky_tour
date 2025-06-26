package org.hypnos;

/**
 * 2311. 小于等于 K 的最长二进制子序列
 */
public class LongestSubsequence {

	public int longestSubsequence(String s, int k) {
		int n = s.length();
		int m = 32 - Integer.numberOfLeadingZeros(k); // k 的二进制长度
		if (n < m) {
			return n; // 全选
		}

		int sufVal = Integer.parseInt(s.substring(n - m), 2);
		int ans = sufVal <= k ? m : m - 1; // 后缀长度

		for (int i = 0; i < n - m; i++) {
			ans += '1' - s.charAt(i); // 添加前导零
		}
		return ans;
	}
}
