package org.bintree;

import org.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 872. 叶子相似的树
 */
public class LeafSimilar {

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		buildSequence(root1, list1);
		buildSequence(root2, list2);
		if (list1.size() != list2.size())
			return false;
		for (int i = 0; i < list1.size(); ++i) {
			if (!list1.get(i).equals(list2.get(i)))
				return false;
		}
		return true;
	}

	private void buildSequence(TreeNode root, List<Integer> list) {
		if (root == null )
			return;
		if (root.left == null && root.right == null){
			list.add(root.val);
			return;
		}
		buildSequence(root.left, list);
		buildSequence(root.right, list);
	}
}
