package tree.binarytree0590;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 n叉树的根节点root，返回 其节点值的 后序遍历 。
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.binarytree0590
 * @create 2022-09-22-22:36
 */
public class Binarytree0590 {
    public static void main(String[] args) {

    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
    List<Integer> list = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        for (Node node : root.children) {
            postorder(node);
        }
        list.add(root.val);
        return list;
    }
}