package tree.binarytree0110;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.binarytree0110
 * @create 2022-09-13-17:01
 */
public class Binarytree0110 {
    public static void main(String[] args) {

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

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            int res = Math.abs((isBalancedTree(root.left) - isBalancedTree(root.right)));
            if (res > 2) {
                return false;
            }
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int isBalancedTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(isBalancedTree(root.right), isBalancedTree(root.left)) + 1;
    }
}