package test206;

/**给你单链表的头节点 head ，请你反转链表，并返回反转后的链表
 * @author sxx_27
 * @create 2022-02-25 15:58
 */
public class Test206 {


    public static void main(String[] args) {

        Solution solution = new Solution();
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3)));
        ListNode listNode = solution.reverseList(head);
        System.out.println(listNode);

    }
}

/**
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
    public ListNode reverseList(ListNode head) {

        if (head==null)
        {
            return head;
        }


        ListNode move = head.next;
        ListNode temp = head;
        while (move!=null)
        {
            temp.next = move.next;
            move.next = head;
            head = move;
            move = temp.next;
        }

        return head;
    }


    public ListNode reverseList1(ListNode head) {

        ListNode move = head;
        ListNode temp = null;
        while (move!=null)
        {
            ListNode listNode = move.next;
            move.next = temp;
            temp = move;
            move = listNode;
        }
        return head;
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
