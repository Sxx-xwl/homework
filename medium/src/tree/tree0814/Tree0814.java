package tree.tree0814;

/**
 * 给你二叉树的根结点 root ，此外树的每个结点的值要么是 0 ，要么是 1 。
 * 返回移除了所有不包含 1 的子树的原二叉树。
 * 节点 node 的子树为 node 本身加上所有 node 的后代。
 * https://leetcode.cn/problems/binary-tree-pruning/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree0814
 * @create 2022-11-28-16:11
 */
public class Tree0814 {
    public static void main(String[] args) {

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.val == 0 && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }
}