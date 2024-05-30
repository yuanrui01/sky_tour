package org.hypnos;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 346. 数据流中的移动平均值
 */
public class MovingAverage {

    private final int size;
    private int cnt;
    private int slideVal;
    private final Queue<Integer> queue;

    public MovingAverage(int size) {
        this.size = size;
        this.cnt = 0;
        this.slideVal = 0;
        this.queue = new LinkedList<>();
    }

    public double next(int val) {
        if (cnt < size) {
            slideVal += val;
        } else {
            int poll = queue.poll();
            slideVal = slideVal + val - poll;
        }
        cnt++;
        queue.offer(val);
        return (double) slideVal / (Math.min(cnt, size));
    }
}
