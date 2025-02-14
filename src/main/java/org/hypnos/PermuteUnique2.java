package org.hypnos;

import java.util.*;

public class PermuteUnique2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int mn = 0;
        int mx = -10;
        for (int num : nums) {
            mn = Math.min(mn, num);
            mx = Math.max(mx, num);
        }
        int[] count = new int[mx - mn + 1];
        for (int num : nums) {
            count[num - mn]++;
        }
        dfs(0, nums, ans, path, count, mn);
        return ans;
    }

    public void dfs(int i, int[] nums, List<List<Integer>> ans, List<Integer> path, int[] count, int bias) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = 0; j < count.length; ++j) {
            if (count[j] > 0) {
                count[j]--;
                path.add(j+bias);
                dfs(i + 1, nums, ans, path, count, bias);
                path.remove(path.size()-1);
                count[j]++;
            }
        }
    }

    public static void main(String[] args) {
        PermuteUnique2 permuteUnique2 = new PermuteUnique2();
        int[] nums = {1,1,2};
        System.out.println(permuteUnique2.permuteUnique(nums));
    }
}
