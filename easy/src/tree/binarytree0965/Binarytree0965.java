package tree.binarytree0965;

/**
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.binarytree0965
 * @create 2022-10-10-13:28
 */
public class Binarytree0965 {
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
    int temp;

    public boolean isUnivalTree(TreeNode root) {
        temp = root.val;
        return searach(root);
    }

    private boolean searach(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.val != temp) {
            return false;
        }
        return searach(root.left) && searach(root.right);
    }
}