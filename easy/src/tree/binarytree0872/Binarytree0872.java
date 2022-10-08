package tree.binarytree0872;

import java.util.ArrayList;
import java.util.List;

/**
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个叶值序列 。
 * 举个例子，如上图所示，给定一棵叶值序列为(6, 7, 4, 9, 8)的树。
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是叶相似的。
 * 如果给定的两个根结点分别为root1 和root2的树是叶相似的，则返回true；否则返回 false 。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.binarytree0872
 * @create 2022-10-08-13:50
 */
public class Binarytree0872 {
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
    List<Integer> list1, list2;

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        dfs1(root1, list1);
        dfs1(root2, list2);
        return list1.equals(list2);
    }

    private void dfs1(TreeNode root, List list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        dfs1(root.left, list);
        dfs1(root.right, list);
    }
}
