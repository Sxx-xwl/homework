package test.test0143;

import java.time.temporal.Temporal;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * https://leetcode.cn/problems/reorder-list/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0143
 * @create 2022-12-06-11:17
 */
public class Test0143 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        new Solution().reorderList(head);
    }
}

class ListNode {
    int val;
    ListNode next;

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

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

class Solution {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    private ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = new ListNode(0);
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            ListNode nextNode = pre.next;
            pre.next = cur;
            pre.next.next = nextNode;
            cur = temp;
        }
        return pre.next;
    }

    private void mergeList(ListNode l1, ListNode l2) {
        ListNode templ1 = l1;
        ListNode templ2 = l2;
        while (l1 != null) {
            templ1 = l1.next;
            l1.next = l2;
            l1 = templ1;
            if (l2 == null) {
                return;
            }
            templ2 = l2.next;
            l2.next = l1;
            l2 = templ2;
        }
    }
}