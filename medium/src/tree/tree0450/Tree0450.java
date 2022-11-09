package tree.tree0450;

import javafx.scene.transform.Rotate;

import java.util.TooManyListenersException;

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，
 * 删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。
 * 返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * https://leetcode.cn/problems/delete-node-in-a-bst/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree0450
 * @create 2022-11-09-12:20
 */
public class Tree0450 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2),
                        new TreeNode(4)),
                new TreeNode(6,
                        null,
                        new TreeNode(7)));
        System.out.println(new Solution().deleteNode(root, 7));
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

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root, curParent = null;
        while (cur != null && cur.val != key) {
            curParent = cur;
            if (cur.val < key) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        if (cur == null) {
            return root;
        }
        if (cur.left == null && cur.right == null) {
            cur = null;
        } else if (cur.left == null) {
            cur = cur.right;
        } else if (cur.right == null) {
            cur = cur.left;
        } else {
            TreeNode temp = cur.right, tempParent = cur;
            while (temp.left != null) {
                tempParent = temp;
                temp = temp.left;
            }
            if (tempParent.val == cur.val) {
                tempParent.right = temp.right;
            } else {
                tempParent.left = temp.right;
            }
            temp.left = cur.left;
            temp.right = cur.right;
            cur = temp;
        }
        if (curParent == null) {
            return cur;
        } else {
            if (curParent.left != null && curParent.left.val == key) {
                curParent.left = cur;
            } else {
                curParent.right = cur;
            }
        }
        return root;
    }
}