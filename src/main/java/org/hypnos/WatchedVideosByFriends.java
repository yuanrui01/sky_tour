package org.hypnos;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 1311. 获取你好友已观看的视频 - BFS -文字修改
 */
public class WatchedVideosByFriends {

	public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
		int n = friends.length;
		boolean[] vis = new boolean[n];
		Queue<Integer> queue = new ArrayDeque<>();
		int k = -1;
		vis[id] = true;
		queue.add(id);
		while (!queue.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			while (!queue.isEmpty()) {
				list.add(queue.poll());
			}
			for (Integer i : list) {
				for (int friend : friends[i]) {
					if (!vis[friend]) {
						vis[friend] = true;
						queue.add(friend);
					}
				}
			}
			k++;
			if (k == level) {
				Map<String, Integer> result = new HashMap<>();
				for (Integer i : list) {
					for (String video : watchedVideos.get(i)) {
						result.merge(video, 1, Integer::sum);
					}
				}
				return result.entrySet().stream().sorted((o1, o2) -> {
                    if (o1.getValue() - o2.getValue() == 0)
                        return o1.getKey().compareTo(o2.getKey());
                    else
                        return o1.getValue() - o2.getValue();
                }).map(Map.Entry::getKey).collect(Collectors.toList());
			}
		}
		return null;
	}
}
