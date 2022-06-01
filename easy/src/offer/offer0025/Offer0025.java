package offer.offer0025;

/**
 * 输入两个递增排序的链表，
 * 合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * @author sxx_27
 * @create 2022-04-29 20:38
 */
public class Offer0025 {

    public static void main(String[] args) {

        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode head2 = new ListNode(0, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4)))));
        System.out.println(new Solution().mergeTwoLists(head1, head2));

    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode resNode = new ListNode(0);
        ListNode temp = resNode;
        while (l1 != null && l2 != null){
            if (l1.val> l2.val){
                temp.next = l2;
                l2=l2.next;
            }else {
                temp.next = l1;
                l1=l1.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;
        return resNode.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

