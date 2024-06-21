package org.hypnos;

import org.common.TreeNode;

import java.util.HashMap;
import java.util.Map;


/**
 * 1214. 查找两棵二叉搜索树之和
 */
public class TwoSumBSTs {

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Map<Integer, Integer> map1 = new HashMap<>();
        traverse(root1, map1);
        return find(root2, target, map1);
    }

    private boolean find(TreeNode root2, int target, Map<Integer, Integer> map1) {
        if (root2 != null) {
            if (map1.get(target - root2.val) != null)
                return true;
            return find(root2.left, target, map1) || find(root2.right, target, map1);
        }
        return false;
    }

    private void traverse(TreeNode root1, Map<Integer, Integer> map1) {
        if (root1 != null) {
            map1.merge(root1.val, 1, Integer::sum);
            traverse(root1.left, map1);
            traverse(root1.right, map1);
        }
    }
}
