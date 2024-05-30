package org.hypnos;

import java.util.*;

/**
 * 2981. 找出出现至少三次的最长特殊子字符串 I - 暴力
 */
public class MaximumLength {

	public int maximumLength(String s) {
		int ans = -1;
		char[] sArr = s.toCharArray();
		int n = sArr.length;
		for (int window = n - 1; window >= 1; --window) {
			Map<String, Integer> map = new HashMap<>();
			for (int i = 0; i < n - window + 1; ++i) {
				boolean flag = true;
				for (int j = i; j < i + window; ++j) {
					if (sArr[i] != sArr[j]) {
						flag = false;
						break;
					}
				}
				if (flag)
					map.merge(s.substring(i, i + window), 1, Integer::sum);
			}
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				if (entry.getValue() >= 3) {
					return window;
				}
			}
		}
		return ans;
	}


	/**
	 * 分类讨论
	 */
	public int maximumLength2(String s) {
		List<Integer>[] groups = new List[26];
		Arrays.setAll(groups, e -> new ArrayList<>());
		char[] arr = s.toCharArray();
		int cnt = 0;
		for (int i = 0; i < arr.length; ++i) {
			cnt++;
			if (i < arr.length - 1 && arr[i] != arr[i + 1]) {
				groups[arr[i] - 'a'].add(cnt);
				cnt = 0;
			}
		}
		groups[arr[arr.length - 1] - 'a'].add(cnt);
		int ans = 0;
		for (List<Integer> group : groups) {
			if (group.isEmpty()) continue;
			group.sort(Collections.reverseOrder());
			group.add(0);
			group.add(0);
			ans = Math.max(ans, Math.max(group.get(0) - 2, Math.max(Math.min(group.get(0) - 1, group.get(1)), group.get(2))));
		}
		return ans > 0 ? ans : -1;
	}

	public static void main(String[] args) {
		String s = "aaaa";
		MaximumLength maximumLength = new MaximumLength();
		System.out.println(maximumLength.maximumLength2(s));
	}
}
