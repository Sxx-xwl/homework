package tree.tree0889;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组，preorder 和 postorder ，
 * 其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，
 * postorder 是同一棵树的后序遍历，重构并返回二叉树。
 * 如果存在多个答案，您可以返回其中 任何 一个。
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree0889
 * @create 2022-12-01-14:05
 */
public class Tree0889 {
    public static void main(String[] args) {
//        System.out.println(new Solution().constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1}));
        System.out.println(new Solution().constructFromPrePost(new int[]{3, 4, 1, 2}, new int[]{1, 4, 2, 3}));
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

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

class Solution {
    Map<Integer, Integer> map;
    int preRoot = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
        return constructTree(preorder, postorder, 0, postorder.length - 1);
    }

    private TreeNode constructTree(int[] preorder, int[] postorder, int postL, int postR) {
        if (preRoot >= preorder.length || postL > postR) {
            return null;
        }
        if (postL == postR) {
            preRoot++;
            return new TreeNode(postorder[postR]);
        }
        int rootVal = preorder[preRoot++];
        TreeNode root = new TreeNode(rootVal);
        int postIndex = map.get(preorder[preRoot]);
        root.left = constructTree(preorder, postorder, postL, postIndex);
        root.right = constructTree(preorder, postorder, postIndex + 1, postR - 1);
        return root;
    }
}