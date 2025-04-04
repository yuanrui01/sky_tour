package org.hypnos;

import org.common.TreeNode;

// 236. 二叉树的最近公共祖先
public class LowestCommonAncestor {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode lNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rNode = lowestCommonAncestor(root.right, p, q);
        if (lNode != null && rNode != null) {
            return root;
        }
        if (lNode != null) {
            return lNode;
        }
        return rNode;
    }
}
