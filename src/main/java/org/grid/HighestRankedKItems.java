package org.grid;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 2146. 价格范围内最高排名的 K 样物品
 */
public class HighestRankedKItems {

	static class GNode {
		public int dis;
		public int price;
		public int r;
		public int c;

		public GNode(int dis, int price, int r, int c) {
			this.dis = dis;
			this.r = r;
			this.price = price;
			this.c = c;
		}

		public int getDis() {
			return dis;
		}

		public int getPrice() {
			return price;
		}

		public int getR() {
			return r;
		}

		public int getC() {
			return c;
		}
	}

	private int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

	public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
		List<GNode> ans = new ArrayList<>();
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] vis = new boolean[m][n];
		int lo = pricing[0];
		int hi = pricing[1];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{start[0], start[1], 0});
		vis[start[0]][start[1]] = true;
		if (grid[start[0]][start[1]] >= lo && grid[start[0]][start[1]] <= hi) {
			ans.add(new GNode(0, grid[start[0]][start[1]], start[0], start[1]));
		}
		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			int i = poll[0];
			int j = poll[1];
			int z = poll[2];
			for (int[] dir : dirs) {
				int x = i + dir[0];
				int y = j + dir[1];
				if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != 0 && !vis[x][y]) {
					vis[x][y] = true;
					ans.add(new GNode(z + 1, grid[x][y], x, y));
					queue.add(new int[]{x, y, z + 1});
				}
			}
		}
		List<GNode> collect = ans.stream().filter(gNode -> gNode.price >= lo && gNode.price <= hi).collect(Collectors.toList());
		Comparator<GNode> gNodeComparator = Comparator.comparing(GNode::getDis).thenComparing(GNode::getPrice).thenComparing(GNode::getR).thenComparing(GNode::getC);
		collect.sort(gNodeComparator);
		return collect.stream().map(gNode -> List.of(gNode.r, gNode.c)).limit(k).collect(Collectors.toList());
	}

	public List<List<Integer>> highestRankedKItems2(int[][] grid, int[] pricing, int[] start, int k) {
		List<int[]> ans = new ArrayList<>();
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] vis = new boolean[m][n];
		int lo = pricing[0];
		int hi = pricing[1];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{start[0], start[1], 0});
		vis[start[0]][start[1]] = true;
		if (grid[start[0]][start[1]] >= lo && grid[start[0]][start[1]] <= hi) {
			ans.add(new int[] {0, grid[start[0]][start[1]], start[0], start[1]});
		}
		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			int i = poll[0];
			int j = poll[1];
			int z = poll[2];
			for (int[] dir : dirs) {
				int x = i + dir[0];
				int y = j + dir[1];
				if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != 0 && !vis[x][y]) {
					vis[x][y] = true;
					ans.add(new int[]{z + 1, grid[x][y], x, y});
					queue.add(new int[]{x, y, z + 1});
				}
			}
		}
		List<int[]> collect = ans.stream().filter(gNode -> gNode[1] >= lo && gNode[1] <= hi).collect(Collectors.toList());
		Comparator<int[]> comparator = (a, b) -> {
			for (int i = 0; i < a.length; i++) {
				if (a[i] != b[i]) {
					return Integer.compare(a[i], b[i]);
				}
			}
			return 0;
		};
		collect.sort(comparator);
		return collect.stream().map(gNode -> List.of(gNode[2], gNode[3])).limit(k).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		int[][] grid = {{1,2,0,1},{1,3,3,1},{0,2,5,1}};
		int[] pricing = {2,3};
		int[] start = {2,3};
		int k = 2;
		HighestRankedKItems highestRankedKItems = new HighestRankedKItems();
		System.out.println(highestRankedKItems.highestRankedKItems(grid,pricing, start, k));
	}
}
