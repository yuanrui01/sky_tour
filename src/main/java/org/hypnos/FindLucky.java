package org.hypnos;


/**
 * 1394. 找出数组中的幸运数
 */
public class FindLucky {

    public int findLucky(int[] arr) {
        int[] ans = new int[501];
        for (int a : arr) {
            ans[a]++;
        }
        for (int i = 500; i > 0; --i) {
            if (i == ans[i]) return i;
        }
        return -1;
    }
}
