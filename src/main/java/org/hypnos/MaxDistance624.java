package org.hypnos;


import java.util.List;

/**
 * 624. 数组列表中的最大距离
 */
public class MaxDistance624 {

    public int maxDistance(List<List<Integer>> arrays) {
        int mn = arrays.get(0).get(0);
        int mx = arrays.get(0).get(arrays.get(0).size()-1);
        int ans = -1;
        for (int i = 1; i < arrays.size(); ++i) {
            List<Integer> array = arrays.get(i);
            int first  = array.get(0);
            int last = array.get(array.size()-1);
            ans = Math.max(ans, Math.abs(mn - last));
            ans = Math.max(ans, Math.abs(mx - first));
            mn = Math.min(mn, first);
            mx = Math.max(mx, last);
        }
        return ans;
    }
}
