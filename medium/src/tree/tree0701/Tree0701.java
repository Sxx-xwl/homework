package tree.tree0701;

import top.top002.Top002;

/**
 * 给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，
 * 将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
 * https://leetcode.cn/problems/insert-into-a-binary-search-tree/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree0701
 * @create 2022-11-27-11:13
 */
public class Tree0701 {
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

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode pre = root;
        while (pre != null) {
            if (val < pre.val) {
                if (pre.left!=null){
                    pre = pre.left;
                }else {
                    pre.left = new TreeNode(val);
                    return root;
                }
            }else {
                if (pre.right!=null){
                    pre = pre.right;
                }else {
                    pre.right = new TreeNode(val);
                    return root;
                }
            }
        }
        return root;
    }
}