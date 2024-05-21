package org.hypnos;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

/**
 * 841. 钥匙和房间 - DFS-stack/BFS-queue
 */
public class CanVisitAllRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        int count = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(0);
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            if (visited[pop])
                continue;
            visited[pop] = true;
            count++;
            if (count == n)
                return true;
            List<Integer> roomKeys = rooms.get(pop);
            for (Integer roomKey : roomKeys) {
                stack.push(roomKey);
            }
        }
        return false;
    }
}
