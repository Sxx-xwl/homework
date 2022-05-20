package offer0035;

import java.util.HashMap;
import java.util.Map;

/**
 * 请实现 copyRandomList 函数，
 * 复制一个复杂链表。在复杂链表中，
 * 每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * @author sxx_27
 * @create 2022-05-19 13:58
 */
public class Offer0035 {
    public static void main(String[] args) {

    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList0(Node head) {
        if (head == null) {
            return head;
        }
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        Node res = head;
        while (res != null) {
            map.get(res).next = map.get(res.next);
            map.get(res).random = map.get(res.random);
            res = res.next;
        }
        return map.get(head);
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        //将拷贝节点放到原节点后面，例如1->2->3这样的链表就变成了这样1->1'->2->2'->3->3'
        for (Node cur = head, copy = null; cur != null; cur = cur.next.next) {
            copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
        }
        //把拷贝节点的random指针安排上
        for (Node cur = head; cur != null; cur = cur.next.next) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
        }
        //分离拷贝节点和原节点，变成1->2->3和1'->2'->3'两个链表，后者就是答案
        Node newHead = head.next;
        for (Node cur = head, temp = null; cur != null; cur = cur.next) {
            temp = cur.next;
            cur.next = temp.next;
            temp.next = (temp.next == null) ? null : temp.next.next;
        }
        return newHead;
    }
}