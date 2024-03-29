package test.test141;

/**给你一个链表的头节点 head ，判断链表中是否有环。
 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
 评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 * @author sxx_27
 * @create 2022-02-14 20:28
 */
public class Test141 {


    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // 空链表、单节点链表一定不会有环
        while (fast != null && fast.next != null) {
            fast = fast.next.next; // 快指针，一次移动两步
            slow = slow.next;      // 慢指针，一次移动一步
            if (fast == slow) {   // 快慢指针相遇，表明有环
                return true;
            }
        }
        return false; // 正常走到链表末尾，表明没有环
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
