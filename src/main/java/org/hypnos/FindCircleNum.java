package org.hypnos;

/**
 * 547. 省份数量
 */
public class FindCircleNum {

	public int findCircleNum(int[][] isConnected) {
		int n= isConnected.length;
		boolean[] visited = new boolean[n];
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				ans++;
				dfs(isConnected, visited, n, i);
			}
		}
		return ans;
	}

	private void dfs(int[][] isConnected, boolean[] visited, int n, int i) {
		for (int k = 0; k < n; k++) {
			if (isConnected[i][k] == 1 && !visited[k]) {
				visited[k] = true;
				dfs(isConnected, visited, n, k);
			}
		}
	}

	public static void main(String[] args) {
		int[][] isConnected = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
		FindCircleNum findCircleNum = new FindCircleNum();
		System.out.println(findCircleNum.findCircleNum(isConnected));
	}
}
