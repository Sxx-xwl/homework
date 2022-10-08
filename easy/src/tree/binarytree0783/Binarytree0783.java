package tree.binarytree0783;

/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 差值是一个正数，其数值等于两值之差的绝对值。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.binarytree0783
 * @create 2022-10-08-13:35
 */
public class Binarytree0783 {
    public static void main(String[] args) {

    }
}

class Solution {
    int minVal = Integer.MAX_VALUE;
    int preVal = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        if (root != null) {
            minDiffInBST(root.left);
            if (preVal < Integer.MAX_VALUE) {
                minVal = Math.min(minVal, root.val - preVal);
            }
            preVal = root.val;
            minDiffInBST(root.right);
        }
        return minVal;
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