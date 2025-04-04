package org.hypnos;

import org.common.TreeNode;

/**
 * 235. 二叉搜索树的最近公共祖先
 */
public class LowestCommonAncestor235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int x = root.val;
        if (p.val < x && q.val < x) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > x && q.val > x)  {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
