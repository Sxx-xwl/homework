package tree.tree0515;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 * https://leetcode.cn/problems/find-largest-value-in-each-tree-row/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree0515
 * @create 2022-11-16-11:20
 */
public class Tree0515 {
    public static void main(String[] args) {

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private List<Integer> list;

    public List<Integer> largestValues(TreeNode root) {
        list = new ArrayList<>();
        dfs(root, 0);
        return list;
    }

    private void dfs(TreeNode root, int index) {
        if (root == null) {
            return;
        }
        if (list.size() <= index) {
            list.add(root.val);
        } else {
            if (root.val > list.get(index)) {
                list.set(index, root.val);
            }
        }
        dfs(root.left, index + 1);
        dfs(root.right, index + 1);
    }
}