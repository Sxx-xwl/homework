package tree.tree0109;

/**
 * 给定一个单链表的头节点 head，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差不超过 1
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree0109
 * @create 2022-10-21-10:42
 */
public class Tree0109 {
    public static void main(String[] args) {

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
    ListNode temp;

    public TreeNode sortedListToBST(ListNode head) {
        temp = head;
        int len = getLength(head);
        return dfs(0, len - 1);
    }

    private int getLength(ListNode head) {
        int res = 0;
        while (head != null) {
            res++;
            head = head.next;
        }
        return res;
    }

    private TreeNode dfs(int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = l + (r - l) / 2;
        TreeNode cur = new TreeNode();
        cur.left = dfs(l, mid - 1);
        cur.val = temp.val;
        temp = temp.next;
        cur.right = dfs(mid + 1, r);
        return cur;
    }
}