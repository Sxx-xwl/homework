package test.test160;

/**给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。

 图示两个链表在节点 c1 开始相交：

 题目数据 保证 整个链式结构中不存在环。

 注意，函数返回结果后，链表必须 保持其原始结构 。

 自定义评测：

 评测系统 的输入如下（你设计的程序 不适用 此输入）：

 intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0
 listA - 第一个链表
 listB - 第二个链表
 skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数
 skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数

 评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。如果程序能够正确返回相交节点，那么你的解决方案将被 视作正确答案

 * @author sxx_27
 * @create 2022-02-16 16:36
 */


public class Test160 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int a = getNodeCount(headA);
        int b = getNodeCount(headB);

        ListNode longList = a >= b? headA:headB;
        ListNode shortList = a < b? headA:headB;

        int count = a >= b? (a-b):(b-a);

        while (count!=0)
        {
            longList=longList.next;
            count--;
        }
        while(longList!=null)
        {
            if (longList==shortList)
            {
                return longList;
            }
            longList=longList.next;
            shortList=shortList.next;
        }
        return null;
    }

    int getNodeCount(ListNode head){
        int res = 0;
        while(head!=null){
            head = head.next;
            res++;
        }
        return res;
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