package tree.binarytree1022;

/**
 * 给出一棵二叉树，其上每个结点的值都是0或1。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
 * 例如，如果路径为0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数01101，也就是13。
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.binarytree1022
 * @create 2022-10-11-11:03
 */
public class Binarytree1022 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(0, new TreeNode(0), new TreeNode(1)),
                new TreeNode(1, new TreeNode(0), new TreeNode(1)));
        System.out.println(new Solution().sumRootToLeaf(root));
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
    int res, temp;

    public int sumRootToLeaf(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        temp = (temp << 1) | root.val;
        dfs(root.left);
        dfs(root.right);
        if (root.left == null && root.right == null) {
            res += temp;
        }
        temp = temp >> 1;
    }
}