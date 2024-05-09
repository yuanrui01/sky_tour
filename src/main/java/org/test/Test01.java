package org.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分手速练习
 */
public class Test01 {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int left = 0;
		int right = nums.length - 1;
		int target = 8;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if(nums[mid] < target)
				left = mid + 1;
			else
				right = mid - 1;
		}
		System.out.println(left);
	}
	public int lengthOfLIS(int[] nums) {
		List<Integer> ilist = new ArrayList<>();
        for (int num : nums) {
            int index = lowerBound(ilist, num);
            if (index == ilist.size())
                ilist.add(num);
            else
                ilist.set(index, num);
        }
		return ilist.size();
	}


	private int lowerBound(List<Integer> ilist, int target) {
		int left = 0;
		int right = ilist.size() - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if(ilist.get(mid) < target)
				left = mid + 1;
			else
				right = mid - 1;
		}
		return left;
	}
}
