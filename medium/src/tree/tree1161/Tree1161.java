package tree.tree1161;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 * 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
 * https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree1161
 * @create 2022-12-03-13:31
 */
public class Tree1161 {
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
    private int[] arr;
    private int maxH = 1;

    public int maxLevelSum(TreeNode root) {
        int res = 0, max = Integer.MIN_VALUE;
        arr = new int[10001];
        dfs(root, 1);
        for (int i = 1; i <= maxH; i++) {
            if (arr[i] > max) {
                max = arr[i];
                res = i;
            }
        }
        return res;
    }

    private void dfs(TreeNode root, int index) {
        if (root == null) {
            return;
        }
        arr[index] += root.val;
        maxH = Math.max(index,maxH);
        dfs(root.left, index + 1);
        dfs(root.right, index + 1);
    }
}