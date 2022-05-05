package test234;

import com.sun.org.apache.xpath.internal.operations.Mod;

import java.util.ArrayList;

/**
 * @author sxx_27
 * @create 2022-02-26 16:54
 */
public class Test234 {

    public static void main(String[] args) {

        Solution solution = new Solution();
//        ListNode head = new ListNode(1,new ListNode(2,new ListNode(2,new ListNode(1))));
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(2,new ListNode(1)))));
//        ListNode head = new ListNode(1);
        boolean palindrome = solution.isPalindrome3(head);
        System.out.println(palindrome);

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
    /*
    快慢指针 反转后半部分
     */
    public boolean isPalindrome(ListNode head) {

        if (head==null||head.next==null)
        {
            return true;
        }
        ListNode fast = head.next;
        ListNode move = head.next;
        ListNode temp = head ;
        while (fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            move = move.next;
            temp = temp.next;
        }
        temp.next = null;
        temp = move;

        ListNode mv = move.next;
        while (mv!=null)
        {
            temp.next = mv.next;
            mv.next = move;
            move = mv;
            mv = temp.next;
        }

        while (move!=null)
        {
            if (move.val!=head.val)
            {
                return false;
            }
            move = move.next;
            head = head.next;
        }
        return true;
    }
    /*
    将链表放进数组里
     */
    public boolean isPalindrome1(ListNode head){

        if (head==null||head.next==null)
        {
            return true;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        while (head!=null)
        {
            arr.add(head.val);
            head = head.next;
        }
        int slow = 0;
        int fast = arr.size()-1;
        while (slow <= fast)
        {
            if (arr.get(slow) != arr.get(fast))
            {
                return false;
            }
            slow++;
            fast--;
        }
        return true;
    }
    /*
    用数学方法比较
     */
    public boolean isPalindrome2(ListNode head){

        int a = 0 , b = 0;
        int t = 1;

        while (head!=null)
        {
            a = a * 10 + head.val;
            b = b + t * head.val;
            t *= 10 ;
            head = head.next;
        }
        if (a!=b)
        {
            return false;
        }
        return true;
    }
    /*
    快慢指针反转前半部分
     */
    public boolean isPalindrome3(ListNode head){

        if (head==null||head.next==null)
        {
            return true;
        }
        ListNode move = head.next;
        ListNode fast = head;
        ListNode temp = head;
        while (true)
        {
            fast = fast.next.next;
            if (fast == null)
            {
                break;
            }
            if (fast.next==null)
            {
                move = move.next;
                break;
            }
            temp.next = move.next;
            move.next = head;
            head = move;
            move = temp.next;
        }
        while (move!=null)
        {
            if (move.val!=head.val)
            {
                return false;
            }
            move = move.next;
            head = head.next;
        }
        return true;
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
