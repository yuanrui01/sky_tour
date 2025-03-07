package org.hypnos;


import java.util.HashMap;
import java.util.Map;

/**
 * 2597. 美丽子集的数目
 */
public class BeautifulSubsets {

    private int ans = -1;

    public int beautifulSubsets(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        dfs(nums, 0, k, cnt);
        return ans;
    }

    private void dfs(int[] nums, int i, int k, Map<Integer, Integer> cnt) {
        if (i == nums.length) {
            ans++;
            return;
        }
        dfs(nums, i + 1, k, cnt);
        int x = nums[i];
        if (cnt.getOrDefault(x - k, 0) == 0
                && cnt.getOrDefault(x + k, 0) == 0) {
            cnt.merge(x, 1, Integer::sum);
            dfs(nums, i + 1, k, cnt);
            cnt.merge(x, -1, Integer::sum);
        }
    }

}
