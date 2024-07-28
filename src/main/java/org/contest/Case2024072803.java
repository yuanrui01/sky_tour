package org.contest;

/**
 * @author: yuanrui
 */
public class Case2024072803 {

	public boolean canAliceWin(int[] nums) {
		int s = 0;
		int d = 0;
		for (int num : nums) {
			if (num < 10)
				s+=num;
			else
				d+=num;
		}
		return s != d;
	}

	public static void main(String[] args) {
		Case2024072803 case2024072803 = new Case2024072803();
		int[] nums ={1,2,3,4,10};

		System.out.println(case2024072803.canAliceWin(nums));
	}
}
