package tree.tree0099;

/**
 * 给你二叉搜索树的根节点 root ，
 * 该树中的 恰好 两个节点的值被错误地交换。
 * 请在不改变其结构的情况下，恢复这棵树
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree0099
 * @create 2022-10-18-10:35
 */
public class Tree0099 {
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
    TreeNode a, b;
    TreeNode pre = new TreeNode(Integer.MIN_VALUE);
    boolean flag = false;

    public void recoverTree(TreeNode root) {
        dfs(root);
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (root.val < pre.val) {
            if (a == null && !flag) a = pre;
            b = root;
        }
        if (a != null) flag = true;
        pre = root;
        dfs(root.right);
    }
}