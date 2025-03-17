package org.hypnos;

/**
 * 3340. 检查平衡字符串
 */
public class IsBalanced {

	// 因为有0字符的存在，所以你还是需要考虑偏移量
	public boolean isBalanced(String num) {
		int n = num.length();
		int s = 0;
		for (int i = 0; i < n; ++i) {
			char c = num.charAt(i);
			if (i%2==0) {
				s += c - 'a';
			} else {
				s -= c - 'a';
			}
		}
		return s == 0;
	}

	public static void main(String[] args) {
		IsBalanced isBalanced = new IsBalanced();
		String num = "11";
		System.out.println(isBalanced.isBalanced(num));
	}
}
