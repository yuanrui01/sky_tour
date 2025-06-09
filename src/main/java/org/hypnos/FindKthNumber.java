package org.hypnos;


/**
 * 440. 字典序的第K小数字
 */
public class FindKthNumber {

    public int findKthNumber(int n, int k) {
        int node = 1;
        k--;
        while (k > 0) {
            int size = countSubTreeSize(n, node);
            if (size <= k) {
                node++;
                k -= size;
            } else {
                node *= 10;
                k--;
            }
        }
        return node;
    }

    private int countSubTreeSize(int n, int node) {
        int size = 0;
        long left = node;
        long right = node + 1;
        while (left <= n) {
            size += (int) (Math.min(right, n + 1) - left);
            left *= 10;
            right *= 10;
        }
        return size;
    }
}
