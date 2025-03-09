package org.hypnos;

import java.util.*;

/**
 * 2070. 每一个查询的最大美丽值
 */
public class MaximumBeauty2 {

	public int[] maximumBeauty(int[][] items, int[] queries) {
		List<int[]> list = new ArrayList<>();
		Arrays.sort(items, (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
		int max = 0;
		for (int[] item : items) {
			max = item[1] = Math.max(max, item[1]);
			if (list.isEmpty()) {
				list.add(item);
			} else {
				int[] last = list.get(list.size()-1);
				if (last[0] != item[0]) {
					list.add(item);
				}
			}
		}
		int[][] arr = list.toArray(new int[0][]);
		int[] ans = new int[queries.length];
		for (int i = 0; i < queries.length; ++i) {
			int query = queries[i];
			// 找到最后一个小于等于query的元素
			int left = 0;
			int right = arr.length-1;
			while (left <= right) {
				int mid = (left + right) / 2;
				int midV = arr[mid][0];
				if (query < midV) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			if (right == -1) {
				ans[i] = 0;
			} else {
				ans[i] = arr[right][1];
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[][] items = {{193,732},{781,962},{864,954},{749,627},{136,746},{478,548},{640,908},{210,799},{567,715},{914,388},{487,853},{533,554},{247,919},{958,150},{193,523},{176,656},{395,469},{763,821},{542,946},{701,676}};
		int[] queries = {885,1445,1580,1309,205,1788,1214,1404,572,1170,989,265,153,151,1479,1180,875,276,1584};
		MaximumBeauty2 maximumBeauty2 = new MaximumBeauty2();

		System.out.println(Arrays.toString(maximumBeauty2.maximumBeauty(items, queries)));
	}
}
