package interview04.interview0004;

/**
 * 实现一个函数，检查二叉树是否平衡。
 * 在这个问题中，平衡树的定义如下：
 * 任意一个节点，其两棵子树的高度差不超过 1
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className interview04.interview0004
 * @create 2022-10-15-10:36
 */
public class Interview0004 {
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
    boolean flag;

    public boolean isBalanced(TreeNode root) {
        flag = true;
        dfs(root);
        return flag;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        if (Math.abs(l - r) > 1) {
            flag = false;
        }
        return Math.max(l, r) + 1;
    }
}