package tree.binarytree0559;

import java.util.List;

/**
 * 给定一个 N 叉树，找到其最大深度。
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.binarytree0559
 * @create 2022-09-20-21:45
 */
public class Binarytree0559 {
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
    int maxD = 0;

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int d = 0;
        for (Node child : root.children) {
            d = Math.max(maxDepth(child), d);
        }
        return d + 1;
    }
}