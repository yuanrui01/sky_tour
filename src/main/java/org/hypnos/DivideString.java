package org.hypnos;

/**
 * 2138. 将字符串拆分为若干长度为 k 的组
 */
public class DivideString {

	public String[] divideString(String s, int k, char fill) {
		int n = s.length();
		StringBuilder sb = new StringBuilder(s);
		if (n % k != 0) {
			int kl = k - (n % k);
			for (int i = 0; i < kl; ++i) {
				sb.append(fill);
			}
			n = n + kl;
		}
		String[] ans = new String[n/k];
		for (int i = 0; i < n; i+=k) {
			ans[i/k] = sb.substring(i, i+k);
		}
		return ans;
	}


	public static void main(String[] args) {
		DivideString divideString = new DivideString();
		String s = "ctoyjrwtngqwt";
		int k = 8;
		char fill = 'n';
		System.out.println(divideString.divideString(s, k, fill));
	}
}
