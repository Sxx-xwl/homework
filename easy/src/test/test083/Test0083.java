package test.test083;

/**
 * 给定一个已排序的链表的头 head ，
 * 删除所有重复的元素，使每个元素只出现一次 。
 * 返回 已排序的链表
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0083
 * @create 2022-10-18-10:26
 */
public class Test0083 {
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

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            while (temp.next != null && temp.next.val == temp.val) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return head;
    }
}