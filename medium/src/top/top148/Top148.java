package top.top148;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你链表的头结点 head ，
 * 请将其按 升序 排列并返回 排序后的链表 。
 *
 * @Classname Top148
 * @Version 1.0.0
 * @Date 2022/7/17 12:22
 * @Created by sxx_xwl
 */
public class Top148 {
    public static void main(String[] args) {
        ListNode head = new ListNode(4, new ListNode(1, new ListNode(2, new ListNode(3))));
        System.out.println(new Solution().sortList(head));
    }
}

class Solution {
    public ListNode sortList(ListNode head) {
        return head == null ? null : swap(head);
    }

    private ListNode swap(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode l = swap(head);
        ListNode r = swap(slow);
        return merge(l, r);
    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode hh = new ListNode(0);
        ListNode cur = hh;
        while (l != null && r != null) {
            if (l.val < r.val) {
                cur.next = l;
                cur = cur.next;
                l = l.next;
            } else {
                cur.next = r;
                cur = cur.next;
                r = r.next;
            }
        }
        if (l != null) {
            cur.next = l;
        }
        if (r != null) {
            cur.next = r;
        }
        return hh.next;
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

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}