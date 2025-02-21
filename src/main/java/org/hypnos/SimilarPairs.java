package org.hypnos;

/**
 * 2506. 统计相似字符串对的数目
 */
public class SimilarPairs {

	public int similarPairs(String[] words) {
		int n = words.length;
		int[] mode = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				mode[i] |= (1 << (words[i].charAt(j) - 'a'));
			}
		}

		int ans = 0;
		for (int i = 0; i < n - 1; ++i) {
			for (int j = i+1; j < n; ++j) {
				if (mode[i] == mode[j]) {
					ans++;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		String[] modes = {"aba","aabb","abcd","bac","aabc"};
		SimilarPairs similarPairs = new SimilarPairs();
		System.out.println(similarPairs.similarPairs(modes));
	}
}
