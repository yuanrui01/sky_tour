package org.hypnos;

import java.util.*;

/**
 * 740. 删除并获得点数
 */
public class DeleteAndEarn {


	public int deleteAndEarn(int[] nums) {
		int ans = 0;

		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.merge(num, 1, Integer::sum);
		}

		List<int[]> list = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			list.add(new int[]{entry.getKey(), entry.getValue()});
		}
		list.sort(Comparator.comparingInt(a -> a[0]));

		// init
		List<List<Integer>> ill = new ArrayList<>();
		List<Integer> il0 = new ArrayList<>();
		il0.add(list.get(0)[0] * list.get(0)[1]);
		ill.add(il0);

		for (int i = 1; i < list.size(); i++) {
			int numTotal = list.get(i)[0] * list.get(i)[1];
			if (list.get(i)[0] == (list.get(i - 1)[0] + 1)) {
				ill.get(ill.size() - 1).add(numTotal);
			} else {
				List<Integer> ilx = new ArrayList<>();
				ilx.add(numTotal);
				ill.add(ilx);
			}
		}

		for (List<Integer> integers : ill) {
			ans += rob(integers);
		}

		return ans;
	}

	public int rob(List<Integer> nums) {
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
