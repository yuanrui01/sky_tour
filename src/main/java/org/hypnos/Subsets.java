package org.hypnos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 78. 子集
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void dfs(int[] nums, int i, List<Integer> set, List<List<Integer>> ans) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(set));
            return;
        }
        dfs(nums, i + 1, set, ans);
        set.add(nums[i]);
        dfs(nums, i + 1, set, ans);
        set.remove(set.size() - 1);
    }
}
