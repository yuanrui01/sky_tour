package org.ds;

/**
 * 1010. 总持续时间可被 60 整除的歌曲
 */
public class NumPairsDivisibleBy60 {

	public int numPairsDivisibleBy60(int[] time) {
		int[] hash = new int[60];
		int ans = 0;
		for(int i = 0; i < time.length; ++i) {
			int t = time[i] % 60;
			ans += t == 0 ? hash[0] : hash[60 - t];
			hash[t]++;
		}
		return ans;
	}
}
