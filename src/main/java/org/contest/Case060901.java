package org.contest;

/**
 * @author: yuanrui
 */
public class Case060901 {


	public int numberOfChild(int n, int k) {
		int index = 0;
		int inc = 1;
		while (k > 0) {
			if (index == 0)
				inc = 1;
			if (index == n - 1)
				inc = -1;
			index += inc;
			k--;
		}
		return index;
	}


	public static void main(String[] args) {
		Case060801 case060801 = new Case060801();
		Case060901 case060901 = new Case060901();
		System.out.println(case060901.numberOfChild(3, 5));
		System.out.println(case060901.numberOfChild(5, 6));
		System.out.println(case060901.numberOfChild(4, 2));
	}
}
