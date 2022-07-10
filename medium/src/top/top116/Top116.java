package top.top116;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

 struct Node {
 int val;
 Node *left;
 Node *right;
 Node *next;
 }
 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

 初始状态下，所有 next 指针都被设置为 NULL。
 * @Classname Top116
 * @Version 1.0.0
 * @Date 2022/7/10 14:25
 * @Created by sxx_xwl
 */
public class Top116 {
    public static void main(String[] args) {

    }
}

class Solution {
    Node[] nodes;

    public Node connect(Node root) {
        int height = height(root);
        nodes = new Node[height];
        add(root, 0);
        return root;
    }

    private void add(Node root, int index) {
        if (root == null) {
            return;
        }
        root.next = null;
        if (nodes[index] != null) {
            nodes[index].next = root;
        }
        nodes[index] = root;
        add(root.left, index + 1);
        add(root.right, index + 1);
    }

    private int height(Node root) {
        if (root == null) {
            return 0;
        }
        return height(root.left) + 1;
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
};