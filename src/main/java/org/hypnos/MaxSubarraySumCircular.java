package org.hypnos;

/**
 * 918. 环形子数组的最大和
 */
public class MaxSubarraySumCircular {

	public int maxSubarraySumCircular(int[] nums) {
		int maxAns = Integer.MIN_VALUE, minAns = 0;
		int maxSum = 0, minSum = 0, sum = 0;
		for (int num : nums) {
			sum += num;
			maxSum += num;
			minSum += num;
			maxAns = Math.max(maxAns, maxSum);
			minAns = Math.min(minAns, minSum);
			if (maxSum < 0) maxSum = 0;
			if (minSum > 0) minSum = 0;
		}
		return Math.max(maxAns, sum == minAns ? maxAns : sum - minAns);
	}

	public static void main(String[] args) {
		int[] nums = {-7,1,2,7,-2,-5};
		MaxSubarraySumCircular maxSubarraySumCircular = new MaxSubarraySumCircular();
		System.out.println(maxSubarraySumCircular.maxSubarraySumCircular(nums));
	}
}
