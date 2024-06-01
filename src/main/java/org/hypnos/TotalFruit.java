package org.hypnos;

/**
 * 904. 水果成篮
 */
public class TotalFruit {

	public int totalFruit(int[] fruits) {
		int ans = 0;
		int pBlock = 0;
		int ppBlock = 0;
		int ppType = -1;
		int pType = -1;
		int n = fruits.length;
		int i = 0;
		while (i < n) {
			int curBlock = 1;
			while (i + 1 < n && fruits[i] ==  fruits[i + 1]) {
				curBlock++;
				i++;
			}
			int newRes = pBlock + curBlock;
			ans = Math.max(ans, newRes);
			ppBlock = pBlock;
			pBlock = curBlock;
			ppType = pType;
			pType = fruits[i];
			if (i + 1 < n && fruits[i + 1] == ppType)
				pBlock += ppBlock;
			++i;
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] fruits = {3,6,6,6,3,6,3};
		TotalFruit totalFruit = new TotalFruit();
		System.out.println(totalFruit.totalFruit(fruits));
	}
}
