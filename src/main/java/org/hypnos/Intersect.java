package org.hypnos;

import java.util.ArrayList;
import java.util.List;


/**
 * 350. 两个数组的交集 II
 */
public class Intersect {

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();
        int[] mode1 = new int[1001];
        for (int n1 : nums1) {
            mode1[n1]++;
        }
        for (int n2 : nums2) {
            if (mode1[n2] > 0) {
                ans.add(n2);
                mode1[n2]--;
            }
        }
        return ans.stream().mapToInt(i->i).toArray();
    }
}
