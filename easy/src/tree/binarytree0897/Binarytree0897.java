package tree.binarytree0897;

/**
 * 给你一棵二叉搜索树的root，
 * 请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，
 * 使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.binarytree0897
 * @create 2022-10-09-10:27
 */
public class Binarytree0897 {
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
    TreeNode temp = new TreeNode(0);
    TreeNode res = temp;
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        increasingBST(root.left);
        temp.right = new TreeNode(root.val);
        temp = temp.right;
        increasingBST(root.right);
        return res.right;
    }
}