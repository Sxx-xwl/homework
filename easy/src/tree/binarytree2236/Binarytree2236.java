package tree.binarytree2236;

/**
 * 给你一个 二叉树 的根结点root，该二叉树由恰3个结点组成：根结点、左子结点和右子结点。
 * 如果根结点值等于两个子结点值之和，返回true，否则返回false 。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.binarytree2236
 * @create 2022-10-12-11:21
 */
public class Binarytree2236 {
    public static void main(String[] args) {

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public boolean checkTree(TreeNode root) {
        return root.val - root.left.val == root.right.val;
    }
}