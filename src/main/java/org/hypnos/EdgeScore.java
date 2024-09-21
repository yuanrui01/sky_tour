package org.hypnos;

/**
 * 2374. 边积分最高的节点
 */
public class EdgeScore {

	public int edgeScore(int[] edges) {
		long[] ans = new long[edges.length];
		for (int i = 0; i < edges.length; ++i) {
			ans[edges[i]] += i;
		}
		int mi = edges.length - 1;
		for (int i = edges.length - 1; i >= 0; --i) {
			if (ans[i] >= ans[mi]) mi = i;
		}
		return mi;
	}
}
