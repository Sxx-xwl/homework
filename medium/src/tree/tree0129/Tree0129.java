package tree.tree0129;

/**
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree0129
 * @create 2022-10-25-10:48
 */
public class Tree0129 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,
                new TreeNode(9,
                        new TreeNode(5),
                        new TreeNode(1)),
                new TreeNode(0));
        System.out.println(new Solution().sumNumbers(root));
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
    private int res = 0, cur = 0;

    public int sumNumbers(TreeNode root) {
        preOrder(root);
        return res;
    }

    private void preOrder(TreeNode root) {
        cur = root.val + cur * 10;
        if (root.left == null && root.right == null) {
            res += cur;
            cur /= 10;
            return;
        }

        if (root.left != null) preOrder(root.left);
        if (root.right != null) preOrder(root.right);
        cur /= 10;
    }
}