package top.top138;

/**
 * 给你一个长度为 n 的链表，
 * 每个节点包含一个额外增加的随机指针 random ，
 * 该指针可以指向链表中的任何节点或空节点。
 * 构造这个链表的深拷贝。
 * 拷贝应该正好由 n 个 全新 节点组成，
 * 其中每个新节点的值都设为其对应的原节点的值。
 * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，
 * 并使原链表和复制链表中的这些指针能够表示相同的链表状态。
 * 复制链表中的指针都不应指向原链表中的节点 。
 * 例如，如果原链表中有 X 和 Y 两个节点，
 * 其中 X.random --> Y 。
 * 那么在复制链表中对应的两个节点 x 和 y ，
 * 同样有 x.random --> y 。
 * 返回复制链表的头节点。
 * 用一个由n个节点组成的链表来表示输入/输出中的链表。
 * 每个节点用一个[val, random_index]表示：
 * val：一个表示Node.val的整数。
 * random_index：随机指针指向的节点索引（范围从0到n-1）；
 * 如果不指向任何节点，则为null。
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 *
 * @Classname Top138
 * @Version 1.0.0
 * @Date 2022/7/12 20:22
 * @Created by sxx_xwl
 */
public class Top138 {
    public static void main(String[] args) {
        Node head = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node2.random = head;
        node3.random = node5;
        node4.random = node3;
        node5.random = head;
        Node temp = head;
        while (temp != null) {
            System.out.print(temp);
            System.out.print(">");
            temp = temp.next;
        }
        System.out.println();
        temp = new Solution().copyRandomList(head);
        while (temp != null) {
            System.out.print(temp);
            System.out.print(">");
            temp = temp.next;
        }
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

    public Node(int val, Node next, Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }

}

class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;
        //在旧链表的每一个节点后面新增节点
        // 1->2->3  ==>  1->1'->2->2'->3->3'
        while (temp != null) {
            Node node = new Node(temp.val, temp.next, null);
            Node n = temp.next;
            temp.next = node;
            temp = n;
        }
        //从头开始，将每一个新增节点添加random
        temp = head;
        while (temp != null) {
            temp.next.random = temp.random == null ? null : temp.random.next;
            temp = temp.next.next;
        }
        // 还原原始链表，分离原链表和克隆链表
        temp = head;
        Node cloneHead = head.next;
        while(temp.next != null){
            Node node = temp.next;
            temp.next = temp.next.next;
            temp = node;
        }
        return cloneHead;
    }
}