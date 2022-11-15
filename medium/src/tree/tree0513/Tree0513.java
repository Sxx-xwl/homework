package tree.tree0513;

/**
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * 假设二叉树中至少有一个节点。
 * https://leetcode.cn/problems/find-bottom-left-tree-value/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree0513
 * @create 2022-11-15-11:03
 */
public class Tree0513 {
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
    private int res;
    private int maxDep;

    public int findBottomLeftValue(TreeNode root) {
        res = 0;
        maxDep = 0;
        preOrder(root, 0);
        return res;
    }

    private void preOrder(TreeNode root, int dep) {
        if (root == null) {
            return;
        }
        preOrder(root.left, dep + 1);
        if (dep > maxDep) {
            res = root.val;
            maxDep = dep;
        }
        preOrder(root.right, dep + 1);
    }
}