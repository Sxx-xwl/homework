package offer0018;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 *
 * @author sxx_27
 * @create 2022-04-27 21:31
 */
public class Offer0018 {

    public static void main(String[] args) {

        ListNode head = new ListNode(4, new ListNode(5, new ListNode(1, new ListNode(9, null))));
        ListNode listNode = new Solution().deleteNode(head, 1);
        System.out.println(listNode);

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
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
    public ListNode deleteNode(ListNode head, int val) {
        ListNode tempNode = head;
        if (head.val == val) {
            return head.next;
        }

        while (head.next != null) {
            if (head.next.val == val) {
                break;
            }
            head = head.next;
        }
        if (head.next.next == null) {
            head.next = null;
        } else {
            head.next = head.next.next;
        }
        return tempNode;
    }
}