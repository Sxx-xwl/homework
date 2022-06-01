package offer.offer0052;

import java.util.HashSet;
import java.util.Set;

/**
 * 输入两个链表，找出它们的第一个公共节点
 *
 * @author sxx_27
 * @create 2022-05-05 16:45
 */
public class Offer0052 {

    public static void main(String[] args) {


    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode getIntersectionNode0(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;

        int len1 = 0;
        int len2 = 0;
        while (temp1 != null) {
            len1++;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            len2++;
            temp2 = temp2.next;
        }
        ListNode temp3 = headA;
        ListNode temp4 = headB;
        if (len1 < len2) {
            len2 -= len1;
            while (len2 > 0) {
                len2--;
                temp4 = temp4.next;
            }
        } else if (len1 > len2) {
            len1 -= len2;
            while (len1 > 0) {
                len1--;
                temp3 = temp3.next;
            }
        }
        while (temp3 != null) {
            if (temp3 == temp4) {
                return temp3;
            } else {
                temp3 = temp3.next;
                temp4 = temp4.next;
            }
        }
        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode temp1 = headA;
        ListNode temp2 = headB;

        while (temp1 != temp2) {
            temp1 = temp1 == null ? headB : temp1.next;
            temp2 = temp2 == null ? headA : temp2.next;
        }
        return temp1;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (headB != null) {
            set.add(headB);
            headB = headB.next;
        }
        while (headA != null) {
            int len = set.size();
            set.add(headA);
            if (len == set.size()) {
                return headA;
            } else {
                headA = headA.next;
            }
        }
        return null;
    }
}