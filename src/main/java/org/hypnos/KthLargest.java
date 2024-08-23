package org.hypnos;

import java.util.List;
import java.util.PriorityQueue;


/**
 * 703. 数据流中的第 K 大元素
 */
public class KthLargest {

    private int k;
    private PriorityQueue<Integer> mxHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.mxHeap = new PriorityQueue<>();
        for (int num : nums) add(num);
    }

    public int add(int val) {
        if (this.mxHeap.size() < k) {
            mxHeap.add(val);
        } else if (mxHeap.peek() < val) {
            mxHeap.poll();
            mxHeap.add(val);
        }
        return mxHeap.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4,5,8,2};
        KthLargest kthLargest = new KthLargest(k, nums);
        List<Integer> integers = List.of(3, 5, 10, 9, 4);
        for (Integer integer : integers) {
            System.out.println(kthLargest.add(integer));
        }

    }
}
