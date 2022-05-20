package offer0036;

import java.time.temporal.Temporal;

/**
 * 输入一棵二叉搜索树，
 * 将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，
 * 只能调整树中节点指针的指向。
 *
 * @author sxx_27
 * @create 2022-05-20 10:00
 */
public class Offer0036 {

    public static void main(String[] args) {
        Node root = new Node(4, new Node(2, new Node(1), new Node(3)), new Node(5));
        Node node = new Solution().treeToDoublyList(root);
        System.out.println(node);
    }

}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
};

class Solution {
    Node head;
    Node pre;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        traverse(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void traverse(Node root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        if (pre == null) {
            head = root;
        }else {
            pre.right = root;
        }
        root.left = pre;
        pre = root;
        traverse(root.right);
    }
}