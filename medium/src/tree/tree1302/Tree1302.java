package tree.tree1302;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
 * https://leetcode.cn/problems/deepest-leaves-sum/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree1302
 * @create 2022-12-09-15:01
 */
public class Tree1302 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4, new TreeNode(7), null), new TreeNode(5)),
                new TreeNode(3, null, new TreeNode(6, null, new TreeNode(8))));
        System.out.println(new Solution().deepestLeavesSum(root));
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
    int res = 0, maxH = 0;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int height) {
        if (root == null) {
            return;
        }
        if (height == maxH) {
            res += root.val;
        } else if (height > maxH) {
            maxH = height;
            res = root.val;
        }
        dfs(root.left, height + 1);
        dfs(root.right, height + 1);
    }
}