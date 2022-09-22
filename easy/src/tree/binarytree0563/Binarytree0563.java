package tree.binarytree0563;


/**
 * 给你一个二叉树的根节点 root ，计算并返回 整个树 的坡度 。
 * 一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。
 * 如果没有左子树的话，左子树的节点之和为 0 ；没有右子树的话也是一样。空结点的坡度是 0 。
 * 整个树 的坡度就是其所有节点的坡度之和。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.binarytree0563
 * @create 2022-09-22-21:14
 */
public class Binarytree0563 {
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
    int de = 0;

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        findTilt(root.left);
        findTilt(root.right);
        int l = root.left == null ? 0 : root.left.val;
        int r = root.right == null ? 0 : root.right.val;
        de += Math.abs((l - r));
        root.val += (l + r);
        return de;
    }
}