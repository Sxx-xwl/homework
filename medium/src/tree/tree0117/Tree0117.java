package tree.tree0117;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。
 * 如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有next 指针都被设置为 NULL。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree0117
 * @create 2022-10-24-10:10
 */
public class Tree0117 {
    public static void main(String[] args) {
        Node root = new Node(1,
                new Node(2,
                        new Node(4),
                        new Node(5), null),
                new Node(3,
                        null,
                        new Node(7), null), null);
        System.out.println(new Solution().connect(root));
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
};

class Solution {
//    List<List<Node>> listlist;

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node cur = root;
        while (cur != null) {
            Node dummy = new Node(0);
            Node pre = dummy;
            while (cur != null) {
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            cur = dummy.next;
        }
        return root;
    }

//    private void dfs(Node root, int index) {
//        if (root == null) {
//            return;
//        }
//        if (listlist.size() > index) {
//            List<Node> nodes = listlist.get(index);
//            Node node = nodes.remove(0);
//            node.next = root;
//            nodes.add(root);
//        } else {
//            List<Node> nodes = new ArrayList<>();
//            nodes.add(root);
//            listlist.add(nodes);
//        }
//        dfs(root.left, index + 1);
//        dfs(root.right, index + 1);
//    }
}