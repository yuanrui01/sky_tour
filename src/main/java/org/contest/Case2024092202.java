package org.contest;

/**
 * @author: yuanrui
 */
public class Case2024092202 {

	public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
		long left = 0;
		long right = (long) mountainHeight * (mountainHeight + 1) / 2 * workerTimes[0];
		for (int wt : workerTimes) {
			right = Math.min(right, (long) mountainHeight * (mountainHeight + 1) / 2 * wt);
		}
		while (left < right) {
			long mid = left + (right - left) / 2;
			if (canComplete(mid, mountainHeight, workerTimes)) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	private boolean canComplete(long time, int mountainHeight, int[] workerTimes) {
		long totalHeightReduced = 0;
		for (int wt : workerTimes) {
			long maxWork = (long) Math.sqrt(1 + (double) (8 * time) / wt) - 1;
			maxWork /= 2;
			totalHeightReduced += maxWork;
			if (totalHeightReduced >= mountainHeight) {
				return true;
			}
		}
		return totalHeightReduced >= mountainHeight;
	}

	public static void main(String[] args) {
		Case2024092202 case2024092202 = new Case2024092202();
		int height = 87;
		int[] workerTimes = {45,76,5,78};
		System.out.println(case2024092202.minNumberOfSeconds(height, workerTimes));
	}
}
