package org.hypnos;

/**
 * 904. 水果成篮
 */
public class TotalFruit {

	public int totalFruit(int[] fruits) {
		int ans = 0;
		int pBlock = 0; // 上个水果块的大小
		int pType = -1; // 上个块水果类型
		int n = fruits.length;
		for (int i = 0; i < n; i++) {
			int curBlock = 1; // 当前水果块大小
			while (i + 1 < n && fruits[i] ==  fruits[i + 1]) {
				curBlock++;
				i++;
			}
			int newRes = pBlock + curBlock; // 当前水果块 + 上一水果块
			ans = Math.max(ans, newRes);
			pBlock = curBlock;
			if (i + 1 < n && fruits[i + 1] == pType) {
				pBlock = newRes; // 如果下一个水果块类型跟上个水果块类型一样，合并水果块
			}
			pType = fruits[i];
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] fruits = {3,6,6,6,3,6,3};
		TotalFruit totalFruit = new TotalFruit();
		System.out.println(totalFruit.totalFruit(fruits));
	}
}
