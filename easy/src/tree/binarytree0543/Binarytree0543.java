package tree.binarytree0543;


/**
 * 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.binarytree0543
 * @create 2022-09-20-21:17
 */
public class Binarytree0543 {
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
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        searchMaxDepth(root);
        return max;
    }

    private int searchMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = searchMaxDepth(root.left);
        int r = searchMaxDepth(root.right);
        max = Math.max(l + r, max);
        return Math.max(l, r)+1;
    }
}