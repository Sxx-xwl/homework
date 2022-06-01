package test.test021;

/**将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @author sxx_27
 * @create 2022-01-25 15:58
 */
public class Test021 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        ListNode list1 = new ListNode(1,new ListNode(2,new ListNode(2)));
        ListNode list2 = new ListNode(1,new ListNode(3,new ListNode(4)));
        ListNode listNode = solution.mergeTwoLists(list1, list2);
        while (listNode!=null)
        {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
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

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head3 = new ListNode(0);
        ListNode temp3 = head3;
        while (list1 != null && list2 != null)
        {
            if (list1.val >= list2.val)
            {
                temp3.next = list2;
                temp3 = temp3.next;
                list2 = list2.next;
            }
            else {
                temp3.next = list1;
                temp3 = temp3.next;
                list1 = list1.next;
            }

        }
        if (list1==null)
        {
            temp3.next = list2;
        }else if (list2==null)
        {
            temp3.next = list1;
        }

        return head3.next;
    }
}