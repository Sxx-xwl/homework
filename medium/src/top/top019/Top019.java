package top.top019;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，
 * 并且返回链表的头结点。
 *
 * @Classname Top019
 * @Version 1.0.0
 * @Date 2022/6/26 20:34
 * @Created by sxx_xwl
 */
public class Top019 {
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

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        while (n-->=0&&fast!=null){
            fast = fast.next;
            if (fast == null && n==0){
                return head.next;
            }
        }
        while (fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}