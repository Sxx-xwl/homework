package tree.tree1367;

import test.test0002.Test0002;

import java.util.HashMap;

/**
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree1367
 * @create 2022-12-12-15:23
 */
public class Tree1367 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,
                new TreeNode(3,
                        new TreeNode(1,
                                new TreeNode(1),
                                new TreeNode(2)),
                        null),
                null);
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1)));
        System.out.println(new Solution().isSubPath(head, root));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (root.val != head.val) {
            return false;
        }
        return dfs(head.next, root.left) || dfs(head.next, root.right);
    }
}