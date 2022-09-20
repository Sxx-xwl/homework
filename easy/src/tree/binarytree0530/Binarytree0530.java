package tree.binarytree0530;


import java.util.function.Predicate;

/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 差值是一个正数，其数值等于两值之差的绝对值。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.binarytree0530
 * @create 2022-09-20-20:48
 */
public class Binarytree0530 {
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
    int min = Integer.MAX_VALUE;
    TreeNode preNode = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getMinimumDifference(root.left);
        int res = preNode == null ? Integer.MAX_VALUE : root.val - preNode.val;
        min = Math.min(min, res);
        preNode = root;
        getMinimumDifference(root.right);
        return min;
    }
}