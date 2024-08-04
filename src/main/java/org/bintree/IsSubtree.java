package org.bintree;

import org.common.TreeNode;

/**
 * 572. 另一棵树的子树
 */
public class IsSubtree {


	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if (root == null)
			return false;
		if (root.val == subRoot.val && isSameTree(root, subRoot))
			return true;
		return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
	}

	private boolean isSameTree(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null)
			return true;
		if (t1 == null || t2 == null)
			return false;
		return t1.val == t2.val && isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
	}
}
