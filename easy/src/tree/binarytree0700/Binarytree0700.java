package tree.binarytree0700;

import java.util.Set;

/**
 * 给定二叉搜索树（BST）的根节点root和一个整数值val。
 * 你需要在 BST 中找到节点值等于val的节点。
 * 返回以该节点为根的子树。 如果节点不存在，则返回null。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.binarytree0700
 * @create 2022-09-29-16:36
 */
public class Binarytree0700 {
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
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val < val) {
            return searchBST(root.right, val);
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return root;
        }
    }
}