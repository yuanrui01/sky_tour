package org.hypnos;


import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] onPath = new boolean[nums.length];
        dfs(0, nums, ans, path, onPath  );
        return ans;
    }

    private void dfs(int i, int[] nums, List<List<Integer>> ans, List<Integer> path, boolean[] onPath) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = 0; j < nums.length; ++j) {
            if (!onPath[j]) {
                path.set(i,nums[j]);
                onPath[j] = true;
                dfs(i + 1, nums, ans, path, onPath);
                onPath[j] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
