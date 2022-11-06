package tree.tree0429;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 * <p>
 * https://leetcode.cn/problems/n-ary-tree-level-order-traversal/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree429
 * @create 2022-11-06-11:06
 */
public class Tree429 {
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
    private List<List<Integer>> listList;

    public List<List<Integer>> levelOrder(Node root) {
        listList = new ArrayList<>();
        dfs(root, 0);
        return listList;
    }

    private void dfs(Node root, int index) {
        if (root == null) {
            return;
        }
        if (index < listList.size()) {
            List<Integer> list = listList.get(index);
            list.add(root.val);
        } else {
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            listList.add(temp);
        }
        for (Node cur : root.children) {
            dfs(cur, index + 1);
        }
    }
}
