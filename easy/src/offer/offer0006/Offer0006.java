package offer.offer0006;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * @author sxx_27
 * @create 2022-04-23 21:23
 */
public class Offer0006 {

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public int[] reversePrint1(ListNode head) {

        if (head == null) {
            return new int[0];
        } else if (head.next == null) {
            return new int[]{head.val};
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(head.val);
        while (head.next != null) {
            head = head.next;
            stack.push(head.val);
        }
        int size = stack.size();
        int res[] = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = stack.pop();
        }

        return res;
    }

    public int[] reversePrint0(ListNode head) {

        if (head == null) {
            return new int[0];
        } else if (head.next == null) {
            return new int[]{head.val};
        }
        ArrayList<Integer> list = new ArrayList();
        list.add(0, head.val);
        while (head.next != null) {
            head = head.next;
            list.add(0, head.val);
        }
        int res[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    public int[] reversePrint(ListNode head) {

        if (head == null) {
            return new int[0];
        } else if (head.next == null) {
            return new int[]{head.val};
        }
        ListNode temp = head;
        int count = 1;
        while (head.next != null) {
            head = head.next;
            count++;
        }
        int res[] = new int[count];
        for (int i = 0; i < count; i++) {
            res[count - i - 1] = temp.val;
            temp = temp.next;
        }
        return res;
    }
}
