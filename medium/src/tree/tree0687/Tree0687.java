package tree.tree0687;

/**
 * 给定一个二叉树的 root ，返回 最长的路径的长度 ，
 * 这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。
 * 两个节点之间的路径长度 由它们之间的边数表示。
 * https://leetcode.cn/problems/longest-univalue-path/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree0687
 * @create 2022-11-26-15:31
 */
public class Tree0687 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(4,
                        new TreeNode(4),
                        new TreeNode(4)),
                new TreeNode(5, null,
                        new TreeNode(5)));
        System.out.println(new Solution().longestUnivaluePath(root));
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
    private int res = 0;

    public int longestUnivaluePath(TreeNode root) {
        longestUnivaluePath1(root);
        return res;
    }

    private int longestUnivaluePath1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = longestUnivaluePath1(root.left);
        int right = longestUnivaluePath1(root.left);
        int l = 0, r = 0;
        if (root.left != null && root.left.val == root.val) {
            l = left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            r = right + 1;
        }
        res = Math.max(res, l + r);
        return Math.max(l, r);
    }
}