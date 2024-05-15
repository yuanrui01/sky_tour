package org.hypnos;


/**
 * 198. 打家劫舍
 */
public class Rob {

    private int[] nums;

    public int rob(int[] nums) {
		int f0 = 0, f1 = 0;
		for (int num : nums) {
			int newF = Math.max(f1, f0 + num);
			f0 = f1;
			f1 = newF;
		}
		return f1;
    }

    public static void main(String[] args) {
        Rob rob = new Rob();
        int[] nums = {2,7,9,3,1};
        System.out.println(rob.rob(nums));
    }
}
