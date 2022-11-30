package tree.test0865;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个根为 root 的二叉树，每个节点的深度是 该节点到根的最短距离 。
 * 返回包含原始树中所有 最深节点 的 最小子树 。
 * 如果一个节点在 整个树 的任意节点之间具有最大的深度，则该节点是 最深的 。
 * 一个节点的 子树 是该节点加上它的所有后代的集合。
 * https://leetcode.cn/problems/smallest-subtree-with-all-the-deepest-nodes/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.test0865
 * @create 2022-11-30-12:08
 */
public class Test0865 {
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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int lh = getHeight(root.left), rh = getHeight(root.right);
        if (lh == rh) {
            return root;
        } else if (lh > rh) {
            return subtreeWithAllDeepest(root.left);
        } else {
            return subtreeWithAllDeepest(root.right);
        }
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}