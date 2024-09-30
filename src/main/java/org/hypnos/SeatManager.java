package org.hypnos;

import java.util.PriorityQueue;

/**
 * 1845. 座位预约管理系统
 */
public class SeatManager {

    private PriorityQueue<Integer> queue;

    public SeatManager(int n) {
        queue = new PriorityQueue<>(n);
        for (int i = 1; i <= n; ++i) {
            queue.add(i);
        }
    }

    public int reserve() {
        return queue.poll();
    }

    public void unreserve(int seatNumber) {
        queue.add(seatNumber);
    }
}
