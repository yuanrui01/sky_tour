package org.hypnos;

import java.util.Arrays;


/**
 * 1552. 两球之间的磁力
 */
public class MaxDistance {


    public int maxDistance(int[] pos, int m) {
        Arrays.sort(pos);
        int n = pos.length;
        int l = 1;
        int r = (pos[n-1] - pos[0]) / (m - 1);
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(pos, m, mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    private boolean check(int[] position, int m, int mid) {
        int pre = position[0];
        m--;
        for (int i = 1; i < position.length; ++i) {
            if (position[i] - pre >= mid) {
                m--;
                pre = position[i];
            }
            if (m == 0) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        int m = 4;
        MaxDistance maxDistance = new MaxDistance();
        System.out.println(maxDistance.maxDistance(nums, m));
    }
}
