package org.hypnos;

/**
 * 2116. 判断一个括号字符串是否有效
 */
public class CanBeValid {

	public boolean canBeValid(String s, String locked) {
		if (s.length() % 2 > 0) {
			return false;
		}
		int mn = 0;
		int mx = 0;
		for (int i = 0; i < s.length(); i++) {
			if (locked.charAt(i) == '1') { // 不能改
				int d = s.charAt(i) == '(' ? 1 : -1;
				mx += d;
				if (mx < 0) { // c 不能为负
					return false;
				}
				mn += d;
			} else { // 可以改
				mx++; // 改成左括号，c 加一
				mn--; // 改成右括号，c 减一
			}
			if (mn < 0) { // c 不能为负
				mn = 1; // 此时 c 的取值范围都是奇数，最小的奇数是 1
			}
		}
		return mn == 0; // 说明最终 c 能是 0
	}
}
