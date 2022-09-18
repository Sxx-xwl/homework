package tree.binarytree0404;

/**
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.binarytree0404
 * @create 2022-09-18-22:50
 */
public class Binarytree0404 {
    public static void main(String[] args) {

    }
}

class Solution {
    int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            res += root.left.val;
        }
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

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