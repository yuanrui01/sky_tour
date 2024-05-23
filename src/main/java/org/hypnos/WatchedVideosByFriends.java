package org.hypnos;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 1311. 获取你好友已观看的视频
 */
public class WatchedVideosByFriends {

	private class Node {
		public String video;
		public int count;


		public Node(String video, int count) {
			this.video = video;
			this.count = count;
		}

		public String getVideo() {
			return video;
		}

		public int getCount() {
			return count;
		}
	}


	public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
		int n = friends.length;
		boolean[] vis = new boolean[n];
		Queue<Integer> queue = new ArrayDeque<>();
		int k = 0;
		vis[id] = true;
		queue.add(id);
		while (!queue.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			while (!queue.isEmpty()) {
				list.add(queue.poll());
			}
			k++;
			if (k == level) {
				Map<String, Integer> result = new HashMap<>();
				for (Integer i : list) {
					for (String video : watchedVideos.get(i)) {
						result.merge(video, 1, Integer::sum);
					}
				}
				List<Node> nodes = result.entrySet().stream().map(entry -> new Node(entry.getKey(), entry.getValue())).collect(Collectors.toList());
				nodes.sort(Comparator.comparingInt(Node::getCount).thenComparing(Node::getVideo));
				return nodes.stream().map(Node::getVideo).collect(Collectors.toList());
			}
			for (Integer i : list) {
				for (int friend : friends[i]) {
					if (!vis[friend]) {
						vis[friend] = true;
						queue.add(friend);
					}
				}
			}
		}
		return null;
	}
}
