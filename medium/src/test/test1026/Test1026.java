package test.test1026;

/**
 * 给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
 * （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
 * https://leetcode.cn/problems/maximum-difference-between-node-and-ancestor/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test1026
 * @create 2022-12-10-14:13
 */
public class Test1026 {
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
    private int res = 0;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return res;
    }

    private void dfs(TreeNode root, int maxV, int minV) {
        if (root == null) {
            res = Math.max(res, Math.abs(maxV - minV));
            return;
        }
        dfs(root.left, Math.max(root.val, maxV), Math.min(root.val, minV));
        dfs(root.right, Math.max(root.val, maxV), Math.min(root.val, minV));
    }
}