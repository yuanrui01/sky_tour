package org.hypnos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * 90. 子集 II
 */
public class SubsetsWithDup {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void dfs(int[] nums, int i, List<Integer> set, List<List<Integer>> ans) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(set));
            return;
        }
        // 选
        int x = nums[i];
        set.add(x);
        dfs(nums, i + 1, set, ans);
        set.remove(set.size()-1);

        // 不选，跳过重复的元素
        do {
            i++;
        } while (i < nums.length && nums[i] == x);
        dfs(nums, i, set, ans);
    }

    public static void main(String[] args) {
        int[] nums = {0};
        SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
        System.out.println(subsetsWithDup.subsetsWithDup(nums));
    }
}
