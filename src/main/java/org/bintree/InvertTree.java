package org.bintree;

import org.common.TreeNode;

/**
 * @author: yuanrui
 */
public class InvertTree {

	public TreeNode invertTree(TreeNode root) {
		if (root != null) {
			TreeNode tmp = root.left;
			root.left = root.right;
			root.right = tmp;
			invertTree(root.left);
			invertTree(root.right);
		}
		return root;
	}
}
