package tree.binarytree0226;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.binarytree0226
 * @create 2022-09-17-20:58
 */
public class Binarytree0226 {

}

class Solution {
    public TreeNode invertTree(TreeNode root) {
        search(root);
        return root;
    }

    private void search(TreeNode root) {
        if (root == null) {
            return;
        }
        search(root.left);
        search(root.right);
        if (root.left != null && root.right != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        } else if (root.left == null || root.right == null) {
            if (root.left == null) {
                root.left = root.right;
                root.right = null;
            }else {
                root.right = root.left;
                root.left = null;
            }
        }
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