package org.hypnos;

import org.common.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 * 1123. 最深叶节点的最近公共祖先
 */
public class LcaDeepestLeaves {

    private int maxDepth = 0;

    private List<TreeNode> nodes = new ArrayList<>();

    private TreeNode ans = null;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        addDepthNodes(root, 0);
        if (nodes.size() == 1) {
            return nodes.get(0);
        }
        findAns(root, 0);
        return ans;
    }

    private int findAns(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            if (depth == maxDepth) {
                return 1;
            }
            return 0;
        }
        int count = 0;
        if (root.left != null) {
            count += findAns(root.left, depth+1);
        }
        if (root.right != null) {
            count += findAns(root.right, depth+1);
        }
        if (ans == null && count == nodes.size()) {
            ans = root;
        }
        return count;
    }

    private void dfs(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            maxDepth = Math.max(maxDepth, depth);
            return;
        }
        if (root.left != null) {
            dfs(root.left, depth + 1);
        }
        if (root.right != null) {
            dfs(root.right, depth + 1);
        }
    }

    private void addDepthNodes(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            if (depth == maxDepth) {
                nodes.add(root);
            }
            return;
        }
        if (root.left != null) {
            addDepthNodes(root.left, depth + 1);
        }
        if (root.right != null) {
            addDepthNodes(root.right, depth + 1);
        }
    }

    public static void main(String[] args) {
        LcaDeepestLeaves lcaDeepestLeaves = new LcaDeepestLeaves();
        TreeNode root = new TreeNode(1, new TreeNode(2,new TreeNode(3, null, new TreeNode(6)),new TreeNode(4, null, new TreeNode(5))), null);
        System.out.println(lcaDeepestLeaves.lcaDeepestLeaves(root).val);
    }
}
