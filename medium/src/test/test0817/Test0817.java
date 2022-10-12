package test.test0817;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0817
 * @create 2022-10-12-14:28
 */
public class Test0817 {
    public static void main(String[] args) {

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public int numComponents(ListNode head, int[] nums) {
        int count;
        Boolean flag = true;
        Set set = new HashSet();
        for (int num : nums) set.add(num);
        count = set.contains(head.val) ? 1 : 0;
        while (head != null) {
            if (!set.contains(head.val)) {
                count += flag ? 1 : 0;
            }
            flag = set.contains(head.val);
            head = head.next;
        }
        return flag ? count : count - 1;
    }
}
