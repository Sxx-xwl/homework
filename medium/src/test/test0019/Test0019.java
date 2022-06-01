package test.test0019;

/**给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * @author sxx_27
 * @create 2022-03-12 19:39
 */
public class Test0019 {

    public static void main(String[] args) {

        Solution solution = new Solution();
//        ListNode list1 = new ListNode(1 , new ListNode(2));
        ListNode list1 = new ListNode(1);
//        ListNode list1 = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,new ListNode(6))))));
        ListNode listNode = solution.removeNthFromEnd1(list1,1);
        while (listNode!=null)
        {
            System.out.print(listNode.val + "-->");
            listNode = listNode.next;
        }

    }
}

/**smol
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode temp = null;
        if (n == 1) {
            temp = head.next;
            while (temp.next != null) {
                temp = temp.next;
                slow = slow.next;
            }
            slow.next = null;
            return head;
        }
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast!=null){
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
            temp = slow.next;
            slow.next = temp.next;
            return head;
        }else
        {
            temp = slow.next;
            return temp;
        }

    }
    public ListNode removeNthFromEnd1(ListNode head, int n) {

        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;

    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
