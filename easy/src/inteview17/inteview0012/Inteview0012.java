package inteview17.inteview0012;

/**
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。
 * 实现一个方法，把二叉搜索树转换为单向链表，
 * 要求依然符合二叉搜索树的性质，转换操作应是原址的，
 * 也就是在原始的二叉搜索树上直接修改。
 * 返回转换后的单向链表的头节点
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className inteview17.inteview0012
 * @create 2022-10-16-11:17
 */
public class Inteview0012 {
    public static void main(String[] args) {

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    TreeNode temp, res;

    public TreeNode convertBiNode(TreeNode root) {
        res = new TreeNode(1);
        temp = res;
        dfs(root);
        return res.right;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        temp.right = root;
        root.left = null;
        temp = temp.right;
        dfs(root.right);
    }
}