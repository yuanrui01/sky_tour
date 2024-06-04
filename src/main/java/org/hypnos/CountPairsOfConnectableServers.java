package org.hypnos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3067. 在带权树网络中统计可连接服务器对数目
 */
public class CountPairsOfConnectableServers {

	public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
		int n = edges.length + 1;
		List<int[]>[] g = new List[n];
		Arrays.setAll(g, e -> new ArrayList<>());
		boolean[] vis = new boolean[n];
		int[] ans = new int[n];
		for (int[] edge : edges) {
			g[edge[0]].add(new int[]{edge[1], edge[2]});
			g[edge[1]].add(new int[]{edge[0], edge[2]});
		}
		for (int i = 0; i < n; ++i) {
			Arrays.fill(vis, false);
			ans[i] = calc(g, vis, i, signalSpeed);
		}
		return ans;
	}

	private int calc(List<int[]>[] g, boolean[] vis, int c, int signalSpeed) {
		List<int[]> other = g[c];
		if (other.size() == 1)
			return 0;
		vis[c] = true;
		List<Integer> list = new ArrayList<>();
		for (int[] v : g[c]) {
			int res = 0;
			if (v[1] % signalSpeed == 0)
				res++;
			res += dfs(g, vis, v[0], v[1], signalSpeed);
			if (res > 0)
				list.add(res);
		}
		if (list.size() == 1)
			return 0;
		else {
			int res = 0;
			for (int i = 0; i < list.size() - 1; ++i) {
				for (int j = i + 1; j < list.size(); ++j) {
					res += list.get(i)*list.get(j);
				}
			}
			return res;
		}
	}

	private int dfs(List<int[]>[] g, boolean[] vis, int c, int inherit, int signalSpeed) {
		vis[c] = true;
		int res = 0;
		for (int[] v : g[c]) {
			if (!vis[v[0]]) {
				inherit += v[1];
				if (inherit % signalSpeed == 0)
					res++;
				res += dfs(g, vis, v[0], inherit, signalSpeed);
				inherit -= v[1];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[][] edges = {{0,1,1},{1,2,5},{2,3,13},{3,4,9},{4,5,2}};
		int signalSpeed = 1;
		CountPairsOfConnectableServers count = new CountPairsOfConnectableServers();
		int[] res = count.countPairsOfConnectableServers(edges, signalSpeed);
		System.out.println(Arrays.toString(res));

		System.out.println(5%1);
	}
}
