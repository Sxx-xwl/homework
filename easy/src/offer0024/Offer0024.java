package offer0024;

/**
 * 定义一个函数，输入一个链表的头节点，
 * 反转该链表并输出反转后链表的头节点。
 *
 * @author sxx_27
 * @create 2022-04-29 20:12
 */
public class Offer0024 {

    public static void main(String[] args) {

        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        System.out.println(new Solution().reverseList(head));
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

class Solution {
    public ListNode reverseList0(ListNode head) {

        if (head == null||head.next == null) {
            return head;
        }
        ListNode root = null;
        ListNode templ = head;
        ListNode tempr = head;
        while (tempr != null) {
            templ.next = root;
            root = templ;
            templ = tempr;
            tempr = tempr.next;
        }
        return root;
    }

    //递归太难了
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}