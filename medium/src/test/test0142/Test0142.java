package test.test0142;

/**
 * 给定一个链表的头节点 head，返回链表开始入环的第一个节点。如果链表无环，则返回null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 不允许修改 链表。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0142
 * @create 2022-09-07-22:11
 */
public class Test0142 {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode one = new ListNode(2);
        ListNode two = new ListNode(0);
        ListNode three = new ListNode(-4);
        head.next = one;
        one.next = null;
//        one.next = two;
//        two.next = three;
//        three.next = one;
        ListNode listNode = new Solution().detectCycle(head);
        System.out.println(listNode);
    }
}

class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != null && fast != slow) {
            if (fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow;
        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
            if (fast == null) {
                return null;
            }
        }
        return slow;
    }
}

class ListNode {
    int val;
    ListNode next;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    ListNode(int x) {
        val = x;
    }

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val;
    }
}