package test0002;

/**给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。

 请你将两个数相加，并以相同形式返回一个表示和的链表。

 你可以假设除了数字 0 之外，这两个数都不会以 0开头。

 * @author sxx_27
 * @create 2022-03-06 21:17
 */
public class Test0002 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        ListNode listNode1 = new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,null)))))));
        ListNode listNode2 = new ListNode(9,new ListNode(9,new ListNode(9,null)));
        ListNode listNode = solution.addTwoNumbers(listNode1, listNode2);
        System.out.println(listNode);

    }

}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode p = new ListNode(0);
        ListNode l3 = p;
        int flag = 0;
        int sum;
        while (l1 != null || l2 != null) {
            int num1 = l1!=null ? l1.val : 0;
            int num2 = l2!=null ? l2.val : 0;
            l3.next = new ListNode(0);
            l3 = l3.next;
            if (flag == 1) {
                sum = num1 + num2 + 1;
                flag = 0;
            } else {
                sum = num1 + num2;
            }
            if (sum > 9) {
                flag++;
                sum = sum - 10;
            }
            l3.val = sum;
            if (l1 != null)
            {
                l1 = l1.next;
            }
            if (l2 != null)
            {
                l2 = l2.next;
            }
        }
        if (flag == 1) {
            l3.next = new ListNode(0);
            l3 = l3.next;
            l3.val = 1;
        }
        return p.next;
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
        return "" +
                 val +
                "," + next ;
    }
}