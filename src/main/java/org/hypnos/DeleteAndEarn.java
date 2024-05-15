package org.hypnos;

import java.util.*;

/**
 * 740. 删除并获得点数
 */
public class DeleteAndEarn {


	public int deleteAndEarn(int[] nums) {
		int max = 0;
		for (int num : nums)
			max = Math.max(max, num);
		int[] robs = new int[max + 1];
		for (int num : nums)
			robs[num] += num;
		return rob(robs);
	}

	public int rob(int[] nums) {
		int f0 = 0, f1 = 0;
		for (int x : nums) {
			int newF = Math.max(f1, f0 + x);
			f0 = f1;
			f1 = newF;
		}
		return f1;
	}

	public static void main(String[] args) {
		DeleteAndEarn deleteAndEarn = new DeleteAndEarn();
		int[] nums = new int[]{3,4,2};
		System.out.println(deleteAndEarn.deleteAndEarn(nums));
	}
}
