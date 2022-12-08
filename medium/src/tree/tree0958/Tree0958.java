package tree.tree0958;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树的 root ，确定它是否是一个 完全二叉树 。
 * 在一个 完全二叉树 中，除了最后一个关卡外，所有关卡都是完全被填满的，
 * 并且最后一个关卡中的所有节点都是尽可能靠左的。
 * 它可以包含 1 到 2h 节点之间的最后一级 h 。
 * https://leetcode.cn/problems/check-completeness-of-a-binary-tree/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree0958
 * @create 2022-12-07-10:27
 */
public class Tree0958 {
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
    public boolean isCompleteTree(TreeNode root) {
        boolean flag = false;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            TreeNode temp = deque.pollFirst();
            if (temp.left == null && temp.right != null) {
                return false;
            }
            if (flag && (temp.left != null || temp.right != null)) {
                return false;
            }
            if (temp.right == null) {
                flag = true;
            }
            if (temp.left != null) {
                deque.offerLast(temp.left);
            }
            if (temp.right != null) {
                deque.offerLast(temp.right);
            }
        }
        return true;
    }
}